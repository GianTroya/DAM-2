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

    public Proyeccion buscarProyeccion(Integer id) {
        return proyeccionRepository.findById(id).orElseThrow(() -> new RuntimeException("Proyección no encontrada"));
    }

    public Proyeccion insertarProyeccion(Proyeccion proyeccion) {
        return proyeccionRepository.save(proyeccion);
    }

    public void restarAsiento(Proyeccion proyeccion) {
        if (proyeccion.getAsientosDisponibles()<=0) {
            throw new RuntimeException("No hay asientos disponibles");
        } else {
            proyeccion.setAsientosDisponibles(proyeccion.getAsientosDisponibles()-1);
        }
    }

    public void borrarProyeccion(Integer id) {
        proyeccionRepository.deleteById(id);
    }
}
