package com.practice.SpringSecurity.service.Impl;

import com.practice.SpringSecurity.Entity.Users;
import com.practice.SpringSecurity.Exception.UserAlreadyRegistered;
import com.practice.SpringSecurity.Repository.UserDetailsRepository;
import com.practice.SpringSecurity.Vo.User;
import com.practice.SpringSecurity.Vo.UserForm;
import com.practice.SpringSecurity.service.UserRegistrtionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrtionServiceImpl implements UserRegistrtionService {
    @Autowired
    UserDetailsRepository  userDetailsRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public boolean registerUser(UserForm userForm) throws UserAlreadyRegistered {
        boolean isRegistered =  false;
        System.out.println("in registration service : username " + userForm.userName);
        Users users = userDetailsRepository.findByUserName(userForm.userName);
        System.out.println("userDetailsRepository db : " + users);
        if(users!=null) {
            throw new UserAlreadyRegistered();
        } else{
            Users newUser = prepareUserObject(userForm);
            userDetailsRepository.save(newUser);
            isRegistered = true;
        }
        return isRegistered;
    }

    private Users prepareUserObject(UserForm userForm) {
        return new Users(userForm.userName,passwordEncoder.encode(userForm.passWord));
    }
}
