/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ec.edu.monster.prueba;

import ec.edu.monster.modelo.Localidad;
import ec.edu.monster.modelo.Ticket;
import ec.edu.monster.servicio.TicketService;
import java.util.List;

/**
 *
 * @author Mateo
 */
public class PruebaTicketService {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            TicketService service = new TicketService();
            List<Ticket> lista = service.leerPartidos();
            
            for (Ticket tk : lista) {
                System.out.println(tk.getCodigoPartido() + "\n - " + tk.getNombreEstadio() + "\n - " + tk.getEquipoLocal() + " VS " + tk.getEquipoVisita()
                + "\n - " + tk.getFechaPartido() + " " + tk.getHoraPartido());
                System.out.println("----------------------------------------------");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
}
