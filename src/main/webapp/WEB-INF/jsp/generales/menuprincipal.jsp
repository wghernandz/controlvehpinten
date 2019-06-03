<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="../generales/header.jsp" %>
    <c:set var="appPath" value="${pageContext.request.contextPath}"/>
<%
	String contextPath = request.getContextPath();	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<c:url value="https://unpkg.com/v-calendar/lib/v-calendar.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/menuprincipal.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/menuprincipal.js" />"></script>
</head>
<body>
<c:url value="/mttovehiculos/ingresovehiculo" var="urlIngresoVehiculo" />
<c:url value="/flujovehiculo/estado" var="urlFlujoVehiculo"/>
<div class="nav-side-menu" style="float:left;width:20%;">
    <div class="brand">SERVIPINTEN</div>
    <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>
  
        <div class="menu-list">
  
            <ul id="menu-content" class="menu-content collapse out">
                <li  data-toggle="collapse" data-target="#products" class="collapsed active">
                  <a href="#"><i class="fab fa-pagelines fa-lg"></i>CONTROL VEHICULOS<span class="arrow"></span></a>
                </li>
                <ul class="sub-menu collapse" id="products">
                    <li class="active"><a href="${urlIngresoVehiculo}">Ingreso nuevo vehiculo</a></li>
                    <li><a href="${urlFlujoVehiculo}">Flujo de Vehiculos</a></li>
                </ul>

                <li data-toggle="collapse" data-target="#service" class="collapsed">
                  <a href="#"><i class="fab fa-pagelines fa-lg"></i>CATALOGOS<span class="arrow"></span></a>
                </li>  
                <ul class="sub-menu collapse" id="service">
                  <li>Vehiculos</li>
                  <li>Cliente</li>
                </ul>


                <li data-toggle="collapse" data-target="#new" class="collapsed">
                  <a href="#"><i class="fab fa-pagelines fa-lg"></i> New <span class="arrow"></span></a>
                </li>
                <ul class="sub-menu collapse" id="new">
                  <li>New New 1</li>
                  <li>New New 2</li>
                  <li>New New 3</li>
                </ul>


                 <li>
                  <a href="#">
                  <i class="fas fa-user-tie fa-lg"></i> Profile
                  </a>
                  </li>

                 <li>
                  <a href="#">
                  <i class="fa fa-users fa-lg"></i> Usuarios
                  </a>
                </li>
            </ul>
     </div>
</div>

</html>