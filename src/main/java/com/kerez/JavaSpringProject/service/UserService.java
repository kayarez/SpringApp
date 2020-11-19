package com.kerez.JavaSpringProject.service;

import com.kerez.JavaSpringProject.model.UserModel;
import com.kerez.JavaSpringProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends AbstractService {

    @Autowired
    private UserRepository repository;

    public UserService(UserRepository repository) {
        super(repository);
    }

    public Optional<UserModel> findByEmail(String name) {
        return Optional.of(repository.findByEmail(name));
    }

    public UserModel findByEmailAndPassword(String name, String pass) {
        return repository.findByEmailAndPassword(name, pass);
    }

}
