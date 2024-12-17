package com.practice.SpringSecurity.Congtroller;

import com.practice.SpringSecurity.Exception.UserAlreadyRegistered;
import com.practice.SpringSecurity.Vo.UserForm;
import com.practice.SpringSecurity.service.UserRegistrtionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.GeneratedValue;

@Controller
public class AuthenticationController {
    @Autowired
    UserRegistrtionService userRegistrtionService;
    @Autowired
    AuthenticationManager authenticationManager;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView authentication() {
        System.out.println("in authenticate controller");
        ModelAndView modelAndView = new ModelAndView("authentication");
        modelAndView.addObject("userForm",new UserForm());
        return modelAndView;
    }


    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ModelAndView register(UserForm userForm) {
        boolean isRegistered = false;
        System.out.println("in registration controller" + userForm);
        System.out.println("in registration controller" + userForm.userName);
        System.out.println("in registration controller" + userForm.passWord);
        ModelAndView modelAndView = new ModelAndView("welcome");
        try{
            isRegistered = userRegistrtionService.registerUser(userForm);
            if(isRegistered) {
                modelAndView.addObject("userName",userForm.name);
            }
        } catch (UserAlreadyRegistered ue) {
            System.out.println("user already registered");
            modelAndView.addObject("userError","User Already Registered");

        } catch (Exception e) {
            modelAndView.addObject("userError","Please Try again after some Time");
            System.out.println("internal server error");
            e.printStackTrace();
        }
        if(!isRegistered) {
            modelAndView.setViewName("authentication");
        }
        return modelAndView;
    }

    @GetMapping("/logout")
    public String logout() {

        return "logout";
    }
}
