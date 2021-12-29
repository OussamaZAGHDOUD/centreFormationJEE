<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Matiere</title>

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
	<br></br><br></br>
	<div class="container col-md-8 col-md-offset-2 col-xs-12">
		<div class="panel panel-primary">
			<div class="panel-heading">Modifier une formation</div>
			<div class="panel-body">
				<form action="ConfirmationModificationFormation.do" method="post">
				<div class="form-group">
				<label class="control-label">Nom de la formation</label>
				<input type="text" name="nomFormation" value="${f.getNomFormation() }" required="required" class="form-control"/>
				<input type="hidden" name="idFormation" value="${f.getIdFormation() }"/>
				<span></span>
				</div>

					<div class="form-group">
				<label class="control-label">Nombre des jours</label>
				<input type="number" name="nbrJour" value="${f.getNbrJour() }" class="form-control"/>
				<span></span>
				</div>
				
				<button type="submit" class="btn btn-primary">Modifier</button>
				</form>


			</div>
		</div>
	</div>
</body>
<footer class="footer">
	<%@include file="Footer.jsp"%>
</footer>
</html>