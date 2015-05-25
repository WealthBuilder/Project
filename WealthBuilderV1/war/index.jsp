<!DOCTYPE html>
<html>
<head>
<title>Wealth Builder</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!--// bootstrap-css -->
<!-- css -->
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<!--// css -->
<!-- js -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<!-- js -->
<!--fonts-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
<!--/fonts-->
	<!-- start-smoth-scrolling -->
		<script type="text/javascript" src="js/move-top.js"></script>
		<script type="text/javascript" src="js/easing.js"></script>
		<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
				});
			});
		</script>
	<!-- start-smoth-scrolling -->

</head>
<body>
<!-- Header -->
<jsp:include page="header.jsp"/>
<!-- //Header -->

<!--banner-->
<div id="home" class="banner">
	<div class="container">
			<!-- responsiveslides -->
					<script src="js/responsiveslides.min.js"></script>
						<script>
							// You can also use "$(window).load(function() {"
							$(function () {
							 // Slideshow 4
							$("#slider3").responsiveSlides({
								auto: true,
								pager: true,
								nav: false,
								speed: 500,
								namespace: "callbacks",
								before: function () {
							$('.events').append("<li>before event fired.</li>");
							},
							after: function () {
								$('.events').append("<li>after event fired.</li>");
								}
								});
								});
					</script>
				<!-- responsiveslides -->
		<div  id="top" class="callbacks_container">
			<ul class="rslides" id="slider3">
				<li>
					<div class="banner-info text-center">
						<h1>WELCOME TO THE WEALTH BUILDER</h1>
						<p>Free quality stock tips guaranteed.</p>
						<!-- 
						<div class="start">
								<a href="#">START TOUR</a>
								<a href="#">SEND A QUOTE</a>
						</div>  -->
					</div>
				</li>
				<li>
					<div class="banner-info text-center">
						<h1>RS ONE LAKH TO ONE CRORE IN 18 MONTHS</h1>
						<p>Earn money consistently in stock market.</p>
						<!-- 
						<div class="start">
								<a href="#">START TOUR</a>
								<a href="#">SEND A QUOTE</a>
						</div>  -->
					</div>
				</li>
				<li>
					<div class="banner-info text-center">
						<h1>BECOME WEALTHY IN STYLE</h1>
						<p>Enormous wealth can be created by investing properly.</p>
						<!-- 
						<div class="start">
								<a href="#">START TOUR</a>
								<a href="#">SEND A QUOTE</a>
						</div>  -->
					</div>
				</li>
			</ul>
		</div>
	</div>
</div>
<!--//banner-->
<!--about-->
<div id="about" class="about">
	<div class="about-grids">
		<div class="about-left">
			<div class="about-info">
				<h3>ABOUT US</h3>
				<p>Our goal is to help everyone to make money in stock market. Almost everyone lose money in stock market and the reason is simple - lack of knowledge.</p>
				<p>In our research , we found that almost everyone invests money in stock market by just following some expert's advice from TV/moneycontrol and thats the worst way to invest. </p>
				<a href="readmore.html">READ MORE</a>
			</div>
		</div>
		<div class="about-right">
			<img src="images/pic1.jpg" alt=""/>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<!--//about-->
<!--behind-->

<!--footer-->
<jsp:include page="footer.jsp"/>
<!--//footer-->

<!-- smooth scrolling -->
	<script type="text/javascript">
		$(document).ready(function() {
		/*
			var defaults = {
			containerID: 'toTop', // fading element id
			containerHoverID: 'toTopHover', // fading element hover id
			scrollSpeed: 1200,
			easingType: 'linear' 
			};
		*/								
		$().UItoTop({ easingType: 'easeOutQuart' });
		});
	</script>
	<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!-- //smooth scrolling -->
</body>
</html>