package com.example.demo.controller.mongo;

import com.example.demo.model.mongo.EntradaMongo;
import com.example.demo.service.mongo.EntradaMongoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mongo/entradas")
public class EntradaMongoController {

    private final EntradaMongoService service;

    public EntradaMongoController(EntradaMongoService service) {
        this.service = service;
    }

    @GetMapping
    public List<EntradaMongo> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public EntradaMongo findById(@PathVariable String id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping
    public EntradaMongo save(@RequestBody EntradaMongo entrada) {
        return service.save(entrada);
    }

    @PutMapping("/{id}")
    public EntradaMongo update(@PathVariable String id, @RequestBody EntradaMongo entrada) {
        return service.update(id, entrada);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
