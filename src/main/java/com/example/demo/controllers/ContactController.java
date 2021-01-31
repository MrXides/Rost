package com.example.demo.controllers;

import com.example.demo.DTO.ContactDTO;
import com.example.demo.DTO.ContactUserDTO;
import com.example.demo.business.ContactBusinessService;
import com.example.demo.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private ContactBusinessService contactBusinessService;
    @GetMapping
    protected List<ContactDTO> getContactList(){
        return contactBusinessService.getContactsList();
    }
    @GetMapping("{id}")
    protected ContactDTO getContact(@PathVariable Long id){
        return contactBusinessService.getContact(id);
    }
    @PostMapping("/create")
    protected ContactUserDTO create(@RequestBody Contact contact){
        return  contactBusinessService.create(contact);
    }
    @DeleteMapping
    protected void delete(@PathVariable Long id){
        contactBusinessService.delete(id);
    }
    @GetMapping("/dup")
    protected List<ContactDTO> getDuplicates(){
        return contactBusinessService.getDuplicates();
    }
}
