package com.kerez.JavaSpringProject.service;

import com.kerez.JavaSpringProject.model.UsersAndFilmsModel;
import com.kerez.JavaSpringProject.repository.UsersFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersFilmService extends AbstractService {
    @Autowired
    UsersFilmRepository repository;

    public UsersFilmService(UsersFilmRepository repository) {
        super(repository);
    }

    public List<UsersAndFilmsModel> getAllUsersFilms(int id) {

      return null;
    }
}

