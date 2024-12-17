package com.practice.SpringSecurity.Congtroller;

import com.practice.SpringSecurity.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/home")
    public String home() {
        System.out.println("in home controller");
        return "home";
    }
}
