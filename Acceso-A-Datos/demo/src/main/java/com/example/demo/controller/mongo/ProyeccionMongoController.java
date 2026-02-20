package com.example.demo.controller.mongo;

import com.example.demo.model.mongo.ProyeccionMongo;
import com.example.demo.service.mongo.ProyeccionMongoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mongo/proyecciones")
public class ProyeccionMongoController {

    private final ProyeccionMongoService service;

    public ProyeccionMongoController(ProyeccionMongoService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProyeccionMongo> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ProyeccionMongo findById(@PathVariable String id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping
    public ProyeccionMongo save(@RequestBody ProyeccionMongo proyeccion) {
        return service.save(proyeccion);
    }

    @PutMapping("/{id}")
    public ProyeccionMongo update(@PathVariable String id, @RequestBody ProyeccionMongo proyeccion) {
        return service.update(id, proyeccion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
