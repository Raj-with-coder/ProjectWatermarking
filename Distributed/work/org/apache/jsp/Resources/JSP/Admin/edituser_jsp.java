package org.apache.jsp.Resources.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.nits.util.*;
import java.sql.*;

public final class edituser_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\r\n");

	ResultSet rs=(ResultSet)request.getAttribute("rs");
	int id=0;
	String userid="",add="",cno="",city="",name="",email="";
	while(rs.next())
	{
		id=rs.getInt(1);
		userid=rs.getString(2);
		name=rs.getString(4);
		add=rs.getString(6);
		city=rs.getString(7);
		email=rs.getString(8);
		cno=rs.getString(9);
	}

      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/message.css\" rel=\"stylesheet\" type=\"text/css\" /> \r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/login.css\" type=\"text/css\"/>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/JS/style.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");
      out.write("<div style=\"position:absolute;top:-20px;left:100\" class=\"c\">\t\r\n");
      out.write("\t<table id=\"login\">\r\n");
      out.write("\t\t\t<h1 align=\"center\" id=\"label\">Edit User</h1>\r\n");
      out.write("\t\t\t<hr size=\"10\" color=\"#5E74D8\"></hr>\r\n");
      out.write("\t\t\t<form action=\"");
      out.print(request.getContextPath() );
      out.write("/UserList\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"submit\" value=\"Edit\"></input>\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"edit1\" value=\"YES\"></input>\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"id\" value=\"");
      out.print(id );
      out.write("\"></input>\r\n");
      out.write("\t\t\t\t<tr id=\"label\">\r\n");
      out.write("\t\t\t\t\t<td>User-ID</td>\r\n");
      out.write("\t\t\t\t\t<td><input class=\"field\" value=\"");
      out.print(userid );
      out.write("\" name=\"id\" type=\"text\" readonly/></td>\r\n");
      out.write("\t\t\t\t\t<td>Address</td>\r\n");
      out.write("\t\t\t\t\t<td><input class=\"field\" value=\"");
      out.print(add );
      out.write("\" name=\"add\" type=\"text\" required=\"yes\"/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr id=\"label\">\r\n");
      out.write("\t\t\t\t\t<td>Contact No</td>\r\n");
      out.write("\t\t\t\t\t<td><input class=\"field\" value=\"");
      out.print(cno );
      out.write("\" name=\"cno\" type=\"text\" required=\"yes\"/></td>\r\n");
      out.write("\t\t\t\t\t<td>City</td>\r\n");
      out.write("\t\t\t\t\t<td><input class=\"field\" value=\"");
      out.print(city );
      out.write("\" name=\"city\" type=\"text\" required=\"yes\"/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr id=\"label\">\r\n");
      out.write("\t\t\t\t\t<td>Name</td>\r\n");
      out.write("\t\t\t\t\t<td><input class=\"field\" value=\"");
      out.print(name );
      out.write("\" name=\"name\" type=\"text\" required=\"yes\"/></td>\r\n");
      out.write("\t\t\t\t\t<td>Emai-ID</td>\r\n");
      out.write("\t\t\t\t\t<td><input class=\"field\" value=\"");
      out.print(email );
      out.write("\" name=\"email\" type=\"text\" required=\"yes\"/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t<td><input class=\"button\" type=\"submit\" value=\"Register\"/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</table>\r\n");
      out.write("</div>\t\t\r\n");

if(Utility.parse(request.getParameter("no"))==1)
{
      out.write("\r\n");
      out.write("\t<div class=\"error\" id=\"message\" style=\"position:absolute\">\t\r\n");
      out.write("\t\t<p>Sorry this user id is already exists.....!</p>\r\n");
      out.write("\t</div>\t\t\t\r\n");
}

      out.write("\r\n");
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
