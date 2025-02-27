package com.spring.Address_Book_App.controller;

import com.spring.Address_Book_App.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address-book")
public class AddresBookController {

    @Autowired
    AddressBookService addressBookService;

    @GetMapping(value = {"", "/"})
    public ResponseEntity<String> getAllAddressBook(){
        return addressBookService.getAllAddressBook();
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getAddressBookById(@PathVariable String id){
        return addressBookService.getAddressBookById(id);
    }

    @PostMapping("")
    public ResponseEntity<String> createAddressBook(){
        return addressBookService.createAddressBook();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAddressBook(@PathVariable String id){
        return addressBookService.updateAddressBook(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddressBook(@PathVariable String id){
        return addressBookService.deleteAddressBook(id);
    }

    @DeleteMapping(value = {"", "/"})
    public ResponseEntity<String> deleteAllAddressBook(){
        return addressBookService.deleteAllAddressBook();
    }

}