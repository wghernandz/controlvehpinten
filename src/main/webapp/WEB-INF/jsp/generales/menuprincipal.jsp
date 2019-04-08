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
<link href="<c:url value="/resources/css/menuprincipal.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/menuprincipal.js" />"></script>
</head>
<body>
<c:url value="/ingresovehiculo" var="urlIngresoVehiculo" />
<div class="nav-side-menu">
    <div class="brand">SERVIPINTEN</div>
    <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>
  
        <div class="menu-list">
  
            <ul id="menu-content" class="menu-content collapse out">
                <li>
                  <a href="#">
                  <i class="fas fa-tachometer-alt fa-lg"></i> Dashboard
                  </a>
                </li>

                <li  data-toggle="collapse" data-target="#products" class="collapsed active">
                  <a href="#"><i class="fab fa-studiovinari fa-lg"></i>CONTROL VEHICULOS<span class="arrow"></span></a>
                </li>
                <ul class="sub-menu collapse" id="products">
                    <li class="active"><a href="${urlIngresoVehiculo}">Ingreso nuevo vehiculo</a></li>
                    <li><a href="#">Estados de vehiculo</a></li>
                </ul>

                <li data-toggle="collapse" data-target="#service" class="collapsed">
                  <a href="#"><i class="fab fa-fort-awesome-alt fa-lg"></i>CATALOGOS<span class="arrow"></span></a>
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