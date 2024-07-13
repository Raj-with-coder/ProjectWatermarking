<%@ page import="java.sql.*" %>
<%@ page import="com.nits.DAOFactory.*" %>
<%@ page import="com.nits.util.*" %>
<html>
<%
	ResultSet rs=(ResultSet)Utility.parse2(request.getAttribute("rs"));
	String id=request.getParameter("id");
	int count=1;
%>
<head>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Resources/CSS/message.css" type="text/css"/>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Resources/CSS/contact.css" type="text/css"/>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Resources/CSS/login.css" type="text/css"/>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Resources/CSS/button.css" type="text/css"/>
	<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/pagination.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/style.js"></script>
</head>
<body onload="startTimer()">
<form action="<%=request.getContextPath() %>/ImageList1">
<div align="left">
	<input type="submit" name="submit" value="Add" class="gradientbuttons"/>&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="submit" name="submit" value="Delete" class="gradientbuttons"/>&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="hidden" name="id" value="<%=id %>"></input>
</div>
	<table id="results" class="tab" style="width:400px;">
	<tr>
		<th>Select</th>
		<th>Image</th>
		<th>User ID</th>
	</tr>
	<%
	if(rs!=null)
		while(rs.next())
		{%>
			<tr>
				<td><input name="chk" type="checkbox" value="<%=rs.getInt(1) %>"><%=count++ %></td>
						<td><img src="<%=request.getContextPath()%>/Resources/Images/Secret_Images/<%=rs.getString(2) %>" height="50" width="50"></img></td>
						<td><%=rs.getString(3) %></td>
			</tr>
		<%}
	%>
</table>
</form>
<div id="pageNavPosition" style="cursor:hand"></div>
<script type="text/javascript"><!--
        var pager = new Pager('results', 2); 
        pager.init(); 
        pager.showPageNav('pager', 'pageNavPosition'); 
        pager.showPage(1);
    //--></script>
<%
	if(Utility.parse(request.getParameter("no"))==1)
    {%>
    	<div class="success" id="message" style="position:absolute;top:10px;left:300px">	
    		<p>Image Added Successfully.....!</p>
    	</div>			
    <%}
	if(Utility.parse(request.getParameter("no"))==-1)
	{%>
		<div class="error" id="message" style="position:absolute;top:10px;left:300px">	
			<p>Opp's something went wrong.....!</p>
		</div>			
	<%}
	if(Utility.parse(request.getParameter("no"))==2)
	{%>
		<div class="error" id="message" style="position:absolute;top:10px;left:300px">	
			<p>Opp's select atleast one.....!</p>
		</div>			
	<%}
	if(Utility.parse(request.getParameter("no"))==5)
	{%>
		<div class="error" id="message" style="position:absolute;top:10px;left:300px">	
			<p>Opp's select only one.....!</p>
		</div>			
	<%}
	if(Utility.parse(request.getParameter("no"))==3)
	{%>
		<div class="success" id="message" style="position:absolute;top:10px;left:300px">	
			<p>Image Deleted Successfully.....!</p>
		</div>			
	<%}
	if(Utility.parse(request.getParameter("no"))==6)
	{%>
		<div class="error" id="message" style="position:absolute;top:10px;left:300px">	
			<p>Sorry This image already Allocated.....!</p>
		</div>			
	<%}
	if(Utility.parse(request.getParameter("no"))==8)
	{%>
		<div class="success" id="message" style="position:absolute;top:10px;left:300px">	
			<p>Image has allocated successfully.....!</p>
		</div>			
	<%}
	if(Utility.parse(request.getParameter("no"))==4)
	{%>
		<form id="login" action="<%=request.getContextPath() %>/AddImage1" enctype="multipart/form-data" method="post">
			<input type="hidden" name="id" value="<%=id %>"></input>
			<div class="tab" style="position:absolute;top:50px;left:430px;width:300px;">
				<input class="field" type="file" name="file" style="width:250px"></input>
				<input class="gradientbuttons" type="submit" value="Add Image" style="position:absolute;top:-45px;left:280px;"/>
			</div>
			
		</form>
	<%}
	if(Utility.parse(request.getParameter("no"))==7)
	{%>
		<form id="login" action="<%=request.getContextPath() %>/AllocateImage">
			<div class="tab" style="position:absolute;top:50px;left:430px;width:300px;">
				<select class="button" name="id" style="width:250px">
				<option value="">~~~~Select User~~~~</option>
				<%
					String img_id=request.getParameter("img_id");
					ResultSet rs1=(ResultSet)Utility.parse2(request.getAttribute("rs1"));
					if(rs1!=null)
						while(rs1.next())
						{
							%><option value="<%=rs1.getString(2)%>"><%=rs1.getString(2) %></option><%
						}
				%>
				<input type="hidden" name="img_id" value="<%=img_id %>"></input>
				</select>
				<input class="gradientbuttons" type="submit" value="Add Image" style="position:absolute;top:-45px;left:280px;"/>
			</div>
			
		</form>
	<%}
%>		
</body>
</html>