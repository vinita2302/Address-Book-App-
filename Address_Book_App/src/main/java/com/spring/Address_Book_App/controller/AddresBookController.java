package com.spring.Address_Book_App.controller;

import com.spring.Address_Book_App.dto.AddressBookDto;
import com.spring.Address_Book_App.model.AddressBook;
import com.spring.Address_Book_App.service.AddressBookService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/address-book")
public class AddresBookController {

    @Autowired
    AddressBookService addressBookService;

    @GetMapping(value = {"", "/"})
    public ResponseEntity<List<AddressBook>> getAllAddressBook(){
        log.info("Get all address book");
        return addressBookService.getAllAddressBook();
    }

    @GetMapping("/{name}")
    public ResponseEntity<AddressBook> getAddressBookByName(@PathVariable String name){
        log.info("Get address book by name");
        return addressBookService.getAddressBookByName(name);
    }

    @PostMapping("")
    public ResponseEntity<AddressBook> createAddressBook(@Valid @RequestBody AddressBookDto addressBookDto){
        log.info("create address book using {}", addressBookDto);
        return addressBookService.createAddressBook(addressBookDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressBook> updateAddressBook(@PathVariable String id, @Valid @RequestBody AddressBookDto addressBookDto){
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
