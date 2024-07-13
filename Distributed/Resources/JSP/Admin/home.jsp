<html>
<%
	String admin=request.getAttribute("admin").toString();
%>
<script language="JavaScript">
javascript:window.history.forward(-1);
</script>

<head>
	<link href="<%=request.getContextPath() %>/Resources/CSS/style.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Resources/CSS/button.css" type="text/css"/>
</head>
<body>

<div style="position:relative;top:0px;left:0px;">	
	<div align="right" class="gradientbuttons">
		<a class="gradientlinks" href="<%=request.getContextPath() %>/AdminProfile?name=<%=admin %>" target="afrm" ><label style="color: white;"> Show Profile</a>
		<a class="gradientlinks" href="<%=request.getContextPath() %>/UserList?submit=get" target="afrm"><label style="color: white;"> User List&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
		<a class="gradientlinks" href="<%=request.getContextPath() %>/ImageList?submit=get" target="afrm"><label style="color: white;"> Image Management</a>
		<a class="gradientlinks" href="<%=request.getContextPath() %>/"><label style="color: white;"> Sign Out&nbsp;&nbsp;&nbsp;&nbsp;</a>
	</div>
<br>
<center>
<img src="<%=request.getContextPath() %>/Resources/Images/cooltext3.png" width="100%"></img>
</center>
	
</div>
	
	
	<div style="position:absolute;top:180px;left:50px;">
		<iframe frameborder="0" scrolling="auto" name="afrm" height="475" width="1055"></iframe>
	</div>
</body>
</html>