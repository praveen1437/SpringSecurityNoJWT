package com.practice.SpringSecurity.service.Impl;

import com.practice.SpringSecurity.Entity.Users;
import com.practice.SpringSecurity.Repository.UserDetailsRepository;
import com.practice.SpringSecurity.Vo.User;
import com.practice.SpringSecurity.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userDetailsRepository.findByUserName(username);
        System.out.println("user details : " + user);
        System.out.println("user details username: " + username);

        //return new User(user.getPassWord(), user.getUserName(), new ArrayList<>());
        if(user!=null) {
            System.out.println("user details username: " + user.getPassWord());
            return new User(user.getPassWord(), user.getUserName(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}

