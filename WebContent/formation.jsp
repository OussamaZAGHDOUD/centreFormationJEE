<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion centre</title>


<style type="text/css">
a[disabled="disabled"] {
	pointer-events: none;
}
</style>

<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,600,700,900"
	rel="stylesheet">
<!--
			CSS
			============================================= -->
<link rel="stylesheet" href="PageHome/css/font-awesome.min">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="PageHome/css/bootstrap.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

	<%@include file="header.jsp"%>
</head>
<body>
		<%if(request.getAttribute("msg")!=null){ %><div class="alert alert-danger center" >${msg}</div>	<br><br><%} %>
	
        
<div class="container">

<div>
<form class="form-inline"  action="formation.do">
          <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="nomFormation">
          <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Chercher <i class="fa fa-search" aria-hidden="true"></i></button>
          <a class="btn btn-primary pull-right"  style="margin-left: 600px;" href="ajouterFormation.do">Ajouter une formation <i class="fa fa-plus-circle" aria-hidden="true"></i></a>
</form>


</div>

<br><br>
<!-- <form action="https://google.com">
    <input type="submit" value="Go to Google" />
        </form> -->
     
        
<table class="table table-striped">
<tr>
<th>Nom de la formation</th><th>Nombre des jours</th><th></th><th>Nombre totale : ${liste.getFormations().size()}</th>
</tr>
<c:forEach items="${liste.getFormations()}" var="m">

<tr>
<td>${m.getNomFormation()}</td>
<td>${m.getNbrJour()}</td>
<td><a class="btn btn-danger" onclick ="return confirm('Etes vous sure ? ')" href="SupprimerFormation.do?id=${m.getIdFormation() }">Supprimer <i class="fa fa-trash-o" aria-hidden="true"></a></td>
<td><a class="btn btn-warning" href="EditFormation.do?id=${m.getIdFormation() }">Modifier <i class="fa fa-pencil" aria-hidden="true"></i></a></td>
</tr>
</c:forEach>
</table>
</div>





</body>
<footer class="footer">
	<%@include file="Footer.jsp"%>
</footer>
</html>