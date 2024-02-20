<%@page import="java.util.List"%>
<%@page import="ec.edu.monster.ws.Ticket"%>
<%@page import="ec.edu.monster.controlador.TicketController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comprar Boleto</title>
        <!-- Agrega aquí los enlaces a tus archivos CSS si los tienes -->

        <!-- Agrega el enlace al archivo CSS de Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
              crossorigin="anonymous">
            <style>
    
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
        .container {
            max-width: 600px; /* Ajusta el ancho máximo del contenedor según sea necesario */
            margin-top: 50px; /* Añade un espacio en la parte superior del contenedor */
        }

    </style>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#buscar").click(function () {
                    var partido = $("#partido").val();
                    $.ajax({
                        url: "obtenerLocalidadesServlet",
                        method: "POST",
                        data: {partido: partido},
                        success: function (response) {
                            $("#tablaLocalidades").html(response);
                        }
                    });
                });
            });
        </script>
        <script>
            function agregarAlCarrito() {
                var localidad = document.getElementById('localidad').value;
                var cantidad = document.getElementById('localidades').value;

                // Obtener el map guardado en un input hidden
                var mapInput = document.getElementById('mapInput');
                var localidadMap = JSON.parse(mapInput.value);

                // Agregar la localidad y cantidad al map
                if (!localidadMap.hasOwnProperty(localidad)) {
                    localidadMap[localidad] = parseInt(cantidad);
                } else {
                    localidadMap[localidad] += parseInt(cantidad);
                    //localidadMap[localidad] = localidadMap.get(localidad) + parseInt(cantidad);
                }


                // Actualizar el input hidden con el map actualizado
                mapInput.value = JSON.stringify(localidadMap);

                // Actualizar la tabla de carrito
                var carrito = document.getElementById('carrito');
                var row = carrito.insertRow(-1);
                var cell1 = row.insertCell(0);
                var cell2 = row.insertCell(1);

                cell1.innerHTML = localidad;
                cell2.innerHTML = cantidad;
            }
        </script>
    </head>
    <body class="bg-light text-center py-5">
        <div class="container">
            
            <br>
            <br>
            <h1>COMPRA DE BOLETOS</h1>
            <img src="images/fondobuy.jpg" height="300px" width="200px">
            <br>
            <form action="confirmarCompraServlet" method="POST">
                <div class="mb-3">
                    <label for="partido" class="form-label titulo">Seleccione un partido:</label>
                    <select name="partido" id="partido" class="form-select">
                        <%
                            TicketController controller = new TicketController();
                            List<Ticket> lista = controller.traerPartidos();

                            int index = 1;
                            for (Ticket tk : lista) {
                                String fechaFormateada = tk.getFechaPartido().toString().substring(0, 10);
                        %>
                        <option value="<%=tk.getCodigoPartido()%>"><%=tk.getEquipoLocal() + " vs " + tk.getEquipoVisita() + " - " + fechaFormateada + " - " + tk.getHoraPartido()%></option>
                        <%
                                index++;
                            }
                        %>
                    </select>
                </div>
                <div class="mb-3">
                    <input type="button" id="buscar" value="Buscar" class="btn btn-primary">
                </div>
                <br><br>
                <div id="tablaLocalidades"></div>
                <br><br>
                <br><br>
                <input type="submit" value="Comprar" class="btn btn-primary">
            </form>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
    </body>
</html> 
