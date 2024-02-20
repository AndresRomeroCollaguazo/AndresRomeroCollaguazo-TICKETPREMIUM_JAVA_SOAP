<%@page import="ec.edu.monster.ws.Localidad"%>
<%@page import="ec.edu.monster.controlador.TicketController"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factura</title>
        <!-- Agrega aquí los enlaces a tus archivos CSS si los tienes -->

        <!-- Agrega el enlace al archivo CSS de Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
            crossorigin="anonymous">
        <style>
            /* Estilos para el modal */
            .modal {
                display: block; /* Mostrar el modal por defecto */
                position: fixed;
                z-index: 1;
                left: 0;
                top: 0;
                width: 100%;
                height: 100%;
                overflow: auto;
                background-color: rgba(0, 0, 0, 0.4); /* Fondo oscuro semitransparente */
            }
            .btn-primary {
                background-color: #FFC107; /* Cambia el color del botón a verde */
                border-color: #FFC107;

            }

            .modal-content {
                background-color: #fefefe;
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
    </head>
    <body>
        <!-- Modal -->
        <div id="myModal" class="modal">
            <div class="modal-content">
                <span class="close" onclick="closeModal()">&times;</span>
                <center>
                <h2>Factura de su compra</h2>
                </center>
                
                <center>
            
            
            <img src="images/compra.png" height="100px" width="100px">
            </center>
                
                <% List<Integer> lista = (List<Integer>) request.getAttribute("cantidades");%>
                
                    <br>
                <table class="table">
                    <tr>
                        <th>Nombre</th>
                        <th>Cantidad</th>
                        <th>Precio</th>
                        <th>Total</th>
                    </tr>
                    <%
                        TicketController controller = new TicketController();
                        String codigoPartido = (String) request.getAttribute("codigoPartido");
                        List<Localidad> listaLc = controller.traerLocalidades(Integer.parseInt(codigoPartido));
                        double precioSinIva = 0;
                    %>
                    <% if (codigoPartido != null && !codigoPartido.isEmpty() && lista != null && lista.size() == listaLc.size()) {
                            int codigoPartidoInt = Integer.parseInt(codigoPartido);
                            for (int i = 0; i < listaLc.size(); i++) {
                                Localidad lc = listaLc.get(i);
                                precioSinIva = lc.getPrecioLocalidad() * lista.get(i);
                    %>
                    <tr>
                        <td><%= lc.getNombreLocalidad()%></td>
                        <td><%= lista.get(i)%></td>
                        <td>$<%= lc.getPrecioLocalidad()%></td>
                        <td>$<%= precioSinIva%></td>
                    </tr>
                    <%
                            }
                        }%>
                </table>
                <table class="table">
                    
                    <tr>
                        <th>Total:</th>
                        <td>$<%= request.getAttribute("precioConIva")%></td>
                    </tr>
                </table>
                <a href="menu.jsp" class="btn btn-primary">Volver al Menú Principal</a>
            </div>
        </div>

        <!-- Agrega el enlace al archivo JavaScript de Bootstrap -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
            crossorigin="anonymous"></script>
        <script>
            // JavaScript para mostrar y ocultar el modal
            function closeModal() {
                document.getElementById("myModal").style.display = "none";
            }
        </script>
    </body>
</html>
