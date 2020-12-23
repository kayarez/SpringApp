package com.kerez.JavaSpringProject.Repository;

import com.kerez.JavaSpringProject.repository.UserRepository;
import com.kerez.JavaSpringProject.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserRepositoryTests {
    @Autowired
    private UserService userService;

    @Test
    public void getUserByName() {
        Assert.assertNotNull(userService.getUserByUsername("Katya"));
    }

    @Test
    public void getNullUserByName() {
        Assert.assertNull(userService.getUserByUsername("Admin"));
    }
}
