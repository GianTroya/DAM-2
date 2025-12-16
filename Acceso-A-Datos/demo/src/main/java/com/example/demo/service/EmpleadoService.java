package com.example.demo.service;

import com.example.demo.model.Empleado;
import com.example.demo.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {
    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public List<Empleado> listarEmpleados() {
        return empleadoRepository.findAll();
    }

    public Optional<Empleado> buscarEmpleado(Integer id) {
        return empleadoRepository.findById(id);
    }

    public Empleado insertarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public void borrarEmpleado(Integer id) {
        empleadoRepository.deleteById(id);
    }
}