/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ec.edu.monster.prueba;

import ec.edu.monster.servicio.TicketService;


/**
 *
 * @author Mateo
 */
public class PruebaTicketServiceLectura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            TicketService service = new TicketService();
            java.util.List<ec.edu.monster.ws.Ticket> lista = service.traerPartidos();
            for (ec.edu.monster.ws.Ticket tk : lista) {
                String fechaFormateada = tk.getFechaPartido().toString().substring(0, 10);
                System.out.println(tk.getCodigoPartido() + "\n - " + tk.getNombreEstadio() + "\n - " + tk.getEquipoLocal() + " vs " + tk.getEquipoVisita()
                + "\n - " + fechaFormateada + " " + tk.getHoraPartido());

                System.out.println("----------------------------------------------");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
}
