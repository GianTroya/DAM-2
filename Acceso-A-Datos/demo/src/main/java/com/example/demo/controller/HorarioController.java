package com.example.demo.controller;

import com.example.demo.model.Horario;
import com.example.demo.service.HorarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horarios_semanales_empleados")
public class HorarioController {

    private final HorarioService horarioService;

    public HorarioController(HorarioService horarioService) {
        this.horarioService = horarioService;
    }

    @GetMapping
    public List<Horario> listar() {
        return horarioService.listarHorarios();
    }

    @GetMapping("/{id}")
    public Horario buscarPorId(@PathVariable Integer id) {
        return horarioService.buscarHorario(id).orElseThrow(() -> new RuntimeException("Horario no encontrado"));
    }

    @PostMapping
    public Horario crear(@RequestBody Horario horario) {
        return horarioService.insertarHorario(horario);
    }

    @DeleteMapping
    public void borrar(@PathVariable Integer id) {
        horarioService.borrarHorario(id);
    }
}
