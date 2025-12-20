package com.example.demo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table (name = "entradas")
public class Entrada {
    // atributo clave primaria
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Integer idEntrada;

    // relación con Proyección
    @ManyToOne
    @JoinColumn(name = "id_proyeccion", nullable = false)
    private Proyeccion proyeccion;

    // atributo tipo fecha
    private LocalDate fechaCompra;

    // constructor
    public Entrada() {}

    // getters y setters

    public Integer getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(Integer idEntrada) {
        this.idEntrada = idEntrada;
    }

    public Proyeccion getProyeccion() {
        return proyeccion;
    }

    public void setProyeccion(Proyeccion proyeccion) {
        this.proyeccion = proyeccion;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    // toString


    @Override
    public String  toString() {
        return "Entrada{" +
                "idEntrada=" + idEntrada +
                ", proyeccion=" + proyeccion +
                ", fechaCompra=" + fechaCompra +
                '}';
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}
