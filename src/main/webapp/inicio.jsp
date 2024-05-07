<%@page import="org.apache.jasper.tagplugins.jstl.core.Import" %>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.datatables.net/v/1.10.20/css/jquery.datatables.min.css">
<title>INICIO</title>
</head>
<body>
	<div class="container">
        <div class="">
            <h1>Gestionar Ventas</h1>
            <div>
                <h1>Bienvenido <% out.print(session.getAttribute("correo")); %></h1>
            </div>
        </div>
        <div>

            <table id="miTabla" class="table table-striped table-hover" style="width: 100%">
                <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
                <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
        
                <script type="text/javascript">
                    $(document).ready(function(){
                        $('#miTabla').dataTable({
                            language:{
                                "url":"//cdn.datatables.net/plug-ins/1.10.15/i18n/Spanish.json"
                            }
                        });
                    });
                </script>
                
                <thead class="thead-dark">
                    <tr>
                        <th>ID</th>
                        <th>Codigo</th>
                        <th>Nombre</th>
                        <th>Precio</th>
                        <th>Stock</th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="p" items="${data}">
                        <tr>
                            <td>${p.id}</td>
                            <td>${p.cod}</td>
                            <td>${p.nombre}</td>
                            <td>${p.nivel}</td>
                            <td>${p.docente}</td>
                            <td><a href="ServletProducto?type=info&id=${p.id}">
                                <img src="img/eye-fill.svg"/>
                            </a></td>
                            <td><a href="ServletProducto?type=eliminar&id=${p.id}">
                                <img src="img/trash3-fill.svg"/>
                            </a></td>
                            <td><a href="ServletProducto?type=infoEdit&id=${p.id}">
                                <img src="img/pencil-fill.svg"/>
                            </a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <table id="miTabla2" class="table table-striped table-hover" style="width: 100%">
                <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
                <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
        
                <script type="text/javascript">
                    $(document).ready(function(){
                        $('#miTabla2').dataTable({
                            language:{
                                "url":"//cdn.datatables.net/plug-ins/1.10.15/i18n/Spanish.json"
                            }
                        });
                    });
                </script>
                
                <thead class="thead-dark">
                    <tr>
                        <th>ID</th>
                        <th>Codigo</th>
                        <th>Nombre</th>
                        <th>Precio</th>
                        <th>Stock</th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="p" items="${data}">
                        <tr>
                            <td>${p.id}</td>
                            <td>${p.cod}</td>
                            <td>${p.nombre}</td>
                            <td>${p.nivel}</td>
                            <td>${p.docente}</td>
                            <td><a href="ServletVenta?type=info&id=${p.id}">
                                <img src="img/eye-fill.svg"/>
                            </a></td>
                            <td><a href="ServletVenta?type=eliminar&id=${p.id}">
                                <img src="img/trash3-fill.svg"/>
                            </a></td>
                            <td><a href="ServletVenta?type=infoEdit&id=${p.id}">
                                <img src="img/pencil-fill.svg"/>
                            </a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <a href="ServletProducto?type=nuevo" class="btn btn-primary">Agregar Producto</a>
        <a href="ServletVenta?type=nuevo" class="btn btn-primary">Agregar Venta</a>
    </div>
</body>
</html>