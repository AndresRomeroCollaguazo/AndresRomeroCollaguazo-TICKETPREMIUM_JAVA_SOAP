<%@page import="ec.edu.monster.ws.Localidad"%>
<%@page import="ec.edu.monster.controlador.TicketController"%>
<%@page import="java.util.List"%>
<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmación de Compra</title>
        <!-- Agrega aquí los enlaces a tus archivos CSS si los tienes -->

        <!-- Agrega el enlace al archivo CSS de Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
            crossorigin="anonymous">
        <style>
            /* Estilos para el modal */
            .btn-primary {
            background-color: #FFC107; /* Cambia el color del botón a verde */
            border-color: #FFC107;
          
            }
            .titulo {
            color: #FFC107; /* Cambia el color del texto a tu preferencia */
            font-size: 2em; /* Ajusta el tamaño del texto según sea necesario */
            font-weight: bold; /* Hace que el texto sea negrita */
            text-align: center; /* Centra el texto */
            margin-bottom: 20px; /* Añade un espacio en la parte inferior del título */
            /* Puedes agregar más estilos según tus preferencias */
            }
            .modal {
                display: none; /* Ocultar el modal por defecto */
                position: fixed;
                z-index: 1;
                left: 0;
                top: 0;
                width: 100%;
                height: 100%;
                overflow: auto;
                background-color: rgba(0, 0, 0, 0.4); /* Fondo oscuro semitransparente */
            }

            .modal-content {
                background-color: #FFC107;
                margin: 15% auto;
                padding: 20px;
                border: 1px solid #888;
                width: 40%;
            }

            .close {
                color: #aaa;
                float: right;
                font-size: 28px;
                font-weight: bold;
            }

            .close:hover,
            .close:focus {
                color: black;
                text-decoration: none;
                cursor: pointer;
            }
        </style>
        <script>
            // JavaScript para mostrar y ocultar el modal
            function openModal() {
                document.getElementById("myModal").style.display = "block";
            }

            function closeModal() {
                document.getElementById("myModal").style.display = "none";
            }
        </script>
    </head>
    <body>
        <div class="container">
            <h1 class="titulo">Verificación de su Compra</h1>
            <center>
            
            
            <img src="images/fondobuy.jpg" height="300px" width="200px">
            </center>
            <br>
            <br>
            <%-- Obtener los datos enviados desde el servlet --%>
            <% String codigoPartido = (String) request.getAttribute("codigoPartido"); %>
            <% List<Integer> cantidades = (List<Integer>) request.getAttribute("Cantidades");
                request.getSession().setAttribute("Cantidades", cantidades);
                request.getSession().setAttribute("codigoPartido", codigoPartido);%>

            <table class="table">
                <tr class='table-success'>
                    <th>Nombre</th>
                    <th>Cantidad</th>
                    <th>Precio</th>
                    <th>Total</th>
                </tr>
                <%
                    TicketController controller = new TicketController();
                    List<Localidad> listaLc = controller.traerLocalidades(Integer.parseInt(codigoPartido));
                    double precioSinIva = 0;
                %>
                <% if (codigoPartido != null && !codigoPartido.isEmpty() && cantidades != null && cantidades.size() == listaLc.size()) {
                        int codigoPartidoInt = Integer.parseInt(codigoPartido);
                        for (int i = 0; i < listaLc.size(); i++) {
                            Localidad lc = listaLc.get(i);
                            precioSinIva += lc.getPrecioLocalidad() * cantidades.get(i);
                            double precio = lc.getPrecioLocalidad() * cantidades.get(i);
                %>
                <tr>
                    <td><%= lc.getNombreLocalidad()%></td>
                    <td><%= cantidades.get(i)%></td>
                    <td>$<%= lc.getPrecioLocalidad()%></td>
                    <td>$<%= precio%></td>
                </tr>
                <%
                        }
                    }%>
            </table>
            <table class="table">
                <tr>
                    <th>Subtotal</th>
                    <th>IVA 12%</th>
                    <th>Total</th>
                </tr>
                <%
                    double iva = precioSinIva * 0.12;
                    double precioConIva = precioSinIva + iva;
                    request.setAttribute("precioConIva", precioConIva);
                    request.getSession().setAttribute("precioConIva", precioConIva);
                    DecimalFormat df = new DecimalFormat("#.##");
                %>
                <tr>
                    <td><%= df.format(precioSinIva)%></td>
                    <td><%= df.format(iva)%></td>
                    <td><%= df.format(precioConIva)%></td>
                </tr>
            </table>

            <form action="RegistrarCompraConsumidorServlet" method="POST">
                <input type="submit" value="Confirmar compra" class="btn btn-primary">
            </form>
            <br>

            <!-- Modal -->
            <div id="myModal" class="modal">
                <div class="modal-content">
                    <span class="close" onclick="closeModal()">&times;</span>
                    <h2>Ingrese sus datos para la factura</h2>
                    <form action="RegistrarCompraFacturaServlet" method="POST">
                        <label for="nombre">Nombre:</label>
                        <input type="text" id="nombre" name="nombre" required class="form-control"><br><br>
                        <label for="cedula">Cédula:</label>
                        <input type="text" id="cedula" name="cedula" required class="form-control"><br><br>
                        <label for="direccion">Dirección:</label>
                        <input type="text" id="direccion" name="direccion" required class="form-control"><br><br>
                        <input type="submit" value="Aceptar y Comprar" class="btn btn-primary">
                    </form>
                </div>
            </div>
        </div>

        <!-- Agrega el enlace al archivo JavaScript de Bootstrap -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
            crossorigin="anonymous"></script>
    </body>
</html>
