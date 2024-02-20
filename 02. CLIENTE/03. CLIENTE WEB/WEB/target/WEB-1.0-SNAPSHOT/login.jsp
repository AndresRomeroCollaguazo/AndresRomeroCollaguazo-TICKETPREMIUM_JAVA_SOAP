<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" name="viewport" content="width=device-width">
    <title>Iniciar sesión</title>
    <!-- Agrega aquí los enlaces a tus archivos CSS si los tienes -->
    <!-- Añade los enlaces a los archivos CSS de Bootstrap -->
   <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link href="css/Login.css" rel="stylesheet" />
   <script src="https://www.google.com/recaptcha/api.js" async defer></script>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
    <div class="container login-container">
        <div class="row">
            <div class="col-md-6 login-form-1">
           
                <form>
            <div class="imagen-login">
                        <img src="images/fondolog.jpg" />
             </div>
                </form>
            </div>
             <div class="col-md-6 login-form-2">
                <h3>INICIO DE SESIÓN</h3>
                 <form method="post" action="loginServlet">
            <div class="form-group">
                <label for="username">Usuario:</label>
                <input type="text" class="form-control" id="username" name="username" required>
            </div>
            <div class="form-group">
                <label for="password">Contraseña:</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <br>
            <br>
            <br>
             <div class="form-group">
               <center><input type="submit" class="btnSubmit" name="btn-login" value="Iniciar sesión"/></center>
            </div>
              <br>
        
                 </form>
             </div>
        </div>
    </div>
  <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            document.getElementById("formulario").addEventListener('submit', validarCaptcha);
        });

        function validarCaptcha(evento) {
            evento.preventDefault();
            var response = grecaptcha.getResponse();
            if (response.length == 0) {
                alert("Captcha no verificado")
                return;
            }
            this.submit();
        }
   
        

    <!-- Añade el enlace al archivo JavaScript de Bootstrap -->
</script>
</body>
</html>







