package com.example.demo.controller.mongo;

import com.example.demo.model.mongo.AsignacionMongo;
import com.example.demo.service.mongo.AsignacionMongoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mongo/asignaciones")
public class AsignacionMongoController {

    private final AsignacionMongoService service;

    public AsignacionMongoController(AsignacionMongoService service) {
        this.service = service;
    }

    @GetMapping
    public List<AsignacionMongo> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public AsignacionMongo findById(@PathVariable String id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping
    public AsignacionMongo save(@RequestBody AsignacionMongo asignacion) {
        return service.save(asignacion);
    }

    @PutMapping("/{id}")
    public AsignacionMongo update(@PathVariable String id, @RequestBody AsignacionMongo asignacion) {
        return service.update(id, asignacion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
