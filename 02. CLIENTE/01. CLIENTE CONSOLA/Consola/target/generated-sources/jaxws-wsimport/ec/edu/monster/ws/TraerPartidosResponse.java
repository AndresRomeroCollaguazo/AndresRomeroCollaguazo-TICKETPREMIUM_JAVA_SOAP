
package ec.edu.monster.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for traerPartidosResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="traerPartidosResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="partidos" type="{http://ws.monster.edu.ec/}ticket" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "traerPartidosResponse", propOrder = {
    "partidos"
})
public class TraerPartidosResponse {

    protected List<Ticket> partidos;

    /**
     * Gets the value of the partidos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the partidos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPartidos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ticket }
     * 
     * 
     */
    public List<Ticket> getPartidos() {
        if (partidos == null) {
            partidos = new ArrayList<Ticket>();
        }
        return this.partidos;
    }

}
