package com.kerez.JavaSpringProject.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserModel extends BasicEntity {
    private int id;
    private String login;
    private String email;
    private Integer review;
    private int role;
    private String password;

    public UserModel() {
    }

    public UserModel(int id, String login, String email, Integer review, int role, String password) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.review = review;
        this.role = role;
        this.password = password;
    }

    @ManyToMany
    @JoinTable(
            name = "users_and_films",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = @JoinColumn(name = "film_id"))
    private Set<UserModel> users;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login", nullable = false, length = 20)
    public String getLogin() {
        return login;
    }

    public void setLogin(String name) {
        this.login = name;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 30)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "review", nullable = true)
    public Integer getReview() { return review; }

    public void setReview(Integer money) {
        this.review = review;
    }

    @Basic
    @Column(name = "role", nullable = false)
    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Basic
    @Column(name = "password",nullable = false)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserModel userModel = (UserModel) o;

        if (id != userModel.id) return false;
        if (role != userModel.role) return false;
        if (login != null ? !login.equals(userModel.login) : userModel.login != null) return false;
        if (email != null ? !email.equals(userModel.email) : userModel.email != null) return false;
        if (review != null ? !review.equals(userModel.review) : userModel.review != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (review != null ? review.hashCode() : 0);
        result = 31 * result + role;
        return result;
    }
}
