<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>  
<head>
<meta charset="ISO 8859-1"  name="viewport" content="width=device-width, initial-scale=1">
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
	<br></br>
	<%if(request.getAttribute("msg")!=null){ %><div class="alert alert-danger center" >${msg}</div><%} %>
	<br></br>

<div class="container">

     
   <br><br>     
<table class="table table-striped">
<tr>
<!-- <th>Matricule</th> -->
<th>Nom</th><th>Email</th><th>Nom formation</th><th>Nom enseignant</th><th>Date début</th>
</tr>
<c:forEach items="${liste}" var="e">

	<c:forEach items="${e.value}" var="i">
	
		<tr>
		<td>${ie.getEtudiant(e.key).getNom()}</td>
		<td>${ie.getEtudiant(e.key).getEmail()}</td>
		
			<td>${im.getSessionNom(i)}</td>		
			<td>${im.getSession(i).getNomEnseignant()}</td>
			<td>${im.getSession(i).getDateDebut()}</td>
			
			<td><a class="btn btn-primary" href="AffecterE.do?idEtudiant=${ie.getEtudiant(e.key).getMatricule()}&idSession=${im.getSession(i).getIdSession()}"><i class="fa fa-share" aria-hidden="true"></i>
 Affecter </a></td>
		</tr>
	</c:forEach>
<%-- <td><a class ="btn btn-danger" onclick ="return confirm('Etes vous sure ? ')" href="Supprimer.do?id=${e.getMatricule() }">Supprimer <i class="fa fa-trash-o" aria-hidden="true"></i></a></td>
<td><a class="btn btn-warning" href="Edit.do?id=${e.getMatricule() }">Modifier <i class="fa fa-pencil" aria-hidden="true"></i></a></td>
<td><a class="btn btn-primary" href="Affecter.do?idEtudiant=${e.getMatricule() }"><i class="fa fa-share" aria-hidden="true"></i>
 Affecter à une formation</a></td> --%>
 
</c:forEach>
</table>
</div>

</body>
<footer class="footer">
	<%@include file="Footer.jsp"%>
</footer>
</html>