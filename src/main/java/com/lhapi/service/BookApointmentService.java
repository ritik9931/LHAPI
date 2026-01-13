package com.lhapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhapi.dto.request.BookApointmentRequest;
import com.lhapi.dto.response.BookApointmentResponse;
import com.lhapi.entity.BookApointment;
import com.lhapi.reposioory.BoookApointmentRepository;

@Service
public class BookApointmentService {

    @Autowired
    private BoookApointmentRepository repository;

    // POST - Save BookApointment
   public void saveBookApointment(BookApointmentRequest request) {

    BookApointment bookapointment = new BookApointment();
    bookapointment.setFullname(request.getFullname());
    bookapointment.setEmail(request.getEmail());
    bookapointment.setPhonenumber(request.getPhonenumber());
    bookapointment.setDepartment(request.getDepartment());
    bookapointment.setAppointmentDate(request.getAppointmentDate());
    bookapointment.setMessage(request.getMessage());

    repository.save(bookapointment);
}
    // GET - Fetch All BookApointment
    public List<BookApointmentResponse> getAllBookApointment() {

        return repository.findAll()
                .stream()
                .map(c -> {
                    BookApointmentResponse res = new BookApointmentResponse();
                    res.setId(c.getId());
                    res.setFullname(c.getFullname());
                    res.setEmail(c.getEmail());
                    res.setPhonenumber(c.getPhonenumber());
                    res.setDepartment(c.getDepartment());
                    res.setAppointmentDate(c.getAppointmentDate());
                    res.setMessage(c.getMessage());
                    return res;
                })
                .toList();
    }
}
