package com.tomhor.garagevinylstore.service;

import com.tomhor.garagevinylstore.model.Author;
import com.tomhor.garagevinylstore.model.Vinyl;
import com.tomhor.garagevinylstore.repository.VinylRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VinylServiceImpl implements VinylService{
    private final VinylRepository vinylRepository;

    public VinylServiceImpl(VinylRepository vinylRepository) {
        this.vinylRepository = vinylRepository;
    }

    @Override
    public List<Vinyl> findByName(String name) {
        List<Vinyl> vinyls = new ArrayList<>();
        vinylRepository.findByName(name).iterator().forEachRemaining(vinyls::add);
        return vinyls;
    }

    @Override
    public Optional<Vinyl> findById(Long id) {
        Optional<Vinyl> vinylOptional = vinylRepository.findById(id);
        vinylOptional.orElseThrow(() -> new EntityNotFoundException("Nie znaleziono autora o podanym id " + id));
        return vinylOptional;
    }

    @Override
    public List<Vinyl> findAll() {
        List<Vinyl> vinyls = new ArrayList<>();
        vinylRepository.findAll().iterator().forEachRemaining(vinyls::add);
        return vinyls;
    }

    @Override
    public void deleteById(Long id) {
        vinylRepository.deleteById(id);
    }

    @Override
    public Vinyl save(Vinyl vinyl) {
        return vinylRepository.save(vinyl);
    }

    @Override
    public List<Vinyl> findByAuthor(Author author) {
        return vinylRepository.findByAuthor(author);
    }
}
