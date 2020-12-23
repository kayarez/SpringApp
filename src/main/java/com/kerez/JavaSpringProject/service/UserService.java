package com.kerez.JavaSpringProject.service;

import com.kerez.JavaSpringProject.exceptions.IncorrectPasswordException;
import com.kerez.JavaSpringProject.exceptions.UserNameNotFoundException;
import com.kerez.JavaSpringProject.model.User;
import com.kerez.JavaSpringProject.model.UserDto;

import java.util.Optional;


public interface UserService {

    User login(UserDto userDto) throws UserNameNotFoundException, IncorrectPasswordException;
    void register(UserDto userDto) throws Exception;
    boolean isAdmin(String username);
    User getUserByUsername(String username);
    User getById(int id);

}
