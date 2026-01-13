package com.lhapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhapi.dto.request.ContactRequest;
import com.lhapi.dto.response.ContactResponse;
import com.lhapi.service.ContactService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private ContactService service;

    // POST API
    @PostMapping
    public ResponseEntity<String> submitContact(
            @RequestBody ContactRequest request) {

        return ResponseEntity.ok(service.saveContact(request));
    }

    // GET API
    @GetMapping
    public ResponseEntity<List<ContactResponse>> getContacts() {

        return ResponseEntity.ok(service.getAllContacts());
    }
}
