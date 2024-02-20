/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ec.edu.monster.modelo;

import ec.edu.monster.controlador.TicketController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mateo
 */
@WebServlet("/RegistrarCompraConsumidorServlet")
public class RegistrarCompraConsumidorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TicketController controller = new TicketController();
        List<Integer> cantidades = (List<Integer>) request.getSession().getAttribute("Cantidades");
        String codigoPartido = (String) request.getSession().getAttribute("codigoPartido");
        double precioConIva = (double) request.getSession().getAttribute("precioConIva");
        controller.registroCompra("-", "-", "-", 
                cantidades.get(1), cantidades.get(0), 
                cantidades.get(2),cantidades.get(3), 
                precioConIva, Integer.parseInt(codigoPartido));
        
        // Establecer los atributos en la solicitud para pasarlos a la página JSP
        request.setAttribute("nombre", "-");
        request.setAttribute("cedula", "-");
        request.setAttribute("direccion", "-");
        request.setAttribute("cantidades", cantidades);
        request.setAttribute("codigoPartido", codigoPartido);
        request.setAttribute("precioConIva", precioConIva);

        // Redirigir a la página JSP para mostrar el modal
        request.getRequestDispatcher("modalFactura.jsp").forward(request, response);
    }

}
