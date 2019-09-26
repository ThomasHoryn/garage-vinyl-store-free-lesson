package com.tomhor.garagevinylstore.service;

import com.tomhor.garagevinylstore.model.Author;
import com.tomhor.garagevinylstore.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findByName(String name) {
        List<Author> authors = new ArrayList<>();
        authorRepository.findByName(name).iterator().forEachRemaining(authors::add);
        return authors;
    }

    @Override
    public Author findById(Long id) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        authorOptional.orElseThrow(() -> new EntityNotFoundException("Nie znaleziono autora o podanym id " + id));
        return authorOptional.get();
    }

    @Override
    public List<Author> findAll() {
        List<Author> authors = new ArrayList<>();
        authorRepository.findAll().iterator().forEachRemaining(authors::add);
        return authors;
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

}
