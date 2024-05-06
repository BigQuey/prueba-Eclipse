<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Login</title>
</head>
<body>
<div class="container">
    <br>
    <div class="col-lg-6">
        <form action="ServletLogin" method="post" id="id_form">
            <input type="hidden" name="type" value="login">
            <div class="form-group">
                <label>Correo:</label>
                <input type="text" class="form-control" name="txtCorreo">
            </div><br>
            <div class="form-group">
                <label>Contraseña:</label>
                <input type="password" class="form-control" name="txtPassword">
            </div><br>
            <input type="submit" class="btn btn-primary" value="ingresar">
        </form>
        <br>
        <%
        	String mensaje = (String) request.getAttribute("mensaje");
        	if(mensaje != null){
        %>
        <div class="alert alert-danger">
        	<strong>Error!--</strong><%=mensaje %>
        </div>
        <%
        	}
        %>
    </div>
</div>
</body>
</html>