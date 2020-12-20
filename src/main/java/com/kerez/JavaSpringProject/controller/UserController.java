package com.kerez.JavaSpringProject.controller;


import com.kerez.JavaSpringProject.OAP.Loggable;
import com.kerez.JavaSpringProject.model.User;
import com.kerez.JavaSpringProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Loggable
    @GetMapping("user")
    public ResponseEntity getUsers() {
        return ResponseEntity.ok(userService.getAll());
    }

    @Loggable
    @PostMapping("user")
    public void saveUser(@RequestBody User user) {
        userService.save(user);
    }

    @Loggable
    @PostMapping("login")
    public ResponseEntity<Object> getAuthUser(@RequestBody AuthRequest request) {

        User userEntity = userService.findByEmailAndPassword(request.getEmail(), request.getPassword());
        if (userEntity == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } else {
            return ResponseEntity.ok(userEntity);
        }
    }

    @GetMapping("/indexx")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("indexx.html");
        return modelAndView;
    }
    // Convert a predefined exception to an HTTP Status code
}


