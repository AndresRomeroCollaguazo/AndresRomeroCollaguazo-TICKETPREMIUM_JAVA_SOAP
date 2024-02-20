<!DOCTYPE html>
<html>
<head>
     <meta name="viewport" content="width=device-width" />
    <title>Registro de Usuario</title>
    <!-- Agrega el enlace al archivo CSS de Bootstrap -->
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link href="css/Login.css" rel="stylesheet" type="text/css"/>
        <link href="css/marcoPagina.css" rel="stylesheet" type="text/css"/>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
            crossorigin="anonymous">
</head>
<body>
     <div class="container login-container">
            <div class="row">
                <div class="col-md-5 login-form-1">
                    <div class="imagen-registro">
                        <img class="imagenHBoo" src="images/pngwing.com (1).png" />
                    </div>
                </div>
<div class="col-md-7 login-form-2">
        <h3>FORMULARIO DE REGISTRO</h3>
        <form action="registroServlet" method="post" id="formulario">
          <div class="border border-white rounded p-3 bg-succes">
                            <div class="row">
                                <div class="col-md-6"> 
                                    <div class="form-group">
                <label for="username">Usuario:</label>
                <input type="text" id="username" name="username" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="password">Contraseña:</label>
                <input type="password" id="password" name="password" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="nombres">Nombres:</label>
                <input type="text" id="nombres" name="nombres" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="apellidos">Apellidos:</label>
                <input type="text" id="apellidos" name="apellidos" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="cedula">Cédula:</label>
                <input type="text" id="cedula" name="cedula" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="direccion">Dirección:</label>
                <input type="text" id="direccion" name="direccion" class="form-control" required>
            </div>
                                </div>
                            </div>
          </div>
        </br>

         <div class="form-group">
                            <center><button type="submit" class="btnSubmit"><i class="fa-solid fa-floppy-disk"></i> Registrarse</button></center>
          </div>
        
        <br>
          <div class="form-group">
              <center> <a href="login.jsp"><button type="button" class="btnSubmit"><i class="fa-solid fa-arrow-left"></i>Volver al inicio de sesión</button></a></center>
    </div>
               

                 </form>
        </div>
</div>
     </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
            crossorigin="anonymous"></script>
</body>
</html>
