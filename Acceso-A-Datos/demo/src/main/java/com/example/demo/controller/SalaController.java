package com.example.demo.controller;

import com.example.demo.model.Empleado;
import com.example.demo.model.Sala;
import com.example.demo.service.SalaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/salas")
public class SalaController {
    // definimos el atributo salaService
    private final SalaService salaService;

    // generamos el constructor para salaService
    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    //
    @GetMapping
    public List<Sala> listar() {
        return salaService.listarSalas();
    }

    //
    @GetMapping("/{id}")
    public Sala buscarPorId(@PathVariable Integer id) {
        return salaService.buscarSala(id)
                .orElseThrow(() -> new RuntimeException("Sala no encontrada"));
    }

    //
    @PostMapping
    public Sala crear(@RequestBody Sala sala) {
        return salaService.insertarSala(sala);
    }

    //
    @DeleteMapping
    public void borrar(@PathVariable Integer id) {
        salaService.borrarSala(id);
    }
}
