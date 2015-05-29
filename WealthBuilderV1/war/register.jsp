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
<div class="contact">
	<div class="container">
		<div class="contact-form">

			<div class="contact-info">
				<h3>PLEASE ENTER YOUR DETAILS - All Fields are mandatory</h3>
			</div>
			<% if(request.getAttribute("ERRORS") != null) {
			%>
			<font color="red"><%=request.getAttribute("ERRORS")%></font><br><br>
			<%} %>
			<form action="registerUser" method="post">
			<div class="contact-left">
				<input type="text" placeholder="First Name" name="FIRST_NAME"required>
				<input type="text" placeholder="Last Name" name="LAST_NAME" required>
				<input type="text" placeholder="Email" name="EMAIL_ID" required>
				<input type="password" placeholder="password" name="PASSWORD_1" required>
				<input type="password" placeholder="again password" name="PASSWORD_2" required>
				<input type="text" placeholder="Mobile" name="MOBILE_NUMBER" required>
				
			</div>
			<div class="clearfix"></div>
			<input type="submit" value="SUBMIT"> 
			</form>
			
		</div>
	</div>
</div>
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