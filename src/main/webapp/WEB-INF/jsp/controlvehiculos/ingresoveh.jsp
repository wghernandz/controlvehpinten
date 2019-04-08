<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="../generales/header.jsp" %>
<%@ include file="../generales/menuprincipal.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Insert title here</title>
</head>
<body>
<div id="miconteiner2" style="padding: 25px 100px 100px 250px;">
<form>
  <div class="form-group">
    <label for="fecha">FECHA</label>
            <input type='text' class="form-control" id='datetimepicker4' />
        <script type="text/javascript">
        var default_date=  new Date();
            $(function () {
                $('#datetimepicker4').datetimepicker({
                	    autoclose: true,
                	    format: 'dd-mm-yyyy hh:mm:ss',
                	    minView: "month",
                	    useCurrent:false, // default this is set to true
                	    defaultDate: default_date
                });
            });
        </script>
 </div>
 <div class="form-group">
    <label for="cliente">CLIENTE</label>
     	<select class="form-control" id="cliente">
  			<option selected>Open this select menu</option>
  			<option value="1">One</option>
  			<option value="2">Two</option>
  			<option value="3">Three</option>
		</select>
  </div>
  
   <div class="form-group">
    <label for="marca">MARCA</label>
     	<select class="form-control" id="marca">
  				<option selected>Seleccione marca</option>
  			<c:forEach items="${marcas}" var="item" varStatus="marca">
  			 	<option value="${item.idmarca}">${item.nombremarca}</option> 
  			</c:forEach>
		</select>
  </div>
  
    <div class="form-group">
    <label for="modelo">MODELO</label>
     	<select class="form-control" id="modelo">
  			<option selected>Open this select menu</option>
  			<option value="1">One</option>
  			<option value="2">Two</option>
  			<option value="3">Three</option>
		</select>
  </div>
  
   <div class="form-group">
    <label for="placa">PLACA</label>
     	<input id="placa" class="form-control"></input>
  </div>
  
  <div class="form-group">
  <label for="anio">AÑO VEHICULO</label>
     	<select class="form-control" id="anio">
  			<option selected>Open this select menu</option>
  			<option value="1">One</option>
  			<option value="2">Two</option>
  			<option value="3">Three</option>
		</select>
  </div>
  
   <div class="form-group">
    <label for="comentario">COMENTARIOS</label>
     	<input id="comentario" class="form-control"></input>
  </div>

  <button type="submit" class="btn btn-primary">INGRESAR</button>
</form>
</div>
</body>
</html>