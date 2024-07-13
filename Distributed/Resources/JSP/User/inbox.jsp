<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.nits.util.*" %>
<html>
<%
	ResultSet rs=(ResultSet)Utility.parse2(request.getAttribute("rs"));
	String id=request.getParameter("name");
%>
<head>
<script type="text/javascript">
	function showImg(){
	var image = document.getElementById("img");
	var dropd = document.getElementById("dd");
	image.src = dropd.value;	
};
function showImg1(){
	var image = document.getElementById("img1");
	var dropd = document.getElementById("dd1");
	image.src = dropd.value;	
};
</script>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Resources/CSS/message.css" type="text/css"/>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Resources/CSS/contact.css" type="text/css"/>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Resources/CSS/button.css" type="text/css"/>
	<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/pagination.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/style.js"></script>
</head>
<body onload="startTimer()">
<form action="<%=request.getContextPath() %>/Inbox">
<div align="left">
	<input type="submit" name="submit" value="Create" class="gradientbuttons"/>&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="submit" name="submit" value="Extract" class="gradientbuttons"/>&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="submit" name="submit" value="Delete" class="gradientbuttons"/>&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="hidden" name="name" value="<%=id %>"></input>
</div>
	<table id="results" class="tab" style="padding:10px;width:600px" border="0">
	<tr>
		<th>Select</th>
		<th>From</th>
		<th>Subject</th>
		<th>Image</th>
		<th>Day</th>
		<th>Time</th>
		<th>Date</th>
	</tr>
	<%
	if(rs!=null)
		while(rs.next())
		{%>
			<tr>
				<td id="td"><input name="chk" type="checkbox" value="<%=rs.getInt(1) %>"></td>
						<td id="td"><%=rs.getString(2) %></td>
						<td id="td"><%=rs.getString(5) %></td>
						<td><img src="<%=request.getContextPath()%>/Resources/Images/Messages/<%=rs.getString(4) %>" height="100" width="100"></img></td>
						<td id="td"><%=rs.getString(8) %></td>
						<td id="td"><%=rs.getString(7) %></td>
						<td id="td"><%=rs.getString(6) %></td>
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
    		<p>Hidden Message Created Successfully.....!</p>
    	</div>			
    <%}
	if(Utility.parse(request.getParameter("no"))==-1)
	{%>
		<div class="success" id="message" style="position:absolute;top:10px;left:300px">	
			<p>Opp's something went wrong.....!</p>
		</div>			
	<%}
	if(Utility.parse(request.getParameter("no"))==2)
	{%>
		<div class="error" id="message" style="position:absolute;top:10px;left:300px">	
			<p>Opp's select atleast one.....!</p>
		</div>			
	<%}
	if(Utility.parse(request.getParameter("no"))==3)
	{%>
		<div class="success" id="message" style="position:absolute;top:10px;left:300px">	
			<p>Message Deleted Successfully.....!</p>
		</div>			
	<%}
	if(Utility.parse(request.getParameter("no"))==4)
	{%>
		<div class="error" id="message" style="position:absolute;top:10px;left:300px">	
			<p>Opp's Select only one....!</p>
		</div>			
	<%}
	if(Utility.parse(request.getParameter("no"))==5)
	{%>
		<div class="success" id="message" style="position:absolute;top:10px;left:300px">	
			<p>User Updated Successfully....!</p>
		</div>			
	<%}
	if(Utility.parse(request.getParameter("no"))==6)
	{
		String img1=request.getContextPath()+"/Resources/Images/main.jpg";
		String img2=request.getContextPath()+"/Resources/Images/secret.jpg";
		ResultSet rs1=(ResultSet)Utility.parse2(request.getAttribute("rs1"));
		ResultSet rs2=(ResultSet)Utility.parse2(request.getAttribute("rs2"));
		ResultSet rs3=(ResultSet)Utility.parse2(request.getAttribute("rs3"));
		%>
		<form id="login" style="position:absolute;top:50px;left:650px" action="<%=request.getContextPath() %>/HideProcess">
			<input type="hidden" name="name" value="<%=id %>"></input>
			<select name="select1" class="button" id="dd" onChange="showImg()">
				<option value="<%=img1 %>">Select Image</option>
				<%
				if(rs!=null)
					while(rs1.next())
					{%>
						<option value="<%=request.getContextPath()%>/Resources/Images/Input_Images/<%=rs1.getString(1) %>"><%=rs1.getString(1) %></option>
					<%}
				%>
			</select>
			<select name="select2" class="button" id="dd1" onChange="showImg1()">
				<option value="<%=img2 %>">Select Image</option>
				<%
				if(rs!=null)
					while(rs2.next())
					{%>
						<option value="<%=request.getContextPath()%>/Resources/Images/Secret_Images/<%=rs2.getString(1) %>"><%=rs2.getString(1) %></option>
					<%}
				%>
			</select>
			<select name="select3" class="button">
				<option value="No_User">Select User</option>
				<%
				if(rs!=null)
					while(rs3.next())
					{%>
						<option value="<%=rs3.getString(2) %>"><%=rs3.getString(2) %></option>
					<%}
				%>
			</select>
			<br>
			Subject<br><textarea rows="2" cols="15" name="sub"></textarea>
			<br></br>
			<!-- Enter Secret Message<br><textarea rows="2" cols="24" name="sub"></textarea>
			<br></br> -->

			<input type="submit" name="submit" value="Hide & Send" class="gradientbuttons"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<img style="position:absolute;top:300px;left:-500px" id="img" src="<%=request.getContextPath()%>/Resources/Images/main.jpg" height="100" width="100"/>
			<img style="position:absolute;top:300px;left:-300px" id="img1" src="<%=request.getContextPath()%>/Resources/Images/secret.jpg" height="100" width="100"/>
		</form>		
	<%
	if(Utility.parse(request.getParameter("no1"))==101)
	{%>
		<div class="error" id="message" style="position:absolute;top:10px;left:300px">	
			<p>Opp's select the all the values.....!</p>
		</div>			
	<%}
	if(Utility.parse(request.getParameter("no1"))==102)
	{%>
		<div class="error" id="message" style="position:absolute;top:10px;left:300px">	
			<p>Opp's Your Main Image Is Greater Than Secret Image.....!</p>
		</div>			
	<%}
	}
	if(Utility.parse(request.getParameter("no"))==7)
	{
	 
		//String dec_path=request.getParameter("dec_path");
		/*String temp="file:///";
		temp=temp+dec_path;
		System.out.println(temp);
		*/
		
	%>
	
	<% 
	/* String hash1 = session.getAttribute("hashTag1").toString();
	String hash2 = session.getAttribute("hashTag2").toString();
	
	if(hash1.equals(hash2))
	{ */
	%>
		<script type="text/javascript">
		alert("Secret image extracted successfully");
		</script>
	
		<h1>Your Secret Image Extracted Successfully...... </h1>
		
		 <div style="position:absolute;top:50px;left:650px">
			<img src="<%=request.getContextPath()%>/Resources/Images/Dec_Sec_Img/Dec_Img.jpg" height="150" width="150"></img> 
		 </div> 
	
	
	
	
	
	<%-- <script type="text/javascript">
		alert("Secret image extracted successfully");
	</script>
	
		<h1>Your Secret Image Extracted Successfully...... </h1>
		
		 <div style="position:absolute;top:50px;left:650px">
			<img src="<%=request.getContextPath()%>/Resources/Images/Dec_Sec_Img/Dec_Img.jpg" height="150" width="150"></img> 
		 </div>  --%>
		
	<%
	}
%>		
</body>
</html>