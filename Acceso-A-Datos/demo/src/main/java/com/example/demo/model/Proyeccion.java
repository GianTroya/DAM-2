package com.example.demo.model;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Table(name = "proyecciones")
public class Proyeccion {

    // clave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProyeccion;

    // relación con Película
    @ManyToOne
    @JoinColumn(name = "id_pelicula", nullable = false)
    private Pelicula pelicula;

    // relación con Sala
    @ManyToOne
    @JoinColumn(name = "id_sala", nullable = false)
    private Sala sala;

    private LocalDate fechaHoraInicio;
    private LocalDate fechaHoraFin;
    private Double precioEntrada;
    private Integer asientosDisponibles;

    // constructor vacío
    public Proyeccion() {}

    // getters y setters

    public Integer getIdProyeccion() {
        return idProyeccion;
    }

    public void setIdProyeccion(Integer idProyeccion) {
        this.idProyeccion = idProyeccion;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public LocalDate getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDate fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public LocalDate getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(LocalDate fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public Double getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(Double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public Integer getAsientosDisponibles() {
        return asientosDisponibles;
    }

    public void setAsientosDisponibles(Integer asientosDisponibles) {
        this.asientosDisponibles = asientosDisponibles;
    }

    // toString()

    @Override
    public String toString() {
        return "Proyeccion{" +
                "idProyeccion=" + idProyeccion +
                ", pelicula=" + pelicula +
                ", sala=" + sala +
                ", fechaHoraInicio=" + fechaHoraInicio +
                ", fechaHoraFin=" + fechaHoraFin +
                ", precioEntrada=" + precioEntrada +
                ", asientosDisponibles=" + asientosDisponibles +
                '}';
    }
}
