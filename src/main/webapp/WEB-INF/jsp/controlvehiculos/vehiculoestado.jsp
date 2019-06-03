<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../generales/header.jsp" %>
<%@ include file="../generales/menuprincipal.jsp" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="<c:url value="/resources/css/vehiculoestado.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/vehiculoestado-jq.js" />"></script>
</head>
<body>
	
<div class="container" style="float:right;width:80%">
  <h2>ESTADO DE VEHICULOS EN SERVIPINTEN</h2>
  <p>Clasificacion segun Estado</p>

  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#home">INGRESADOS</a></li>
    <li><a data-toggle="tab" href="#menu1">PRESUPUESTADOS</a></li>
    <li><a data-toggle="tab" href="#menu2">AUTORIZADOS</a></li>
    <li><a data-toggle="tab" href="#menu3">ENDEREZADO</a></li>
    <li><a data-toggle="tab" href="#menu3">PINTURA</a></li>
    <li><a data-toggle="tab" href="#menu3">MECANICA</a></li>
    <li><a data-toggle="tab" href="#menu3">A ENTREGAR</a></li>
    <li><a data-toggle="tab" href="#menu3">ENTREGADOS</a></li>
  </ul>

  <div class="tab-content">
    <div id="home" class="tab-pane fade in active">
      <h3>INGRESADOS</h3>
       <div class="container" >
        <div class="table-wrapper" style="width: 80%;float:left;">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-8"><h2>Vehiculos <b>Ingresados</b></h2></div>
                    <div class="col-sm-4">
                        <button type="button" class="btn btn-info add-new"><i class="fa fa-plus"></i> Add New</button>
                    </div>
                </div>
            </div>
            <table class="table table-bordered" style="font-size: 11px;width: auto;" >
                <thead>
                    <tr>
                        <th style="width:80px;">FECHA INGRESO</th>
                        <th><div style="width: 65px;">MARCA</div></th>
                        <th><div style="width: 65px;">MODELO</div></th>
                        <th><div style="width: 60px;">PLACA</div></th>
                        <th><div style="width: 200px;">CLIENTE</div></th>
                        <th><div style="width: 100px;">ASESOR</div></th>
                        <th><div style="width: 60px;">ESTADO</div></th>
                        <th><div style="width: 80px;">ACCIONES</div></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${listavehestado}" var="v">
                    <tr data-id="${v.idingresovehiculo}">
                        <td><div style="width: 80px;">${v.fechaingreso}</div></td>
                        <td><div style="width: 65px;">${v.modelo.marca.nombremarca}</div></td>
                        <td><div style="width: 65px;">${v.modelo.nombremodelo}</div></td>
                        <td><div style="width: 60px;">${v.placa}</div></td>
                        <td><div style="width: 200px;">${v.cliente.nombrecliente}</div></td>
                        <td><div style="width: 100px;">${v.asesor.persona.primernombre}</div></td>
                        <td><div style="width: 60px;">${v.estado.nombreestado}</div></td>
                        <td style="font-size:15px; width:15px;">
                        <div style="width: 80px;">
							<a class="add" title="Add" data-toggle="tooltip"><i class="material-icons">&#xE03B;</i></a>
                            <a class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                            <a class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
                        </div>
                        </td>
                    </tr>
                </c:forEach>     
                </tbody>
            </table>
        </div>
    </div>     
          
    </div>
    <div id="menu1" class="tab-pane fade">
      <h3></h3>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
    </div>
    <div id="menu2" class="tab-pane fade">
      <h3>PRESUPUESTADOS</h3>
      <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
    </div>
    <div id="menu3" class="tab-pane fade">
      <h3>Menu 3</h3>
      <p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
    </div>
  </div>
</div>

<div id="app" class="modal" style="width:515px;height:650px;" >
  <div class="modal-dialog">

    <!-- Modal content-->
    
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Modal Header</h4>
      </div>
      <div class="modal-body" style="height: 500px; width: 500px;">
        <f:form>
      	<div class="form-row">
      		<div class="form-group col-md-6">
      		<label for="fing">FECHA DE INGRESO</label>
	        	<v-date-picker class="input form-control" v-model="selectedDate"></v-date-picker>
	        
	        </div>
	        <div class="form-group col-md-6">
	        <label for="marca">MARCA</label>
	        	<select path="marca.idmarca" class="form-control" name="marca" id="marca" v-model="marcaSeleccionada" @changed="mounted">
	        	<option value="-1">Seleccione marca...</option>
	        	<c:forEach items="${marcas}" var="item">
	        		<option value="${item.idmarca}">${item.nombremarca}</option>
	        	</c:forEach>
	        	<select>
	        </div>
        </div>
        <div class="form-row">
        	<div class="form-group col-md-6">
        	<label for="modelo">MODELO</label>
        	<select class="form-control" name="modelo" id="modelo">
        		<option>seleccione modelo...</option>
        	</select>
        	</div>
        	<div class="form-group col-md-6">
        	<label for="placa">PLACA</label>
        	<input class="form-control" type="text" name="placa" id="placa" value=""></input>
        	</div>
        </div>
        <div class="form-row">
        	<div class="form-group col-md-6">
        		<label for="cliente">CLIENTE</label>
	        	<select class="form-control" name="cliente" id="cliente"></select>
	        </div>
	        <div class="form-group col-md-6">
    	    	<label for="asesor">ASESOR</label>
        		<select class="form-control" name="asesor" id="asesor"></select>
        	</div>
        </div>
        <div class="form-row">
        	<div class="form-group col-md-6">
         	<label for="estado">ESTADO</label>
	        <select class="form-control" name="estado" id="estado"></select>
	        </div>
	        <div class="form-group col-md-6">
	        <label for="amparo">AMPARO</label>
	        <input class="form-control" type="text" name="amparo" id="amparo"></input>
	        </div>
        </div>
        <div class="form-row">
        	<div class="form-group col-md-6">
        	<label for="siniestro">SINIESTRO</label>
	        <input class="form-control" type="text" name="siniestro" id="siniestro"></input>
	        </div>
	        <div class="form-group col-md-6">
	        <label for="fechapromesa">FECHA PROMESA</label>
	        <input class="form-control" type="text" name="fechapromesa" id="fechapromesa"></input>
	        </div>
        </div>
        <div>
        	<button type="button" class="btn btn-default" data-dismiss="modal">MODIFICAR</button>
        	<button type="button" class="btn btn-default" data-dismiss="modal">CERRAR</button>
        </div>
        </f:form>
      </div>
    </div>
  </div>
</div> 
</body>
<script type="module" src="<c:url value="/resources/js/marcavehiculoanidado.js"/>"></script>
<script type="module" src="<c:url value="/resources/js/vehiculoestado-jq.js"/>"></script>
</html>