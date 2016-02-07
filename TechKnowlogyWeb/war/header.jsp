<div id="header">
  <div id="logo">
    <h1><a href="#">Techknowlogy Academy</a></h1>
    <div class="slogan">Call us @ 8884155355</div>
  </div>
  <div id="menubar">
    <ul id="menu">
      <!-- put class="current" in the li tag for the selected page - to highlight which page you're on -->
      <% if("HOME".equals(request.getAttribute("PAGE"))) { %>
      	<li class="current"><a href="index.jsp">Home</a></li>
	  <%}  else	{ %>
	  	<li><a href="index.jsp">Home</a></li>
	  <% } %>

      <!-- put class="current" in the li tag for the selected page - to highlight which page you're on -->
      <% if("TRAINER".equals(request.getAttribute("PAGE"))) { %>
      	<li class="current"><a href="trainerProfile.jsp">Know Your Trainer</a></li>
	  <%}  else	{ %>
	  	<li><a href="trainerProfile.jsp">Know Your Trainer</a></li>
	  <% } %>	
	  
	  <!-- put class="current" in the li tag for the selected page - to highlight which page you're on -->
      <% if("RIGHT_COURSE".equals(request.getAttribute("PAGE"))) { %>
      	<li class="current"><a href="rightCourse.jsp">Find Right Course</a></li>
	  <%}  else	{ %>
	  	<li><a href="rightCourse.jsp">Find Right Course</a></li>
	  <% } %>  
	  
	  <!-- put class="current" in the li tag for the selected page - to highlight which page you're on -->
      <% if("ALL_COURSES".equals(request.getAttribute("PAGE"))) { %>
      	<li class="current"><a href="allCourses.jsp">All Courses</a></li>
	  <%}  else	{ %>
	  	<li><a href="allCourses.jsp">All Courses</a></li>
	  <% } %> 

	  <!-- put class="current" in the li tag for the selected page - to highlight which page you're on -->
      <% if("CONTACT_US".equals(request.getAttribute("PAGE"))) { %>
      	<li class="current"><a href="contactUs.jsp">Contact Us</a></li>
	  <%}  else	{ %>
	  	<li><a href="AllCourses.jsp">Contact Us</a></li>
	  <% } %> 	  
	  	  

    </ul>
  </div>
</div>