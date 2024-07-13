<%@ page import="com.nits.util.*" %>
<html>
<head>
	<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/style.js"></script>
	<script src="<%=request.getContextPath() %>/Resources/JS/jquery-1.6.4.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function()
			{
				$(".TabMenu span:first").addClass("selector");
				$(".TabMenu span").mouseover(function()
					{
						$(this).addClass("hovering");
					});
				$(".TabMenu span").mouseout(function()
					{
						$(this).removeClass("hovering");
					});				
				$(".TabMenu span").click(function()
					{
						$(".selector").removeClass("selector");
						$(this).addClass("selector");
						var TabWidth = $(".TabContent:first").width();
						if(parseInt($(".TabContent:first").css("margin-left")) > 0)
							TabWidth += parseInt($(".TabContent:first").css("margin-left"));
						if(parseInt($(".TabContent:first").css("margin-right")) >0)
							TabWidth += parseInt($(".TabContent:first").css("margin-right"));
						var newLeft = -1* $("span").index(this) * TabWidth;
						$(".AllTabs").animate({
							left: + newLeft + "px"},1000);
					});
			});
</script>

  <title>Login Form</title>
  <link href="<%=request.getContextPath() %>/Resources/CSS/style-2.css" rel="stylesheet" type="text/css" />
  <link href="<%=request.getContextPath() %>/Resources/CSS/style.css" rel="stylesheet" type="text/css" />
 
</head>
<body>
	<body onload="startTimer()">
	<center>
	<img src="<%=request.getContextPath() %>/Resources/Images/cooltext3.png" width="100%"></img>
</center>
  <form method="post" class="login" action="<%=request.getContextPath() %>/AdminLogin">
    <h1>Admin Login</h1>
    <input type="text" name="name" class="login-input" placeholder="Admin id" required="yes" autofocus>
    <input type="password" name="pass" class="login-input" placeholder="Password">
    <input type="submit" value="Login" class="login-submit">
    <p class="login-help"><a href="index2.jsp">User Login</a></p>
  </form>
	
	<%	
		int no=Utility.parse(request.getParameter("no"));
		if(no==1)
		{%>
			<div class="error" id="message">	
				<p>Opp's,Invalid userid / password..!</p>
			</div>			
		<%}
		if(no==3)
		{%>
			<div class="error" id="message">	
				<p>Opp's,Something went wrong ..!</p>
			</div>			
		<%}
		if(no==4)
		{%>
			<div class="success" id="message">	
				<p>You have registered successfully!</p>
			</div>			
		<%}
	%>

<%
	if(no==2)
	{%>
		<div style="position:absolute;top:170px;left:210" class="c">	
		<%
			if(Utility.parse(request.getParameter("no1"))==5)
			{%>
				<div class="error" id="message" style="position:absolute">	
					<p>Sorry this user id is already exists.....!</p>
				</div>			
			<%}
		%>
			<table id="login">
			<h1 align="center" id="label">User Registeration</h1>
			<hr size="10" color="#5E74D8"></hr>
			<form method="post" action="<%=request.getContextPath() %>/UserRegister">
				<tr id="label">
					<td>User-ID</td>
					<td><input class="field" name="id" type="text" required="yes"/></td>
					<td>Address</td>
					<td><input class="field" name="add" type="text" required="yes"/></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr id="label">
					<td>Password</td>
					<td><input class="field" name="pass" type="password" required="yes"/></td>
					<td>City</td>
					<td><input class="field" name="city" type="text" required="yes"/></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr id="label">
					<td>Name</td>
					<td><input class="field" name="name" type="text" required="yes"/></td>
					<td>Emai-ID</td>
					<td><input class="field" name="email" type="text" required="yes"/></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr id="label">
					<td>&nbsp;</td>
					<td>
						&nbsp;&nbsp;&nbsp;Male<input name="gender" value="Male" type="radio" checked="true"/>
						&nbsp;&nbsp;&nbsp;Female<input name="gender" value="Female" type="radio"/>
					</td>
					<td>Contact No</td>
					<td><input class="field" name="cno" type="text" required="yes"/></td>
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
	}
	else
	{
		%>
		<div style="position:absolute;top:170px;left:210">
			<p>
				
			</p>
		</div>
		<%
	}
%>

</body>
</html>