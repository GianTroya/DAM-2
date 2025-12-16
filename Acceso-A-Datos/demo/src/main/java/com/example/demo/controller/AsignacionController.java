package com.example.demo.controller;

import com.example.demo.model.Asignacion;
import com.example.demo.service.AsignacionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignaciones_empleados_proyecciones")
public class AsignacionController {

    private final AsignacionService asignacionService;

    public AsignacionController(AsignacionService asignacionService) {
        this.asignacionService = asignacionService;
    }

    @GetMapping
    public List<Asignacion> listar() {
        return asignacionService.listarAsignacion();
    }

    @GetMapping("/{id}")
    public Asignacion buscar(@PathVariable Integer id) {
        return  asignacionService.buscarAsignacion(id).orElseThrow(() -> new RuntimeException("Asignacion no encontrada"));
    }

    @PostMapping
    public Asignacion crear(@RequestBody Asignacion asignacion) {
        return  asignacionService.insertarAsignacion(asignacion);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id) {
        asignacionService.borrarAsignacion(id);
    }
}
