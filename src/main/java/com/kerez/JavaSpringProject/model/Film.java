package com.kerez.JavaSpringProject.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column
    public String name;
    @Column
    public String description;
    @ManyToOne()
    @JoinColumn(name = "producer")
    public Producer producer;

    public Film() {
    }

    public Film(int id, String name, String description, Producer producer) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.producer = producer;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
}
