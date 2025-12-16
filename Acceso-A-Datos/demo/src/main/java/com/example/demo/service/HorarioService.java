package com.example.demo.service;

import com.example.demo.model.Horario;
import com.example.demo.repository.HorarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioService {

    private final HorarioRepository horarioRepository;

    public HorarioService(HorarioRepository horarioRepository) {
        this.horarioRepository = horarioRepository;
    }

    public List<Horario> listarHorarios() {
        return horarioRepository.findAll();
    }

    public Optional<Horario> buscarHorario(Integer id) {
        return horarioRepository.findById(id);
    }

    public Horario insertarHorario(Horario horario) {
        return horarioRepository.save(horario);
    }

    public void borrarHorario(Integer id) {
        horarioRepository.deleteById(id);
    }
}
