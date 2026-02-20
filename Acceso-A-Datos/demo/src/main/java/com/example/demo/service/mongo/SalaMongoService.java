package com.example.demo.service.mongo;

import com.example.demo.model.mongo.SalaMongo;
import com.example.demo.repository.mongo.SalaMongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaMongoService {

    private final SalaMongoRepository repository;

    public SalaMongoService(SalaMongoRepository repository) {
        this.repository = repository;
    }

    public List<SalaMongo> findAll() {
        return repository.findAll();
    }

    public Optional<SalaMongo> findById(String id) {
        return repository.findById(id);
    }

    public SalaMongo save(SalaMongo sala) {
        return repository.save(sala);
    }

    public SalaMongo update(String id, SalaMongo updated) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setNombreSala(updated.getNombreSala());
                    existing.setCapacidad(updated.getCapacidad());
                    existing.setTipoSala(updated.getTipoSala());
                    existing.setCalidadSonido(updated.getCalidadSonido());
                    existing.setActiva(updated.isActiva());
                    return repository.save(existing);
                })
                .orElse(null);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
