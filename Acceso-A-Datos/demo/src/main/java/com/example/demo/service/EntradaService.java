package com.example.demo.service;

import com.example.demo.model.Entrada;
import com.example.demo.repository.EntradaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntradaService {

    private final EntradaRepository entradaRepository;

    public EntradaService(EntradaRepository entradaRepository) {
        this.entradaRepository = entradaRepository;
    }

    public List<Entrada> listarEntradas() {
        return entradaRepository.findAll();
    }

    public Optional<Entrada> buscarEntrada(Integer id) {
        return entradaRepository.findById(id);
    }

    public Entrada insertarEntrada(Entrada entrada) {
        return entradaRepository.save(entrada);
    }

    public void borrarEntrada(Integer id) {
        entradaRepository.deleteById(id);
    }
}
