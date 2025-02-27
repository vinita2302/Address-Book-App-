package com.spring.Address_Book_App.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address-book")
public class AddresBookController {

    @GetMapping(value = {"", "/"})

    public String getAllAddressBook(){
        return "get all address book";
    }

    @GetMapping("/{id}")
    public String getAddressBookById(@PathVariable String id){
        return "get address book of id "+id;
    }

    @PostMapping("")
    public String createAddressBook(){
        return "create address book";
    }

    @PutMapping("/{id}")
    public String updateAddressBook(@PathVariable String id){
        return "update address book of id "+id;
    }

    @DeleteMapping("/{id}")
    public String deleteAddressBook(@PathVariable String id){
        return "delete address book of id "+id;
    }

    @DeleteMapping(value = {"", "/"})
    public String deleteAllAddressBook(){
        return "delete all address book";
    }

}

    public ResponseEntity<String> getAllAddressBook(){
        return new ResponseEntity("get all address book", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getAddressBookById(@PathVariable String id){
        return new ResponseEntity("get address book of id "+id, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> createAddressBook(){
        return new ResponseEntity("create address book", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAddressBook(@PathVariable String id){
        return new ResponseEntity("update address book of id "+id, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddressBook(@PathVariable String id){
        return new ResponseEntity("delete address book of id "+id, HttpStatus.OK);
    }

    @DeleteMapping(value = {"", "/"})
    public ResponseEntity<String> deleteAllAddressBook(){
        return new ResponseEntity("delete all address book", HttpStatus.OK);
    }

}

