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
	<% request.setAttribute("PAGE","ALL_COURSES"); %>
	<jsp:include page="header.jsp" />
 
    <div id="site_content">
        <h1>Available Trainings</h1>
        
        <div class="contentBoxLeft">
	        <h3>C Language</h3>
	        <h5>Next batch starting on - <strong>4th April 2016</strong><br><a href="register.jsp?tName=c">Click here to register</a></h5>
	        <p>This training is best for PU,BE,BCA,MCA students.C is on the oldest programming language.<br /><a href="courseDetails.jsp?tName=c">Read more</a></p>
        </div>     
        <div class="contentBoxLeft">
	        <h3>Java</h3>
	        <h5>Next batch starting on - <strong>4th April 2016</strong><br><a href="register.jsp?training=java">Click here to register</a></h5>
	        <p>This training is best for PU,BE,BCA,MCA students.Java is most widely used programming language.<br /><a href="courseDetails.jsp?tName=java">Read more</a></p>
        </div>  
        <div class="contentBoxHighlight">
	        <h3>Java &amp; Advanced Java</h3>
	        <h5>Next batch starting on - <strong>4th April 2016</strong><br><a href="register.jsp?training=ADV_JAVA">Click here to register</a></h5>
	        <p>This training is best for job seekers and graduates.Learn how Java is used by companies.<br/><a href="#">Read more</a></p>
        </div>  
        <div class="contentBoxLeft">
	        <h3>Struts</h3>
	        <h4>What's the News?</h4>
	        <h5>1st July 2011</h5>
	        <p>Put your latest news item here, or anything else you would like in the sidebar!<br /><a href="#">Read more</a></p>
        </div>  
        <div class="contentBoxHighlight">
	        <h3>Spring</h3>
	        <h4>What's the News?</h4>
	        <h5>1st July 2011</h5>
	        <p>Put your latest news item here, or anything else you would like in the sidebar!<br /><a href="#">Read more</a></p>
        </div>  
        <div class="contentBoxLeft">
	        <h3>Hibernate</h3>
	        <h4>What's the News?</h4>
	        <h5>1st July 2011</h5>
	        <p>Put your latest news item here, or anything else you would like in the sidebar!<br /><a href="#">Read more</a></p>
        </div>   
        <div class="contentBoxHighlight">
	        <h3>Angular.js</h3>
	        <h4>What's the News?</h4>
	        <h5>1st July 2011</h5>
	        <p>Put your latest news item here, or anything else you would like in the sidebar!<br /><a href="#">Read more</a></p>
        </div>  
        <div class="contentBoxLeft">
	        <h3>Node.js</h3>
	        <h4>What's the News?</h4>
	        <h5>1st July 2011</h5>
	        <p>Put your latest news item here, or anything else you would like in the sidebar!<br /><a href="#">Read more</a></p>
        </div>  
        <div class="contentBoxHighlight">
	        <h3>Android</h3>
	        <h4>What's the News?</h4>
	        <h5>1st July 2011</h5>
	        <p>Put your latest news item here, or anything else you would like in the sidebar!<br /><a href="#">Read more</a></p>
        </div>                              
      </div>
    </div>
    <div id="footer">
      <p>Copyright &copy; Techknowlogy Academy</p>
    </div>
</body>
</html>
