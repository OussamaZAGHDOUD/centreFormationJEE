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
	<br></br>
	<br></br>
        
<div class="container">

				<label class="control-label">Matière : ${nomSession} &emsp;&emsp;&emsp;&emsp;  Enseignant :${nomEns} </label> 
				<div class="pull-right">
				
<a <c:choose>
    <c:when test="${ statut=='Terminée'}"> disabled="disabled" </c:when>  
	</c:choose>

href="AffecterDesEtudiantsParGroup.do?id=${id}" 
 class="btn btn-primary   mr-1" >
Affecter des étudiants
</a>
<a <c:choose>
    <c:when test="${statut=='Terminée'}"> disabled="disabled" </c:when>  
	</c:choose>
 href="genererFeuille.do?id=${id}" class="btn btn-primary ">Generer feuille de presence</a>
</div>

				<br></br>

<table class="table table-striped">
<tr>
<th>Nom de l'étudiant </th><th>Numéro de téléphone</th><th>Adresse</th>
</tr>
<c:forEach items="${liste}" var="e">

<tr>
<td>${e.getNom()}</td>
<td>${e.getNumTel()}</td>
<td>${e.getAdresse()}</td>
</tr>
</c:forEach>
</table>
</div>
</body>
<footer class="footer">
	<%@include file="Footer.jsp"%>
</footer>
</html>