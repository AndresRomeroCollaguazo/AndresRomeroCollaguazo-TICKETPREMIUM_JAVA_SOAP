/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ec.edu.monster.modelo;

import ec.edu.monster.controlador.TicketController;
import ec.edu.monster.ws.Localidad;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@WebServlet("/confirmarCompraServlet")
public class ConfirmarCompraServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener el código del partido seleccionado
        String codigoPartido = request.getParameter("partido");

        // Obtener los datos de la tabla "carrito"
        List<Integer> carritoData = getCarritoData(request);
        request.setAttribute("Cantidades",carritoData);
        request.setAttribute("codigoPartido", codigoPartido);
        // Aquí puedes realizar las acciones necesarias con los datos obtenidos
        // Guardar el código del partido y los datos del carrito en la base de datos, generar una factura, etc.
        // Redireccionar a la página de confirmación de compra exitosa
        request.getRequestDispatcher("confirmacionCompraExitosa.jsp").forward(request, response);
    }

    public List<Integer> getCarritoData(HttpServletRequest request) {
        // Obtener los datos de la tabla "carrito" y retornarlos como un Map<String, Integer>

        // Crear el Map para almacenar los datos del carrito
        String localidadMapJSON = request.getParameter("localidadMap");
        System.out.println(localidadMapJSON);
        Map<String, Double> carritoData = new Gson().fromJson(localidadMapJSON, new TypeToken<Map<String, Double>>() {
        }.getType());
        
        for (Map.Entry<String, Double> entry : carritoData.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            System.out.println(key + ": " + val);
        }

        List<Double> aux = new ArrayList<>();
        TicketController controller = new TicketController();
        List<Localidad> lista = controller.traerLocalidades(Integer.parseInt(request.getParameter("partido")));
        for (int i = 0; i < lista.size(); i++) {
            Localidad lc = lista.get(i);
            if (carritoData.containsKey(lc.getNombreLocalidad())) {
                aux.add(carritoData.get(lc.getNombreLocalidad()));
            } else {
                aux.add(0.0);
            }
        }

        List<Integer> listaInteger = new ArrayList<>();
        for (Double valor : aux) {
            listaInteger.add(valor.intValue());
        }
        
        for (Integer integer : listaInteger) {
            System.out.println(integer);
        }
        
        return listaInteger;
    }
}
