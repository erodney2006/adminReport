<%@ page language="java" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Welcome Member! <br>What would you like to do?
<form action="deposit" method="post">
	<table >

		<tr>
			<td>
				<input type="submit" value="Deposit"  />
			</td>
				
		</tr>
	</table>
		
</form>
		
<form action="withdraw" method="post">
		<table>

			<tr>		
				<td>
				<input type="submit" value="Withdraw"/>
				</td>
		
			</tr>
		</table>
</form>
		
<form action="inbox" method="post" >
	<table>

		<tr>
			<td>
				<input  type="submit" value="Balance" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>