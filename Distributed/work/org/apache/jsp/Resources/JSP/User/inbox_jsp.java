package org.apache.jsp.Resources.JSP.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;
import com.nits.util.*;

public final class inbox_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");

	ResultSet rs=(ResultSet)Utility.parse2(request.getAttribute("rs"));
	String id=request.getParameter("name");

      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction showImg(){\r\n");
      out.write("\tvar image = document.getElementById(\"img\");\r\n");
      out.write("\tvar dropd = document.getElementById(\"dd\");\r\n");
      out.write("\timage.src = dropd.value;\t\r\n");
      out.write("};\r\n");
      out.write("function showImg1(){\r\n");
      out.write("\tvar image = document.getElementById(\"img1\");\r\n");
      out.write("\tvar dropd = document.getElementById(\"dd1\");\r\n");
      out.write("\timage.src = dropd.value;\t\r\n");
      out.write("};\r\n");
      out.write("</script>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/message.css\" type=\"text/css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/contact.css\" type=\"text/css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/button.css\" type=\"text/css\"/>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/JS/pagination.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/JS/style.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");
      out.write("<form action=\"");
      out.print(request.getContextPath() );
      out.write("/Inbox\">\r\n");
      out.write("<div align=\"left\">\r\n");
      out.write("\t<input type=\"submit\" name=\"submit\" value=\"Create\" class=\"gradientbuttons\"/>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t<input type=\"submit\" name=\"submit\" value=\"Extract\" class=\"gradientbuttons\"/>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t<input type=\"submit\" name=\"submit\" value=\"Delete\" class=\"gradientbuttons\"/>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t<input type=\"hidden\" name=\"name\" value=\"");
      out.print(id );
      out.write("\"></input>\r\n");
      out.write("</div>\r\n");
      out.write("\t<table id=\"results\" class=\"tab\" style=\"padding:10px;width:600px\" border=\"0\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th>Select</th>\r\n");
      out.write("\t\t<th>From</th>\r\n");
      out.write("\t\t<th>Subject</th>\r\n");
      out.write("\t\t<th>Image</th>\r\n");
      out.write("\t\t<th>Day</th>\r\n");
      out.write("\t\t<th>Time</th>\r\n");
      out.write("\t\t<th>Date</th>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t");

	if(rs!=null)
		while(rs.next())
		{
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td id=\"td\"><input name=\"chk\" type=\"checkbox\" value=\"");
      out.print(rs.getInt(1) );
      out.write("\"></td>\r\n");
      out.write("\t\t\t\t\t\t<td id=\"td\">");
      out.print(rs.getString(2) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td id=\"td\">");
      out.print(rs.getString(5) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td><img src=\"");
      out.print(request.getContextPath());
      out.write("/Resources/Images/Messages/");
      out.print(rs.getString(4) );
      out.write("\" height=\"100\" width=\"100\"></img></td>\r\n");
      out.write("\t\t\t\t\t\t<td id=\"td\">");
      out.print(rs.getString(8) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td id=\"td\">");
      out.print(rs.getString(7) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td id=\"td\">");
      out.print(rs.getString(6) );
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t");
}
	
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("<div id=\"pageNavPosition\" style=\"cursor:hand\"></div>\r\n");
      out.write("<script type=\"text/javascript\"><!--\r\n");
      out.write("        var pager = new Pager('results', 2); \r\n");
      out.write("        pager.init(); \r\n");
      out.write("        pager.showPageNav('pager', 'pageNavPosition'); \r\n");
      out.write("        pager.showPage(1);\r\n");
      out.write("    //--></script>\r\n");

	if(Utility.parse(request.getParameter("no"))==1)
    {
      out.write("\r\n");
      out.write("    \t<div class=\"success\" id=\"message\" style=\"position:absolute;top:10px;left:300px\">\t\r\n");
      out.write("    \t\t<p>Hidden Message Created Successfully.....!</p>\r\n");
      out.write("    \t</div>\t\t\t\r\n");
      out.write("    ");
}
	if(Utility.parse(request.getParameter("no"))==-1)
	{
      out.write("\r\n");
      out.write("\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:10px;left:300px\">\t\r\n");
      out.write("\t\t\t<p>Opp's something went wrong.....!</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");
      out.write("\t");
}
	if(Utility.parse(request.getParameter("no"))==2)
	{
      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:10px;left:300px\">\t\r\n");
      out.write("\t\t\t<p>Opp's select atleast one.....!</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");
      out.write("\t");
}
	if(Utility.parse(request.getParameter("no"))==3)
	{
      out.write("\r\n");
      out.write("\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:10px;left:300px\">\t\r\n");
      out.write("\t\t\t<p>Message Deleted Successfully.....!</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");
      out.write("\t");
}
	if(Utility.parse(request.getParameter("no"))==4)
	{
      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:10px;left:300px\">\t\r\n");
      out.write("\t\t\t<p>Opp's Select only one....!</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");
      out.write("\t");
}
	if(Utility.parse(request.getParameter("no"))==5)
	{
      out.write("\r\n");
      out.write("\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:10px;left:300px\">\t\r\n");
      out.write("\t\t\t<p>User Updated Successfully....!</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");
      out.write("\t");
}
	if(Utility.parse(request.getParameter("no"))==6)
	{
		String img1=request.getContextPath()+"/Resources/Images/main.jpg";
		String img2=request.getContextPath()+"/Resources/Images/secret.jpg";
		ResultSet rs1=(ResultSet)Utility.parse2(request.getAttribute("rs1"));
		ResultSet rs2=(ResultSet)Utility.parse2(request.getAttribute("rs2"));
		ResultSet rs3=(ResultSet)Utility.parse2(request.getAttribute("rs3"));
		
      out.write("\r\n");
      out.write("\t\t<form id=\"login\" style=\"position:absolute;top:50px;left:650px\" action=\"");
      out.print(request.getContextPath() );
      out.write("/HideProcess\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"name\" value=\"");
      out.print(id );
      out.write("\"></input>\r\n");
      out.write("\t\t\t<select name=\"select1\" class=\"button\" id=\"dd\" onChange=\"showImg()\">\r\n");
      out.write("\t\t\t\t<option value=\"");
      out.print(img1 );
      out.write("\">Select Image</option>\r\n");
      out.write("\t\t\t\t");

				if(rs!=null)
					while(rs1.next())
					{
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<option value=\"");
      out.print(request.getContextPath());
      out.write("/Resources/Images/Input_Images/");
      out.print(rs1.getString(1) );
      out.write('"');
      out.write('>');
      out.print(rs1.getString(1) );
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t");
}
				
      out.write("\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t\t<select name=\"select2\" class=\"button\" id=\"dd1\" onChange=\"showImg1()\">\r\n");
      out.write("\t\t\t\t<option value=\"");
      out.print(img2 );
      out.write("\">Select Image</option>\r\n");
      out.write("\t\t\t\t");

				if(rs!=null)
					while(rs2.next())
					{
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<option value=\"");
      out.print(request.getContextPath());
      out.write("/Resources/Images/Secret_Images/");
      out.print(rs2.getString(1) );
      out.write('"');
      out.write('>');
      out.print(rs2.getString(1) );
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t");
}
				
      out.write("\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t\t<select name=\"select3\" class=\"button\">\r\n");
      out.write("\t\t\t\t<option value=\"No_User\">Select User</option>\r\n");
      out.write("\t\t\t\t");

				if(rs!=null)
					while(rs3.next())
					{
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<option value=\"");
      out.print(rs3.getString(2) );
      out.write('"');
      out.write('>');
      out.print(rs3.getString(2) );
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t");
}
				
      out.write("\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t\t<br>\r\n");
      out.write("\t\t\tSubject<br><textarea rows=\"2\" cols=\"15\" name=\"sub\"></textarea>\r\n");
      out.write("\t\t\t<br></br>\r\n");
      out.write("\t\t\t<!-- Enter Secret Message<br><textarea rows=\"2\" cols=\"24\" name=\"sub\"></textarea>\r\n");
      out.write("\t\t\t<br></br> -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t<input type=\"submit\" name=\"submit\" value=\"Hide & Send\" class=\"gradientbuttons\"/>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t<img style=\"position:absolute;top:300px;left:-500px\" id=\"img\" src=\"");
      out.print(request.getContextPath());
      out.write("/Resources/Images/main.jpg\" height=\"100\" width=\"100\"/>\r\n");
      out.write("\t\t\t<img style=\"position:absolute;top:300px;left:-300px\" id=\"img1\" src=\"");
      out.print(request.getContextPath());
      out.write("/Resources/Images/secret.jpg\" height=\"100\" width=\"100\"/>\r\n");
      out.write("\t\t</form>\t\t\r\n");
      out.write("\t");

	if(Utility.parse(request.getParameter("no1"))==101)
	{
      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:10px;left:300px\">\t\r\n");
      out.write("\t\t\t<p>Opp's select the all the values.....!</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");
      out.write("\t");
}
	if(Utility.parse(request.getParameter("no1"))==102)
	{
      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:10px;left:300px\">\t\r\n");
      out.write("\t\t\t<p>Opp's Your Main Image Is Greater Than Secret Image.....!</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");
      out.write("\t");
}
	}
	if(Utility.parse(request.getParameter("no"))==7)
	{
	 
		//String dec_path=request.getParameter("dec_path");
		/*String temp="file:///";
		temp=temp+dec_path;
		System.out.println(temp);
		*/
		
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t");
 
	/* String hash1 = session.getAttribute("hashTag1").toString();
	String hash2 = session.getAttribute("hashTag2").toString();
	
	if(hash1.equals(hash2))
	{ */
	
      out.write("\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\talert(\"Secret image extracted successfully\");\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\r\n");
      out.write("\t\t<h1>Your Secret Image Extracted Successfully...... </h1>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t <div style=\"position:absolute;top:50px;left:650px\">\r\n");
      out.write("\t\t\t<img src=\"");
      out.print(request.getContextPath());
      out.write("/Resources/Images/Dec_Sec_Img/Dec_Img.jpg\" height=\"150\" width=\"150\"></img> \r\n");
      out.write("\t\t </div> \r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t");

	}

      out.write("\t\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
