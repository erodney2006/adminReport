<%@ page language="java" %>
<%@page import="java.util.ArrayList"%>
<%@page import="action.*"%>
<%@page import="java.util.Iterator"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="normalize.css">
	<link rel="stylesheet" href="style.css">
</head>
<body>
Welcome to the bank site


</body>
<%
						
						 RegisterServlet instance= new RegisterServlet();
						instance.setup();
						instance.updateQuery(); 
					
					%>
<form action="home" method="post">
	<table>

		
		<tr>
			<td><a href="login.jsp">Login</a></td>
			<td><a href="register.jsp">Register</a></td>
		</tr>
	</table>
	</form>
</body>
</html>