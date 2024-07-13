<%@ page import="com.nits.util.*" %>
<%@ page import="java.sql.*" %>
<html>
<%
	String user=Utility.parse1(request.getAttribute("user"));
	ResultSet rs=(ResultSet)request.getAttribute("rs");
	int no=Utility.parse(request.getParameter("no"));
	int id=0;
	String userid="",name="",gender="",add="",email="",phone="",city="";
	if(no==0)
	while(rs.next())
	{
		id=rs.getInt(1);
		userid=rs.getString(2);
		name=rs.getString(4);
		gender=rs.getString(5);
		add=rs.getString(6);
		city=rs.getString(7);
		email=rs.getString(8);
		phone=rs.getString(9);
	}
%>
<head>
	<link href="<%=request.getContextPath() %>/Resources/CSS/message.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/login.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/button.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/style.js"></script>
</head>
<body onload="startTimer()">
		<%
			if(no==1)
			{
				%>
					<div class="error" id="message">	
						<p>Opp's,Seems something went wrong ..!</p>
					</div>
				<%
			}
			if(no==0)
			{
				%>
					<form id="login" action="<%=request.getContextPath() %>/EditProfile2">
					<input type="hidden" name="user" value="<%=user %>"></input>
					<input type="hidden" name="no" value="2"></input>
					<input type="hidden" name="id" value="<%=id %>"></input>
					<div align="right">
						<input type="submit" value="Save Updates" class="gradientbuttons"/>&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="gradientbuttons" href="<%=request.getContextPath() %>/ChangePass2?name=<%=user %>&no=1&id=<%=id %>" target="afrm">Change Password</a>
					</div><br></br>
					<div id="a1">
						<p>Your ID No : <%=id %></p>
						<p>Your Name : <input class="field" type="text" name="name" value="<%=name %>"></input></p>
						<p>Your User ID : <%=userid %></p>
						<p>Your Gedner : <input class="field" type="text" name="gender" value="<%=gender %>"></input></p>
						<p>Your Mail ID : <input class="field" type="text" name="email" value="<%=email %>"></input></p>
						<p>Your Cell N0 : <input class="field" type="text" name="phone" value="<%=phone %>"></input></p>
						<p>Your Address : <input class="field" type="text" name="add" value="<%=add %>"></input></p>
						<p>Your City : <input class="field" type="text" name="city" value="<%=city %>"></input></p>
					</div>
					</form>
				<%
			}
		%>
</body>
</html>