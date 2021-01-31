package com.example.demo.DTO;

import com.example.demo.enums.Types;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContactUserDTO {
    private Long id;
    private Types type;
    private String content;
    private UserDTO user;
}
