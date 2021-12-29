<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" style="display: block;" lang="zxx">
<head>
<!-- Mobile Specific Meta -->
<meta charset="UTF-8" name="viewport"	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Centre de formation</title>

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
<script type="text/javascript" charset="UTF-8"
	src="https://maps.googleapis.com/maps-api-v3/api/js/42/8/common.js"></script>
<script type="text/javascript" charset="UTF-8"
	src="https://maps.googleapis.com/maps-api-v3/api/js/42/8/util.js"></script>
</head>

<body style="display: block;">

	<!-- Start Header Area -->
	<header id="header" class="dark header-scrolled">
		<div class="container main-menu">
			<div class="row align-items-center d-flex">
				<div id="logo">
					<a href="index.html"><img src="PageHome/img/logo2.png" alt=""
						title="" style="width: 80px;"></a>


					<nav id="nav-menu-container" class="ml-auto">

						<ul class="nav-menu white sf-js-enabled sf-arrows"
							style="touch-action: pan-y;">

							<%if(session.getAttribute("nom")!=null) {%>
							<li class=""><a>Bonjour ${nom}</a><br> <a
								href="logout.visiteur">Logout</a></li>
							<%} else { %>
							<li class=""><a href="login.etudiant">Login</a></li>

							<%} %>
						</ul>
					</nav>

				</div>

			</div>
		</div>
	</header>
	<!-- End Header Area -->

	<!-- start banner Area -->
	<section class="banner-area relative" style="bottom: 50px;">
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<br>
				<br>
				<br>
				<br>
				<div class="about-content col-lg-10">
					<h1 class="text-white">Bienvenue</h1>
					<p class="link-nav">
						<span class="box"> <a>Centre BenMahmoud de formation</a>
							<div class="row">
								<div class="col-lg-12 text-center">


									<a <%if(session.getAttribute("role")!="etudiant"){ %>
										href="reserver.visiteur" <%}else{ %>
										href="reservermembre.visiteur" <%} %>
										class="primary-btn mt-50" data-text="Réserver votre formation">
										<span>C</span> <span>l</span> <span>i</span> <span>q</span> <span>u</span>
										<span>e</span> <span>r</span> <span> </span> <span>i</span> <span>ç</span>
										<span>i</span>
									</a>
								</div>
							</div>
						</span>
					</p>

				</div>

			</div>
		</div>
	</section>
	<!-- End banner Area -->

	<!-- Start Work Area Area -->
	<section class="work-area section-gap-top section-gap-bottom-90"
		id="work">
		<div class="container">
			<div class="row d-flex justify-content-between align-items-end mb-80">
				<div class="col-lg-6">
					<div class="section-title">
						<h2>Nos Formations</h2>
						<p>Votre réussite ... c'est notre fièrté ...</p>
						<div class="row">
							<div class="col-lg-12 text-center">
								<a href="reserver.visiteur" class="primary-btn mt-50"
									data-text="Réserver votre formation"> <span>C</span> <span>l</span>
									<span>i</span> <span>q</span> <span>u</span> <span>e</span> <span>r</span>
									<span> </span> <span>i</span> <span>ç</span> <span>i</span>
								</a>
							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-6">
					<div class="filters">
						<ul>
							<li class="active" data-filter=".all">All Categories</li>
							<li data-filter=".creative">Langues</li>
							<li data-filter=".web-design">IT</li>
						</ul>
					</div>
				</div>
			</div>

			<div class="filters-content">
				<div class="row grid" style="position: relative; height: 719.167px;">
					<div
						class="single-work col-lg-4 col-md-6 col-sm-12 all creative wow fadeInUp"
						data-wow-duration="2s"
						style="position: absolute; left: 0%; top: 0px; visibility: visible; animation-duration: 2s; animation-name: fadeInUp;">
						<div class="relative">
							<div class="thumb">
								<div class="overlay overlay-bg"></div>
								<img class="image img-fluid" src="PageHome/img/work/w1.jpg"
									alt="">
							</div>

						</div>
					</div>
					<div
						class="single-work col-lg-4 col-md-6 col-sm-12 all web-design branding wow fadeInUp"
						data-wow-duration="2s" data-wow-delay="0.2s"
						style="position: absolute; left: 33.3333%; top: 0px; visibility: visible; animation-duration: 2s; animation-delay: 0.2s; animation-name: fadeInUp;">
						<div class="relative">
							<div class="thumb">
								<div class="overlay overlay-bg"></div>
								<img class="image img-fluid" src="PageHome/img/work/w2.jpg"
									alt="">
							</div>

						</div>
					</div>
					<div
						class="single-work col-lg-4 col-md-6 col-sm-12 all branding web-design wow fadeInUp"
						data-wow-duration="2s" data-wow-delay="0.4s"
						style="position: absolute; left: 66.6667%; top: 0px; visibility: visible; animation-duration: 2s; animation-delay: 0.4s; animation-name: fadeInUp;">
						<div class="relative">
							<div class="thumb">
								<div class="overlay overlay-bg"></div>
								<img class="image img-fluid" src="PageHome/img/work/w3.jpg"
									alt="">
							</div>

						</div>
					</div>
					<div
						class="single-work col-lg-4 col-md-6 col-sm-12 all web-design wow fadeInUp"
						data-wow-duration="2s" data-wow-delay="0.6s"
						style="position: absolute; left: 66.6667%; top: 359px; visibility: visible; animation-duration: 2s; animation-delay: 0.6s; animation-name: fadeInUp;">
						<div class="relative">
							<div class="thumb">
								<div class="overlay overlay-bg"></div>
								<img class="image img-fluid" src="PageHome/img/work/w6.jpg"
									alt="">
							</div>

						</div>
					</div>
					<div
						class="single-work col-lg-4 col-md-6 col-sm-12 all creative wow fadeInUp"
						data-wow-duration="2s"
						style="position: absolute; left: 0%; top: 388px; visibility: visible; animation-duration: 2s; animation-name: fadeInUp;">
						<div class="relative">
							<div class="thumb">
								<div class="overlay overlay-bg"></div>
								<img class="image img-fluid" src="PageHome/img/work/w4.jpg"
									alt="">
							</div>

						</div>
					</div>
					<div
						class="single-work col-lg-4 col-md-6 col-sm-12 all branding wow fadeInUp"
						data-wow-duration="2s" data-wow-delay="0.2s"
						style="position: absolute; left: 33.3333%; top: 437px; visibility: visible; animation-duration: 2s; animation-delay: 0.2s; animation-name: fadeInUp;">
						<div class="relative">
							<div class="thumb">
								<div class="overlay overlay-bg"></div>
								<img class="image img-fluid" src="PageHome/img/work/w5.jpg"
									alt="">
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- End Work Area Area -->

	<!-- Start Contact Area -->
	<section class="contact-area section-gap">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="contact-title">
						<h2>Contact Us</h2>

					</div>
				</div>
			</div>

			<div class="row mt-80">
				<div class="col-lg-4 col-md-4">
					<div class="contact-box">
						<h4>+44 2365 654 8962</h4>
					</div>
				</div>
				<div class="col-lg-4 col-md-4">
					<div class="contact-box">
						<h4>information@XXX.com</h4>
					</div>
				</div>
				<div class="col-lg-4 col-md-4">
					<div class="contact-box">
						<h4>Adresse : XXX</h4>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-12 text-center">
					<a href="reserver.visiteur" class="primary-btn mt-50"
						data-text="Réserver votre formation"> <span>C</span> <span>l</span>
						<span>i</span> <span>q</span> <span>u</span> <span>e</span> <span>r</span>
						<span> </span> <span>i</span> <span>ç</span> <span>i</span>
					</a>
				</div>
			</div>
		</div>
	</section>
	<!-- End Contact Area -->

	<!-- start footer Area 
    <footer class="footer-area">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-12">
                    <div class="footer-top flex-column">
                        <div class="footer-logo">
                            <a href="#">
                                <img src="img/logo.png" alt="">
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
                    Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. 
                    Copyright &copy;
                    <script>
                        document.write(new Date().getFullYear());
                    </script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                    Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. 
                </p>
            </div>
        </div>
    </footer>
    End footer Area -->

	<!-- ####################### Start Scroll to Top Area ####################### -->
	<div id="back-top" class="back-top-animation">
		<a title="Go to Top" href="#"> <i class="lnr lnr-arrow-up"></i>
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
