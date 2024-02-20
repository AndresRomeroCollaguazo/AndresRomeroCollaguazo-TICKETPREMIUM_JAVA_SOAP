
package ec.edu.monster.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for traerLocalidades complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="traerLocalidades"&gt;
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
@XmlType(name = "traerLocalidades", propOrder = {
    "codigoPartido"
})
public class TraerLocalidades {

    protected int codigoPartido;

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
