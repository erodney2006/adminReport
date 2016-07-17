<%@ page language="java" %>
<%@page import="java.util.ArrayList"%>
<%@page import="action.*"%>
<%@page import="java.util.Iterator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		

			  <!-- ####################################################################################################### -->
         
    <h1><font style="font-family: cursive;" color="green">List of all customers so far</font></h1>
    
				
					<%
						
						Iterator it2=Globals.listCust.iterator();
						while(it2.hasNext()){
						String s2=(String)it2.next();
					%><tr>
						<td><h3><font style="font-family: cursive;"><%=s2%></font></h3></td>
					</tr>
					<%
						}
					%>
				
			

	
</body>
</html>