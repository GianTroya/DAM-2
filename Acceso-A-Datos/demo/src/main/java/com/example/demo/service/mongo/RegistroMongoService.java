package com.example.demo.service.mongo;

import com.example.demo.model.mongo.RegistroMongo;
import com.example.demo.repository.mongo.RegistroMongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroMongoService {

    private final RegistroMongoRepository repository;

    public RegistroMongoService(RegistroMongoRepository repository) {
        this.repository = repository;
    }

    public List<RegistroMongo> findAll() {
        return repository.findAll();
    }

    public Optional<RegistroMongo> findById(String id) {
        return repository.findById(id);
    }

    public RegistroMongo save(RegistroMongo registro) {
        return repository.save(registro);
    }

    public RegistroMongo update(String id, RegistroMongo updated) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setIdEmpleado(updated.getIdEmpleado());
                    existing.setMes(updated.getMes());
                    existing.setAno(updated.getAno());
                    existing.setHorasTotales(updated.getHorasTotales());
                    existing.setHorasExtra(updated.getHorasExtra());
                    return repository.save(existing);
                })
                .orElse(null);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
