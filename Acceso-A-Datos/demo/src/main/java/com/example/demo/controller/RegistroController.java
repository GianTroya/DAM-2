package com.example.demo.controller;

import com.example.demo.model.Registro;
import com.example.demo.service.RegistroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registro_horas_mensuales")
public class RegistroController {

    private final RegistroService registroService;

    public RegistroController(RegistroService registroService) {
        this.registroService = registroService;
    }

    @GetMapping
    public List<Registro> listar() {
        return registroService.listarRegistros();
    }

    @GetMapping("/{id}")
    public Registro buscarPorId(@PathVariable Integer id) {
        return registroService.buscarRegistro(id).orElseThrow(() -> new RuntimeException("Registro no encontrado"));
    }

    @PostMapping
    public Registro crear(@RequestBody Registro registro) {
        return registroService.insertarRegistro(registro);
    }

    @DeleteMapping
    public void borrar(@PathVariable Integer id) {
        registroService.borrarRegistro(id);
    }
}
