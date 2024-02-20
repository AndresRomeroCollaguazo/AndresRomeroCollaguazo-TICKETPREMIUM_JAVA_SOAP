package com.example.ticket_premium_movil;

import java.util.Date;

public class Ticket {
    private String nombreEstadio;
    private int codigoPartido;
    private String equipoVisita;
    private String equipoLocal;
    private Date fechaPartido;
    private String horaPartido;

    public String getNombreEstadio() {
        return nombreEstadio;
    }

    public void setNombreEstadio(String nombreEstadio) {
        this.nombreEstadio = nombreEstadio;
    }

    public int getCodigoPartido() {
        return codigoPartido;
    }

    public void setCodigoPartido(int codigoPartido) {
        this.codigoPartido = codigoPartido;
    }

    public String getEquipoVisita() {
        return equipoVisita;
    }

    public void setEquipoVisita(String equipoVisita) {
        this.equipoVisita = equipoVisita;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Date getFechaPartido() {
        return fechaPartido;
    }

    public void setFechaPartido(Date fechaPartido) {
        this.fechaPartido = fechaPartido;
    }

    public String getHoraPartido() {
        return horaPartido;
    }

    public void setHoraPartido(String horaPartido) {
        this.horaPartido = horaPartido;
    }
}
