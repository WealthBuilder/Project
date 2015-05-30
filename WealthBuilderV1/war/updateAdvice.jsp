<!DOCTYPE html>
<%@page import="com.wealth.builder.util.DisplayUtil"%>
<%@page import="com.wealth.builder.vo.Advice"%>
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
				<h3>Current positions</h3> 
				<br>
				<table class="table-border">
				<tr>
					<th width="100" class="th-border" > Started On</th>
					<th width="150"  class="th-border"> Stock Name </th>
					<th width="400" class="th-border"> Tip </th>
					<th width="100" class="th-border"> Status </th>
					<th width="100" class="th-border"> Profit/Loss </th>
					<th width="300" class="th-border"> Remark </th>
					<th width="100" class="th-border"> Updated Date </th>
				</tr>
				<% Advice []advices = (Advice[])session.getAttribute("ADVICES");
					if(advices != null)	{
						for(Advice advice : advices)	{
				%>
				<tr>
					<td width="100" class="th-border" > <%=DisplayUtil.getDisplayableDate(advice.getCreatedDate())%></td>
					<td width="150"  class="th-border"> <%=advice.getStockName()%> </td>
					<td width="400" class="th-border"> <%=advice.getAdvice()%> </td>
					<td width="100" class="th-border"> <%=advice.getStatus()%> </td>
					<td width="100" class="th-border"> <%=advice.getProfit()%> </td>
					<td width="300" class="th-border"> <%=advice.getRemark()%> </td>
					<td width="100" class="th-border" > <%=DisplayUtil.getDisplayableDate(advice.getUpdatedDate())%></td>
					<td width="50" class="th-border"> <a href="editAdvice?ACTION=edit&adviceId=<%=advice.getAdviceId()%>">Edit</a> </td>
					<td width="50" class="th-border"> <a href="editAdvice?ACTION=delete&adviceId=<%=advice.getAdviceId()%>" onclick="return confirm('Are you sure?')">Delete</a> </td>
				</tr>	
				<%		}
					}
				%>
				</table>
			</div>
			
			<a href="createNewAdvice.jsp"> Create new advice</a> <br><br>
			
			<a href="viewAdvices?ACTION=view"> View All advices </a>
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