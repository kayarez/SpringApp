package com.kerez.JavaSpringProject.controller;

import com.kerez.JavaSpringProject.AOP.Loggable;
import com.kerez.JavaSpringProject.model.User;
import com.kerez.JavaSpringProject.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping(value = "/register", method = RequestMethod.GET)
public class MailController {
    public final JavaMailSender emailSender;
    private final UserService userService;


    public MailController(JavaMailSender emailSender, UserService userService) {
        this.emailSender = emailSender;
        this.userService = userService;
    }

    @GetMapping(value = "sendNotify")
    @Loggable
    public ResponseEntity<Object> sendSimpleEmail(Principal principal) {

        SimpleMailMessage message = new SimpleMailMessage();
        User user = userService.getUserByUsername(principal.getName());
        message.setTo(user.getEmail());
        message.setFrom("appspringapp@gmail.com");
        message.setSubject("SpringApp");
        StringBuilder msg = new StringBuilder("You are successfully registered\n\n");


        message.setText(String.valueOf(msg));
        this.emailSender.send(message);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

