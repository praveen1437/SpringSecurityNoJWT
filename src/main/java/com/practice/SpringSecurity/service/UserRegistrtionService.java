package com.practice.SpringSecurity.service;

import com.practice.SpringSecurity.Exception.UserAlreadyRegistered;
import com.practice.SpringSecurity.Vo.UserForm;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRegistrtionService {

    boolean registerUser(UserForm userForm) throws UserAlreadyRegistered;
}
