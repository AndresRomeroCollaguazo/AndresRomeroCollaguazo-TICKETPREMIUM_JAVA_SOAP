/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.servicio;

import ec.edu.monster.ws.Ticket;
import java.util.List;

/**
 *
 * @author Jhonatan
 */
public class TicketService {

    public java.util.List<ec.edu.monster.ws.Ticket> traerPartidos() {

        ec.edu.monster.ws.WSTicket_Service service = new ec.edu.monster.ws.WSTicket_Service();
        ec.edu.monster.ws.WSTicket port = service.getWSTicketPort();
        java.util.List<ec.edu.monster.ws.Ticket> lista = port.traerPartidos();
        return lista;
    }

    public void registroCompra(java.lang.String nombreCliente, java.lang.String cedula, java.lang.String direccion,
            int cantPalco, int cantTribuna, int cantGeneral, int cantGeneralVisita, double totalPrecio, int codigoPartido) {

        ec.edu.monster.ws.WSTicket_Service service = new ec.edu.monster.ws.WSTicket_Service();
        ec.edu.monster.ws.WSTicket port = service.getWSTicketPort();
        port.registroCompra(nombreCliente, cedula, direccion, cantPalco, cantTribuna, cantGeneral, cantGeneralVisita, totalPrecio, codigoPartido);
    }

    public java.util.List<ec.edu.monster.ws.Localidad> traerLocalidades(int codigoPartido) {

        ec.edu.monster.ws.WSTicket_Service service = new ec.edu.monster.ws.WSTicket_Service();
        ec.edu.monster.ws.WSTicket port = service.getWSTicketPort();
        java.util.List<ec.edu.monster.ws.Localidad> lista = port.traerLocalidades(codigoPartido);

        return lista;
    }

    public java.util.List<ec.edu.monster.ws.Factura> traerReporte(int codigoPartido) {

        ec.edu.monster.ws.WSTicket_Service service = new ec.edu.monster.ws.WSTicket_Service();
        ec.edu.monster.ws.WSTicket port = service.getWSTicketPort();
        java.util.List<ec.edu.monster.ws.Factura> lista = port.traerReporte(codigoPartido);

        return lista;
    }

    public void registrarUsuario(String usuario, String password, String nombres, String apellidos, String cedula, String direccion) {
        ec.edu.monster.ws.WSTicket_Service service = new ec.edu.monster.ws.WSTicket_Service();
        ec.edu.monster.ws.WSTicket port = service.getWSTicketPort();
        port.registroUsuario(usuario, password, nombres, apellidos, cedula, direccion);

    }

    public boolean comprobarUsuario(String username, String password) {

        boolean existe;
        ec.edu.monster.ws.WSTicket_Service service = new ec.edu.monster.ws.WSTicket_Service();
        ec.edu.monster.ws.WSTicket port = service.getWSTicketPort();
        existe = port.comprobarUsuario(username, password);

        return existe;
    }

}
