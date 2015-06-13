<!DOCTYPE html>
<%@page import="com.wealth.builder.util.DisplayUtil"%>
<%@page import="com.wealth.builder.vo.Advice"%>
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
<script type="text/javascript">

function FloatUp(id,ms){
 var obj=document.getElementById(id),top=document.body.clientHeight;
 if (window.innerHeight){
  top=window.innerHeight;
 }
 else if (document.documentElement.clientHeight){
  top=document.documentElement.clientHeight;
 }
 animate(obj,'bottom',0,top-obj.offsetHeight,new Date(),ms||2000);
}

function animate(obj,mde,f,t,srt,mS){
	 var oop=this,ms=new Date().getTime()-srt,now=(t-f)/mS*ms+f;
	 if (isFinite(now)){
	  obj.style[mde]=now+'px';
	 }
	 if (ms<mS){
	  this.dly=setTimeout(function(){ oop.animate(obj,mde,f,t,srt,mS); },10);
	 }
	 else {
	  obj.style[mde]=t+'px';
	 }
	}
	
function Init(){
 FloatUp('tst',2000);
}

if (window.addEventListener){
 window.addEventListener('load',Init, false);
}
else if (window.attachEvent){
 window.attachEvent('onload',Init);
}

</script>
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
					<th width="400" class="th-border"> Advice </th>
					<th width="100" class="th-border"> Status </th>
					<th width="100" class="th-border"> Profit/Loss </th>
					<th width="300" class="th-border"> Remark </th>
				</tr>
				<% Advice []advices = (Advice[])session.getAttribute("USER_ADVICES");
					if(advices != null)	{
						for(Advice advice : advices)	{
				%>
				
				<tr>
					<td width="100" class="th-border" > <%=DisplayUtil.getDisplayableDate(advice.getCreatedDate()) %></td>
					<td width="150"  class="th-border"> <%=advice.getStockName() %></td>
					<td width="400" class="th-border"> <textarea rows="3" cols="55" readonly="readonly"><%=advice.getAdvice()%></textarea> </td>
					<td width="100" class="th-border"> <%=advice.getStatus() %> </td>
					<td width="100" class="th-border"> <%=advice.getProfit() %> </td>
					<td width="300" class="th-border"> <%=DisplayUtil.getDisplayableString(advice.getRemark())%> </td>
				</tr>
				<% }//for
				}//if
				%>
				</table>
			</div>
			
		</div>
	</div>
</div>
<!--footer-->
<jsp:include page="footer.jsp"/>
<!--//footer-->

<div id="tst" class="float" ><input type="button" name="" value="X" onmouseup="this.parentNode.style.display='none'; " />
<a href="faq.jsp" style="text-decoration: none;"> <br/><br/><br/> <font color="white" size="4"> 
Before making any position with our advice , please visit FAQ.</font> </a>
</div> 
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