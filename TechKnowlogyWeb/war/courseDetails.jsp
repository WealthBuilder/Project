<!DOCTYPE HTML>
<%@ page import = "java.util.ResourceBundle" %> 
<% ResourceBundle resource = ResourceBundle.getBundle("techKnowlogy");%>

<html>

<head>
  <title>Techknowlogy Academy</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=windows-1252" />

  <link rel="stylesheet" type="text/css" href="style/style.css" />

</head>

<%
String courseName = resource.getString("course.name." + request.getParameter("tName"));

String courseDesc1 = resource.getString("course.desc1." + request.getParameter("tName"));
String courseDesc2 = resource.getString("course.desc2." + request.getParameter("tName"));

String duration = resource.getString("course.schedule." + request.getParameter("tName"));
String fees = resource.getString("course.fee." + request.getParameter("tName"));

%>

<body>
  
  <div id="main">

	<!--  Include header -->
	<% request.setAttribute("PAGE","ALL_COURSES"); %>
	<jsp:include page="header.jsp" />

    <div id="site_content">
      <div id="content">
        <!-- insert the page content here -->
        <h1><%= resource.getString("course.name.label") %> - <%= courseName %> </h1>
        <p> <%= courseDesc1%> </p>
        <p><strong><%= courseDesc2%> </strong></p>
        <table> 
        	<tr>
        		<td><strong><%= resource.getString("course.duration.label")%></strong></td>
        		<td>:</td>
        		<td><%=duration%></td>
        	</tr>
        	
        	<tr>
        		<td><strong><%= resource.getString("course.fee.label")%></strong></td>
        		<td>:</td>
        		<td><%=fees%></td>
        	</tr> 
        	
        	<tr>
        		<td><strong><%= resource.getString("course.next.batch.label")%></strong></td>
        		<td>:</td>
        		<td><%=fees%> <a href="register.jsp?tName=<%=request.getParameter("tName")%>">Click here to register</a></td>
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
