/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.2.11.v20150529
 * Generated at: 2016-04-20 19:31:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.templates;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class selfevaluation_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <style type=\"text/css\">\r\n");
      out.write("            .tg  {border-collapse:collapse;border-spacing:0;}\r\n");
      out.write("            .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}\r\n");
      out.write("            .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}\r\n");
      out.write("            .tg .tg-yfvh{font-weight:bold;font-style:italic;vertical-align:top}\r\n");
      out.write("            .tg .tg-yw4l{vertical-align:top}\r\n");
      out.write("        </style>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://ajax.googleapis.com/ajax/libs/dojo/1.10.4/dijit/themes/claro/claro.css\" >\r\n");
      out.write("        <script src=\"http://ajax.googleapis.com/ajax/libs/dojo/1.10.4/dojo/dojo.js\"     \r\n");
      out.write("        data-dojo-config=\"parseOnLoad: true\">\r\n");
      out.write("        </script>\r\n");
      out.write("        <script>\r\n");
      out.write("            dojo.require(\"dojo.parser\");\r\n");
      out.write("            dojo.require(\"dijit/form/DateTextBox\");\r\n");
      out.write("            dojo.require(\"dijit.dijit\");\r\n");
      out.write("            dojo.require(\"dojox.layout.TableContainer\");\r\n");
      out.write("            dojo.require(\"dijit.form.TextBox\");\r\n");
      out.write("            dojo.require(\"dijit.form.Checkbox\");\r\n");
      out.write("        </script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body class=\"claro\">\r\n");
      out.write("        <div style=\"width: 150px; margin: auto;\">Self-Assessment Form</div>\r\n");
      out.write("        <br><br>\r\n");
      out.write("        <div style=\"width: 800%; margin: auto;\">\r\n");
      out.write("            <label for=\"date\">Date:</label>\r\n");
      out.write("            <input type=\"text\" name=\"date\" id=\"date1\" title=\"Date\"\r\n");
      out.write("            data-dojo-type=\"dijit/form/DateTextBox\"\r\n");
      out.write("            required=\"true\" />\r\n");
      out.write("            <label for=\"teamMemberName\" >Team Member Name:</label>\r\n");
      out.write("            <input type=\"text\" name=\"teamMemberName\" title=\"Team Member Name\"\r\n");
      out.write("            data-dojo-type=\"dijit/form/TextBox\"\r\n");
      out.write("            data-dojo-props=\"trim:true\" id=\"teamMember\" />\r\n");
      out.write("            <label for=\"project\" >Project:</label>\r\n");
      out.write("            <input type=\"text\" name=\"project\" title=\"Project\"\r\n");
      out.write("            data-dojo-type=\"dijit/form/TextBox\"\r\n");
      out.write("            data-dojo-props=\"trim:true\" id=\"project\" />\r\n");
      out.write("        </div>\r\n");
      out.write("        <br><br>\r\n");
      out.write("        <div style=\"font-weight: bold;\">1.  Please rate yourself on the following*:</div>\r\n");
      out.write("        <br>\r\n");
      out.write("        <table class=\"tg\">\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th class=\"tg-yw4l\"></th>\r\n");
      out.write("                <th class=\"tg-yfvh\">Excellent</th>\r\n");
      out.write("                <th class=\"tg-yfvh\">Good</th>\r\n");
      out.write("                <th class=\"tg-yfvh\">Average</th>\r\n");
      out.write("                <th class=\"tg-yfvh\">Poor</th>\r\n");
      out.write("                <th class=\"tg-yfvh\">Unacceptable</th>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td class=\"tg-yw4l\">Meeting attendance</td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"MA5\" data-dojo-type=\"dijit/form/CheckBox\" value=\"5\" /></td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"MA4\" data-dojo-type=\"dijit/form/CheckBox\" value=\"4\" /></td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"MA3\" data-dojo-type=\"dijit/form/CheckBox\" value=\"3\" /></td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"MA2\" data-dojo-type=\"dijit/form/CheckBox\" value=\"2\" /></td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"MA1\" data-dojo-type=\"dijit/form/CheckBox\" value=\"1\" /></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td class=\"tg-yw4l\">Preparation for meeting</td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"PFM5\" data-dojo-type=\"dijit/form/CheckBox\" value=\"5\" /></td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"PFM4\" data-dojo-type=\"dijit/form/CheckBox\" value=\"4\" /></td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"PFM3\" data-dojo-type=\"dijit/form/CheckBox\" value=\"3\" /></td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"PFM2\" data-dojo-type=\"dijit/form/CheckBox\" value=\"2\" /></td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"PFM1\" data-dojo-type=\"dijit/form/CheckBox\" value=\"1\" /></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td class=\"tg-yw4l\">Efficiency of meeting</td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"EOM5\" data-dojo-type=\"dijit/form/CheckBox\" value=\"5\" /></td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"EOM4\" data-dojo-type=\"dijit/form/CheckBox\" value=\"4\" /></td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"EOM3\" data-dojo-type=\"dijit/form/CheckBox\" value=\"3\" /></td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"EOM2\" data-dojo-type=\"dijit/form/CheckBox\" value=\"2\" /></td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"EOM1\" data-dojo-type=\"dijit/form/CheckBox\" value=\"1\" /></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td class=\"tg-yw4l\">Communication skills</td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"CS5\" data-dojo-type=\"dijit/form/CheckBox\" value=\"5\" /></td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"CS4\" data-dojo-type=\"dijit/form/CheckBox\" value=\"4\" /></td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"CS3\" data-dojo-type=\"dijit/form/CheckBox\" value=\"3\" /></td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"CS2\" data-dojo-type=\"dijit/form/CheckBox\" value=\"2\" /></td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"CS1\" data-dojo-type=\"dijit/form/CheckBox\" value=\"1\" /></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td class=\"tg-yw4l\">Equal sharing of workload</td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"ES5\" data-dojo-type=\"dijit/form/CheckBox\" value=\"5\" /></td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"ES4\" data-dojo-type=\"dijit/form/CheckBox\" value=\"4\" /></td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"ES3\" data-dojo-type=\"dijit/form/CheckBox\" value=\"3\" /></td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"ES2\" data-dojo-type=\"dijit/form/CheckBox\" value=\"2\" /></td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"ES1\" data-dojo-type=\"dijit/form/CheckBox\" value=\"1\" /></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td class=\"tg-yw4l\">Motivation</td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"M5\" data-dojo-type=\"dijit/form/CheckBox\" value=\"5\" /></td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"M4\" data-dojo-type=\"dijit/form/CheckBox\" value=\"4\" /></td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"M3\" data-dojo-type=\"dijit/form/CheckBox\" value=\"3\" /></td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"M2\" data-dojo-type=\"dijit/form/CheckBox\" value=\"2\" /></td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"M1\" data-dojo-type=\"dijit/form/CheckBox\" value=\"1\" /></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td class=\"tg-yw4l\">Supportiveness</td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"S5\" data-dojo-type=\"dijit/form/CheckBox\" value=\"5\" /></td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"S4\" data-dojo-type=\"dijit/form/CheckBox\" value=\"4\" /></td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"S3\" data-dojo-type=\"dijit/form/CheckBox\" value=\"3\" /></td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"S2\" data-dojo-type=\"dijit/form/CheckBox\" value=\"2\" /></td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"S1\" data-dojo-type=\"dijit/form/CheckBox\" value=\"1\" /></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td class=\"tg-yw4l\">Overall performance</td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"OP5\" data-dojo-type=\"dijit/form/CheckBox\" value=\"5\" /></td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"OP4\" data-dojo-type=\"dijit/form/CheckBox\" value=\"4\" /></td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"OP3\" data-dojo-type=\"dijit/form/CheckBox\" value=\"3\" /></td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"OP2\" data-dojo-type=\"dijit/form/CheckBox\" value=\"2\" /></td>\r\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"OP1\" data-dojo-type=\"dijit/form/CheckBox\" value=\"1\" /></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("        <br><br>\r\n");
      out.write("        <div style=\"font-weight: bold;\">\r\n");
      out.write("        2.  Please provide a narrative with evidence to support any factors for which you have rated yourself as Excellent or Unacceptable.\r\n");
      out.write("        </div>\r\n");
      out.write("        <br>\r\n");
      out.write("        <textarea id=\"textarea2\" name=\"textarea2\" data-dojo-type=\"dijit.form.Textarea\" style=\"width:50%;\"></textarea>\r\n");
      out.write("        <br><br>\r\n");
      out.write("        <div style=\"font-weight: bold;\">\r\n");
      out.write("        3.  Please list any additional factors that you believe are important for consideration in assessing your performance to date.\r\n");
      out.write("        </div>\r\n");
      out.write("        <br>\r\n");
      out.write("        <textarea id=\"textarea2\" name=\"textarea2\" data-dojo-type=\"dijit.form.Textarea\" style=\"width:50%;\"></textarea>\r\n");
      out.write("        <br><br>\r\n");
      out.write("        <div style=\"font-weight: bold;\">\r\n");
      out.write("        4. Describe two strengths that you bring to your team.\r\n");
      out.write("        </div>\r\n");
      out.write("        <br>\r\n");
      out.write("        <textarea id=\"textarea2\" name=\"textarea2\" data-dojo-type=\"dijit.form.Textarea\" style=\"width:50%;\"></textarea>\r\n");
      out.write("        <br><br>\r\n");
      out.write("        <div style=\"font-weight: bold;\">\r\n");
      out.write("        5. Describe the two most significant areas for improvement for yourself as a team member.\r\n");
      out.write("        </div>\r\n");
      out.write("        <br>\r\n");
      out.write("        <textarea id=\"textarea2\" name=\"textarea2\" data-dojo-type=\"dijit.form.Textarea\" style=\"width:50%;\"></textarea>\r\n");
      out.write("        <br><br>\r\n");
      out.write("        <hr>\r\n");
      out.write("        <br>\r\n");
      out.write("        <div>*Adapted from the \"Management Communications for Undergraduates\" (15.279), Sloan School of Management, MIT, by Dr. Lori Breslow, 2000</div>\r\n");
      out.write("        \r\n");
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