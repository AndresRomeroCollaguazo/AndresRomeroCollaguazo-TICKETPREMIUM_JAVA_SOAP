/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controlador;

import ec.edu.monster.servicio.TicketService;
import ec.edu.monster.ws.Factura;
import ec.edu.monster.ws.Localidad;
import ec.edu.monster.ws.Ticket;
import java.util.List;

/**
 *
 * @author Mateo
 */
public class TicketController {
    public List<Ticket> traerPartidos(){
        TicketService service = new TicketService();
        return service.traerPartidos();
    }
    
    public void registroCompra(String nombreCliente, String cedula, String direccion, 
            int cantPalco, int cantTribuna, int cantGeneral, int cantGeneralVisita, double totalPrecio, int codigoPartido){
        
        TicketService service = new TicketService();
        service.registroCompra(nombreCliente, cedula, direccion, cantPalco, cantTribuna, cantGeneral, cantGeneralVisita, totalPrecio, codigoPartido);
    }
    
    public List<Localidad> traerLocalidades(int codigoPartido){
        TicketService service = new TicketService();
        return service.traerLocalidades(codigoPartido);
    }
    
    public List<Factura> traerReporte(int codigoPartido){
        TicketService service = new TicketService();
        return service.traerReporte(codigoPartido);
    }
    
    public void registrarUsuario(String usuario, String password, String nombres, String apellidos, String cedula, String direccion){
        TicketService service = new TicketService();
        service.registrarUsuario(usuario, password, nombres, apellidos, cedula, direccion);
    }
    
    public boolean comprobarUsuario(String username, String password){
        TicketService service = new TicketService();
        return service.comprobarUsuario(username, password);
    }
}
