package com.example.demo.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class UserContactDTO {
    private Long id;
    private String fio;
    private Date date;
    private List<ContactDTO> contactList = new LinkedList<>();

    public UserContactDTO (Long id,String fio,Date date,List<ContactDTO> contactList) {
        this.id = id;
        this.fio = fio;
        this.date = date;
        this.contactList = contactList;
    }
}
