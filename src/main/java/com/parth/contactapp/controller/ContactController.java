package com.parth.contactapp.controller;

import com.parth.contactapp.entity.Contact;
import com.parth.contactapp.service.ContactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
@CrossOrigin(origins = "http://localhost:3000") // React dev URL
public class ContactController {
    private final ContactService service;

    public ContactController(ContactService service) {
        this.service = service;
    }

    @GetMapping
    public List<Contact> getAll() {
        return service.getAllContacts();
    }

    @PostMapping
    public Contact add(@RequestBody Contact contact) {
        return service.saveContact(contact);
    }

    @GetMapping("/{id}")
    public Contact get(@PathVariable Long id) {
        return service.getContactById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteContact(id);

            System.out.println("Contact with ID " + id + " deleted successfully!");


    }
}

