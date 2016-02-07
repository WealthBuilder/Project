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
	<% request.setAttribute("PAGE","RIGHT_COURSE"); %>
	<jsp:include page="header.jsp" />

    <div id="site_content">

      <div id="content">
        <!-- insert the page content here -->
        <h1>Find the right course for you</h1>
        <table>
        <tr>
        	<td> I am a </td>
        	<td>:</td>
        	<td> <input type="radio" name="profession">Student &nbsp;&nbsp;&nbsp;&nbsp;
        	     <input type="radio" name="profession">Graduate/Job Seeker &nbsp;&nbsp;&nbsp;&nbsp;
        		 <input type="radio" name="profession">Working Professional &nbsp;&nbsp;&nbsp;&nbsp;
        		 
        	</td>
        </tr>
        
        </table>
             
      </div>
    </div>
    <div id="footer">
      <p>Copyright &copy; Techknowlogy Academy</p>
    </div>
  </div>
</body>
</html>
