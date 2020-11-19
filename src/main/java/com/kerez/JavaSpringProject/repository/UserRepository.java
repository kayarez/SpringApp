package com.kerez.JavaSpringProject.repository;

import com.kerez.JavaSpringProject.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel,Integer> {
    public UserModel findByEmail(String email);
    public UserModel findByEmailAndPassword(String email, String pass);
}
