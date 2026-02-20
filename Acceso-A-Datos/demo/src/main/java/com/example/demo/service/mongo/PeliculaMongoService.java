package com.example.demo.service.mongo;

import com.example.demo.model.mongo.PeliculaMongo;
import com.example.demo.repository.mongo.PeliculaMongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaMongoService {

    private final PeliculaMongoRepository repository;

    public PeliculaMongoService(PeliculaMongoRepository repository) {
        this.repository = repository;
    }

    public List<PeliculaMongo> findAll() {
        return repository.findAll();
    }

    public Optional<PeliculaMongo> findById(String id) {
        return repository.findById(id);
    }

    public PeliculaMongo save(PeliculaMongo pelicula) {
        return repository.save(pelicula);
    }

    public PeliculaMongo update(String id, PeliculaMongo updated) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setTitulo(updated.getTitulo());
                    existing.setDuracionMinutos(updated.getDuracionMinutos());
                    existing.setGenero(updated.getGenero());
                    existing.setClasificacion(updated.getClasificacion());
                    existing.setDirector(updated.getDirector());
                    existing.setSinopsis(updated.getSinopsis());
                    existing.setFechaEstreno(updated.getFechaEstreno());
                    return repository.save(existing);
                })
                .orElse(null);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
