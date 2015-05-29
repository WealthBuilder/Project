<!--header-->
<div class="header">
	<div class="container">
		<div class="header-left">
			<a href="index.html"><img src="images/logo.png" alt=""/></a>
		</div>
		<div class="header-right">
			<span class="menu">MENU</span>
					<ul class="nav1">
						<li><a class="scroll active" href="#home">HOME</a></li>
						<li><a class="scroll" href="#about">ABOUT</a></li>
						<% if(request.getSession().getAttribute("USER") != null) { %>	
						<li><a href="tips.jsp">TIPS</a></li>
						<%} %>
						<li><a href="faq.html">FAQ - Please read</a></li>
						<li><a href="contact.jsp">CONTACT</a></li>
						<% if(request.getSession().getAttribute("USER") == null) { %>
						<li><a href="login.jsp">LOGIN</a></li>
						<%} %>
						<% if(request.getSession().getAttribute("USER") != null) { %>
						<li><a href="logout">LOGOUT</a></li>
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