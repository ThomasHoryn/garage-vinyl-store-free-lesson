package com.tomhor.garagevinylstore.repository;

import com.tomhor.garagevinylstore.model.Author;
import com.tomhor.garagevinylstore.model.Vinyl;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VinylRepository extends CrudRepository<Vinyl, Long> {

    List<Vinyl> findByName(String name);

    List<Vinyl> findByAuthor(Author author);
}
