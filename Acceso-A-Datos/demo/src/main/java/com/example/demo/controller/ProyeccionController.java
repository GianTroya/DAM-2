package com.example.demo.controller;

import com.example.demo.model.Proyeccion;
import com.example.demo.service.ProyeccionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyecciones")
public class ProyeccionController {
    // atributo proyeccionService
    private final ProyeccionService proyeccionService;
    // constructor
    public ProyeccionController (ProyeccionService proyeccionService) {
        this.proyeccionService = proyeccionService;
    }
    // endpoints
    @GetMapping
    public List<Proyeccion> listar() {
        return proyeccionService.listarProyecciones();
    }

    @GetMapping ("/{id}")
    public Proyeccion buscarPorId(@PathVariable Integer id) {
        return proyeccionService.buscarProyeccion(id);
    }

    @PostMapping
    public Proyeccion crear(@RequestBody Proyeccion proyeccion) {
        return proyeccionService.insertarProyeccion(proyeccion);
    }

    @DeleteMapping
    public void borrar(@PathVariable Integer id) {
        proyeccionService.borrarProyeccion(id);
    }
}
