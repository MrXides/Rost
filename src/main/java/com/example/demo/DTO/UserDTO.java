package com.example.demo.DTO;

import com.example.demo.entity.Contact;
import com.example.demo.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Long id;
    private String fio;
    private Date date;

    public UserDTO (Long id,String fio,Date date) {
        this.id = id;
        this.fio = fio;
        this.date = date;
    }
}
