package com.lhapi.reposioory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lhapi.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
