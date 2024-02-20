/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ec.edu.monster.prueba;

import ec.edu.monster.servicio.TicketService;

/**
 *
 * @author mateo
 */
public class PruebaComprobarUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            TicketService service = new TicketService();
            if (service.comprobarUsuario("carloslopez", "admin")) {
                System.out.println("Existe!!");
            } else {
                System.out.println("No Existe!!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}
