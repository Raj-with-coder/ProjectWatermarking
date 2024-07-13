<%@ page import="com.nits.util.*" %>
<%@ page import="java.sql.*" %>
<html>
<%
	String admin=Utility.parse1(request.getAttribute("admin"));
	ResultSet rs=(ResultSet)request.getAttribute("rs");
	int no=Utility.parse(request.getParameter("no"));
	int id=0;
	String adminid="",name="",add="",email="",phone="";
	if(no==0)
	while(rs.next())
	{
		id=rs.getInt(1);
		adminid=rs.getString(4);
		name=rs.getString(2);
		add=rs.getString(5);
		email=rs.getString(7);
		phone=rs.getString(6);
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
					<form id="login" action="<%=request.getContextPath() %>/EditProfile1">
					<input type="hidden" name="admin" value="<%=admin %>"></input>
					<input type="hidden" name="no" value="2"></input>
					<input type="hidden" name="id" value="<%=id %>"></input>
					<div align="right">
						<input type="submit" value="Save Updates" class="gradientbuttons"/>&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="gradientbuttons" href="<%=request.getContextPath() %>/ChangePass1?name=<%=admin %>&no=1&id=<%=id %>" target="afrm">Change Password</a>
					</div>
					<br></br>
					<div id="a1">
						<p>Your ID No : <%=id %></p>
						<p>Your Name : <input class="field" type="text" name="name" value="<%=name %>"></input></p>
						<p>Your User ID : <%=adminid %></p>
						<p>Your Mail ID : <input class="field" type="text" name="email" value="<%=email %>"></input></p>
						<p>Your Cell N0 : <input class="field" type="text" name="phone" value="<%=phone %>"></input></p>
						<p>Your Address : <input class="field" type="text" name="add" value="<%=add %>"></input></p>
					</div>
					</form>
				<%
			}
		%>
</body>
</html>