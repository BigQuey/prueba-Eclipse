<%@page import="java.util.List"%>
<%@page import="modelo.Producto"%>
<% Producto producto = (Producto)request.getAttribute("producto"); %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Registro de Producto</title>
</head>
<body>
<div class="container">
<br>
<div class="row">
	<div class="col-lg-4">
		<h3>Gestionar Productos</h3>
		<form action="ServletProducto" method="post">
			<input type="hidden" name="type" value="registrar">
			<div class="form-group">
				<label>Codigo</label>
				<input class="form-control" type="text" name="txtCod">
			</div><br>
			<div class="form-group">
				<label>Nombre</label>
				<input class="form-control" type="text" name="txtNombre">
			</div><br>
            <div class="form-group">
				<label>Precio</label>
				<input class="form-control" type="number" name="txtPrecio">
			</div><br>
            <div class="form-group">
				<label>Stock</label>
				<input class="form-control" type="number" name="txtStock">
			</div><br>
		
			<input type="submit" class="btn btn-primary" value="Registrar">
			<a href="ServletProducto?type=listar" class="btn btn-primary">Regresar</a>
		</form>
        <h3>Productos registrados</h3>
        <table class="table table-bordered table-hover responsive nowrap">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Codigo</th>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th>Stock</th>
                </tr>
            </thead>
            <tbody>
                <%
                List<Producto> listarProducto = (List<Producto>) request.getAttribute("dataProducto");
                if(listarProducto != null){
                    for(Producto item: listarProducto){	
                
                %>
                <tr>
                    <td><%=item.getIdProducto() %></td>
                    <td><%=item.getCodProd() %></td>
                    <td><%=item.getNombre() %></td>
                    <td><%=item.getPrecio() %></td>
                    <td><%=item.getStock() %></td>
                    <td>
                        
                <a href="ServletProducto?type=info&id=<%=item.getIdProducto() %>" class="btn btn-warning btn-sm">Informar</a>
    
                <a href="ServletProducto?type=eliminar&id=<%=item.getIdProducto() %>" class="btn btn-warning btn-sm">Eliminar</a>
    
                <a href="ServletProducto?type=infoEdit&id=<%=item.getIdProducto() %>" class="btn btn-warning btn-sm">Editar</a>
                    </td>
                </tr>
                <%
                    }
                }
                %>
            </tbody>
        </table>
	</div>
</div>
</div>
</body>
</html>