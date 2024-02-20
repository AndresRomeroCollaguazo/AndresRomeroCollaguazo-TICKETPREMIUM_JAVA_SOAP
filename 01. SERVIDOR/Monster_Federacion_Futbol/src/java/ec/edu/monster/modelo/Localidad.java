/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelo;

/**
 *
 * @author Jhonatan
 */
public class Localidad {
    private int codigoLocalidad;
    private String nombreLocalidad;
    private int disponibilidadLocalidad;
    private double precioLocalidad;

    public Localidad() {
    }

    public Localidad(int codigoLocalidad, String nombreLocalidad, int disponibilidadLocalidad, double precioLocalidad) {
        this.codigoLocalidad = codigoLocalidad;
        this.nombreLocalidad = nombreLocalidad;
        this.disponibilidadLocalidad = disponibilidadLocalidad;
        this.precioLocalidad = precioLocalidad;
    }

    /**
     * @return the codigoLocalidad
     */
    public int getCodigoLocalidad() {
        return codigoLocalidad;
    }

    /**
     * @param codigoLocalidad the codigoLocalidad to set
     */
    public void setCodigoLocalidad(int codigoLocalidad) {
        this.codigoLocalidad = codigoLocalidad;
    }

    /**
     * @return the nombreLocalidad
     */
    public String getNombreLocalidad() {
        return nombreLocalidad;
    }

    /**
     * @param nombreLocalidad the nombreLocalidad to set
     */
    public void setNombreLocalidad(String nombreLocalidad) {
        this.nombreLocalidad = nombreLocalidad;
    }

    /**
     * @return the disponibilidadLocalidad
     */
    public int getDisponibilidadLocalidad() {
        return disponibilidadLocalidad;
    }

    /**
     * @param disponibilidadLocalidad the disponibilidadLocalidad to set
     */
    public void setDisponibilidadLocalidad(int disponibilidadLocalidad) {
        this.disponibilidadLocalidad = disponibilidadLocalidad;
    }

    /**
     * @return the precioLocalidad
     */
    public double getPrecioLocalidad() {
        return precioLocalidad;
    }

    /**
     * @param precioLocalidad the precioLocalidad to set
     */
    public void setPrecioLocalidad(double precioLocalidad) {
        this.precioLocalidad = precioLocalidad;
    }
    
    
}
