package org.apache.jsp.Resources.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.nits.util.*;

public final class adduser_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/message.css\" rel=\"stylesheet\" type=\"text/css\" /> \r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/login.css\" type=\"text/css\"/>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/JS/style.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/javascript/IndvMemberValidate.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("<script language=\"Javascript\" type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("        function onlyAlphabets(e, t) {\r\n");
      out.write("            try {\r\n");
      out.write("                if (window.event) {\r\n");
      out.write("                    var charCode = window.event.keyCode;\r\n");
      out.write("                }\r\n");
      out.write("                else if (e) {\r\n");
      out.write("                    var charCode = e.which;\r\n");
      out.write("                }\r\n");
      out.write("                else { return true; }\r\n");
      out.write("                if ((charCode > 64 && charCode < 91) || (charCode > 96 && charCode < 123))\r\n");
      out.write("                    return true;\r\n");
      out.write("                else\r\n");
      out.write("                    return false;\r\n");
      out.write("            }\r\n");
      out.write("            catch (err) {\r\n");
      out.write("                alert(err.Description);\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");
      out.write("<div style=\"position:absolute;top:-20px;left:100\" class=\"c\">\t\r\n");
      out.write("\t<table id=\"login\">\r\n");
      out.write("\t\t\t<h1 align=\"center\" id=\"label\">Add User</h1>\r\n");
      out.write("\t\t\t<hr size=\"10\" color=\"#5E74D8\"></hr>\r\n");
      out.write("\t\t\t<form  action=\"");
      out.print(request.getContextPath() );
      out.write("/UserList\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"submit\" value=\"Add\"></input>\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"add1\" value=\"YES\"></input>\r\n");
      out.write("\t\t\t\t<tr id=\"label\">\r\n");
      out.write("\t\t\t\t\t<td>User-ID</td>\r\n");
      out.write("\t\t\t\t\t<td><input class=\"field\" name=\"id\" type=\"text\" required=\"yes\"/></td>\r\n");
      out.write("\t\t\t\t\t<td>Address</td>\r\n");
      out.write("\t\t\t\t\t<td><input class=\"field\" name=\"add\" type=\"text\"  onkeypress=\"return onlyAlphabets(event,this);\"/></td>\r\n");
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
      out.write("\t\t\t\t\t<td><input class=\"field\" name=\"name\" type=\"text\" required=\"yes\" onkeypress=\"return isNumberKey(evt)\"/></td>\r\n");
      out.write("\t\t\t\t\t<td>Emai-ID</td>\r\n");
      out.write("\t\t\t\t\t<td><input class=\"field\" name=\"email\" type=\"text\" pattern=\"\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\trequired=\"yes\"/></td>\r\n");
      out.write("\t\t\t\t\t\r\n");
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
      out.write("\t\t\t\t\t<td><input class=\"field\" name=\"cno\" id=\"cno\" type=\"text\" pattern=\"[7-9]{1}[0-9]{9}\" minlength=\"10\" maxlength=\"10\"\r\n");
      out.write("\t\t\t\t\t\t\t\trequired=\"yes\" /></td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t<td><input class=\"button\" type=\"submit\" value=\"Register\"/> </td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</table>\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
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
