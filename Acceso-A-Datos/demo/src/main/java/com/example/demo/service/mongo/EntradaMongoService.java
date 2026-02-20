package com.example.demo.service.mongo;

import com.example.demo.model.mongo.EntradaMongo;
import com.example.demo.repository.mongo.EntradaMongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntradaMongoService {

    private final EntradaMongoRepository repository;

    public EntradaMongoService(EntradaMongoRepository repository) {
        this.repository = repository;
    }

    public List<EntradaMongo> findAll() {
        return repository.findAll();
    }

    public Optional<EntradaMongo> findById(String id) {
        return repository.findById(id);
    }

    public EntradaMongo save(EntradaMongo entrada) {
        return repository.save(entrada);
    }

    public EntradaMongo update(String id, EntradaMongo updated) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setIdProyeccion(updated.getIdProyeccion());
                    existing.setFechaCompra(updated.getFechaCompra());
                    return repository.save(existing);
                })
                .orElse(null);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
