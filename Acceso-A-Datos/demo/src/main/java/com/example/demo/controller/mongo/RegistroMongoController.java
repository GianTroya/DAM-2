package com.example.demo.controller.mongo;

import com.example.demo.model.mongo.RegistroMongo;
import com.example.demo.service.mongo.RegistroMongoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mongo/registros")
public class RegistroMongoController {

    private final RegistroMongoService service;

    public RegistroMongoController(RegistroMongoService service) {
        this.service = service;
    }

    @GetMapping
    public List<RegistroMongo> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public RegistroMongo findById(@PathVariable String id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping
    public RegistroMongo save(@RequestBody RegistroMongo registro) {
        return service.save(registro);
    }

    @PutMapping("/{id}")
    public RegistroMongo update(@PathVariable String id, @RequestBody RegistroMongo registro) {
        return service.update(id, registro);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
