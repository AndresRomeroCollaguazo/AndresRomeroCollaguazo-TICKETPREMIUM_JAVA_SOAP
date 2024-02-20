/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelo;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jhonatan
 */
@XmlRootElement(name = "ticket")
public class Ticket {
    private String nombreEstadio;
    private int codigoPartido;
    private String equipoVisita;
    private String equipoLocal;
    private String nombrePartido;
    private Date fechaPartido;
    private String horaPartido;

    public Ticket() {
    }

    public Ticket(String nombreEstadio, int codigoPartido, String equipoVisita, String equipoLocal, String nombrePartido, Date fechaPartido, String horaPartido) {
        this.nombreEstadio = nombreEstadio;
        this.codigoPartido = codigoPartido;
        this.equipoVisita = equipoVisita;
        this.equipoLocal = equipoLocal;
        this.nombrePartido = nombrePartido;
        this.fechaPartido = fechaPartido;
        this.horaPartido = horaPartido;
    }
   
    /**
     * @return the nombreEstadio
     */
    public String getNombreEstadio() {
        return nombreEstadio;
    }

    /**
     * @param nombreEstadio the nombreEstadio to set
     */
    public void setNombreEstadio(String nombreEstadio) {
        this.nombreEstadio = nombreEstadio;
    }

    /**
     * @return the codigoPartido
     */
    public int getCodigoPartido() {
        return codigoPartido;
    }

    /**
     * @param codigoPartido the codigoPartido to set
     */
    public void setCodigoPartido(int codigoPartido) {
        this.codigoPartido = codigoPartido;
    }

    /**
     * @return the equipoVisita
     */
    public String getEquipoVisita() {
        return equipoVisita;
    }

    /**
     * @param equipoVisita the equipoVisita to set
     */
    public void setEquipoVisita(String equipoVisita) {
        this.equipoVisita = equipoVisita;
    }

    /**
     * @return the equipoLocal
     */
    public String getEquipoLocal() {
        return equipoLocal;
    }

    /**
     * @param equipoLocal the equipoLocal to set
     */
    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    /**
     * @return the nombrePartido
     */
    public String getNombrePartido() {
        return nombrePartido;
    }

    /**
     * @param nombrePartido the nombrePartido to set
     */
    public void setNombrePartido(String nombrePartido) {
        this.nombrePartido = nombrePartido;
    }

    /**
     * @return the fechaPartido
     */
    public Date getFechaPartido() {
        return fechaPartido;
    }

    /**
     * @param fechaPartido the fechaPartido to set
     */
    public void setFechaPartido(Date fechaPartido) {
        this.fechaPartido = fechaPartido;
    }

    /**
     * @return the horaPartido
     */
    public String getHoraPartido() {
        return horaPartido;
    }

    /**
     * @param horaPartido the horaPartido to set
     */
    public void setHoraPartido(String horaPartido) {
        this.horaPartido = horaPartido;
    }

 
}
