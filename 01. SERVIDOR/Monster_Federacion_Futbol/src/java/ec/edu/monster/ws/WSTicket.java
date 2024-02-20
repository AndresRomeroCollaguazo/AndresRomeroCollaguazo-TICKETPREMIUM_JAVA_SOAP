/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package ec.edu.monster.ws;

import ec.edu.monster.modelo.Cliente;
import ec.edu.monster.modelo.Factura;
import ec.edu.monster.modelo.Localidad;
import ec.edu.monster.modelo.Ticket;
import ec.edu.monster.servicio.TicketService;
import java.util.ArrayList;
import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 *
 * @author Jhonatan
 */
@WebService(serviceName = "WSTicket")
public class WSTicket {

    /**
     * Web service operation
     *
     * @return Retorna una lista de partidos disponibles
     */
    @WebMethod(operationName = "traerPartidos")
    @WebResult(name = "partidos")
    public List<Ticket> traerPartidos() {
        List<Ticket> lista;
        try {
            TicketService service = new TicketService();
            lista = service.leerPartidos();
        } catch (Exception e) {
            lista = new ArrayList<>();
        }
        return lista;
    }

    /**
     * Web service operation
     *
     * @param nombreCliente
     * @param cedula
     * @param direccion
     * @param cantPalco
     * @param cantTribuna
     * @param cantGeneral
     * @param cantGeneralVisita
     * @param totalPrecio
     * @param codigoPartido
     */
    @WebMethod(operationName = "registroCompra")
    @Oneway
    @WebResult(name = "compra")
    public void registroCompra(@WebParam(name = "nombreCliente") String nombreCliente, @WebParam(name = "cedula") String cedula, @WebParam(name = "direccion") String direccion,
            @WebParam(name = "cantPalco") int cantPalco, @WebParam(name = "cantTribuna") int cantTribuna, @WebParam(name = "cantGeneral") int cantGeneral,
            @WebParam(name = "cantGeneralVisita") int cantGeneralVisita, @WebParam(name = "totalPrecio") double totalPrecio, @WebParam(name = "codigoPartido") int codigoPartido) {
        try {
            TicketService service = new TicketService();
            service.registrarVenta(nombreCliente, cedula, direccion, cantPalco, cantTribuna, cantGeneral, cantGeneralVisita, totalPrecio, codigoPartido);
            System.out.println("Éxito en la compra.");
        } catch (Exception e) {
            System.out.println("Error en el web service: " + e);
        }

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "traerLocalidades")
    @WebResult(name = "localidades")
    public List<Localidad> traerLocalidades(@WebParam(name = "codigoPartido") int codigoPartido) {
        List<Localidad> lista;
        try {
            TicketService service = new TicketService();
            lista = service.leerLocalidades(codigoPartido);

        } catch (Exception e) {
            lista = new ArrayList<>();
        }
        return lista;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "traerReporte")
    @WebResult(name = "reporte")
    public List<Factura> traerReporte(@WebParam(name = "codigoPartido") int codigoPartido) {
        List<Factura> lista;
        try {
            TicketService service = new TicketService();
            lista = service.obtenerReporte(codigoPartido);
        } catch (Exception e) {
            lista = new ArrayList<>();
        }
        return lista;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "traerCliente")
    @WebResult(name = "reporte")
    public Cliente traerCliente(@WebParam(name = "usuario") String usuario) {
        Cliente lista = null;
        try {
            TicketService service = new TicketService();
            lista = service.obtenerCliente(usuario);
        } catch (Exception e) {
        }
        return lista;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "registroUsuario")
    @Oneway
    @WebResult(name = "registrar")
    public void registroUsuario(@WebParam(name = "usuario") String usuario, @WebParam(name = "password") String password, @WebParam(name = "nombres") String nombres,
            @WebParam(name = "apellidos") String apellidos, @WebParam(name = "cedula") String cedula, @WebParam(name = "direccion") String direccion) {
        try {
            TicketService service = new TicketService();
            service.registrarUsuario(usuario, password, nombres, apellidos, cedula, direccion);
            System.out.println("Registro exitosa!!");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "comprobarUsuario")
    @WebResult(name = "comprobar")
    public boolean comprobarUsuario(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        boolean existe = false;
        try {
            TicketService service = new TicketService();
            if (service.comprobarUsuario(username, password)) {
                System.out.println("Existe!!");
                existe = true;
            } else {
                System.out.println("No Existe!!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return existe;
    }

}
