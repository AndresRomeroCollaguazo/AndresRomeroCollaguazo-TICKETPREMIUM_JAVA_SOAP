package com.example.ticket_premium_movil;

public class Factura {

    private int cantPalco;
    private int cantTribuna;
    private int cantGeneral;
    private int cantGeneralVisita;
    private double precioTotal;

    public Factura() {
    }

    public Factura(int cantPalco, int cantTribuna, int cantGeneral, int cantGeneralVisita, double precioTotal) {
        this.cantPalco = cantPalco;
        this.cantTribuna = cantTribuna;
        this.cantGeneral = cantGeneral;
        this.cantGeneralVisita = cantGeneralVisita;
        this.precioTotal = precioTotal;
    }



    /**
     * @return the cantPalco
     */
    public int getCantPalco() {
        return cantPalco;
    }

    /**
     * @param cantPalco the cantPalco to set
     */
    public void setCantPalco(int cantPalco) {
        this.cantPalco = cantPalco;
    }

    /**
     * @return the cantTribuna
     */
    public int getCantTribuna() {
        return cantTribuna;
    }

    /**
     * @param cantTribuna the cantTribuna to set
     */
    public void setCantTribuna(int cantTribuna) {
        this.cantTribuna = cantTribuna;
    }

    /**
     * @return the cantGeneral
     */
    public int getCantGeneral() {
        return cantGeneral;
    }

    /**
     * @param cantGeneral the cantGeneral to set
     */
    public void setCantGeneral(int cantGeneral) {
        this.cantGeneral = cantGeneral;
    }

    /**
     * @return the cantGeneralVisita
     */
    public int getCantGeneralVisita() {
        return cantGeneralVisita;
    }

    /**
     * @param cantGeneralVisita the cantGeneralVisita to set
     */
    public void setCantGeneralVisita(int cantGeneralVisita) {
        this.cantGeneralVisita = cantGeneralVisita;
    }

    /**
     * @return the precioTotal
     */
    public double getPrecioTotal() {
        return precioTotal;
    }

    /**
     * @param precioTotal the precioTotal to set
     */
    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

}

