package com.example.demo.model.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "asignaciones")
public class AsignacionMongo {

    @Id
    private String id;

    private String idProyeccion;
    private String idEmpleado;
    private String rol;

    public AsignacionMongo() {}

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

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "AsignacionMongo{" +
                "id='" + id + '\'' +
                ", idProyeccion='" + idProyeccion + '\'' +
                ", idEmpleado='" + idEmpleado + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}