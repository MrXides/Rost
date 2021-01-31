package com.example.demo.entity;

import com.example.demo.enums.Types;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Contact", schema = "public")
public class Contact {
 @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 @Enumerated(EnumType.STRING)
 private Types type;
 private String content;
 @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
 @JoinColumn(name = "user_id")
 private User user;
}
