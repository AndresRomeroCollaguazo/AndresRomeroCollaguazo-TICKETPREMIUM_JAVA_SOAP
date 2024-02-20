<%@page import="java.util.List"%>
<%@page import="ec.edu.monster.ws.Ticket"%>
<%@page import="ec.edu.monster.controlador.TicketController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Reportes de Partidos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
        crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#buscarReporte").click(function () {
                var partido = $("#partido").val();
                // Captura el nombre del partido seleccionado
                var nombrePartido = $("#partido option:selected").text();

                $.ajax({
                    url: "traerReportes",
                    method: "POST",
                    data: { partido: partido },
                    success: function (response) {
                        // Muestra el nombre del partido seleccionado
                        $("#nombrePartidoSeleccionado").text("Partido Seleccionado: " + nombrePartido);
                        // Actualiza el contenido de la tablaLocalidades
                        $("#tablaLocalidades").html(response);
                    }
                });
            });
        });
    </script>

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
<body class="bg-light text-center py-5">
    <div class="container">
        <h1>Reportes de Partidos</h1>
        <form action="traerReportes" method="POST" class="mt-4">
            <div class="row">
                <div class="col-md-6">
                    <select name="partido" id="partido" class="form-select">
                        <%
                            TicketController controller = new TicketController();
                            List<Ticket> lista = controller.traerPartidos();

                            for (Ticket tk : lista) {
                                String fechaFormateada = tk.getFechaPartido().toString().substring(0, 10);
                        %>
                        <option value="<%=tk.getCodigoPartido()%>"><%=tk.getEquipoLocal() + " vs " + tk.getEquipoVisita() + " - " + fechaFormateada + " - " + tk.getHoraPartido()%></option>
                        <%
                            }
                        %>
                    </select>
                </div>
                <div class="col-md-6">
                    <button type="button" id="buscarReporte" class="btn btn-primary">Buscar</button>
                </div>
            </div>
        </form>
        <!-- Mostrar el nombre del partido seleccionado -->
        <div id="nombrePartidoSeleccionado" class="mt-2"></div>
        <div id="tablaLocalidades" class="mt-4"></div>
        <button type="button" class="btn btn-success mt-3" onclick="descargarTXT()">Descargar TXT</button>

        <!-- Incluir jsPDF -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.4.0/jspdf.umd.min.js"></script>

        <!-- Script para descargar TXT -->
        <script>
            
           // Función para descargar TXT
function descargarTXT() {
    var nombrePartidoSeleccionado = $("#nombrePartidoSeleccionado").text().trim();
    var tabla = document.getElementById('tablaLocalidades').innerText;

    // Crear contenido del archivo TXT con el nombre del partido y la tabla
    var contenidoTXT = "Partido Seleccionado: " + nombrePartidoSeleccionado + "\n\n" + tabla;

    // Crear un objeto Blob con el contenido del texto
    var blob = new Blob([contenidoTXT], { type: "text/plain;charset=utf-8" });

    // Crear un enlace de descarga
    var a = document.createElement('a');
    a.href = window.URL.createObjectURL(blob);
    a.download = 'reporte_partidos.txt';

    // Añadir el enlace al documento y hacer clic en él para iniciar la descarga
    document.body.appendChild(a);
    a.click();
    document.body.removeChild(a);
}

        </script>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
            crossorigin="anonymous"></script>
    </div>
</body>
</html>

