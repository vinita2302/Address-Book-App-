package com.spring.Address_Book_App.controller;



import com.spring.Address_Book_App.dto.AddressBookDto;
import com.spring.Address_Book_App.model.AddressBook;
import com.spring.Address_Book_App.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.spring.Address_Book_App.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.*;


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

    public ResponseEntity<String> getAllAddressBook(){
        return addressBookService.getAllAddressBook();

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

        return addressBookService.getAddressBookById(id);

        return new ResponseEntity("get address book of id "+id, HttpStatus.OK);

    }

    @PostMapping("")
    public ResponseEntity<String> createAddressBook(){

        return addressBookService.createAddressBook();

        return new ResponseEntity("create address book", HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAddressBook(@PathVariable String id){

        return addressBookService.updateAddressBook(id);


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddressBook(@PathVariable String id){

        return addressBookService.deleteAddressBook(Long.parseLong(id));


        return addressBookService.deleteAddressBook(id);

        return new ResponseEntity("delete address book of id "+id, HttpStatus.OK);

    }

    @DeleteMapping(value = {"", "/"})
    public ResponseEntity<String> deleteAllAddressBook(){

        return addressBookService.deleteAllAddressBook();
    }

}


        return addressBookService.deleteAllAddressBook();
    }

}

        return new ResponseEntity("delete all address book", HttpStatus.OK);
    }

}



