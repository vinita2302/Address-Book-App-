
package com.spring.Address_Book_App.controller;

import com.spring.Address_Book_App.dto.AddressBookDto;
import com.spring.Address_Book_App.model.AddressBook;
import com.spring.Address_Book_App.service.AddressBookService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/address-book")

public class AddresBookController {  // Fixed class name

    @Autowired
    private AddressBookService addressBookService;

    @GetMapping("")
    public ResponseEntity<List<AddressBook>> getAllAddressBook() {
        log.info("Fetching all address books");

        return addressBookService.getAllAddressBook();
    }

    @GetMapping("/{name}")

    public ResponseEntity<AddressBook> getAddressBookByName(@PathVariable String name){
        log.info("Get address book by name");
  public ResponseEntity<AddressBook> getAddressBookByName(@PathVariable String name) {
        log.info("Fetching address book with name: {}", name);

        return addressBookService.getAddressBookByName(name);
    }

    @PostMapping("")

    public ResponseEntity<AddressBook> createAddressBook(@RequestBody AddressBookDto addressBookDto){
        log.info("create address book using {}", addressBookDto);
      
    public ResponseEntity<AddressBook> createAddressBook(@RequestBody AddressBookDto addressBookDto) {
        log.info("Creating new address book: {}", addressBookDto);

        return addressBookService.createAddressBook(addressBookDto);
    }

    @PutMapping("/{id}")

    public ResponseEntity<AddressBook> updateAddressBook(@PathVariable String id, @RequestBody AddressBookDto addressBookDto){
        log.info("update address book of id {}", id, "with new address book as", addressBookDto);
        return addressBookService.updateAddressBook(Long.parseLong(id), addressBookDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddressBook(@PathVariable String id){
        log.info("delete address book of id {}", id);
        return addressBookService.deleteAddressBook(Long.parseLong(id));
    }

    @DeleteMapping(value = {"", "/"})
    public ResponseEntity<String> deleteAllAddressBook(){
        log.info("delete all address book");
        return addressBookService.deleteAllAddressBook();
    }

}

    public ResponseEntity<AddressBook> updateAddressBook(@PathVariable Long id, @RequestBody AddressBookDto addressBookDto) {
        log.info("Updating address book with id: {} with new data: {}", id, addressBookDto);
        return addressBookService.updateAddressBook(id, addressBookDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddressBook(@PathVariable Long id) {
        log.info("Deleting address book with id: {}", id);
        return addressBookService.deleteAddressBook(id);
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteAllAddressBook() {
        log.info("Deleting all address books");
        return addressBookService.deleteAllAddressBook();
    }
}

