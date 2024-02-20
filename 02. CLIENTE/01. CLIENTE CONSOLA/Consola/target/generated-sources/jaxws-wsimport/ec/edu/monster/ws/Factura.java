
package ec.edu.monster.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for factura complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="factura"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cantGeneral" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cantGeneralVisita" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cantPalco" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cantTribuna" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="precioTotal" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "factura", propOrder = {
    "cantGeneral",
    "cantGeneralVisita",
    "cantPalco",
    "cantTribuna",
    "precioTotal"
})
public class Factura {

    protected int cantGeneral;
    protected int cantGeneralVisita;
    protected int cantPalco;
    protected int cantTribuna;
    protected double precioTotal;

    /**
     * Gets the value of the cantGeneral property.
     * 
     */
    public int getCantGeneral() {
        return cantGeneral;
    }

    /**
     * Sets the value of the cantGeneral property.
     * 
     */
    public void setCantGeneral(int value) {
        this.cantGeneral = value;
    }

    /**
     * Gets the value of the cantGeneralVisita property.
     * 
     */
    public int getCantGeneralVisita() {
        return cantGeneralVisita;
    }

    /**
     * Sets the value of the cantGeneralVisita property.
     * 
     */
    public void setCantGeneralVisita(int value) {
        this.cantGeneralVisita = value;
    }

    /**
     * Gets the value of the cantPalco property.
     * 
     */
    public int getCantPalco() {
        return cantPalco;
    }

    /**
     * Sets the value of the cantPalco property.
     * 
     */
    public void setCantPalco(int value) {
        this.cantPalco = value;
    }

    /**
     * Gets the value of the cantTribuna property.
     * 
     */
    public int getCantTribuna() {
        return cantTribuna;
    }

    /**
     * Sets the value of the cantTribuna property.
     * 
     */
    public void setCantTribuna(int value) {
        this.cantTribuna = value;
    }

    /**
     * Gets the value of the precioTotal property.
     * 
     */
    public double getPrecioTotal() {
        return precioTotal;
    }

    /**
     * Sets the value of the precioTotal property.
     * 
     */
    public void setPrecioTotal(double value) {
        this.precioTotal = value;
    }

}
