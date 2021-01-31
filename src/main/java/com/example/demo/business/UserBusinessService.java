package com.example.demo.business;

import com.example.demo.DTO.UserContactDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.entity.User;
import org.springframework.data.annotation.CreatedBy;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserBusinessService {
    //Получение User по id
    //Optional<User> - тип возвращаемого значения (return)
    //getUser - название метода
    //(Long id) - входной параметр метода
    //Optional может иметь User = null; Если без Optional будет User то при User = null; будет NullPointerException
    UserDTO getUser(Long id);
    User getSUser(Long id);
    User create (User user);
    void delete (Long id);
    List<UserDTO> getUserDTOList();
    UserDTO getUserDTO(User user);
    List<UserContactDTO> getUserContactDTOList();
    UserContactDTO getUserContactDTO(User user);
    List<UserContactDTO> getDuplicates();
}

