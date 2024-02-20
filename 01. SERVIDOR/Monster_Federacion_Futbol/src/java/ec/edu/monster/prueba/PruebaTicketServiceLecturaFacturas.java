/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ec.edu.monster.prueba;

import ec.edu.monster.modelo.Factura;
import ec.edu.monster.servicio.TicketService;
import java.util.List;

/**
 *
 * @author mateo
 */
public class PruebaTicketServiceLecturaFacturas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            TicketService service = new TicketService();
            List<Factura> lista = service.obtenerReporte(1);
            for (Factura fc : lista) {
                System.out.println(fc.getCantPalco() + " - " + fc.getCantTribuna() + " - " + fc.getCantGeneral() + " - " + fc.getCantGeneralVisita() + " - " + fc.getPrecioTotal());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        
        
    }
    
}
