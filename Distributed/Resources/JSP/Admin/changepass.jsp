<%@ page import="com.nits.util.*" %>
<html>
<head>
	<%
		String admin=Utility.parse1(request.getAttribute("admin"));
		int no=Utility.parse(request.getParameter("no"));
		int id=Utility.parse(request.getParameter("id"));
	%>
	<link href="<%=request.getContextPath() %>/Resources/CSS/message.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/login.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/button.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/style.js"></script>
</head>
<body onload="startTimer()">
	<form id="login" action="<%=request.getContextPath() %>/ChangePass1">
		<input type="hidden" name="admin" value="<%=admin %>"></input>
		<input type="hidden" name="id" value="<%=id %>"></input>
		<input type="hidden" name="no" value="2"></input>
		<div align="right">
			<a class="gradientbuttons" href="<%=request.getContextPath() %>/EditProfile1?name=<%=admin %>&no=1" target="afrm">Edit Profile</a>
			<input type="submit" value="Save Updates" class="gradientbuttons"/>&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		<br></br>
	<div id="a1">
		<p>Your ID  : <%=admin %></p>
		<p>Current Password : <input class="field" type="password" name="pass"></input></p>
		<p>New Password : <input class="field" type="password" name="npass"></input></p>
		<p>Confirm new password : <input class="field" type="password" name="cpass"></input></p>
	</div>
<%
if(no==1)
{
	%>
		<div class="error" id="message">	
			<p>Opp's,your current password is wrong ..!</p>
		</div>
	<%
}
if(no==2)
{
	%>
		<div class="error" id="message">	
			<p>Opp's,your new password do not match with confirm password ..!</p>
		</div>
	<%
}
if(no==3)
{
	%>
		<div class="error" id="message">	
			<p>Opp's,Seems something went wrong....!</p>
		</div>
	<%
}
%>	
	
</body>
</html>