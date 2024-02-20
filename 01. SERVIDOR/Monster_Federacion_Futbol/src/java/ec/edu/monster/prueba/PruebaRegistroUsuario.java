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
public class PruebaRegistroUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            TicketService service = new TicketService();
            service.registrarUsuario("jmaigua", "123456", "Jonathan", "Maigua", "1752768661", "Checa");
            System.out.println("Registro exitosa!!");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
}
