package com.example.demo.service.mongo;

import com.example.demo.model.mongo.EmpleadoMongo;
import com.example.demo.repository.mongo.EmpleadoMongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoMongoService {

    private final EmpleadoMongoRepository repository;

    public EmpleadoMongoService(EmpleadoMongoRepository repository) {
        this.repository = repository;
    }

    public List<EmpleadoMongo> findAll() {
        return repository.findAll();
    }

    public Optional<EmpleadoMongo> findById(String id) {
        return repository.findById(id);
    }

    public EmpleadoMongo save(EmpleadoMongo empleado) {
        return repository.save(empleado);
    }

    public EmpleadoMongo update(String id, EmpleadoMongo updated) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setNombre(updated.getNombre());
                    existing.setPuesto(updated.getPuesto());
                    existing.setTipoJornada(updated.getTipoJornada());
                    existing.setEmail(updated.getEmail());
                    existing.setTelefono(updated.getTelefono());
                    existing.setFechaContratacion(updated.getFechaContratacion());
                    existing.setSalarioHora(updated.getSalarioHora());
                    existing.setActivo(updated.getActivo());
                    return repository.save(existing);
                })
                .orElse(null);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
