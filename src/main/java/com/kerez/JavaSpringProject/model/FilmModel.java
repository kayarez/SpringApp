package com.kerez.JavaSpringProject.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "film")
public class FilmModel extends BasicEntity {

    private int id;
    private int rating;
    private int duration;
    private int producerId;
    private String name;
    private String description;
    private String image;



    @ManyToMany(mappedBy = "films")
    private Set<UserModel> users;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Basic
    @Column(name = "rating", nullable = false)
    public int getRating() {
        return rating;
    }

    public void setRating(int e) { this.rating = rating; }


    @Basic
    @Column(name = "duration", nullable = false)
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "producer_id", nullable = false)
    public int getProducerId() {
        return producerId;
    }

    public void setProducerId(int producerId) {
        this.producerId = producerId;
    }

    @Basic
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "image", nullable = false)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmModel that = (FilmModel) o;

        if (id != that.id) return false;
        if (rating != that.rating) return false;
        if (duration != that.duration) return false;
        if (producerId != that.producerId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) rating;
        result = 31 * result + duration;
        result = 31 * result + producerId;
        return result;
    }
}

