package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "registro_horas_mensuales")
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_registro;

    @ManyToOne
    @JoinColumn(name = "empleados", nullable = false)
    private Empleado empleado;

    private Integer mes;

    private Integer ano;

    private Double horasTotales;

    private Double horasExtra;

    // constructor
    public Registro() {}

    //getters y setters

    public Integer getId_registro() {
        return id_registro;
    }

    public void setId_registro(Integer id_registro) {
        this.id_registro = id_registro;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Double getHorasTotales() {
        return horasTotales;
    }

    public void setHorasTotales(Double horasTotales) {
        this.horasTotales = horasTotales;
    }

    public Double getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(Double horasExtra) {
        this.horasExtra = horasExtra;
    }

    //toString()

    @Override
    public String toString() {
        return "Registro{" +
                "id_registro=" + id_registro +
                ", empleado=" + empleado +
                ", mes=" + mes +
                ", ano=" + ano +
                ", horasTotales=" + horasTotales +
                ", horasExtra=" + horasExtra +
                '}';
    }
}
