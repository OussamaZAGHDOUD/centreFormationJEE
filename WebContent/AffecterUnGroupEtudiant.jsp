<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>  
<head>
<meta charset="ISO 8859-1"  name="viewport" content="width=device-width, initial-scale=1">
<title>Gestion centre</title>

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
	<br></br>
	<br></br>

<div class="container">


   <br><br>     
<table class="table table-striped">
<tr>
<th>Matricule</th><th>Numéro Tel</th><th>Nom</th><th>Adresse</th><th>Email</th><th></th><th></th><th>Nombre totale : ${liste.size()}</th>
</tr>
<c:forEach items="${liste}" var="e">

<tr>
<td>${e.getMatricule()}</td>
<td>${e.getNumTel()}</td>
<td>${e.getNom()}</td>
<td>${e.getAdresse()}</td>
<td>${e.getEmail()}</td>
<td></td>
<td></td>

<td><a class="btn btn-primary pull-right" href="Affecter.do?idEtudiant=${e.getMatricule() }&choixFormation=${choixFormation}&idSession=${idSession}">Affecter <i class="fa fa-plus-circle" aria-hidden="true"></i></a></td>
</tr>
</c:forEach>
</table>
</div>

</body>
<footer class="footer">
	<%@include file="Footer.jsp"%>
</footer>
</html>