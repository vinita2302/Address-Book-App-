package com.spring.Address_Book_App.controller;


import com.spring.Address_Book_App.dto.AddressBookDto;
import com.spring.Address_Book_App.model.AddressBook;
import com.spring.Address_Book_App.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address-book")
public class AddresBookController {

    @Autowired
    AddressBookService addressBookService;

    @GetMapping(value = {"", "/"})
    public ResponseEntity<List<AddressBook>> getAllAddressBook(){
        return addressBookService.getAllAddressBook();
    }

    @GetMapping("/{name}")
    public ResponseEntity<AddressBook> getAddressBookByName(@PathVariable String name){
        return addressBookService.getAddressBookByName(name);
    }

    @PostMapping("")
    public ResponseEntity<AddressBook> createAddressBook(@RequestBody AddressBookDto addressBookDto){
        return addressBookService.createAddressBook(addressBookDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressBook> updateAddressBook(@PathVariable String id, @RequestBody AddressBookDto addressBookDto){
        return addressBookService.updateAddressBook(Long.parseLong(id), addressBookDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddressBook(@PathVariable String id){
        return addressBookService.deleteAddressBook(Long.parseLong(id));
    }

    @DeleteMapping(value = {"", "/"})
    public ResponseEntity<String> deleteAllAddressBook(){
        return addressBookService.deleteAllAddressBook();
    }

}