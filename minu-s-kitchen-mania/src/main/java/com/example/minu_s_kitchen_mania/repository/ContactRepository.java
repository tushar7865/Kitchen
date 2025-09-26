package com.example.minu_s_kitchen_mania.repository;

import com.example.minu_s_kitchen_mania.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {
}
