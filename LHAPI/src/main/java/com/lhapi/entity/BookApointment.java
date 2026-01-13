package com.lhapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "BookApointment")
@Data
public class BookApointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullname;
    private String email;
    private String phonenumber;
    private String department;
    
    @Column(name = "appointment_date")
    private String appointmentDate;


    @Column(length = 1000)
    private String message;
}
