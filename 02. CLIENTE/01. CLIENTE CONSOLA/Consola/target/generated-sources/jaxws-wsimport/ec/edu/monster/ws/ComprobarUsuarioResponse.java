
package ec.edu.monster.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for comprobarUsuarioResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="comprobarUsuarioResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="comprobar" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "comprobarUsuarioResponse", propOrder = {
    "comprobar"
})
public class ComprobarUsuarioResponse {

    protected boolean comprobar;

    /**
     * Gets the value of the comprobar property.
     * 
     */
    public boolean isComprobar() {
        return comprobar;
    }

    /**
     * Sets the value of the comprobar property.
     * 
     */
    public void setComprobar(boolean value) {
        this.comprobar = value;
    }

}
