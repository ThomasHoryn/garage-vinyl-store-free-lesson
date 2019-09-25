package com.tomhor.garagevinylstore.repository;

import com.tomhor.garagevinylstore.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    List<Author> findByName(String name);
}
