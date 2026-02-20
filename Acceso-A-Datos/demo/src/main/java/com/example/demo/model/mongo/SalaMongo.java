package com.example.demo.model.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "salas")
public class SalaMongo {

    @Id
    private String id;

    private String nombreSala;
    private Integer capacidad;
    private String tipoSala;
    private String calidadSonido;
    private boolean activa;

    public SalaMongo() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "SalaMongo{" +
                "id='" + id + '\'' +
                ", nombreSala='" + nombreSala + '\'' +
                ", capacidad=" + capacidad +
                ", tipoSala='" + tipoSala + '\'' +
                ", calidadSonido='" + calidadSonido + '\'' +
                ", activa=" + activa +
                '}';
    }
}
