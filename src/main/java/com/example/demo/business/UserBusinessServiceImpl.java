package com.example.demo.business;

import com.example.demo.DTO.ContactDTO;
import com.example.demo.DTO.UserContactDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.access.UserRepository;
import com.example.demo.entity.Contact;
import com.example.demo.entity.User;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class UserBusinessServiceImpl implements UserBusinessService {
    @Autowired
    private UserRepository userRepository;
    @Autowired ContactBusinessService contactBusinessService;
    @Override
    public UserDTO getUser(Long id) {
        return getUserDTO(userRepository.findById(id).orElseThrow(NullPointerException::new));
    }
    public User getSUser(Long id){
        return userRepository.findById(id).orElseThrow(NullPointerException::new);
    }
    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    //Получить список только список пользователей
    @Override
    public List<UserDTO> getUserDTOList() {
        List<User> userList = (List<User>) userRepository.findAll();
        List<UserDTO> userDTOList = new LinkedList<>();
        for(int i = 0; i <= userList.size(); i++){
            userDTOList.add(getUserDTO(userList.get(i)));
        }
        return userDTOList;
    }

    //Получить только пользователя
    public UserDTO getUserDTO(User user){
        user = userRepository.findById(user.getId()).orElseThrow(NullPointerException::new);
        return new UserDTO(user.getId(), user.getFio(), user.getDate());
    }
    //Получить список пользователей с контактами
    public List<UserContactDTO> getUserContactDTOList(){
        List<User> userList = (List<User>) userRepository.findAll();
        List<UserContactDTO> userContactDTOList = new LinkedList<>();
        for(int i=0; i < userList.size(); i++){
            userContactDTOList.add(getUserContactDTO(userList.get(i)));
        }
        return userContactDTOList;
    }
    //Получить пользователя с контактами
    @Transactional
    public UserContactDTO getUserContactDTO(User user){
        user = userRepository.findById(user.getId()).orElseThrow(NullPointerException::new);
        user.loadList();
        return new UserContactDTO(user.getId(), user.getFio(), user.getDate(), getContactDTOList(user.getContactList()));
    }

    @Override
    public List<UserContactDTO> getDuplicates() {
        List<User> duplicates = userRepository.findDuplicates();
        List<UserContactDTO> dtos = new LinkedList<>();
        for(int i =0; i < duplicates.size(); i++){
            dtos.add(getUserContactDTO(duplicates.get(i)));
        }
        return dtos;
    }

    //Получить список контактов
    private List<ContactDTO> getContactDTOList(List<Contact> contactList){
        return contactBusinessService.getContactDTOList(contactList);
    }
    //Получить пользователя по контактным данным
    public UserDTO getUserByContact(String content) {
        Contact contactDTO = contactBusinessService.getContactByContent(content);
        return getUserDTO(contactDTO.getUser());
    }

}
