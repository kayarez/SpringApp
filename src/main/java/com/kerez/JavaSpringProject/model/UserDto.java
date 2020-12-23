package com.kerez.JavaSpringProject.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDto {
    @NotBlank(message = "Enter the username")
    @Size(min = 5, max = 15,message = "Username must be between 5 and 15 symbols")
    private String username;
    @Size(min = 8, max = 20,message = "Password must be between 8 and 20 symbols")
    @NotBlank(message = "Enter the password")
    private String password;
    @Size(min = 8, max = 20,message = "Password must be between 8 and 20 symbols")
    private String repeatPassword;
    @Size(min = 8, max = 20,message = "Email must be between 8 and 20 symbols")
    @NotBlank(message = "Enter the email")
    private String email;

    public UserDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserDto(@NotBlank(message = "Enter the username") @Size(min = 5, max = 15, message = "Username must be between 5 and 15 symbols") String username, @Size(min = 8, max = 20, message = "Password must be between 8 and 20 symbols") @NotBlank(message = "Enter the password") String password, @Size(min = 8, max = 20, message = "Password must be between 8 and 20 symbols") String repeatPassword,  @Size(min = 8, max = 20,message = "Email must be between 8 and 20 symbols")
    @NotBlank(message = "Enter the email")
    String email) {
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.email = email;
    }
}

