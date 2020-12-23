package com.kerez.JavaSpringProject.service.impl;

import com.kerez.JavaSpringProject.AOP.Loggable;
import com.kerez.JavaSpringProject.config.Mapper;
import com.kerez.JavaSpringProject.exceptions.IncorrectPasswordException;
import com.kerez.JavaSpringProject.exceptions.UserNameNotFoundException;
import com.kerez.JavaSpringProject.model.User;
import com.kerez.JavaSpringProject.model.UserDto;
import com.kerez.JavaSpringProject.repository.RoleRepository;
import com.kerez.JavaSpringProject.repository.UserRepository;
import com.kerez.JavaSpringProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Loggable
    public User login(UserDto userDto) throws UserNameNotFoundException, IncorrectPasswordException {
        User user = Mapper.map(userDto, User.class);

        user.setUsername(user.getUsername().toLowerCase());
        User possibleUser = userRepository
                .findUserByUsername(userDto
                        .getUsername())
                .orElseThrow(()->new UserNameNotFoundException("User not found"));
        if(!passwordEncoder.matches(userDto.getPassword(), possibleUser.getPassword())) throw new IncorrectPasswordException("Incorrect password");

        return possibleUser;
    }

    @Override
    @Loggable
    public void register(UserDto userDto) throws Exception {
        if(userRepository
                .findUserByUsername(userDto.getUsername())
                .isPresent()) throw new Exception("User has already registered");

        if(!userDto
                .getPassword()
                .equals(userDto
                        .getRepeatPassword())){
            throw new Exception("Passwords are not equal");
        }

        User user = new User();
        user.setUsername(userDto.getUsername());

        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        user.setEmail(userDto.getEmail());

        user.setRole(roleRepository.getRoleByName("USER"));
        userRepository.save(user);
    }

    @Override
    @Loggable
    public boolean isAdmin(String username) {
        return userRepository.findUserByUsername(username)
                .get()
                .getRole()
                .getName()
                .equals("ADMIN");
    }

    @Override
    @Loggable
    public User getUserByUsername(String username) {
        return userRepository
                .findUserByUsername(username)
                .get();
    }

    @Override
    public User getById(int id) {
        return userRepository.findById((long) id).get();
    }
}
