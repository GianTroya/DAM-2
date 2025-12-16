package com.example.demo.service;

import com.example.demo.model.Asignacion;
import com.example.demo.repository.AsignacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsignacionService {

    private final AsignacionRepository asignacionRepository;

    public AsignacionService(AsignacionRepository asignacionRepository) {
        this.asignacionRepository = asignacionRepository;
    }

    public List<Asignacion> listarAsignacion() {
        return asignacionRepository.findAll();
    }

    public Optional<Asignacion> buscarAsignacion(Integer id) {
        return asignacionRepository.findById(id);
    }

    public Asignacion insertarAsignacion(Asignacion asignacion) {
        return asignacionRepository.save(asignacion);
    }

    public void borrarAsignacion(Integer id) {
        asignacionRepository.deleteById(id);
    }
}
