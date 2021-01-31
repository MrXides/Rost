package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "User", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fio;
    private Date date;
    //ЗАГУГЛИ ПРО mappedBY (тут написано правильно но чтоб ты знал), и про cascade и поставь правильный
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Contact> contactList = new LinkedList<>();

    public User(String fio, Date date) {
        this.fio = fio;
        this.date = date;
    }

    public void loadList() {
        contactList.size();
    }
    //mappedBy = "user"
}
