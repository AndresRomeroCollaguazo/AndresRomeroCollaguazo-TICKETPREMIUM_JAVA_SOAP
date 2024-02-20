
package ec.edu.monster.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for traerClienteResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="traerClienteResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="reporte" type="{http://ws.monster.edu.ec/}cliente" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "traerClienteResponse", propOrder = {
    "reporte"
})
public class TraerClienteResponse {

    protected Cliente reporte;

    /**
     * Gets the value of the reporte property.
     * 
     * @return
     *     possible object is
     *     {@link Cliente }
     *     
     */
    public Cliente getReporte() {
        return reporte;
    }

    /**
     * Sets the value of the reporte property.
     * 
     * @param value
     *     allowed object is
     *     {@link Cliente }
     *     
     */
    public void setReporte(Cliente value) {
        this.reporte = value;
    }

}
