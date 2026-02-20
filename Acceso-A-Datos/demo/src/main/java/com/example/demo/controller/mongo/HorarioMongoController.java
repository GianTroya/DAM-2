package com.example.demo.controller.mongo;

import com.example.demo.model.mongo.HorarioMongo;
import com.example.demo.service.mongo.HorarioMongoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mongo/horarios")
public class HorarioMongoController {

    private final HorarioMongoService service;

    public HorarioMongoController(HorarioMongoService service) {
        this.service = service;
    }

    @GetMapping
    public List<HorarioMongo> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public HorarioMongo findById(@PathVariable String id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping
    public HorarioMongo save(@RequestBody HorarioMongo horario) {
        return service.save(horario);
    }

    @PutMapping("/{id}")
    public HorarioMongo update(@PathVariable String id, @RequestBody HorarioMongo horario) {
        return service.update(id, horario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
