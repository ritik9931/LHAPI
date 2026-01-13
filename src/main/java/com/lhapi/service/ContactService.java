package com.lhapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhapi.dto.request.ContactRequest;
import com.lhapi.dto.response.ContactResponse;
import com.lhapi.entity.Contact;
import com.lhapi.reposioory.ContactRepository;

@Service
public class ContactService {

    @Autowired
    private ContactRepository repository;

    // POST - Save Contact
    public String saveContact(ContactRequest request) {

        Contact contact = new Contact();
        contact.setFullname(request.getFullname());
        contact.setEmail(request.getEmail());
        contact.setPhonenumber(request.getPhonenumber());
        contact.setSubject(request.getSubject());
        contact.setMessage(request.getMessage());

        repository.save(contact);
        return "Contact submitted successfully";
    }

    // GET - Fetch All Contacts
    public List<ContactResponse> getAllContacts() {

        return repository.findAll()
                .stream()
                .map(c -> {
                    ContactResponse res = new ContactResponse();
                    res.setId(c.getId());
                    res.setFullname(c.getFullname());
                    res.setEmail(c.getEmail());
                    res.setPhonenumber(c.getPhonenumber());
                    res.setSubject(c.getSubject());
                    res.setMessage(c.getMessage());
                    return res;
                })
                .toList();
    }
}
