package com.example.demo.service.mongo;

import com.example.demo.model.mongo.AsignacionMongo;
import com.example.demo.repository.mongo.AsignacionMongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsignacionMongoService {

    private final AsignacionMongoRepository repository;

    public AsignacionMongoService(AsignacionMongoRepository repository) {
        this.repository = repository;
    }

    public List<AsignacionMongo> findAll() {
        return repository.findAll();
    }

    public Optional<AsignacionMongo> findById(String id) {
        return repository.findById(id);
    }

    public AsignacionMongo save(AsignacionMongo asignacion) {
        return repository.save(asignacion);
    }

    public AsignacionMongo update(String id, AsignacionMongo updated) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setIdEmpleado(updated.getIdEmpleado());
                    existing.setIdProyeccion(updated.getIdProyeccion());
                    existing.setRol(updated.getRol());
                    return repository.save(existing);
                })
                .orElse(null);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
