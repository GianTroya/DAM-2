package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "salas")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSala;
    private String nombreSala;
    private Integer capacidad;
    private String tipoSala;
    private String calidadSonido;
    private boolean activa;

    //constructor vacío (Requerido por JPA)
    public Sala() {}

    //getters y setters
    public Integer getIdSala() {
        return idSala;
    }

    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(String tipoSala) {
        this.tipoSala = tipoSala;
    }

    public String getCalidadSonido() {
        return calidadSonido;
    }

    public void setCalidadSonido(String calidadSonido) {
        this.calidadSonido = calidadSonido;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    //generamos toString()
    @Override
    public String toString() {
        return "Sala{" +
                "idSala=" + idSala +
                ", nombreSala='" + nombreSala + '\'' +
                ", capacidad=" + capacidad +
                ", tipoSala='" + tipoSala + '\'' +
                ", calidadSonido='" + calidadSonido + '\'' +
                ", activa=" + activa +
                '}';
    }
}
