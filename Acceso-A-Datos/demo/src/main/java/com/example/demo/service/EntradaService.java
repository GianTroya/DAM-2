package com.example.demo.service;

import com.example.demo.model.Entrada;
import com.example.demo.model.Proyeccion;
import com.example.demo.repository.EntradaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntradaService {

    private final EntradaRepository entradaRepository;
    private final ProyeccionService proyeccionService;

    public EntradaService(EntradaRepository entradaRepository, ProyeccionService proyeccionService) {
        this.entradaRepository = entradaRepository;
        this.proyeccionService = proyeccionService;
    }

    public List<Entrada> listarEntradas() {
        return entradaRepository.findAll();
    }

    public Optional<Entrada> buscarEntrada(Integer id) {
        return entradaRepository.findById(id);
    }

    @Transactional
    public Entrada insertarEntrada(Entrada entrada) {
        // obtener id de la proyeccion del json
        Integer idProyeccion = entrada.getProyeccion().getIdProyeccion();
        // obtener proyeccion real de la BD
        Proyeccion proyeccion = proyeccionService.buscarProyeccion(idProyeccion);
        // restar el asiento
        proyeccionService.restarAsiento(proyeccion);
        // asociar proyeccion gestionada
        entrada.setProyeccion(proyeccion);
        // guardar entrada
        return entradaRepository.save(entrada);
    }

    public void borrarEntrada(Integer id) {
        entradaRepository.deleteById(id);
    }
}
