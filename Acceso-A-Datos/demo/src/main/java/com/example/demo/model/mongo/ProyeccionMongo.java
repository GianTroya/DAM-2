package com.example.demo.model.mongo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "proyecciones")
public class ProyeccionMongo {

    @Id
    private String id;

    private String idPelicula;
    private String idSala;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaHoraInicio;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaHoraFin;
    private Double precioEntrada;
    private Integer asientosDisponibles;

    public ProyeccionMongo() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(String idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getIdSala() {
        return idSala;
    }

    public void setIdSala(String idSala) {
        this.idSala = idSala;
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

    @Override
    public String toString() {
        return "ProyeccionMongo{" +
                "id='" + id + '\'' +
                ", idPelicula='" + idPelicula + '\'' +
                ", idSala='" + idSala + '\'' +
                ", fechaHoraInicio=" + fechaHoraInicio +
                ", fechaHoraFin=" + fechaHoraFin +
                ", precioEntrada=" + precioEntrada +
                ", asientosDisponibles=" + asientosDisponibles +
                '}';
    }
}
