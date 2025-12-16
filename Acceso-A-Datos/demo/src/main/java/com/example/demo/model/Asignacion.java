package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "asignaciones_empleados_proyecciones")
public class Asignacion {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idAsignacion;

    @ManyToOne
    @JoinColumn(name = "id_proyeccion", nullable = false)
    private Proyeccion proyeccion;

    @ManyToOne
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;

    private String rol;

    //constructor
    public Asignacion() {}

    //getters y setters

    public Integer getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Proyeccion getProyeccion() {
        return proyeccion;
    }

    public void setProyeccion(Proyeccion proyeccion) {
        this.proyeccion = proyeccion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    // toString()

    @Override
    public String toString() {
        return "AsignacionesEmpleadosProyecciones{" +
                "idAsignacion=" + idAsignacion +
                ", proyeccion=" + proyeccion +
                ", empleado=" + empleado +
                ", rol='" + rol + '\'' +
                '}';
    }
}
