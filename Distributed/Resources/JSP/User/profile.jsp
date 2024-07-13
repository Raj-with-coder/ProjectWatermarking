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
					<br>
					<div align="right">
						<a class="gradientbuttons" href="<%=request.getContextPath() %>/EditProfile2?name=<%=user %>&no=1" target="afrm">Edit Profile</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="gradientbuttons" href="<%=request.getContextPath() %>/ChangePass2?name=<%=user %>&no=1&id=<%=id %>" target="afrm">Change Password</a>
					</div><br></br>
					<div id="a1">
						<p>Your ID No : <%=id %></p>
						<p>Your Name : <%=name %></p>
						<p>Your User ID : <%=userid %></p>
						<p>Your Mail ID : <%=email %></p>
						<p>Your Cell N0 : <%=phone %></p>
						<p>Your Address : <%=add %></p>
						<p>Your City : <%=city %></p>
					</div>
				<%
				if(Utility.parse(request.getParameter("no1"))==1)
				{
					%>
						<div class="success" id="message">	
							<p>Your profile updated successfully ..!</p>
						</div>
					<%
				}
			}
		%>
</body>
</html>