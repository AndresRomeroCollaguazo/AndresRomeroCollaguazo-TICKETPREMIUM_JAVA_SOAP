
package ec.edu.monster.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for localidad complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="localidad"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoLocalidad" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="disponibilidadLocalidad" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nombreLocalidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="precioLocalidad" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "localidad", propOrder = {
    "codigoLocalidad",
    "disponibilidadLocalidad",
    "nombreLocalidad",
    "precioLocalidad"
})
public class Localidad {

    protected int codigoLocalidad;
    protected int disponibilidadLocalidad;
    protected String nombreLocalidad;
    protected double precioLocalidad;

    /**
     * Gets the value of the codigoLocalidad property.
     * 
     */
    public int getCodigoLocalidad() {
        return codigoLocalidad;
    }

    /**
     * Sets the value of the codigoLocalidad property.
     * 
     */
    public void setCodigoLocalidad(int value) {
        this.codigoLocalidad = value;
    }

    /**
     * Gets the value of the disponibilidadLocalidad property.
     * 
     */
    public int getDisponibilidadLocalidad() {
        return disponibilidadLocalidad;
    }

    /**
     * Sets the value of the disponibilidadLocalidad property.
     * 
     */
    public void setDisponibilidadLocalidad(int value) {
        this.disponibilidadLocalidad = value;
    }

    /**
     * Gets the value of the nombreLocalidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreLocalidad() {
        return nombreLocalidad;
    }

    /**
     * Sets the value of the nombreLocalidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreLocalidad(String value) {
        this.nombreLocalidad = value;
    }

    /**
     * Gets the value of the precioLocalidad property.
     * 
     */
    public double getPrecioLocalidad() {
        return precioLocalidad;
    }

    /**
     * Sets the value of the precioLocalidad property.
     * 
     */
    public void setPrecioLocalidad(double value) {
        this.precioLocalidad = value;
    }

}
