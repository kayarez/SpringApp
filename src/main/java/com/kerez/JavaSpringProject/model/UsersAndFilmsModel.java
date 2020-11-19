package com.kerez.JavaSpringProject.model;

import javax.persistence.*;

@Entity
@Table(name = "users_and_films")
public class UsersAndFilmsModel {
    private int id;
    private int userId;
    private int filmId;
    private int reviews;
    private int duration;
    FilmModel film;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "film_id", nullable = false)
    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int scooterId) {
        this.filmId = filmId;
    }

    @Basic
    @Column(name = "reviews", nullable = false)
    public int getReviews() {
        return reviews;
    }

    public void setReviews(int reviews) { this.reviews = reviews; }

    @Basic
    @Column(name = "duration", nullable = false)
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


    @ManyToOne
    @JoinColumn(name = "film_id",insertable = false,updatable = false)
    public FilmModel getFilm() {
        return film;
    }

    public void setFilm(FilmModel film) {
        this.film = film;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersAndFilmsModel that = (UsersAndFilmsModel) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (filmId != that.filmId) return false;
        if (duration != that.duration) return false;
        if (reviews != that.reviews) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + filmId;
        result = 31 * result + reviews;
        result = 31 * result + duration;
        return result;
    }
}

