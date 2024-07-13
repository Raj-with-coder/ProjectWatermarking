<%@ page import="com.nits.util.*" %>
<%@ page import="java.sql.*" %>
<html>
<%
	ResultSet rs=(ResultSet)request.getAttribute("rs");
	int id=0;
	String userid="",add="",cno="",city="",name="",email="";
	while(rs.next())
	{
		id=rs.getInt(1);
		userid=rs.getString(2);
		name=rs.getString(4);
		add=rs.getString(6);
		city=rs.getString(7);
		email=rs.getString(8);
		cno=rs.getString(9);
	}
%>
<head>
	<link href="<%=request.getContextPath() %>/Resources/CSS/message.css" rel="stylesheet" type="text/css" /> 
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Resources/CSS/login.css" type="text/css"/>
	<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/style.js"></script>
</head>
<body onload="startTimer()">
<div style="position:absolute;top:-20px;left:100" class="c">	
	<table id="login">
			<h1 align="center" id="label">Edit User</h1>
			<hr size="10" color="#5E74D8"></hr>
			<form action="<%=request.getContextPath() %>/UserList">
			<input type="hidden" name="submit" value="Edit"></input>
			<input type="hidden" name="edit1" value="YES"></input>
			<input type="hidden" name="id" value="<%=id %>"></input>
				<tr id="label">
					<td>User-ID</td>
					<td><input class="field" value="<%=userid %>" name="id" type="text" readonly/></td>
					<td>Address</td>
					<td><input class="field" value="<%=add %>" name="add" type="text" required="yes"/></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr id="label">
					<td>Contact No</td>
					<td><input class="field" value="<%=cno %>" name="cno" type="text" required="yes"/></td>
					<td>City</td>
					<td><input class="field" value="<%=city %>" name="city" type="text" required="yes"/></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr id="label">
					<td>Name</td>
					<td><input class="field" value="<%=name %>" name="name" type="text" required="yes"/></td>
					<td>Emai-ID</td>
					<td><input class="field" value="<%=email %>" name="email" type="text" required="yes"/></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input class="button" type="submit" value="Register"/></td>
				</tr>
		</form>
	</table>
</div>		
<%
if(Utility.parse(request.getParameter("no"))==1)
{%>
	<div class="error" id="message" style="position:absolute">	
		<p>Sorry this user id is already exists.....!</p>
	</div>			
<%}
%>
</body>
</html>