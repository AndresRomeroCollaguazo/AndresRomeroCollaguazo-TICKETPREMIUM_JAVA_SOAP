/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ec.edu.monster.modelo;

import com.sun.javafx.animation.TickCalculation;
import ec.edu.monster.controlador.TicketController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener los valores ingresados por el usuario
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Verificar las credenciales del usuario (aquí debes implementar tu propia lógica de autenticación)
        boolean isAuthenticated = authenticate(username, password);

        if (isAuthenticated) {
            // Inicio de sesión exitoso

            // Crear una sesión de usuario
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Redireccionar al menú principal o a la página deseada
            response.sendRedirect("menu.jsp");
        } else {
            // Inicio de sesión fallido

            // Redireccionar a la página de inicio de sesión con un mensaje de error
            response.sendRedirect("login.jsp?error=1");
        }
    }

    private boolean authenticate(String username, String password) {
        // Aquí debes implementar tu propia lógica de autenticación
        // Verificar las credenciales del usuario en tu base de datos u otro sistema de autenticación
        TicketController controller = new TicketController();

        // Ejemplo de autenticación simple (solo para demostración)
        if (controller.comprobarUsuario(username, password)) {
            return true;
        } else {
            return false;
        }
    }
}