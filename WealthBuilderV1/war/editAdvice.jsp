<!DOCTYPE html>
<%@page import="com.wealth.builder.vo.Advice"%>
<%@page import="com.wealth.builder.util.DisplayUtil"%>
<html>
<head>
<title>WealthBook</title>
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
				<h3>All Fields are mandatory</h3>
			</div>
			<% if(request.getAttribute("ERRORS") != null) {
			%>
			<font color="red"><%=request.getAttribute("ERRORS")%></font><br><br>
			<%} %>
			
				<% Advice advice = (Advice)session.getAttribute("CURRENT_ADVICE");
				%>

			<form action="updateAdvice" method="post">
			<div class="contact-left">
			
			    Created Date <input type="text" name="CREATED_DATE" value="<%=advice.getCreatedDate()%>" readonly="readonly">
				Stock Name <input type="text" name="STOCK_NAME" value="<%=advice.getStockName()%>" readonly="readonly">
				
				Advice <textarea rows="3" cols="50" NAME="ADVICE"> <%=advice.getAdvice()%></textarea> 
				
				Status <input type="text" name="STATUS" value="<%=advice.getStatus()%>">
				
				Remarks <input type="text" name="REMARK" value="<%=advice.getRemark()%>">
				
				Profit <input type="text" name="PROFIT" value="<%=advice.getProfit()%>">
				
				Profile <input type="text" name="PROFILE" value="<%=advice.getProfile()%>" readonly="readonly">
				
				updated date <input type="text" name="UPDATED_DATE" value="<%=advice.getUpdatedDate()%>" readonly="readonly">
				
				<input type="hidden" name="ACTION" value="update"/> 
								
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