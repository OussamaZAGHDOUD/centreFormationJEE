<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
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
	<br></br>
	<br></br>
	<div class="container">
		<input type="text" hidden="active" form="h" name="idEtudiant"
			value="${e.getMatricule()}">
		<table class="table table-striped">
			<tr>
				<th>Matricule</th>
				<th>Numéro Tel</th>
				<th>Nom</th>
				<th>Adresse</th>
			</tr>
			<tr>
				<td>${e.getMatricule()}</td>
				<td>${e.getNumTel()}</td>
				<td>${e.getNom()}</td>
				<td>${e.getAdresse()}</td>
				
				<td><select class="form-control form-control-lg" <%if(request.getParameter("choixFormation")!=null){ %>disabled="disabled"<%} %>
					required="required" form="h" name="choixFormation" 
					onchange="this.form.submit()">
						<option >
							<%	if (request.getParameter("choixFormation") != null) {	%> ${nomFor} <%	} else {	%>Veuillez Choisir une formation<%	}	%>
						</option>
						<c:forEach items="${ifo.tousFormation()}" var="f">
							<option value="${f.getIdFormation() }">Formation :
								${f.getNomFormation()}</option>
						</c:forEach>
				</select></td>
				<td><select class="form-control form-control-lg"
					required="required" name="choixSession" form="h">
						<c:forEach items="${mmodel.getListe()}" var="m">
							<option value="${m.getIdSession()}">Début : ${m.getDateDebut()} - ${m.getNomEnseignant()}</option>
						</c:forEach>
				</select></td>
	










				<td><div class="pull-right">
						<form action="Affecter.do" id="h">
							<input class="btn btn-primary" type="submit" value="Affecter" />
						</form>
						<input type="hidden" value="${idFormation}" form="h">

					</div></td>
			</tr>
		</table>
	</div>
</body>
<footer class="footer">
	<%@include file="Footer.jsp"%>
</footer>
</html>