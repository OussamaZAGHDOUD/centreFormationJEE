<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>


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
	<div class="container col-md-8 col-md-offset-2 col-xs-12">
		<div class="panel panel-primary">
			<div class="panel-heading">Modifier une session de formation</div>
			<div class="panel-body">
				<form action="ConfirmationModificationSession.do" method="post">
				
				<div class="form-group">
				<label class="control-label" hidden="hidden">ID Session</label>
				<input type="hidden"  name="idSession" value="${m.getIdSession() }" class="form-control"/>
				<span></span>
				</div>
				<div class="form-group">
				<label class="control-label">Nom de la formation</label>
				<input class="form-control" type="text" placeholder="${im.getSessionNom(m.getIdSession())}" readonly>
				<input type="hidden" name="idFormation" value="${m.getFormationId()}" />
				
				<span></span>
				</div>
				
					<div class="form-group">
				<label class="control-label">Nombre des jours</label>
			<input class="form-control" type="text" placeholder="${im.getSessionNbrJour(m.getIdSession()) }" readonly>
				<span></span>
				</div>
				
				<div class="form-group">
				<label class="control-label">Nom enseignant</label>
				<input type="text" name="nomEns" value="${m.getNomEnseignant() }" class="form-control"/>
				<span></span>
				</div>
				
				<div class="form-group">
				<label class="control-label">Date de début</label>
				<input type="date" name="dateD" value="${m.getDateDebut() }" class="form-control"/>
				<span></span>
				</div>
			
				
				<div class="form-group">
				<label class="control-label">Nombre des séances par jour</label>
				<input type="number" name="nbrseance" value="${m.getNmbrSeanceParJour() }" class="form-control"/>
				<span></span>
				</div>
				
				<button type="submit" class="btn btn-primary">Editer</button>
				</form>


			</div>
		</div>
	</div>
</body>
<footer class="footer">
	<%@include file="Footer.jsp"%>
</footer>
</html>