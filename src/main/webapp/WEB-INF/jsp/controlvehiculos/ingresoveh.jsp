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
<script type="text/javascript">
$.fn.pageMe = function(opts){
    var $this = this,
        defaults = {
            perPage: 7,
            showPrevNext: false,
            hidePageNumbers: false
        },
        settings = $.extend(defaults, opts);
    
    var listElement = $this;
    var perPage = settings.perPage; 
    var children = listElement.children();
    var pager = $('.pager');
    
    if (typeof settings.childSelector!="undefined") {
        children = listElement.find(settings.childSelector);
    }
    
    if (typeof settings.pagerSelector!="undefined") {
        pager = $(settings.pagerSelector);
    }
    
    var numItems = children.size();
    var numPages = Math.ceil(numItems/perPage);

    pager.data("curr",0);
    
    if (settings.showPrevNext){
        $('<li><a href="#" class="prev_link">«</a></li>').appendTo(pager);
    }
    
    var curr = 0;
    while(numPages > curr && (settings.hidePageNumbers==false)){
        $('<li><a href="#" class="page_link">'+(curr+1)+'</a></li>').appendTo(pager);
        curr++;
    }
    
    if (settings.showPrevNext){
        $('<li><a href="#" class="next_link">»</a></li>').appendTo(pager);
    }
    
    pager.find('.page_link:first').addClass('active');
    pager.find('.prev_link').hide();
    if (numPages<=1) {
        pager.find('.next_link').hide();
    }
      pager.children().eq(1).addClass("active");
    
    children.hide();
    children.slice(0, perPage).show();
    
    pager.find('li .page_link').click(function(){
        var clickedPage = $(this).html().valueOf()-1;
        goTo(clickedPage,perPage);
        return false;
    });
    pager.find('li .prev_link').click(function(){
        previous();
        return false;
    });
    pager.find('li .next_link').click(function(){
        next();
        return false;
    });
    
    function previous(){
        var goToPage = parseInt(pager.data("curr")) - 1;
        goTo(goToPage);
    }
     
    function next(){
        goToPage = parseInt(pager.data("curr")) + 1;
        goTo(goToPage);
    }
    
    function goTo(page){
        var startAt = page * perPage,
            endOn = startAt + perPage;
        
        children.css('display','none').slice(startAt, endOn).show();
        
        if (page>=1) {
            pager.find('.prev_link').show();
        }
        else {
            pager.find('.prev_link').hide();
        }
        
        if (page<(numPages-1)) {
            pager.find('.next_link').show();
        }
        else {
            pager.find('.next_link').hide();
        }
        
        pager.data("curr",page);
      	pager.children().removeClass("active");
        pager.children().eq(page+1).addClass("active");
    
    }
};

function myFunction() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("mitbody");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[4];
    if (td) {
      txtValue = td.textContent || td.innerText;
      console.log('txt value:' + txtValue);
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}


$(document).ready(function(){  
  $('#mitbody').pageMe({pagerSelector:'#myPager',showPrevNext:true,hidePageNumbers:false,perPage:4});   
});
</script>
<style type="text/css">
.table-responsive {height:180px;}

* {
  box-sizing: border-box;
}

#myInput {
  background-image: url('/css/searchicon.png');
  background-position: 10px 10px;
  background-repeat: no-repeat;
  width: 100%;
  font-size: 16px;
  padding: 12px 20px 12px 40px;
  border: 1px solid #ddd;
  margin-bottom: 12px;
}

</style>
</head>
<body>
<div style="float:right;width:80%;padding: 10px 0px 0px 10px;" id="app">

<f:form method="post" action="ingresarveh" modelAttribute="ingresovehiculo" >
<div><h2>INGRESO DE VEHICULO A TALLER</h2></div>
<div id="msg"></div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="fecha">FECHA</label>
      <v-date-picker class="input form-control" v-model="selectedDate" bootstrap-styling="true"></v-date-picker> 
	  <input type="hidden" id="fechaing" name="fechaing" v-model="selectedDate"/>    
    </div>
 	<div class="form-group col-md-6">
    	<label for="cliente">CLIENTE</label>
     		<f:select path="cliente.idcliente" class="form-control" id="cliente">
  				<f:option value="-1">Seleccione Cliente</f:option>
  				<c:forEach items="${clientes}" var="item" varStatus="cliente">
  					<f:option value="${item.idcliente}">${item.nombrecliente}</f:option>	
  				</c:forEach>
			</f:select>
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
     	<select class="form-control" id="modelo" name="modelo" v-model="selected">
  			<option value="-1"> Seleccione modelo</option>
  		<option v-for="modelo in modelos" :key="modelo.idmodelo" :value="modelo.idmodelo">{{ modelo.nombremodelo }}<option>
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
     	<f:select path="anio.idanio" class="form-control" >
  			<f:option value="-1">Seleccione Año</f:option>
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

<div style="float:right;width:80%;padding: 10px 0px 0px 10px;">
<div><h3>VEHICULOS INGRESADOS A TALLER</h3></div>
<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Buscar por placas.." title="Digite una placa..">
<div class="table-responsive">
<table class="table table-hover" id="lvehiculosingresados" >
  <thead>
    <tr class="header">
      <th scope="col">#</th>
      <th scope="col">FECHA INGRESO</th>
      <th scope="col">MARCA</th>
      <th scope="col">MODELO</th>
      <th scope="col">PLACA</th>
      <th scope="col">CLIENTE</th>
      <th scope="col">RECIBIDO POR</th>
    </tr>
  </thead>
  <tbody id="mitbody"  >
  	<c:forEach items="${vehiculosingresados}" var="veh" >
    <tr>
      <td scope="row">1</td>
      <td>${veh.fechaingreso}</td>
      <td>${veh.modelo.marca.nombremarca}</td>
      <td>${veh.modelo.nombremodelo}</td>
      <td>${veh.placa}</td>
      <td>${veh.cliente.nombrecliente}</td>
      <td>${veh.asesor.persona.primernombre}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>
	<div class="col-md-12 text-center">
    	<ul class="pagination pagination-lg pager" id="myPager"></ul>
    </div>
</div>
</body>
<script type="module" src="<c:url value="/resources/js/marcavehiculoanidado.js"/>"></script> 
</html>