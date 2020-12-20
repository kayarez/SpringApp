package com.kerez.JavaSpringProject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column
    public String name;
    @Column
    public int rating;
    @JsonBackReference
    @OneToMany(mappedBy = "producer", fetch = FetchType.EAGER)
    public List<Film> films;

    public Producer() {
    }

    public Producer(int id, String name, int rating, List<Film> films) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.films = films;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
