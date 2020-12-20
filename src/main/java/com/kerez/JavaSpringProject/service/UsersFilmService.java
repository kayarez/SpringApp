package com.kerez.JavaSpringProject.service;

import com.kerez.JavaSpringProject.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersFilmService extends AbstractService {
    @Autowired
    RoleRepository repository;

    public UsersFilmService(RoleRepository repository) {
        super(repository);
    }

    public List<UsersAndFilmsModel> getAllUsersFilms(int id) {

      return null;
    }
}

