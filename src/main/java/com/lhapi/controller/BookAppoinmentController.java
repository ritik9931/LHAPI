package com.lhapi.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhapi.dto.request.BookApointmentRequest;
import com.lhapi.dto.response.BookApointmentResponse;
import com.lhapi.service.BookApointmentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/bookapointment")
public class BookAppoinmentController {

    @Autowired
    private BookApointmentService service;

    // POST API
    @PostMapping
    public ResponseEntity<Map<String, String>> submitBookApointment(
            @RequestBody BookApointmentRequest request) {

        service.saveBookApointment(request);

        return ResponseEntity.ok(
            Map.of("message", "BookAppointment submitted successfully")
        );
    }

    // GET API
    @GetMapping
    public ResponseEntity<List<BookApointmentResponse>> getBookApointment() {

        return ResponseEntity.ok(service.getAllBookApointment());
    }
}
