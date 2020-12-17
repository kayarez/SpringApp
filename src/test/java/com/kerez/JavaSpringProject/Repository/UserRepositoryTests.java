package com.kerez.JavaSpringProject.Repository;

import com.kerez.JavaSpringProject.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByEmail() {
        Assert.assertNotNull(userRepository.findByEmail("tansteppp@gmail.com"));
    }
}
