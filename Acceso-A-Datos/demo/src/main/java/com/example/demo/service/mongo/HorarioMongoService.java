package com.example.demo.service.mongo;

import com.example.demo.model.mongo.HorarioMongo;
import com.example.demo.repository.mongo.HorarioMongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioMongoService {

    private final HorarioMongoRepository repository;

    public HorarioMongoService(HorarioMongoRepository repository) {
        this.repository = repository;
    }

    public List<HorarioMongo> findAll() {
        return repository.findAll();
    }

    public Optional<HorarioMongo> findById(String id) {
        return repository.findById(id);
    }

    public HorarioMongo save(HorarioMongo horario) {
        return repository.save(horario);
    }

    public HorarioMongo update(String id, HorarioMongo updated) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setIdEmpleado(updated.getIdEmpleado());
                    existing.setDia(updated.getDia());
                    existing.setHoraEntrada(updated.getHoraEntrada());
                    existing.setHoraSalida(updated.getHoraSalida());
                    existing.setHorasDia(updated.getHorasDia());
                    return repository.save(existing);
                })
                .orElse(null);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
