package com.example.demo.service.mongo;

import com.example.demo.model.mongo.ProyeccionMongo;
import com.example.demo.repository.mongo.ProyeccionMongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyeccionMongoService {

    private final ProyeccionMongoRepository repository;

    public ProyeccionMongoService(ProyeccionMongoRepository repository) {
        this.repository = repository;
    }

    public List<ProyeccionMongo> findAll() {
        return repository.findAll();
    }

    public Optional<ProyeccionMongo> findById(String id) {
        return repository.findById(id);
    }

    public ProyeccionMongo save(ProyeccionMongo proyeccion) {
        return repository.save(proyeccion);
    }

    public ProyeccionMongo update(String id, ProyeccionMongo updated) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setIdPelicula(updated.getIdPelicula());
                    existing.setIdSala(updated.getIdSala());
                    existing.setFechaHoraInicio(updated.getFechaHoraInicio());
                    existing.setFechaHoraFin(updated.getFechaHoraFin());
                    existing.setPrecioEntrada(updated.getPrecioEntrada());
                    existing.setAsientosDisponibles(updated.getAsientosDisponibles());
                    return repository.save(existing);
                })
                .orElse(null);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
