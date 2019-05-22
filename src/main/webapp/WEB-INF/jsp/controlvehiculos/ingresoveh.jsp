<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="../generales/header.jsp" %>
<%@ include file="../generales/menuprincipal.jsp" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://cdn.jsdelivr.net/npm/vue"></script>
<script src="https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/vue-resource/1.4.0/vue-resource.min.js"></script>
<script src="https://unpkg.com/v-calendar"></script>
<title>Insert title here</title>
</head>
<body>
<div style="padding: 25px 100px 5px 250px;" id="app">

<f:form method="post" action="ingresarveh" modelAttribute="ingresovehiculo" >
<div><h2>INGRESO DE VEHICULO A TALLER</h2></div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="fecha">FECHA</label>
      <v-date-picker class="input form-control" v-model="selectedDate" bootstrap-styling="true"></v-date-picker> 
    </div>
 	<div class="form-group col-md-6">
    	<label for="cliente">CLIENTE</label>
     		<select class="form-control" id="cliente">
  				<option selected>Seleccione Cliente</option>
  				<c:forEach items="${clientes}" var="item" varStatus="cliente">
  					<option value="${item.idcliente}">${item.nombrecliente}</option>	
  				</c:forEach>
			</select>
  	</div>
  </div>
  <div class="form-row">
   <div  class="form-group col-md-6">
    <label for="marca">MARCA</label>
     	<select class="form-control" id="marca" v-model="marcaSeleccionada" @change="mounted" >
  				<option selected>Seleccione marca</option>
  			<c:forEach items="${marcas}" var="item" varStatus="marca">
  			 	<option value="${item.idmarca}">${item.nombremarca}</option> 
  			</c:forEach>
		<select>
  </div>
  
   <div class="form-group col-md-6" >
    <label for="modelo">MODELO</label>
     	<select path="modelo" class="form-control" id="modelo" v-model="selected">
  			<option> Seleccione modelo</option>
  		<option v-for="modelo in modelos" :key="modelo.id" :value="modelo.id">{{ modelo.nombremodelo }}</option>
		</select>
  </div>
  </div>

  <div class="form-row">	
   <div class="form-group col-md-6">
    <label for="placa">PLACA</label>
     	<f:input path="placa" id="placa" class="form-control"></f:input>
  </div>
  
  <div class="form-group col-md-6">
  <f:label path="anio" for="anio">AÑO VEHICULO</f:label>
     	<f:select path="anio" class="form-control" >
  			<f:option value="">Seleccione Año</f:option>
  			<c:forEach items="${anios}" var="item" >
  				<f:option value="${item.idanio}">${item.anio}</f:option>
  			</c:forEach>
		</f:select>
  </div>
  </div>
  
   <div class="form-group">
    <label for="comentario">COMENTARIOS</label>
     	<input id="comentario" class="form-control"></input>
  </div>

  <button type="submit" class="btn btn-primary" >INGRESAR</button>
</f:form>
</div>

<div style="padding: 25px 100px 100px 250px;">
<div><h3>ULTIMOS VEHICULOS INGRESADOS A TALLER</h3></div>
<div>
<table class="table table-hover" >
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">First</th>
      <th scope="col">Last</th>
      <th scope="col">Handle</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td colspan="2">Larry the Bird</td>
      <td>@twitter</td>
    </tr>
  </tbody>
</table>
</div>
</div>
</body>
<script type="module" src="<c:url value="/resources/js/marcavehiculoanidado.js" />"></script> 
</html>