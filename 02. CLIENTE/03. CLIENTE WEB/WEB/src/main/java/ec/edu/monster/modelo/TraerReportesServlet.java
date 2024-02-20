package ec.edu.monster.modelo;
import ec.edu.monster.controlador.TicketController;
import ec.edu.monster.ws.Factura;
import ec.edu.monster.ws.Localidad;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;

@WebServlet("/traerReportes")
public class TraerReportesServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TicketController controller = new TicketController();
        String partido = request.getParameter("partido");
        List<Factura> lista = controller.traerReporte(Integer.parseInt(partido));
        List<Localidad> listaLc = controller.traerLocalidades(Integer.parseInt(partido));
        // Generar la tabla HTML de localidades
        String tablaHTML = generarTablaHTML(listaLc, lista);

        // Escribir la respuesta en formato HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(tablaHTML);
    }

    private String generarTablaHTML(List<Localidad> localidades, List<Factura> facturas) {
    StringBuilder tablaHTML = new StringBuilder();
    tablaHTML.append("<table class='table table-sm'>");

    double aux = 0;
    int auxP = 0, auxT = 0, auxG = 0, auxGV = 0;
    DecimalFormat df = new DecimalFormat("#.##");

    for (Factura fc : facturas) {
        aux = aux + fc.getPrecioTotal();
        auxP = auxP + fc.getCantPalco();
        auxT = auxT + fc.getCantTribuna();
        auxG = auxG + fc.getCantGeneral();
        auxGV = auxGV + fc.getCantGeneralVisita();
    }
    double precioTotal = aux;
    int totalTribuna = auxT;
    int totalPalco = auxP;
    int totalGeneral = auxG;
    int totalGeneralVisita = auxGV;
    List<Integer> totales = new ArrayList<>();
    totales.add(totalTribuna);
    totales.add(totalPalco);
    totales.add(totalGeneral);
    totales.add(totalGeneralVisita);
    tablaHTML.append("</table>");
    tablaHTML.append("<br>");
    tablaHTML.append("<table class='table table-sm'>");
    tablaHTML.append("<thead><tr><th>Localidad</th><th>Vendido</th><th>Recaudado</th></tr></thead>");

    for (int i = 0; i < localidades.size(); i++) {
        Localidad lc = localidades.get(i);
        int total = totales.get(i);
        double recaudado = lc.getPrecioLocalidad() * total;

        tablaHTML.append("<tr>");
        tablaHTML.append("<td>").append(lc.getNombreLocalidad()).append("</td>");
        tablaHTML.append("<td>").append(total).append("</td>");
        tablaHTML.append("<td>$").append(df.format(recaudado)).append("</td>");
        tablaHTML.append("</tr>");
    }
    tablaHTML.append("</table>");
    return tablaHTML.toString();
}
}
