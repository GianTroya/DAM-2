package com.example.demo.service;

import com.example.demo.model.Empleado;
import com.example.demo.model.Pelicula;
import com.example.demo.repository.PeliculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {
    private final PeliculaRepository peliculaRepository;

    public PeliculaService (PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public List<Pelicula> listarPeliculas() {
        return peliculaRepository.findAll();
    }

    public Optional<Pelicula> buscarPelicula(Integer id) {
        return peliculaRepository.findById(id);
    }

    public Pelicula insertarPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public void borrarPelicula(Integer id) {
        peliculaRepository.deleteById(id);
    }
}
