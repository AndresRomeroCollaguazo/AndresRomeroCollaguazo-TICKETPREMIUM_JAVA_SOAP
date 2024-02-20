
package ec.edu.monster.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para localidad complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
     * Obtiene el valor de la propiedad codigoLocalidad.
     * 
     */
    public int getCodigoLocalidad() {
        return codigoLocalidad;
    }

    /**
     * Define el valor de la propiedad codigoLocalidad.
     * 
     */
    public void setCodigoLocalidad(int value) {
        this.codigoLocalidad = value;
    }

    /**
     * Obtiene el valor de la propiedad disponibilidadLocalidad.
     * 
     */
    public int getDisponibilidadLocalidad() {
        return disponibilidadLocalidad;
    }

    /**
     * Define el valor de la propiedad disponibilidadLocalidad.
     * 
     */
    public void setDisponibilidadLocalidad(int value) {
        this.disponibilidadLocalidad = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreLocalidad.
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
     * Define el valor de la propiedad nombreLocalidad.
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
     * Obtiene el valor de la propiedad precioLocalidad.
     * 
     */
    public double getPrecioLocalidad() {
        return precioLocalidad;
    }

    /**
     * Define el valor de la propiedad precioLocalidad.
     * 
     */
    public void setPrecioLocalidad(double value) {
        this.precioLocalidad = value;
    }

}
