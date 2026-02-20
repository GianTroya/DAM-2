package com.example.demo.model.mongo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "horarios")
public class HorarioMongo {

    @Id
    private String id;

    private String idEmpleado;
    private String dia;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate horaEntrada;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate horaSalida;
    private Double horasDia;

    public HorarioMongo() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public LocalDate getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalDate horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalDate getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalDate horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Double getHorasDia() {
        return horasDia;
    }

    public void setHorasDia(Double horasDia) {
        this.horasDia = horasDia;
    }

    @Override
    public String toString() {
        return "HorarioMongo{" +
                "id='" + id + '\'' +
                ", idEmpleado='" + idEmpleado + '\'' +
                ", dia='" + dia + '\'' +
                ", horaEntrada=" + horaEntrada +
                ", horaSalida=" + horaSalida +
                ", horasDia=" + horasDia +
                '}';
    }
}
