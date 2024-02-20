/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ec.edu.monster.modelo;

import ec.edu.monster.controlador.TicketController;
import ec.edu.monster.ws.Localidad;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/obtenerLocalidadesServlet")
public class ObtenerLocalidadesServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtener el partido seleccionado
        String partido = request.getParameter("partido");
        
        // Lógica para obtener las localidades según el partido seleccionado
        TicketController controller = new TicketController();
        List<Localidad> localidades = controller.traerLocalidades(Integer.parseInt(partido));
        
        // Generar la tabla HTML de localidades
        String tablaHTML = generarTablaHTML(localidades);
        
        // Escribir la respuesta en formato HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(tablaHTML);
    }
    
    private String generarTablaHTML(List<Localidad> localidades) {
        StringBuilder tablaHTML = new StringBuilder();
        tablaHTML.append("<table class='table'>");
        tablaHTML.append("<tr><th>Nombre</th><th>Disponibilidad</th><th>Precio</th></tr>");
        for (Localidad localidad : localidades) {
            tablaHTML.append("<tr class='table-success'>");
            tablaHTML.append("<td>").append(localidad.getNombreLocalidad()).append("</td>");
            tablaHTML.append("<td>").append(localidad.getDisponibilidadLocalidad()).append("</td>");
            tablaHTML.append("<td>").append(localidad.getPrecioLocalidad()).append("</td>");
            tablaHTML.append("</tr>");
        }
        tablaHTML.append("</table>");
        tablaHTML.append("<br>");
        tablaHTML.append("<p class='titulo'>Escoge la localidad deseada:</p>");
        tablaHTML.append("<br>");
        tablaHTML.append("<select name='localidad' id='localidad' class='form-select'>");
        for (Localidad localidad : localidades) {
            tablaHTML.append("<option value='").append(localidad.getNombreLocalidad()).append("'>").append(localidad.getNombreLocalidad()).append("</option>");
        }
        tablaHTML.append("</select>");
        tablaHTML.append("<br><br>");
        tablaHTML.append("<p class='titulo'>Escoge la cantidad: </p>");
        tablaHTML.append("<br>");
        tablaHTML.append("<input type='number' name='localidades' id='localidades' min='1' max='10' class='form-control'>");
        tablaHTML.append("<input type='hidden' id='mapInput' name='localidadMap' value='{}'>");
        tablaHTML.append("<br><br>");
        tablaHTML.append("<input type='button' id='escoger' value='Escoger' onclick='agregarAlCarrito()' class='btn btn-primary'>");
        tablaHTML.append("<br><br>");
        tablaHTML.append("<table id='carrito' class='table'>");
        tablaHTML.append("<tr><th>Localidad</th><th>Cantidad Escogida</th></tr>");
        tablaHTML.append("</table>");
        return tablaHTML.toString();
    }
}
