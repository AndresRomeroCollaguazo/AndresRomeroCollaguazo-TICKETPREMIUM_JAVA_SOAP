
package ec.edu.monster.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para comprobarUsuarioResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
     * Obtiene el valor de la propiedad comprobar.
     * 
     */
    public boolean isComprobar() {
        return comprobar;
    }

    /**
     * Define el valor de la propiedad comprobar.
     * 
     */
    public void setComprobar(boolean value) {
        this.comprobar = value;
    }

}
