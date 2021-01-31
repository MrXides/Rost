package com.example.demo.access;

import com.example.demo.entity.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends CrudRepository<Contact,Long> {
    Optional<Contact> findById(Long id);
    Optional<Contact> findByContent(String content);
    @Query(value = "SELECT c FROM Contact c WHERE (SELECT COUNT(*) FROM Contact co WHERE co.type = c.type AND co.content = c.content) > 1")
    List<Contact> findDuplicates();
}
