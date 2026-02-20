package com.example.demo.controller.mongo;

import com.example.demo.model.mongo.PeliculaMongo;
import com.example.demo.service.mongo.PeliculaMongoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mongo/peliculas")
public class PeliculaMongoController {

    private final PeliculaMongoService service;

    public PeliculaMongoController(PeliculaMongoService service) {
        this.service = service;
    }

    @GetMapping
    public List<PeliculaMongo> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PeliculaMongo findById(@PathVariable String id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping
    public PeliculaMongo save(@RequestBody PeliculaMongo pelicula) {
        return service.save(pelicula);
    }

    @PutMapping("/{id}")
    public PeliculaMongo update(@PathVariable String id, @RequestBody PeliculaMongo pelicula) {
        return service.update(id, pelicula);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
