package com.example.demo.DTO;

import com.example.demo.enums.Types;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ContactDTO {
    private Long id;
    private Types type;
    private String content;

    public ContactDTO(Long id, Types type, String content) {
        this.id = id;
        this.type = type;
        this.content = content;
    }
}
