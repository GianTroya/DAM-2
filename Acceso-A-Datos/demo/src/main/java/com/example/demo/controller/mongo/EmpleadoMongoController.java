package com.example.demo.controller.mongo;

import com.example.demo.model.mongo.EmpleadoMongo;
import com.example.demo.service.mongo.EmpleadoMongoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mongo/empleados")
public class EmpleadoMongoController {

    private final EmpleadoMongoService service;

    public EmpleadoMongoController(EmpleadoMongoService service) {
        this.service = service;
    }

    @GetMapping
    public List<EmpleadoMongo> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public EmpleadoMongo findById(@PathVariable String id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping
    public EmpleadoMongo save(@RequestBody EmpleadoMongo empleado) {
        return service.save(empleado);
    }

    @PutMapping("/{id}")
    public EmpleadoMongo update(@PathVariable String id, @RequestBody EmpleadoMongo empleado) {
        return service.update(id, empleado);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
