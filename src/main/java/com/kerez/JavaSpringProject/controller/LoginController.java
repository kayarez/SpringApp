package com.kerez.JavaSpringProject.controller;

import com.kerez.JavaSpringProject.model.UserDto;
import com.kerez.JavaSpringProject.security.AuthenticationException;
import com.kerez.JavaSpringProject.security.JwtInMemoryUserDetailsService;
import com.kerez.JavaSpringProject.security.JwtTokenUtil;
import com.kerez.JavaSpringProject.service.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@CrossOrigin(value = "*")
@RestController
public class LoginController {
    @Value("${jwt.http.request.header}")
    private String tokenHeader;
    private final UserServiceImpl userService;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;

    private  final JwtInMemoryUserDetailsService jwtInMemoryUserDetailsService;

    @Autowired
    public LoginController(UserServiceImpl userService, AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, JwtInMemoryUserDetailsService jwtInMemoryUserDetailsService) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.jwtInMemoryUserDetailsService = jwtInMemoryUserDetailsService;
    }

    @Operation(summary = "User authentification")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Authorithed",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Wrong format")
    })
    @PostMapping(value = "/rest/api/v1/login")
    public Map<Object, Object> login(@RequestBody @Valid UserDto userDto){
        authenticate(userDto.getUsername(), userDto.getPassword());

        final UserDetails userDetails = jwtInMemoryUserDetailsService
                .loadUserByUsername(userDto.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);
        Map<Object, Object> outToken = new HashMap<>();
        outToken.put("token", token);
        return outToken;
    }

    private void authenticate(String username, String password) {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);


        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new AuthenticationException("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new AuthenticationException("INVALID_CREDENTIALS", e);
        }
    }

}

