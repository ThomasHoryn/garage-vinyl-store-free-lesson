package com.tomhor.garagevinylstore.service;

import com.tomhor.garagevinylstore.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    List<Author> findByName(String name);

    Author findById(Long id);

    List<Author> findAll();

    void deleteById(Long id);

    Author save(Author author);


}
