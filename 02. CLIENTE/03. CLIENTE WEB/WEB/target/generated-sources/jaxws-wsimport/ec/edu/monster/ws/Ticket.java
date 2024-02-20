
package ec.edu.monster.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para ticket complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ticket"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoPartido" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="equipoLocal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="equipoVisita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fechaPartido" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="horaPartido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nombreEstadio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nombrePartido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ticket", propOrder = {
    "codigoPartido",
    "equipoLocal",
    "equipoVisita",
    "fechaPartido",
    "horaPartido",
    "nombreEstadio",
    "nombrePartido"
})
public class Ticket {

    protected int codigoPartido;
    protected String equipoLocal;
    protected String equipoVisita;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaPartido;
    protected String horaPartido;
    protected String nombreEstadio;
    protected String nombrePartido;

    /**
     * Obtiene el valor de la propiedad codigoPartido.
     * 
     */
    public int getCodigoPartido() {
        return codigoPartido;
    }

    /**
     * Define el valor de la propiedad codigoPartido.
     * 
     */
    public void setCodigoPartido(int value) {
        this.codigoPartido = value;
    }

    /**
     * Obtiene el valor de la propiedad equipoLocal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEquipoLocal() {
        return equipoLocal;
    }

    /**
     * Define el valor de la propiedad equipoLocal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEquipoLocal(String value) {
        this.equipoLocal = value;
    }

    /**
     * Obtiene el valor de la propiedad equipoVisita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEquipoVisita() {
        return equipoVisita;
    }

    /**
     * Define el valor de la propiedad equipoVisita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEquipoVisita(String value) {
        this.equipoVisita = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaPartido.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaPartido() {
        return fechaPartido;
    }

    /**
     * Define el valor de la propiedad fechaPartido.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaPartido(XMLGregorianCalendar value) {
        this.fechaPartido = value;
    }

    /**
     * Obtiene el valor de la propiedad horaPartido.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHoraPartido() {
        return horaPartido;
    }

    /**
     * Define el valor de la propiedad horaPartido.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHoraPartido(String value) {
        this.horaPartido = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreEstadio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreEstadio() {
        return nombreEstadio;
    }

    /**
     * Define el valor de la propiedad nombreEstadio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreEstadio(String value) {
        this.nombreEstadio = value;
    }

    /**
     * Obtiene el valor de la propiedad nombrePartido.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombrePartido() {
        return nombrePartido;
    }

    /**
     * Define el valor de la propiedad nombrePartido.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombrePartido(String value) {
        this.nombrePartido = value;
    }

}
