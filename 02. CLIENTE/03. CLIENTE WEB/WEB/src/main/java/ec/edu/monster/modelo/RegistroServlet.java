/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ec.edu.monster.modelo;

import ec.edu.monster.controlador.TicketController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registroServlet")
public class RegistroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los parámetros del formulario de registro
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String cedula = request.getParameter("cedula");
        String direccion = request.getParameter("direccion");
        
        // Aquí puedes realizar la lógica de validación de los datos ingresados
        
        // Lógica para registrar el usuario en la base de datos
        try {
            TicketController controller = new TicketController();
            controller.registrarUsuario(username, password, nombres, apellidos, cedula, direccion);
            System.out.println("Registro exitoso!!");
            
            // Redireccionar a una página de éxito o mostrar un mensaje de éxito
            response.sendRedirect("login.jsp");
        } catch (Exception e) {
            System.out.println("Error en el registro: " + e);
            
            // Redireccionar a una página de error o mostrar un mensaje de error
            
        }
    }
}
