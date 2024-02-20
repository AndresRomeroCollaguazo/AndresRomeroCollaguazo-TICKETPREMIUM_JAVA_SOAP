
package ec.edu.monster.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para registroCompra complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="registroCompra">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nombreCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cedula" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="direccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cantPalco" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cantTribuna" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cantGeneral" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cantGeneralVisita" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="totalPrecio" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="codigoPartido" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
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
     * Obtiene el valor de la propiedad nombreCliente.
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
     * Define el valor de la propiedad nombreCliente.
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
     * Obtiene el valor de la propiedad cedula.
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
     * Define el valor de la propiedad cedula.
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
     * Obtiene el valor de la propiedad direccion.
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
     * Define el valor de la propiedad direccion.
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
     * Obtiene el valor de la propiedad totalPrecio.
     * 
     */
    public double getTotalPrecio() {
        return totalPrecio;
    }

    /**
     * Define el valor de la propiedad totalPrecio.
     * 
     */
    public void setTotalPrecio(double value) {
        this.totalPrecio = value;
    }

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

}
