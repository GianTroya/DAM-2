package com.example.demo.service;

import com.example.demo.model.Sala;
import com.example.demo.repository.SalaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {
    // definimos el atributo salaRepository
    private final SalaRepository salaRepository;

    // generamos un constructor para SalaRepository
    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    // creamos el servicio listarSalas
    public List<Sala> listarSalas() {
        return salaRepository.findAll();
    }

    // creamos el servicio buscarSala()
    public Optional<Sala> buscarSala(Integer id) {
        return salaRepository.findById(id);
    }

    // creamos el servicio insertarSala()
    public Sala insertarSala(Sala sala) {
        return salaRepository.save(sala);
    }

    // creamos el servicio borrarSala()
    public void borrarSala(Integer id) {
        salaRepository.deleteById(id);
    }


}
