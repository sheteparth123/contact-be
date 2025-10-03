package com.parth.contactapp.service;



import com.parth.contactapp.entity.Contact;
import com.parth.contactapp.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    private final ContactRepository repository;

    public ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    public List<Contact> getAllContacts() {
        return repository.findAll();
    }

    public Contact saveContact(Contact contact) {
        return repository.save(contact);
    }

    public void deleteContact(Long id) {
        repository.deleteById(id);
    }

    public Contact getContactById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
