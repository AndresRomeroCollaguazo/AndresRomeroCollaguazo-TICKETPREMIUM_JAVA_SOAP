
package ec.edu.monster.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para traerReporte complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="traerReporte"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
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
@XmlType(name = "traerReporte", propOrder = {
    "codigoPartido"
})
public class TraerReporte {

    protected int codigoPartido;

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
