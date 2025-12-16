package com.example.demo.service;

import com.example.demo.model.Registro;
import com.example.demo.repository.RegistroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroService {

    private final RegistroRepository registroRepository;

    public RegistroService(RegistroRepository registroRepository) {
        this.registroRepository = registroRepository;
    }

    public List<Registro> listarRegistros() {
        return registroRepository.findAll();
    }

    public Optional<Registro> buscarRegistro(Integer id) {
        return registroRepository.findById(id);
    }

    public Registro insertarRegistro(Registro registro) {
        return registroRepository.save(registro);
    }

    public void borrarRegistro(Integer id) {
        registroRepository.deleteById(id);
    }
}
