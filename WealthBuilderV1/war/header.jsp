<!--header-->
<%@page import="com.wealth.builder.vo.User"%>
<div class="header">
	<div class="container">
		<div class="header-left">
			<a href="index.jsp"><img src="images/logo.png" alt=""/></a>
		</div>
		<div class="header-right">
			<span class="menu">MENU</span>
					<ul class="nav1">
					
						<% if(request.getSession().getAttribute("USER") != null) { %>
						<li><a href="#">Welcome &nbsp;<%= ((User)request.getSession().getAttribute("USER")).getFirstName()%> </a></li>	
						<%} %>
						
						<li><a href="index.jsp">HOME</a></li>
						<!-- 
						<li><a href="index.jsp#about">ABOUT</a></li>
						-->
						<% if(request.getSession().getAttribute("USER") != null) { %>	
						<li><a href="advice.jsp">ADVICE</a></li>
						<%} %>
						<li><a href="faq.jsp">FAQ</a></li>
						<li><a href="contact.jsp">CONTACT</a></li>
						<% if(request.getSession().getAttribute("USER") == null) { %>
						<li><a href="login.jsp">LOGIN</a></li>
						<%} %>
						<% if(request.getSession().getAttribute("USER") != null) { %>
						<li><a href="logout?ACTION=logout">LOGOUT</a></li>
						<%} %>						
					</ul>
				<!-- script for menu -->
						<script> 
							$( "span.menu" ).click(function() {
							$( "ul.nav1" ).slideToggle( 300, function() {
							 // Animation complete.
							});
							});
						</script>
				<!-- //script for menu -->
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<!--//header-->