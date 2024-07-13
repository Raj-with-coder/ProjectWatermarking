package org.apache.jsp.Resources.JSP.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<html>\r\n");

	String user=request.getAttribute("user").toString();

      out.write("\r\n");
      out.write("<script language=\"JavaScript\">\r\n");
      out.write("javascript:window.history.forward(-1);\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/button.css\" type=\"text/css\"/>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div style=\"position:relative;top:0px;left:0px;\">\t\r\n");
      out.write("\t<div align=\"right\" class=\"gradientbuttons\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<a class=\"gradientlinks\" href=\"");
      out.print(request.getContextPath() );
      out.write("/Inbox?submit=get&name=");
      out.print(user );
      out.write("\" target=\"afrm\"><label style=\"color: white;\">Inbox</label></a>\r\n");
      out.write("\t\t<a class=\"gradientlinks\" href=\"");
      out.print(request.getContextPath() );
      out.write("/ImageList1?submit=get&id=");
      out.print(user );
      out.write("\" target=\"afrm\"><label style=\"color: white;\">Secret Images</label></a>\r\n");
      out.write("\t\t<a class=\"gradientlinks\" href=\"");
      out.print(request.getContextPath() );
      out.write("/UserProfile?name=");
      out.print(user );
      out.write("\" target=\"afrm\"><label style=\"color: white;\">Show Profile</label></a>\r\n");
      out.write("\t\t<a class=\"gradientlinks\" href=\"");
      out.print(request.getContextPath() );
      out.write("/\"><label style=\"color: white\">Sign Out</label>&nbsp;&nbsp;&nbsp;&nbsp;</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("<br>\r\n");
      out.write("<center>\r\n");
      out.write("<img src=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/Images/cooltext3.png\" width=\"100%\"></img>\r\n");
      out.write("</center>\t\r\n");
      out.write("</div>\t\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<div style=\"position:absolute;top:180px;left:50px;\">\r\n");
      out.write("\t\t<iframe frameborder=\"0\" scrolling=\"auto\" name=\"afrm\" height=\"470\" width=\"1055\"></iframe>\r\n");
      out.write("\t</div>\r\n");
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
