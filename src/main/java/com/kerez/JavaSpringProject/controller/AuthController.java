package com.kerez.JavaSpringProject.controller;

import com.kerez.JavaSpringProject.model.User;
import com.kerez.JavaSpringProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired

    @GetMapping("/register")
    public ModelAndView registerPage() {
        return new ModelAndView("register.html");
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody RegistrationRequest registrationRequest) {
        User u = new User();
        u.setPassword(registrationRequest.getPassword());
        u.setLogin(registrationRequest.getLogin());
        u.setRole(1);
        System.out.println(registrationRequest);
        User user= new User();
        try {
            user = (User) userService.save(u);
        }catch (Exception ex){
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.ok(user);
    }

}

