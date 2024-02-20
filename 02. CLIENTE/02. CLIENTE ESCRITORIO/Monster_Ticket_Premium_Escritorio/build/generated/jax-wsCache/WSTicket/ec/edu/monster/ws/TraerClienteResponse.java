
package ec.edu.monster.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para traerClienteResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="traerClienteResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reporte" type="{http://ws.monster.edu.ec/}cliente" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
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
     * Obtiene el valor de la propiedad reporte.
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
     * Define el valor de la propiedad reporte.
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
