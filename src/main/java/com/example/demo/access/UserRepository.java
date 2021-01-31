package com.example.demo.access;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    Optional<User> findById(Long id);
    @Query(value = "SELECT u FROM User u WHERE (SELECT COUNT(*) FROM User us WHERE us.fio = u.fio AND us.date = u.date) > 1")
    List<User> findDuplicates();
}
