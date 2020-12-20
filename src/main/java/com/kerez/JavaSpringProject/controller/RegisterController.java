package com.kerez.JavaSpringProject.controller;


import com.kerez.JavaSpringProject.OAP.Loggable;
import com.kerez.JavaSpringProject.model.User;
import com.kerez.JavaSpringProject.model.UserDto;
import com.kerez.JavaSpringProject.service.UserService;
import com.kerez.JavaSpringProject.service.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@CrossOrigin(value = "*")
@RestController
public class RegisterController {
    private final UserServiceImpl userService;


    @Autowired
    public RegisterController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Operation(summary = "User registration")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Registered",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Wrong format")
    })
    @PostMapping(value = "/rest/api/v1/register")
    public ResponseEntity register(@RequestBody @Valid UserDto userDto) {
        try {
            userService.register(userDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


