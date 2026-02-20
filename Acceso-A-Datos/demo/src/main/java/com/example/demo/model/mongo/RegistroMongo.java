package com.example.demo.model.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "registros")
public class RegistroMongo {

    @Id
    private String id;

    private String idEmpleado;
    private Integer mes;
    private Integer ano;
    private Double horasTotales;
    private Double horasExtra;

    public RegistroMongo() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    @Override
    public String toString() {
        return "RegistroMongo{" +
                "id='" + id + '\'' +
                ", idEmpleado='" + idEmpleado + '\'' +
                ", mes=" + mes +
                ", ano=" + ano +
                ", horasTotales=" + horasTotales +
                ", horasExtra=" + horasExtra +
                '}';
    }
}
