<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="zxx" class="no-js">

<head>
<!-- Mobile Specific Meta -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicon-->
<link rel="shortcut icon" href="img/fav.png">
<!-- Author Meta -->
<meta name="author" content="colorlib">
<!-- Meta Description -->
<meta name="description" content="">
<!-- Meta Keyword -->
<meta name="keywords" content="">
<!-- meta character set -->
<meta charset="UTF-8">
<!-- Site Title -->
<title>S'inscrire</title>

<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,600,700,900"
	rel="stylesheet">
<!--
			CSS
			============================================= -->
<link rel="stylesheet" href="PageHome/css/linearicons.css">
<link rel="stylesheet" href="PageHome/css/font-awesome.min.css">
<link rel="stylesheet" href="PageHome/css/bootstrap.css">
<link rel="stylesheet" href="PageHome/css/magnific-popup.css">
<link rel="stylesheet" href="PageHome/css/nice-select.css">
<link rel="stylesheet" href="PageHome/css/animate.min.css">
<link rel="stylesheet" href="PageHome/css/owl.carousel.css">
<link rel="stylesheet" href="PageHome/css/main.css">
</head>

<body>

	<!-- Start Header Area -->
	<header id="header" class="dark">
		<div class="container main-menu">
			<div class="row align-items-center d-flex">
				<div id="logo">
					<a href="index.html"><img src="PageHome/img/logo2.png" alt="" title="" style="width: 80px;" /></a>
				</div>
				<nav id="nav-menu-container" class="ml-auto">
					<ul class="nav-menu white">
						<li><a href="home.visiteur">Home</a></li>
						<li><a>Bonjour <%
							if (session.getAttribute("nom") != null)
						%>${nom}</a></li>

					</ul>
				</nav>
			</div>
		</div>
	</header>
	<!-- End Header Area -->

	<!-- start banner Area -->
	<section class="banner-area relative" style="bottom: 100px;">
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white">Bonjour ${nom }</h1>
					<br>
					<h4>${msg}</h4>
 <%if(request.getParameter("msg")!=null){ %>	<h4>${msg}</h4><%} %>

				</div>
			</div>
		</div>

	</section>
	<!-- End banner Area -->
	
	<div class="container">
		<h3>Vos Sessions programmées</h3>
		<br>
					<table class="table table-striped">
						<tr>
							<th>Nom de la session</th>
							<th>Nom de l'enseignant</th>
							<th>Date de début</th>
							<th>Nombre des jours</th>
							<th>Nombre des séances par jour</th>
							<th>Nombre totale : ${listeS.size()}</th>
 					</tr>

						<c:forEach items="${listeS}" var="h">

							<tr>
							
								<td>${is.getSessionNom(h.getIdSession())}</td>
								<td>${h.getNomEnseignant()}</td>
								<td>${h.getDateDebut()}</td>
								<td>${is.getSessionNbrJour(h.getIdSession())}</td>
								<td>${h.getNmbrSeanceParJour()}</td>
							</tr>
						</c:forEach>
					</table>				
				</div>
	
	
	
	
	
	
	
	<div class="container">
							<h3>Les sessions disponibles</h3>
	<br>
		<form action="validationReservation.visiteur" method="post">
		
					<table class="table table-striped">
						<tr>
							<th>Nom de la session</th>
							<th>Nom de l'enseignant</th>
							<th>Date de début</th>
							<th>Nombre des jours</th>
							<th>Nombre des séances par jour</th>
							<th>Cocher pour réserver</th>
<%-- 							<th>Nombre totale : ${liste.size()}</th>
 --%>						</tr>

						<c:forEach items="${liste}" var="s">

							<tr>
							
								<td>${is.getSessionNom(s.getIdSession())}</td>
								<td>${s.getNomEnseignant()}</td>
								<td>${s.getDateDebut()}</td>
								<td>${is.getSessionNbrJour(s.getIdSession())}</td>
								<td>${s.getNmbrSeanceParJour()}</td>
								<td><input type="checkbox" name="choix"
									value="${s.getIdSession()}"></input><br /></td>
							</tr>
						</c:forEach>
					</table>
				
                	<input  hidden="hidden" value="${idEtudiant}" name="idEtudiant">
                	<input class="pull-right" type="submit" onclick ="return confirm('Une fois votre demande sera acceptée, vous serez avisé par e-mail de confirmation')" value="Réserver" />
         
    </form>
				</div>

	


	<!-- Start contact-page Area -->
	<br><br>
					<div class="container">
			<div class="row">
				<div class="col-lg-4 d-flex flex-column address-wrap">
					<div class="single-contact-address d-flex flex-row">
						<div class="icon">
							<span class="lnr lnr-home"></span>
						</div>
						<div class="contact-details">
							<h5>Rue Kalaat El Andalous</h5>
							<p>
								XXXXXXXXXXXXXXXXXXXX
							</p>
						</div>
					</div>
					<div class="single-contact-address d-flex flex-row">
						<div class="icon">
							<span class="lnr lnr-phone-handset"></span>
						</div>
						<div class="contact-details">
							<h5>00 216 XXXXXXXX</h5>
							<p>Lundi à  Vendredi 9am to 6 pm</p>
						</div>
					</div>
					<div class="single-contact-address d-flex flex-row">
						<div class="icon">
							<span class="lnr lnr-envelope"></span>
						</div>
						<div class="contact-details">
							<h5>support@Info.com</h5>
							<p>Nous somme à votre service</p>
						</div>
					</div>
				</div>
			<h1>${e.getNom() }</h1> 

				<div class="col-lg-12">
					<div class="map-wrap" style="width:100%; height: 445px;" id="map"></div>
				</div>
			</div>
		</div>
	<!-- End contact-page Area -->

	<!-- start footer Area -->
	<footer class="footer-area">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-12">
					<div class="footer-top flex-column">
						<div class="footer-logo">
							<a href="#">
								<img src="PageHome/img/logo.png" alt="">
							</a>
							<h4>Follow Me</h4>
						</div>
						<div class="footer-social">
							<a href="#"><i class="fa fa-facebook"></i></a>
							<a href="#"><i class="fa fa-twitter"></i></a>
							<a href="#"><i class="fa fa-dribbble"></i></a>
							<a href="#"><i class="fa fa-behance"></i></a>
						</div>
					</div>
				</div>
			</div>
			<div class="row footer-bottom justify-content-center">
				<p class="col-lg-8 col-sm-12 footer-text">
					<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>
	document.write(new Date().getFullYear());
</script> All rights reserved | This template is made with <i
										class="fa fa-heart-o" aria-hidden="true"></i> by <a
										href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
								</p>
			</div>
		</div>
	</footer>
	<!-- End footer Area -->

	<!-- ####################### Start Scroll to Top Area ####################### -->
	<div id="back-top">
		<a title="Go to Top" href="#">
			<i class="lnr lnr-arrow-up"></i>
		</a>
	</div>
	<!-- ####################### End Scroll to Top Area ####################### -->

	<script src="PageHome/js/vendor/jquery-2.2.4.min.js"></script>
	<script
						src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
						integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
						crossorigin="anonymous"></script>
	<script src="PageHome/js/vendor/bootstrap.min.js"></script>
	<script type="text/javascript"
						src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>
	<script src="PageHome/js/easing.min.js"></script>
	<script src="PageHome/js/hoverIntent.js"></script>
	<script src="PageHome/js/superfish.min.js"></script>
	<script src="PageHome/js/mn-accordion.js"></script>
	<script src="PageHome/js/jquery.ajaxchimp.min.js"></script>
	<script src="PageHome/js/jquery.magnific-popup.min.js"></script>
	<script src="PageHome/js/owl.carousel.min.js"></script>
	<script src="PageHome/js/jquery.nice-select.min.js"></script>
	<script src="PageHome/js/isotope.pkgd.min.js"></script>
	<script src="PageHome/js/jquery.circlechart.js"></script>
	<script src="PageHome/js/mail-script.js"></script>
	<script src="PageHome/js/wow.min.js"></script>
	<script src="PageHome/js/main.js"></script>

				</body>

</html>