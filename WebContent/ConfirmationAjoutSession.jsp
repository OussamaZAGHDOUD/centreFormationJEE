<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Matiere</title>


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
<br><br>
	<div class="container col-md-8 col-md-offset-2 col-xs-12">
		<div class="panel panel-primary">
			<div class="panel-heading"><h3>Confirmation</h3></div>
			<br><br>
			<div class="panel-body">
			
			
				<div class="form-group">
				<label>Nom de la formation :</label>
				<label >${nomformation}</label>
				</div>
				
				<div class="form-group">
				<label>Nom de l'enseignant:</label>
				<label >${m.getNomEnseignant() }</label>
				</div>
				
				<div class="form-group">
				<label>Date de d�but :</label>
				<label >${m.getDateDebut() }</label>
				</div>
				
				<div class="form-group">
				<label>Date de fin :</label>
				<label >${m.getDateDebut().plusDays(im.getSessionNbrJour(m.getIdSession())) }</label>
				</div>
				
				<div class="form-group">
				<label>Nombre des s�ances par jour :</label>
				<label >${m.getNmbrSeanceParJour() }</label>
				</div>
				

			</div>
		</div>
	</div>
</body>
<footer class="footer">
	<%@include file="Footer.jsp"%>
</footer>
</html>