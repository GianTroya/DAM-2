package com.example.demo.controller.mongo;

import com.example.demo.model.mongo.SalaMongo;
import com.example.demo.service.mongo.SalaMongoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mongo/salas")
public class SalaMongoController {

    private final SalaMongoService service;

    public SalaMongoController(SalaMongoService service) {
        this.service = service;
    }

    @GetMapping
    public List<SalaMongo> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public SalaMongo findById(@PathVariable String id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping
    public SalaMongo save(@RequestBody SalaMongo sala) {
        return service.save(sala);
    }

    @PutMapping("/{id}")
    public SalaMongo update(@PathVariable String id, @RequestBody SalaMongo sala) {
        return service.update(id, sala);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
