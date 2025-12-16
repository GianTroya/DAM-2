package com.example.demo.controller;

import com.example.demo.model.Entrada;
import com.example.demo.service.EntradaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entradas")
public class EntradaController {

    private final EntradaService entradaService;

    public EntradaController(EntradaService entradaService) {
        this.entradaService = entradaService;
    }

    @GetMapping
    public List<Entrada> listar() {
        return entradaService.listarEntradas();
    }

    @GetMapping("/{id}")
    public Entrada buscarPorId(@PathVariable Integer id) {
        return entradaService.buscarEntrada(id).orElseThrow(() -> new RuntimeException("Entrada no encontrada"));
    }

    @PostMapping
    public Entrada crear(@RequestBody Entrada  entrada) {
        return entradaService.insertarEntrada(entrada);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id) {
        entradaService.borrarEntrada(id);
    }
}
