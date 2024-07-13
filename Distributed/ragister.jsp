<%@ page import="com.nits.util.*" %>
<html>
<head>
	<%-- <link href="<%=request.getContextPath() %>/Resources/CSS/style.css" rel="stylesheet" type="text/css" /> --%>
	<link href="<%=request.getContextPath() %>/Resources/CSS/message.css" rel="stylesheet" type="text/css" /> 
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Resources/CSS/login.css" type="text/css"/>
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


<%-- <div class="TabMenu" id="label">			
	<span>
		<img src="<%=request.getContextPath() %>/Resources/Images/user.png" height="50" width="50" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<br>Admin
	</span>
	<span>
		<img src="<%=request.getContextPath() %>/Resources/Images/user.png" height="50" width="50" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<br>User
	</span>
</div> --%>
	
	<br>
	<%-- <div class="ContentFrame">
		<div class="AllTabs">
			<div class="TabContent">
				<p><h2>Admin Login</h2>
					<form method="post" id="login" action="<%=request.getContextPath() %>/AdminLogin">
						Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="field" name="name" type="text" required="yes"/><br><br>
						Password<input class="field" name="pass" type="password" required="yes"/><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input class="button" type="submit"/>
					</form>
				</p>
			</div>
			<div class="TabContent">
				<p><h2>User Login</h2>
					<form method="post" id="login" action="<%=request.getContextPath() %>/UserLogin">
						Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="field" name="name" type="text" required="yes"/><br><br>
						Password<input class="field" name="pass" type="password" required="yes"/><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input class="button" type="submit"/>
						<pre>No Account ? <a href="<%=request.getContextPath() %>?no=2">Sign up here</a></pre>	
					</form>
				</p>
			</div>
		</div>
	</div>
	
	
	 --%>
	
	
	
	

  
  <title>Login Form</title>
  <link href="<%=request.getContextPath() %>/Resources/CSS/style-2.css" rel="stylesheet" type="text/css" />
  <!-- <link rel="stylesheet" href="css/style-2.css"> -->
  
</head>
<body>
	<body onload="startTimer()">
	<center>
	<img src="<%=request.getContextPath() %>/Resources/Images/cooltext3.png"></img>
</center>

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
			<h2 style=" size: 100px " align="center">User Registeration</h2>
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
</body>
</html>