
package ec.edu.monster.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ticket complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
     * Gets the value of the codigoPartido property.
     * 
     */
    public int getCodigoPartido() {
        return codigoPartido;
    }

    /**
     * Sets the value of the codigoPartido property.
     * 
     */
    public void setCodigoPartido(int value) {
        this.codigoPartido = value;
    }

    /**
     * Gets the value of the equipoLocal property.
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
     * Sets the value of the equipoLocal property.
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
     * Gets the value of the equipoVisita property.
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
     * Sets the value of the equipoVisita property.
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
     * Gets the value of the fechaPartido property.
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
     * Sets the value of the fechaPartido property.
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
     * Gets the value of the horaPartido property.
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
     * Sets the value of the horaPartido property.
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
     * Gets the value of the nombreEstadio property.
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
     * Sets the value of the nombreEstadio property.
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
     * Gets the value of the nombrePartido property.
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
     * Sets the value of the nombrePartido property.
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
