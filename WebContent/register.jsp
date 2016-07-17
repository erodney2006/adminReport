<%@ page language="java" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="normalize.css">
	<link rel="stylesheet" href="style.css">

</head>
<body>
Create A Account

<section class="loginform cf">
		<form action="register" method="post" name="register" >
			<ul>

		<table>

			<tr>
				<td>First:</td>
				<td><input type="text" name="fname" placeholder="First Name" required/></td>
			</tr>
			
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lname" placeholder="last Name" required/></td>
			</tr>
			<tr>
				<td>Address1:</td>
				<td><input type="text" name="addr1" placeholder="address" required/></td>
			</tr>
			
			<tr>
				<td>Address2:</td>
				<td><input type="text" name="addr2" placeholder="apt,suite,p.o"/></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><input type="text" name="city" placeholder="city" required/></td>
			</tr>
			
			<tr>
				<td>State:</td>
				<td><input type="text" name="state" placeholder="state" required/></td>
			</tr>
			
			<tr>
				<td>Zip:</td>
				<td><input type="number" name="zip" placeholder="Zip 5 to 8" required/></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><input type="text" name="country" placeholder="Country US" required/></td>
			</tr>

			<tr>
				<td><input type="submit" value="register" /></td>
				
				
			</tr>
		</table>
</ul>
	</form>
	

		
	</section>
</body>
</html>