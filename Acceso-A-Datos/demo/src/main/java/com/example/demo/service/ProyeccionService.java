package com.example.demo.service;

import com.example.demo.model.Proyeccion;
import com.example.demo.repository.ProyeccionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyeccionService {
    // atributo proyeccionRepository
    private final ProyeccionRepository proyeccionRepository;
    // constructor
    public ProyeccionService(ProyeccionRepository proyeccionRepository){
        this.proyeccionRepository = proyeccionRepository;
    }
    // servicios
    public List<Proyeccion> listarProyecciones() {
        return proyeccionRepository.findAll();
    }

    public Optional<Proyeccion> buscarProyeccion(Integer id) {
        return proyeccionRepository.findById(id);
    }

    public Proyeccion insertarProyeccion(Proyeccion proyeccion) {
        return proyeccionRepository.save(proyeccion);
    }

    public void borrarProyeccion(Integer id) {
        proyeccionRepository.deleteById(id);
    }
}
