<!DOCTYPE HTML>
<html>

<head>
  <title>Techknowlogy Academy</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
  <!-- 
  <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Tangerine&amp;v1" />
  <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Yanone+Kaffeesatz" />
  
   -->
  <link rel="stylesheet" type="text/css" href="style/style.css" />

</head>

<body>
  
  <div id="main">

	<!--  Include header -->
	<% request.setAttribute("PAGE","HOME"); %>
	<jsp:include page="header.jsp" />

    <div id="site_content">
      <div id="sidebar_container">
        <img class="paperclip" src="style/paperclip.png" alt="paperclip" />
        <div class="sidebar">
        <!-- insert your sidebar items here -->
        <h3>Latest News</h3>
        <h4>What's the News?</h4>
        <h5>1st July 2011</h5>
        <p>Put your latest news item here, or anything else you would like in the sidebar!<br /><a href="#">Read more</a></p>
        </div>

      </div>
      <div id="content">
        <!-- insert the page content here -->
        <h1>Welcome to Techknowlogy Academy</h1>
        <p>You are at right place for your technical training needs.Technologies are involving and Organizations are looking for experts on these technology.
           There is huge demand for technology experts.<strong>Get trained and be ready for opportunities.</strong>
        </p>
        
        <h2>Available Trainings</h2>
        <ul>
	        <li>Java</li>
	        <li>Struts</li>
	        <li>Hibernate</li>
	        <li>Spring</li>
	        <li>Angular.js</li>
	        <li>Node.js</li> 
	        <li>Android</li> 
	        <li>And more ...</li>
        </ul>      
      </div>
    </div>
    <div id="footer">
      <p>Copyright &copy; Techknowlogy Academy</p>
    </div>
  </div>
</body>
</html>
