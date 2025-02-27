package com.spring.Address_Book_App.service;

import com.spring.Address_Book_App.dto.AddressBookDto;
import com.spring.Address_Book_App.model.AddressBook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Service
public class AddressBookService {

    private final List<AddressBook> addressBooks = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1); // Generate unique IDs

    public ResponseEntity<List<AddressBook>> getAllAddressBook() {
        log.info("Fetching all address books");
        return ResponseEntity.ok(addressBooks);
    }

    public ResponseEntity<AddressBook> getAddressBookByName(String name) {

        for (AddressBook addressBook : addressBooks) {
            if (addressBook.getName().equals(name)) return new ResponseEntity<>(addressBook, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        log.info("Searching for address book by name: {}", name);
        Optional<AddressBook> addressBook = addressBooks.stream()
                .filter(ab -> ab.getName().equalsIgnoreCase(name))
                .findFirst();

        return addressBook.map(book -> new ResponseEntity<>(book, HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));

    }

    public ResponseEntity<AddressBook> createAddressBook(AddressBookDto addressBookDto) {
        AddressBook newAddressBook = new AddressBook(idCounter.getAndIncrement(), addressBookDto.getName(), addressBookDto.getPhoneNumber());
        addressBooks.add(newAddressBook);
        log.info("Created new address book: {}", newAddressBook);
        return new ResponseEntity<>(newAddressBook, HttpStatus.CREATED);
    }

    public ResponseEntity<AddressBook> updateAddressBook(Long id, AddressBookDto addressBookDto) {

        for (int i = 0; i < addressBooks.size(); i++) {
            if (addressBooks.get(i).getId() == id) {
                addressBooks.set(i, new AddressBook(addressBookDto.getName(), addressBookDto.getPhoneNumber()));
                return new ResponseEntity<>(addressBooks.get(i), HttpStatus.OK);

        log.info("Updating address book with ID: {}", id);
        for (int i = 0; i < addressBooks.size(); i++) {
            if (addressBooks.get(i).getId().equals(id)) {
                AddressBook updatedBook = new AddressBook(id, addressBookDto.getName(), addressBookDto.getPhoneNumber());
                addressBooks.set(i, updatedBook);
                return new ResponseEntity<>(updatedBook, HttpStatus.OK);

            }
        }
        log.warn("Address book with ID {} not found", id);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> deleteAddressBook(Long id) {

        for (int i = 0; i < addressBooks.size(); i++) {
            if (addressBooks.get(i).getId() == id) {
                addressBooks.remove(i);
                return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Unable to delete address book " + id, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> deleteAllAddressBook() {
        if (addressBooks.removeAll(addressBooks)) return new ResponseEntity<>("delete all address book", HttpStatus.OK);
        return null;

        log.info("Deleting address book with ID: {}", id);
        boolean removed = addressBooks.removeIf(ab -> ab.getId().equals(id));
        if (removed) {
            return ResponseEntity.ok("Deleted successfully");
        }

    public ResponseEntity<String> deleteAllAddressBook() {
        if (addressBooks.removeAll(addressBooks)) return new ResponseEntity<>("delete all address book", HttpStatus.OK);
        return new ResponseEntity<>("Unable to delete address books", HttpStatus.OK);

        log.warn("Unable to delete, ID {} not found", id);
        return new ResponseEntity<>("Unable to delete address book " + id, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> deleteAllAddressBook() {
        if (!addressBooks.isEmpty()) {
            addressBooks.clear();
            log.info("Deleted all address books");
            return ResponseEntity.ok("Deleted all address books");
        }
        log.warn("No address books to delete");
        return new ResponseEntity<>("No address books to delete", HttpStatus.NOT_FOUND);

        return new ResponseEntity<>("Unable to delete address book "+id, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> deleteAllAddressBook() {
        if (addressBooks.removeAll(addressBooks)) return new ResponseEntity<>("delete all address book", HttpStatus.OK);
        return new ResponseEntity<>("Unable to delete address books", HttpStatus.OK);


    }
}
