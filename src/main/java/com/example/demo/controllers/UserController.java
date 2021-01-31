package com.example.demo.controllers;

import com.example.demo.DTO.UserContactDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.business.UserBusinessService;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserBusinessService userBusinessService;
    @GetMapping
    protected List<UserContactDTO> getUserContactList(){
        return userBusinessService.getUserContactDTOList();
    }
    @GetMapping("{id}")
    protected UserDTO getUser(@PathVariable Long id){
       return userBusinessService.getUser(id);
    }
    @PostMapping("/create")
    protected User create(@RequestBody User user){
        return userBusinessService.create(user);
    }
    @DeleteMapping("{id}")
    protected void delete(@PathVariable Long id){
        userBusinessService.delete(id);
    }
    @GetMapping("/dup")
    protected  List<UserContactDTO> getDuplicates(){
        return userBusinessService.getDuplicates();
    }
}
