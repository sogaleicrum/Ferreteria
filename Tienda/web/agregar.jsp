<%-- 
    Document   : agregar
    Created on : 02-27-2019, 08:39:26 AM
    Author     : jason.rodriguezusam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <form action="Control" method="post">
                <br>

                <div class="row">
                    <div class="col-md-5 "   ><img src="image/Ferreteria2.png" width="100%" height="225"></div>
                    <div class="col-md-7 "   ></div>
                </div>
                <div class="row">
                    <div class="col-md-10 "   ></div>
                    <div class="col-md-2">
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="inputGroup-sizing-default">Id</span>
                            </div>
                            <input type="text" class="form-control" aria-label="Default" value="<c:out value="${ret.idProducto}"/>" name="id" readonly="" aria-describedby="inputGroup-sizing-default">
                        </div>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-md-6"> 
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="inputGroup-sizing-default">Nombre</span>
                            </div>
                            <input type="text" class="form-control" aria-label="Default"value="<c:out value="${ret.nombre}"/>" name="nombre" aria-describedby="inputGroup-sizing-default">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <label class="input-group-text" for="inputGroupSelect01">Ubicacion</label>
                            </div>
                            <select name="idUbicacion" class="custom-select"  id="inputGroupSelect01">

                                <c:forEach items="${listaUbicacion}" var="u">
                                    <c:choose>
                                        <c:when test="${u.idUbicacion == ret.idUbicacion}">
                                            <option value="<c:out value="${u.idUbicacion}"/>" selected="" ><c:out value="${u.descripcion}"/></option>
                                        </c:when>

                                        <c:otherwise>
                                            <option value="<c:out value="${u.idUbicacion}"/>"><c:out value="${u.descripcion}"/></option>
                                        </c:otherwise>

                                    </c:choose>
                                   
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-md-6">
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <label class="input-group-text" for="inputGroupSelect01">Categoria</label>
                            </div>
                            <select name="idCategoria" class="custom-select" id="inputGroupSelect01">

                                <c:forEach items="${listaCategoria}" var="c">
                                    <c:choose>
                                        <c:when test="${c.idCategoria == ret.idCategoria}">
                                            <option value="<c:out value="${c.idCategoria}"/>" selected=""><c:out value="${c.nombre}"/></option>
                                        </c:when>
                                        <c:otherwise>

                                            <option value="<c:out value="${c.idCategoria}"/>"><c:out value="${c.nombre}"/></option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="inputGroup-sizing-default">Cantidad</span>
                            </div>
                            <input type="text" class="form-control" value="<c:out value="${ret.cantidad}"/>"name="cantidad"aria-label="Default"  aria-describedby="inputGroup-sizing-default">
                        </div>
                    </div>
                    <div class="col-md-2"><input type="submit" name="g" value="Guardar" class="btn-block btn btn-outline-info"></div>
                </div>

            </form>
        </div>
    </body>
</html>
