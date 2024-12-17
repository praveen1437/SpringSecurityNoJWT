package com.practice.SpringSecurity.service.Impl;

import com.practice.SpringSecurity.Entity.Users;
import com.practice.SpringSecurity.Repository.UserDetailsRepository;
import com.practice.SpringSecurity.service.PreloadUsersInDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class  PreloadUsersInDbImpl implements PreloadUsersInDb {
    @Autowired
    UserDetailsRepository userDetailsRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostConstruct
    void loadUserData() {
        Users user = new Users();
        user.setUserName("Praveen");
        user.setPassWord(passwordEncoder.encode("praveen"));
        System.out.println("password : " + user.getPassWord());
        System.out.println("old : " + "$2a$10$4oRj09INjRRCSEygm8xqXO//PPmO6whsQA9lEjlIf/2mtPonWr4Me");
        userDetailsRepository.save(user);
    }


}
