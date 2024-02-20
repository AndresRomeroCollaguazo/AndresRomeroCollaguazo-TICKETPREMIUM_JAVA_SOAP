/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ec.edu.monster.modelo;

import ec.edu.monster.controlador.TicketController;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrarCompraFacturaServlet")
public class RegistrarCompraFacturaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener los datos del formulario
        TicketController controller = new TicketController();
        String nombre = request.getParameter("nombre");
        String cedula = request.getParameter("cedula");
        String direccion = request.getParameter("direccion");
        List<Integer> cantidades = (List<Integer>) request.getSession().getAttribute("Cantidades");
        String codigoPartido = (String) request.getSession().getAttribute("codigoPartido");
        double precioConIva = (double) request.getSession().getAttribute("precioConIva");
        // Aquí puedes realizar las acciones necesarias con los datos de la factura
        // Guardar los datos en la base de datos, generar la factura, etc.
        controller.registroCompra(nombre, cedula, direccion,
                cantidades.get(1), cantidades.get(0),
                cantidades.get(2), cantidades.get(3),
                precioConIva, Integer.parseInt(codigoPartido));
        
        // Establecer los atributos en la solicitud para pasarlos a la página JSP
        request.setAttribute("nombre", nombre);
        request.setAttribute("cedula", cedula);
        request.setAttribute("direccion", direccion);
        request.setAttribute("cantidades", cantidades);
        request.setAttribute("codigoPartido", codigoPartido);
        request.setAttribute("precioConIva", precioConIva);

        // Redirigir a la página JSP para mostrar el modal
        request.getRequestDispatcher("modalFactura.jsp").forward(request, response);
    }
}
