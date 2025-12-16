package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "horarios_semanales_empleados")
public class Horario {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idHorarioSemanal;

    @ManyToOne
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;

    private String dia;

    private LocalDate horaEntrada;

    private LocalDate horaSalida;

    private Double horasDia;

    //constructor

    public Horario() {}

    // getters y setters

    public Integer getIdHorarioSemanal() {
        return idHorarioSemanal;
    }

    public void setIdHorarioSemanal(Integer idHorarioSemanal) {
        this.idHorarioSemanal = idHorarioSemanal;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
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

    // toString

    @Override
    public String toString() {
        return "Horario{" +
                "idHorarioSemanal=" + idHorarioSemanal +
                ", empleado=" + empleado +
                ", dia='" + dia + '\'' +
                ", horaEntrada=" + horaEntrada +
                ", horaSalida=" + horaSalida +
                ", horasDia=" + horasDia +
                '}';
    }
}
