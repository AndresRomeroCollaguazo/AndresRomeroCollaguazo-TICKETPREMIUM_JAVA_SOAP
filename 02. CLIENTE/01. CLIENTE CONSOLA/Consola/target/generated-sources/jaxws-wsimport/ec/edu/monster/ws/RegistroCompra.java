
package ec.edu.monster.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for registroCompra complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="registroCompra"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nombreCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cedula" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="direccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cantPalco" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cantTribuna" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cantGeneral" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cantGeneralVisita" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="totalPrecio" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="codigoPartido" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registroCompra", propOrder = {
    "nombreCliente",
    "cedula",
    "direccion",
    "cantPalco",
    "cantTribuna",
    "cantGeneral",
    "cantGeneralVisita",
    "totalPrecio",
    "codigoPartido"
})
public class RegistroCompra {

    protected String nombreCliente;
    protected String cedula;
    protected String direccion;
    protected int cantPalco;
    protected int cantTribuna;
    protected int cantGeneral;
    protected int cantGeneralVisita;
    protected double totalPrecio;
    protected int codigoPartido;

    /**
     * Gets the value of the nombreCliente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * Sets the value of the nombreCliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreCliente(String value) {
        this.nombreCliente = value;
    }

    /**
     * Gets the value of the cedula property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Sets the value of the cedula property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCedula(String value) {
        this.cedula = value;
    }

    /**
     * Gets the value of the direccion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Sets the value of the direccion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccion(String value) {
        this.direccion = value;
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
     * Gets the value of the totalPrecio property.
     * 
     */
    public double getTotalPrecio() {
        return totalPrecio;
    }

    /**
     * Sets the value of the totalPrecio property.
     * 
     */
    public void setTotalPrecio(double value) {
        this.totalPrecio = value;
    }

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

}
