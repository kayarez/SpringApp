package com.kerez.JavaSpringProject.service;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public class AbstractService {
    public AbstractService(CrudRepository repository) {
        this.repository = repository;
    }

    public CrudRepository<BasicEntity, Long> repository;

    public List getAll() {
        return (List) repository.findAll();
    }

    public BasicEntity getById(int id) {
        return repository.findById((long) id).get();
    }

    public BasicEntity save(BasicEntity basicEntity) {
        return repository.save(basicEntity);
    }

    public void delete(BasicEntity basicEntity) {
        repository.delete(basicEntity);
    }

    public void deleteById(int id) {
        repository.deleteById((long) id);
    }


}
