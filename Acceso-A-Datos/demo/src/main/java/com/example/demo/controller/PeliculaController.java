package com.example.demo.controller;

import com.example.demo.model.Pelicula;
import com.example.demo.service.PeliculaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping
    public List<Pelicula> listar() {
        return peliculaService.listarPeliculas();
    }

    @GetMapping("/{id}")
    public Pelicula buscarPorId(@PathVariable Integer id) {
        return peliculaService.buscarPelicula(id)
                .orElseThrow(() -> new RuntimeException("Película no encontrada"));
    }

    @PostMapping
    public Pelicula crear(@RequestBody Pelicula pelicula) {
        return peliculaService.insertarPelicula(pelicula);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id) {
        peliculaService.borrarPelicula(id);
    }
}
