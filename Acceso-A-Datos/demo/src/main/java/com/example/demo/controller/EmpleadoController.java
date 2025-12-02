package com.example.demo.controller;

import com.example.demo.model.Empleado;
import com.example.demo.service.EmpleadoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public List<Empleado> listar() {
        return empleadoService.listarEmpleados();
    }

    @GetMapping("/{id}")
    public Empleado buscarPorId(@PathVariable Integer id) {
        return empleadoService.buscarEmpleado(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
    }

    @PostMapping
    public Empleado crear(@RequestBody Empleado empleado) {
        return empleadoService.insertarEmpleado(empleado);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id) {
        empleadoService.borrarEmpleado(id);
    }
}
