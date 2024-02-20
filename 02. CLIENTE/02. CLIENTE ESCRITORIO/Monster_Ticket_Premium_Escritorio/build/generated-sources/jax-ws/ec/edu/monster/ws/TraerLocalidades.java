
package ec.edu.monster.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para traerLocalidades complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="traerLocalidades">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
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
@XmlType(name = "traerLocalidades", propOrder = {
    "codigoPartido"
})
public class TraerLocalidades {

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
