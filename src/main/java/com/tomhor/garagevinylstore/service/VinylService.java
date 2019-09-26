package com.tomhor.garagevinylstore.service;

import com.tomhor.garagevinylstore.model.Author;
import com.tomhor.garagevinylstore.model.Vinyl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface VinylService {
    List<Vinyl> findByName(String name);

    List<Vinyl> findByAuthor(Author author);

    Optional<Vinyl> findById(Long id);

    List<Vinyl> findAll();

    void deleteById(Long id);

    Vinyl save(Vinyl vinyl);
}
