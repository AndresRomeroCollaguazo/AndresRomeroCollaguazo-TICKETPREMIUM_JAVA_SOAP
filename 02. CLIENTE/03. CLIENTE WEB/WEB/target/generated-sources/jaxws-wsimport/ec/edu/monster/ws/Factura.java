
package ec.edu.monster.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para factura complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
     * Obtiene el valor de la propiedad cantGeneral.
     * 
     */
    public int getCantGeneral() {
        return cantGeneral;
    }

    /**
     * Define el valor de la propiedad cantGeneral.
     * 
     */
    public void setCantGeneral(int value) {
        this.cantGeneral = value;
    }

    /**
     * Obtiene el valor de la propiedad cantGeneralVisita.
     * 
     */
    public int getCantGeneralVisita() {
        return cantGeneralVisita;
    }

    /**
     * Define el valor de la propiedad cantGeneralVisita.
     * 
     */
    public void setCantGeneralVisita(int value) {
        this.cantGeneralVisita = value;
    }

    /**
     * Obtiene el valor de la propiedad cantPalco.
     * 
     */
    public int getCantPalco() {
        return cantPalco;
    }

    /**
     * Define el valor de la propiedad cantPalco.
     * 
     */
    public void setCantPalco(int value) {
        this.cantPalco = value;
    }

    /**
     * Obtiene el valor de la propiedad cantTribuna.
     * 
     */
    public int getCantTribuna() {
        return cantTribuna;
    }

    /**
     * Define el valor de la propiedad cantTribuna.
     * 
     */
    public void setCantTribuna(int value) {
        this.cantTribuna = value;
    }

    /**
     * Obtiene el valor de la propiedad precioTotal.
     * 
     */
    public double getPrecioTotal() {
        return precioTotal;
    }

    /**
     * Define el valor de la propiedad precioTotal.
     * 
     */
    public void setPrecioTotal(double value) {
        this.precioTotal = value;
    }

}
