/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.2.11.v20150529
 * Generated at: 2016-05-07 19:54:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.templates;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class loginPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(6);
    _jspx_dependants.put("jar:file:/C:/Users/Samuel/.m2/repository/org/springframework/spring-webmvc/3.2.13.RELEASE/spring-webmvc-3.2.13.RELEASE.jar!/META-INF/spring-form.tld", Long.valueOf(1419944808000L));
    _jspx_dependants.put("jar:file:/C:/Users/Samuel/.m2/repository/javax/servlet/jstl/1.2/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153399482000L));
    _jspx_dependants.put("jar:file:/C:/Users/Samuel/.m2/repository/org/springframework/spring-webmvc/3.2.13.RELEASE/spring-webmvc-3.2.13.RELEASE.jar!/META-INF/spring.tld", Long.valueOf(1419944808000L));
    _jspx_dependants.put("file:/C:/Users/Samuel/.m2/repository/javax/servlet/jstl/1.2/jstl-1.2.jar", Long.valueOf(1459809391504L));
    _jspx_dependants.put("file:/C:/Users/Samuel/.m2/repository/org/springframework/spring-webmvc/3.2.13.RELEASE/spring-webmvc-3.2.13.RELEASE.jar", Long.valueOf(1460078896005L));
    _jspx_dependants.put("jar:file:/C:/Users/Samuel/.m2/repository/javax/servlet/jstl/1.2/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153399482000L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>PM Assessment</title>\r\n");
      out.write("        <meta charset=\"windows-1252\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"http://ajax.googleapis.com/ajax/libs/dojo/1.10.4/dijit/themes/claro/claro.css\">\r\n");
      out.write("        <script src=\"http://ajax.googleapis.com/ajax/libs/dojo/1.10.4/dojo/dojo.js\" data-dojo-config=\"parseOnLoad: true\"></script>\r\n");
      out.write("        <script>\r\n");
      out.write("            dojo.require(\"dojo/parser\");\r\n");
      out.write("            dojo.require(\"dijit/form/TextBox\");\r\n");
      out.write("        </script>\r\n");
      out.write("\t\t<style>\r\n");
      out.write("            body {background-color:#860038}\r\n");
      out.write("\t\t</style>\r\n");
      out.write("    </head>\r\n");
      out.write("       <body class=\"tundra\">\r\n");
      out.write("        <img src=\"https://fairmontstate.studentaidcalculator.com/1/logo.sepng\" style=\"margin: auto;position: absolute; left:40.7%; top:27%\">\r\n");
      out.write("\t\t<div id=\"loginContainer\" style=\"width:25%; height:20%; position:absolute; left:37.5%; top:40%; border-style:ridge; border-width:5px;border-color:#F58026;color:#F58026; \" >\r\n");
      out.write("            <div id=\"nestedContainer\" style=\" height:25%; width:30%; position:absolute; left:20%; top:30%; \">\r\n");
      out.write("                <form action=\"/PMA/processLogin\" method=\"POST\" >\r\n");
      out.write("                <input type=\"text\" name=\"username\"\r\n");
      out.write("                        data-dojo-type=\"dijit/form/TextBox\"\r\n");
      out.write("                        data-dojo-props=\"trim:true\" placeholder=\"Username\" id=\"username\" />\r\n");
      out.write("                <br><br>\r\n");
      out.write("                <input type=\"password\" name=\"password\"\r\n");
      out.write("                data-dojo-type=\"dijit/form/TextBox\"\r\n");
      out.write("                data-dojo-props=\"trim:true\" placeholder=\"Password\" id=\"password\" />\r\n");
      out.write("                <br>\r\n");
      out.write("                <button type=\"submit\">Login</button>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
