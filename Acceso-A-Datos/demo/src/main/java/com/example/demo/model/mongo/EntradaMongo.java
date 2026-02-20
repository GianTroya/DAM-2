package com.example.demo.model.mongo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "entradas")
public class EntradaMongo {

    @Id
    private String id;

    private String idProyeccion;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaCompra;

    public EntradaMongo() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdProyeccion() {
        return idProyeccion;
    }

    public void setIdProyeccion(String idProyeccion) {
        this.idProyeccion = idProyeccion;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    @Override
    public String toString() {
        return "EntradaMongo{" +
                "id='" + id + '\'' +
                ", idProyeccion='" + idProyeccion + '\'' +
                ", fechaCompra=" + fechaCompra +
                '}';
    }
}
