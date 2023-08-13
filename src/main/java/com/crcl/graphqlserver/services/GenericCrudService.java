package com.crcl.graphqlserver.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
public abstract class GenericCrudService<T, ID> {

    protected MongoRepository<T, ID> repository;

    public GenericCrudService(MongoRepository<T, ID> repository) {
        this.repository = repository;
    }

    public T create(T entity) {
        log.debug("Start saving entity: {}", entity.getClass().getName());
        T savedEntity = repository.save(entity);
        log.debug("Saved entity: {}", savedEntity);
        return savedEntity;
    }

    public Optional<T> read(ID id) {
        log.debug("Reading entity by ID: {}", id);
        return repository.findById(id);
    }

    public List<T> readAll() {
        log.debug("Reading all entities");
        final List<T> all = repository.findAll();
        log.debug("Read {} entities: {}", all.size(), all);
        return all;
    }

    public T update(T entity) {
        log.debug("Updating entity: {}", entity);
        return repository.save(entity);
    }

    public void delete(ID id) {
        log.debug("Deleting entity by ID: {}", id);
        repository.deleteById(id);
    }

    public T findById(ID id) {
        log.debug("Finding entity by ID: {}", id);
        return repository.findById(id).orElse(null);
    }
}
