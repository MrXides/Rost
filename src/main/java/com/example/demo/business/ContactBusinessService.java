package com.example.demo.business;

import com.example.demo.DTO.ContactDTO;
import com.example.demo.DTO.ContactUserDTO;
import com.example.demo.entity.Contact;
import com.example.demo.enums.Types;

import java.util.List;
import java.util.Optional;

public interface ContactBusinessService {
    ContactDTO getContact (Long id);
    ContactUserDTO create (Contact contact);
    void delete (Long id);
    List<ContactDTO> getContactsList();
    ContactDTO getContactDTO(Contact contact);
    List<ContactDTO> getContactDTOList(List<Contact> contactList);
    Contact getContactByContent(String content);
    List<ContactDTO> getDuplicates();
}
