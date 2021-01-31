package com.example.demo.business;

import com.example.demo.DTO.ContactDTO;
import com.example.demo.DTO.ContactUserDTO;
import com.example.demo.DTO.UserContactDTO;
import com.example.demo.access.ContactRepository;
import com.example.demo.entity.Contact;
import com.example.demo.entity.User;
import com.example.demo.enums.Types;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactBusinessServiceImpl implements ContactBusinessService{
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private UserBusinessService userBusinessService;
    @Override
    public ContactDTO getContact(Long id) {
        Contact contact = contactRepository.findById(id).orElseThrow(NullPointerException::new);
         return new ContactDTO(contact.getId(), contact.getType(), contact.getContent());
    }

    @Override
    public ContactUserDTO create(Contact contact) {
        contact.setUser(userBusinessService.getSUser(contact.getId()));
        contactRepository.save(contact);
        return new ContactUserDTO(contact.getId(), contact.getType(), contact.getContent(),userBusinessService.getUser(contact.getId()));
    }

    @Override
    public void delete(Long id) {
        contactRepository.deleteById(id);
    }

    @Override
    public List<ContactDTO> getContactsList() {
        return getContactDTOList((List<Contact>) contactRepository.findAll());
    }

    public ContactDTO getContactDTO(Contact contact){
        return new ContactDTO(contact.getId(), contact.getType(), contact.getContent());
    }

    @Override
    public List<ContactDTO> getContactDTOList(List<Contact> contactList) {
        List<ContactDTO> contactDTOList = new LinkedList<>();
        for(int i = 0; i < contactList.size(); i++){
            contactDTOList.add(getContactDTO(contactList.get(i)));
        }
        return contactDTOList;
    }

    public Contact getContactByContent(String content){
        return contactRepository.findByContent(content).orElseThrow(NullPointerException::new);
    }

    @Override
    public List<ContactDTO> getDuplicates() {
        List<Contact> duplicates = contactRepository.findDuplicates();
        List<ContactDTO> dtos = new LinkedList<>();
        for(int i =0; i < duplicates.size(); i++){
            dtos.add(getContactDTO(duplicates.get(i)));
        }
        return dtos;
    }

    private ContactUserDTO getContactUserDTO(Contact contact){
        contact = contactRepository.findById(contact.getId()).orElseThrow(NullPointerException::new);
        return new ContactUserDTO(contact.getId(), contact.getType(), contact.getContent(), userBusinessService.getUserDTO(contact.getUser()));
    }
}
