<%-- 
    Document   : inicio
    Created on : 02-25-2019, 01:49:15 PM
    Author     : jason.rodriguezusam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Tienda</title>
    </head>
    <body>
        <div class="container">
            <br>
            <div class="row">
                <div class="col-4"><img src="image/Ferreteria.png" class="btn-block "></div>
                <div class="col-8 "><h1 class="alert alert-secondary h-100 ">INVENTARIO</h1></div>
            </div>
            <br>
            <table class="table border border-secondary">
                <thead class="thead-light">
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Cantidad</th>
                        <th scope="col">Categoria</th>
                        <th scope="col">Ubicacion</th>
                        <th scope="col">Accion</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${Producto}" var="p">
                    <tr>
                        <td><c:out value="${p.id}"/></td>
                    <td><c:out value="${p.nombre}"/></td>
                    <td><c:out value="${p.cantidad}"/></td>
                    <td><c:out value="${p.categoria}"/></td>
                    <td><c:out value="${p.ubicacion}"/></td>
                    <td>
                        <a class="btn btn-block btn-outline-info" href="Control?action=actualizar&id=<c:out value="${p.id}"/>">Actualizar</a>
                        <a class="btn btn-block btn-outline-danger" href="Control?action=eliminar&id=<c:out value="${p.id}"/>">Eliminar</a>
                    </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="row">
                <div class="col-md-4"><a href="Control?action=save" class="btn btn-primary">Agregar</button></a>
                <div class="col-md-8"></div>
            </div>
            

        </div>
    </body>
</html>
