<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Etudiant</title>


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
			<div class="panel-heading">Modification d'un etudiant</div>
			<div class="panel-body">
				<form action="MiseAjourEtudiant.do" method="post">
				
				<div class="form-group">
				
				<input type="hidden" name="matricule" value="${e.getMatricule()}" />
				<span></span>
				</div>
							
				<div class="form-group">
				<label class="control-label">Nom</label>
				<input type="text" name="nom" value="${e.getNom() }" required="required" class="form-control"/>
				<span></span>
				</div>
				
				<div class="form-group">
				<label class="control-label">Numéro de téléphone</label>
				<input type="text" name="numTel" value="${e.getNumTel()}" class="form-control"/>
				<span></span>
				</div>
				
				
				
				<div class="form-group">
				<label class="control-label">Email</label>
				<input type="text" name="email" value="${e.getEmail() }" class="form-control"/>
				<span></span>
				</div>
				<div class="form-group">
				<label class="control-label">Adresse</label>
				<input type="text" name="adresse" value="${e.getAdresse() }" class="form-control"/>
				<span></span>
				</div>
				<button type="submit" class="btn btn-primary pull-right">Modifier</button>
				</form>


			</div>
		</div>
	</div>
</body>
<footer class="footer">
	<%@include file="Footer.jsp"%>
</footer>
</html>