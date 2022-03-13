<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/bf61009fa7.js" crossorigin="anonymous"></script>
        <title>Control de clientes</title>
    </head>
    <body>
       <!-- cabeceros-->
       <jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp"></jsp:include>
       <!-- botones de navegacion -->
       <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacion.jsp"></jsp:include>
       
       <!--Buscador -->
       
       <jsp:include page="/WEB-INF/paginas/comunes/buscador.jsp"></jsp:include>
       
       
       <!-- listado clientes -->
       <jsp:include page="/WEB-INF/paginas/cliente/listadoClientes.jsp"></jsp:include>
     
       <jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp"></jsp:include>   
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
