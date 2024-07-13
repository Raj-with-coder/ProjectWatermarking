package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.nits.util.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/JS/style.js\"></script>\r\n");
      out.write("\t<script src=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/JS/jquery-1.6.4.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(document).ready(function()\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\t$(\".TabMenu span:first\").addClass(\"selector\");\r\n");
      out.write("\t\t\t\t$(\".TabMenu span\").mouseover(function()\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t$(this).addClass(\"hovering\");\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t$(\".TabMenu span\").mouseout(function()\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t$(this).removeClass(\"hovering\");\r\n");
      out.write("\t\t\t\t\t});\t\t\t\t\r\n");
      out.write("\t\t\t\t$(\".TabMenu span\").click(function()\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t$(\".selector\").removeClass(\"selector\");\r\n");
      out.write("\t\t\t\t\t\t$(this).addClass(\"selector\");\r\n");
      out.write("\t\t\t\t\t\tvar TabWidth = $(\".TabContent:first\").width();\r\n");
      out.write("\t\t\t\t\t\tif(parseInt($(\".TabContent:first\").css(\"margin-left\")) > 0)\r\n");
      out.write("\t\t\t\t\t\t\tTabWidth += parseInt($(\".TabContent:first\").css(\"margin-left\"));\r\n");
      out.write("\t\t\t\t\t\tif(parseInt($(\".TabContent:first\").css(\"margin-right\")) >0)\r\n");
      out.write("\t\t\t\t\t\t\tTabWidth += parseInt($(\".TabContent:first\").css(\"margin-right\"));\r\n");
      out.write("\t\t\t\t\t\tvar newLeft = -1* $(\"span\").index(this) * TabWidth;\r\n");
      out.write("\t\t\t\t\t\t$(\".AllTabs\").animate({\r\n");
      out.write("\t\t\t\t\t\t\tleft: + newLeft + \"px\"},1000);\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("  <title>Login Form</title>\r\n");
      out.write("  <link href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/style-2.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("  <link href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write(" \r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<body onload=\"startTimer()\">\r\n");
      out.write("\t<center>\r\n");
      out.write("\t<img src=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/Images/cooltext3.png\" width=\"100%\"></img>\r\n");
      out.write("</center>\r\n");
      out.write("  <form method=\"post\" class=\"login\" action=\"");
      out.print(request.getContextPath() );
      out.write("/AdminLogin\">\r\n");
      out.write("    <h1>Admin Login</h1>\r\n");
      out.write("    <input type=\"text\" name=\"name\" class=\"login-input\" placeholder=\"Admin id\" required=\"yes\" autofocus>\r\n");
      out.write("    <input type=\"password\" name=\"pass\" class=\"login-input\" placeholder=\"Password\">\r\n");
      out.write("    <input type=\"submit\" value=\"Login\" class=\"login-submit\">\r\n");
      out.write("    <p class=\"login-help\"><a href=\"index2.jsp\">User Login</a></p>\r\n");
      out.write("  </form>\r\n");
      out.write("\t\r\n");
      out.write("\t");
	
		int no=Utility.parse(request.getParameter("no"));
		if(no==1)
		{
      out.write("\r\n");
      out.write("\t\t\t<div class=\"error\" id=\"message\">\t\r\n");
      out.write("\t\t\t\t<p>Opp's,Invalid userid / password..!</p>\r\n");
      out.write("\t\t\t</div>\t\t\t\r\n");
      out.write("\t\t");
}
		if(no==3)
		{
      out.write("\r\n");
      out.write("\t\t\t<div class=\"error\" id=\"message\">\t\r\n");
      out.write("\t\t\t\t<p>Opp's,Something went wrong ..!</p>\r\n");
      out.write("\t\t\t</div>\t\t\t\r\n");
      out.write("\t\t");
}
		if(no==4)
		{
      out.write("\r\n");
      out.write("\t\t\t<div class=\"success\" id=\"message\">\t\r\n");
      out.write("\t\t\t\t<p>You have registered successfully!</p>\r\n");
      out.write("\t\t\t</div>\t\t\t\r\n");
      out.write("\t\t");
}
	
      out.write("\r\n");
      out.write("\r\n");

	if(no==2)
	{
      out.write("\r\n");
      out.write("\t\t<div style=\"position:absolute;top:170px;left:210\" class=\"c\">\t\r\n");
      out.write("\t\t");

			if(Utility.parse(request.getParameter("no1"))==5)
			{
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"error\" id=\"message\" style=\"position:absolute\">\t\r\n");
      out.write("\t\t\t\t\t<p>Sorry this user id is already exists.....!</p>\r\n");
      out.write("\t\t\t\t</div>\t\t\t\r\n");
      out.write("\t\t\t");
}
		
      out.write("\r\n");
      out.write("\t\t\t<table id=\"login\">\r\n");
      out.write("\t\t\t<h1 align=\"center\" id=\"label\">User Registeration</h1>\r\n");
      out.write("\t\t\t<hr size=\"10\" color=\"#5E74D8\"></hr>\r\n");
      out.write("\t\t\t<form method=\"post\" action=\"");
      out.print(request.getContextPath() );
      out.write("/UserRegister\">\r\n");
      out.write("\t\t\t\t<tr id=\"label\">\r\n");
      out.write("\t\t\t\t\t<td>User-ID</td>\r\n");
      out.write("\t\t\t\t\t<td><input class=\"field\" name=\"id\" type=\"text\" required=\"yes\"/></td>\r\n");
      out.write("\t\t\t\t\t<td>Address</td>\r\n");
      out.write("\t\t\t\t\t<td><input class=\"field\" name=\"add\" type=\"text\" required=\"yes\"/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr id=\"label\">\r\n");
      out.write("\t\t\t\t\t<td>Password</td>\r\n");
      out.write("\t\t\t\t\t<td><input class=\"field\" name=\"pass\" type=\"password\" required=\"yes\"/></td>\r\n");
      out.write("\t\t\t\t\t<td>City</td>\r\n");
      out.write("\t\t\t\t\t<td><input class=\"field\" name=\"city\" type=\"text\" required=\"yes\"/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr id=\"label\">\r\n");
      out.write("\t\t\t\t\t<td>Name</td>\r\n");
      out.write("\t\t\t\t\t<td><input class=\"field\" name=\"name\" type=\"text\" required=\"yes\"/></td>\r\n");
      out.write("\t\t\t\t\t<td>Emai-ID</td>\r\n");
      out.write("\t\t\t\t\t<td><input class=\"field\" name=\"email\" type=\"text\" required=\"yes\"/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr id=\"label\">\r\n");
      out.write("\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;Male<input name=\"gender\" value=\"Male\" type=\"radio\" checked=\"true\"/>\r\n");
      out.write("\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;Female<input name=\"gender\" value=\"Female\" type=\"radio\"/>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>Contact No</td>\r\n");
      out.write("\t\t\t\t\t<td><input class=\"field\" name=\"cno\" type=\"text\" required=\"yes\"/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t<td><input class=\"button\" type=\"submit\" value=\"Register\"/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t   </div>\t\t\t\r\n");
      out.write("\t");

	}
	else
	{
		
      out.write("\r\n");
      out.write("\t\t<div style=\"position:absolute;top:170px;left:210\">\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t");

	}

      out.write("\r\n");
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
