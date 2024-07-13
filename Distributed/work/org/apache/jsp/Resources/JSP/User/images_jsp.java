package org.apache.jsp.Resources.JSP.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import com.nits.DAOFactory.*;
import com.nits.util.*;

public final class images_jsp extends org.apache.jasper.runtime.HttpJspBase
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
	String id=request.getParameter("id");
	int count=1;

      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/message.css\" type=\"text/css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/contact.css\" type=\"text/css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/login.css\" type=\"text/css\"/>\r\n");
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
      out.write("/ImageList1\">\r\n");
      out.write("<div align=\"left\">\r\n");
      out.write("\t<input type=\"submit\" name=\"submit\" value=\"Add\" class=\"gradientbuttons\"/>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t<input type=\"submit\" name=\"submit\" value=\"Delete\" class=\"gradientbuttons\"/>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t<input type=\"hidden\" name=\"id\" value=\"");
      out.print(id );
      out.write("\"></input>\r\n");
      out.write("</div>\r\n");
      out.write("\t<table id=\"results\" class=\"tab\" style=\"width:400px;\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th>Select</th>\r\n");
      out.write("\t\t<th>Image</th>\r\n");
      out.write("\t\t<th>User ID</th>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t");

	if(rs!=null)
		while(rs.next())
		{
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td><input name=\"chk\" type=\"checkbox\" value=\"");
      out.print(rs.getInt(1) );
      out.write('"');
      out.write('>');
      out.print(count++ );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td><img src=\"");
      out.print(request.getContextPath());
      out.write("/Resources/Images/Secret_Images/");
      out.print(rs.getString(2) );
      out.write("\" height=\"50\" width=\"50\"></img></td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(rs.getString(3) );
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
      out.write("    \t\t<p>Image Added Successfully.....!</p>\r\n");
      out.write("    \t</div>\t\t\t\r\n");
      out.write("    ");
}
	if(Utility.parse(request.getParameter("no"))==-1)
	{
      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:10px;left:300px\">\t\r\n");
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
	if(Utility.parse(request.getParameter("no"))==5)
	{
      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:10px;left:300px\">\t\r\n");
      out.write("\t\t\t<p>Opp's select only one.....!</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");
      out.write("\t");
}
	if(Utility.parse(request.getParameter("no"))==3)
	{
      out.write("\r\n");
      out.write("\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:10px;left:300px\">\t\r\n");
      out.write("\t\t\t<p>Image Deleted Successfully.....!</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");
      out.write("\t");
}
	if(Utility.parse(request.getParameter("no"))==6)
	{
      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:10px;left:300px\">\t\r\n");
      out.write("\t\t\t<p>Sorry This image already Allocated.....!</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");
      out.write("\t");
}
	if(Utility.parse(request.getParameter("no"))==8)
	{
      out.write("\r\n");
      out.write("\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:10px;left:300px\">\t\r\n");
      out.write("\t\t\t<p>Image has allocated successfully.....!</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");
      out.write("\t");
}
	if(Utility.parse(request.getParameter("no"))==4)
	{
      out.write("\r\n");
      out.write("\t\t<form id=\"login\" action=\"");
      out.print(request.getContextPath() );
      out.write("/AddImage1\" enctype=\"multipart/form-data\" method=\"post\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"id\" value=\"");
      out.print(id );
      out.write("\"></input>\r\n");
      out.write("\t\t\t<div class=\"tab\" style=\"position:absolute;top:50px;left:430px;width:300px;\">\r\n");
      out.write("\t\t\t\t<input class=\"field\" type=\"file\" name=\"file\" style=\"width:250px\"></input>\r\n");
      out.write("\t\t\t\t<input class=\"gradientbuttons\" type=\"submit\" value=\"Add Image\" style=\"position:absolute;top:-45px;left:280px;\"/>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t");
}
	if(Utility.parse(request.getParameter("no"))==7)
	{
      out.write("\r\n");
      out.write("\t\t<form id=\"login\" action=\"");
      out.print(request.getContextPath() );
      out.write("/AllocateImage\">\r\n");
      out.write("\t\t\t<div class=\"tab\" style=\"position:absolute;top:50px;left:430px;width:300px;\">\r\n");
      out.write("\t\t\t\t<select class=\"button\" name=\"id\" style=\"width:250px\">\r\n");
      out.write("\t\t\t\t<option value=\"\">~~~~Select User~~~~</option>\r\n");
      out.write("\t\t\t\t");

					String img_id=request.getParameter("img_id");
					ResultSet rs1=(ResultSet)Utility.parse2(request.getAttribute("rs1"));
					if(rs1!=null)
						while(rs1.next())
						{
							
      out.write("<option value=\"");
      out.print(rs1.getString(2));
      out.write('"');
      out.write('>');
      out.print(rs1.getString(2) );
      out.write("</option>");

						}
				
      out.write("\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"img_id\" value=\"");
      out.print(img_id );
      out.write("\"></input>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t<input class=\"gradientbuttons\" type=\"submit\" value=\"Add Image\" style=\"position:absolute;top:-45px;left:280px;\"/>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</form>\r\n");
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
