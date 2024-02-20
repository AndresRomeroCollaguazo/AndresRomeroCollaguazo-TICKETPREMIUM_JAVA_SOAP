/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ec.edu.monster.prueba;

import ec.edu.monster.servicio.TicketService;
import ec.edu.monster.ws.Localidad;
import java.util.List;

/**
 *
 * @author Mateo
 */
public class PruebaTicketServiceLecturaLocalidades {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            TicketService service = new TicketService();
            List<Localidad> lista = service.traerLocalidades(1);
            for (Localidad lc : lista) {
                System.out.println(lc.getCodigoLocalidad() + " - " + lc.getNombreLocalidad() + " - "
                        + lc.getDisponibilidadLocalidad() + " - " + lc.getPrecioLocalidad());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
                
    }
    
}
