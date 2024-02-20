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
public class PruebaTicketServiceRegistrar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            TicketService service = new TicketService();
            service.registroCompra("Ezequiel Castillo", "1722469960", "Sabanilla y Hucachi",
                    0, 1, 0, 10, 65.0, 1);
            System.out.println("Compra exitosa!!");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
}
