<%@page import="java.util.List"%>
<%@page import="modelo.Venta"%>
<% Venta Venta = (Venta)request.getAttribute("venta"); %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Registro de Venta</title>
</head>
<body>
<div class="container">
<br>
<div class="row">
	<div class="col-lg-4">
		<h3>Gestionar Ventas</h3>
		<form action="ServletVenta" method="post">
			<div class="form-group">
				<label>Codigo de Venta</label>
				<input class="form-control" type="text" name="txtCodVenta">
			</div><br>
            <div class="form-group">
				<label>Dni del cliente</label>
				<input class="form-control" type="text" name="txtDniCli">
			</div><br>
			<div class="form-group">
				<label>producto</label>
				<input class="form-control" type="text" name="txtProd">
			</div><br>
            <div class="form-group">
				<label>cantidad</label>
				<input class="form-control" type="number" name="txtCant">
			</div><br>
            <div class="form-group">
				<label>Total</label>
				<input class="form-control" type="number" name="txtTotal">
			</div><br>
            <div class="form-group">
				<label>Metodo de pago</label>
				<input class="form-control" type="text" name="txtMetPago">
			</div><br>
		
			<input type="submit" class="btn btn-primary" value="Registrar">
			<a href="ServletVenta?type=listar" class="btn btn-primary">Regresar</a>
		</form>
        <h3>Ventas registrados</h3>
        <table class="table table-bordered table-hover responsive nowrap">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Codigo de venta</th>
                    <th>DNI</th>
                    <th>codVendedor</th>
                    <th>Producto</th>
                    <th>Fecha de compra</th>
                    <th>Metodo de venta</th>
                    <th>Cantidad</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody>
                <%
                List<Venta> listarVenta = (List<Venta>) request.getAttribute("dataVenta");
                if(listarVenta != null){
                    for(Venta item: listarVenta){	
                
                %>
                <tr>
                    <td><%=item.getIdVenta() %></td>
                    <td><%=item.getCodVenta() %></td>
                    <td><%=item.getDniCliente() %></td>
                    <td><%=item.getCodVendedor() %></td>
                    <td><%=item.getProducto() %></td>
                    <td><%=item.getFechaCompra() %></td>
                    <td><%=item.getMetodoPago() %></td>
                    <td><%=item.getCantProductos() %></td>
                    <td><%=item.getTotal() %></td>
                    <td>
                        
                <a href="ServletVenta?type=info&id=<%=item.getIdVenta() %>" class="btn btn-warning btn-sm">Informar</a>
    
                <a href="ServletVenta?type=eliminar&id=<%=item.getIdVenta() %>" class="btn btn-warning btn-sm">Eliminar</a>
    
                <a href="ServletVenta?type=infoEdit&id=<%=item.getIdVenta() %>" class="btn btn-warning btn-sm">Editar</a>
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