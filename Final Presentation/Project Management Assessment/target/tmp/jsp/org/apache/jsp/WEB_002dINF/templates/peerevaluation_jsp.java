/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.2.11.v20150529
 * Generated at: 2016-05-01 15:55:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.templates;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class peerevaluation_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            .tg  {border-collapse:collapse;border-spacing:0;}\n");
      out.write("            .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}\n");
      out.write("            .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}\n");
      out.write("            .tg .tg-yfvh{font-weight:bold;font-style:italic;vertical-align:top}\n");
      out.write("            .tg .tg-yw4l{vertical-align:top}\n");
      out.write("        </style>\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://ajax.googleapis.com/ajax/libs/dojo/1.10.4/dijit/themes/claro/claro.css\" >\n");
      out.write("        <script src=\"http://ajax.googleapis.com/ajax/libs/dojo/1.10.4/dojo/dojo.js\"     \n");
      out.write("        data-dojo-config=\"parseOnLoad: true\">\n");
      out.write("        </script>\n");
      out.write("        <script>\n");
      out.write("            dojo.require(\"dojo.parser\");\n");
      out.write("            dojo.require(\"dijit.form.DateTextBox\");\n");
      out.write("            dojo.require(\"dijit.dijit\");\n");
      out.write("            dojo.require(\"dojox.layout.TableContainer\");\n");
      out.write("            dojo.require(\"dijit.form.TextBox\");\n");
      out.write("            dojo.require(\"dijit.form.Button\");\n");
      out.write("            \n");
      out.write("            var answerMap = {\n");
      out.write("                AID: 2,\n");
      out.write("                UCA: parent.username,\n");
      out.write("                GID: parent.selectedGroupId,\n");
      out.write("                Name: (parent.name).concat(\" PeerEvalOf \").concat(parent.peerEvalOf),\n");
      out.write("                A1: \"\",\n");
      out.write("                A2: parent.peerEvalOf,\n");
      out.write("                A3: parent.selectedGroup,\n");
      out.write("                A4: \"\",\n");
      out.write("                A5: \"\",\n");
      out.write("                A6: \"\",\n");
      out.write("                A7: \"\",\n");
      out.write("                A8: \"\",\n");
      out.write("                A9: \"\",\n");
      out.write("                A10: \"\",\n");
      out.write("                A11: \"\",\n");
      out.write("                A12: \"\",\n");
      out.write("                A13: \"\",\n");
      out.write("                A14: \"\",\n");
      out.write("                A15: \"\"\n");
      out.write("            };\n");
      out.write("            \n");
      out.write("            function saveSelfAssessment(){\n");
      out.write("                if(document.getElementById(\"A1\").value.trim() != \"\"){\n");
      out.write("                    answerMap.A1 = document.getElementById(\"A1\").value.trim();\n");
      out.write("                }\n");
      out.write("                answerMap.A2 = document.getElementById(\"A2\").value.trim();\n");
      out.write("                answerMap.A3 = document.getElementById(\"A3\").value.trim();\n");
      out.write("                answerMap.A4 = getCheckBoxAnswer(\"A4\");\n");
      out.write("                answerMap.A5 = getCheckBoxAnswer(\"A5\");\n");
      out.write("                answerMap.A6 = getCheckBoxAnswer(\"A6\");\n");
      out.write("                answerMap.A7 = getCheckBoxAnswer(\"A7\");\n");
      out.write("                answerMap.A8 = getCheckBoxAnswer(\"A8\");\n");
      out.write("                answerMap.A9 = getCheckBoxAnswer(\"A9\");\n");
      out.write("                answerMap.A10 = getCheckBoxAnswer(\"A10\");\n");
      out.write("                answerMap.A11 = getCheckBoxAnswer(\"A11\");\n");
      out.write("                if(document.getElementById(\"A12\").value.trim() != \"\"){\n");
      out.write("                    answerMap.A12 = document.getElementById(\"A12\").value.trim();\n");
      out.write("                }\n");
      out.write("                if(document.getElementById(\"A13\").value.trim() != \"\"){\n");
      out.write("                    answerMap.A13 = document.getElementById(\"A13\").value.trim();\n");
      out.write("                }\n");
      out.write("                if(document.getElementById(\"A14\").value.trim() != \"\"){\n");
      out.write("                    answerMap.A14 = document.getElementById(\"A14\").value.trim();\n");
      out.write("                }\n");
      out.write("                if(document.getElementById(\"A15\").value.trim() != \"\"){\n");
      out.write("                    answerMap.A15 = document.getElementById(\"A15\").value.trim();\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                console.log(answerMap);\n");
      out.write("                \n");
      out.write("                dojo.xhrPost({\n");
      out.write("                   url:  \"/PMA/student/saveSelf\",\n");
      out.write("                   handleAs: \"json\",\n");
      out.write("                   content: {\n");
      out.write("                       \"AID\": answerMap.AID,\n");
      out.write("                       \"UCA\": answerMap.UCA,\n");
      out.write("                       \"GID\": answerMap.GID,\n");
      out.write("                       \"Name\": answerMap.Name,\n");
      out.write("                       \"A1\": answerMap.A1,\n");
      out.write("                       \"A2\": answerMap.A2,\n");
      out.write("                       \"A3\": answerMap.A3,\n");
      out.write("                       \"A4\": answerMap.A4,\n");
      out.write("                       \"A5\": answerMap.A5,\n");
      out.write("                       \"A6\": answerMap.A6,\n");
      out.write("                       \"A7\": answerMap.A7,\n");
      out.write("                       \"A8\": answerMap.A8,\n");
      out.write("                       \"A9\": answerMap.A9,\n");
      out.write("                       \"A10\": answerMap.A10,\n");
      out.write("                       \"A11\": answerMap.A11,\n");
      out.write("                       \"A12\": answerMap.A12,\n");
      out.write("                       \"A13\": answerMap.A13,\n");
      out.write("                       \"A14\": answerMap.A14,\n");
      out.write("                       \"A15\": answerMap.A15,\n");
      out.write("                       \"answers\": 15\n");
      out.write("                   },\n");
      out.write("                   load: test\n");
      out.write("                });\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function test(response){\n");
      out.write("                console.log(\"I got a response\");\n");
      out.write("                console.log(response);\n");
      out.write("                //var json = JSON.parse(response);\n");
      out.write("                console.log(response.a15);\n");
      out.write("            }\n");
      out.write("            function getCheckBoxAnswer(question){\n");
      out.write("                if(document.getElementById(question.concat(\"-5\")).checked){\n");
      out.write("                    return 5;\n");
      out.write("                }\n");
      out.write("                else if(document.getElementById(question.concat(\"-4\")).checked){\n");
      out.write("                    return 4;\n");
      out.write("                }\n");
      out.write("                else if(document.getElementById(question.concat(\"-3\")).checked){\n");
      out.write("                    return 3;\n");
      out.write("                }\n");
      out.write("                else if(document.getElementById(question.concat(\"-2\")).checked){\n");
      out.write("                    return 2;\n");
      out.write("                }\n");
      out.write("                else if(document.getElementById(question.concat(\"-1\")).checked){\n");
      out.write("                    return 1;\n");
      out.write("                }\n");
      out.write("                else{\n");
      out.write("                    return null;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function loadAssessment(response){\n");
      out.write("                if(response.answers == \"Y\"){\n");
      out.write("                    answerMap.A1 = response.a1;\n");
      out.write("                    answerMap.A2 = response.a2;\n");
      out.write("                    answerMap.A3 = response.a3;\n");
      out.write("                    answerMap.A4 = response.a4;\n");
      out.write("                    answerMap.A5 = response.a5;\n");
      out.write("                    answerMap.A6 = response.a6;\n");
      out.write("                    answerMap.A7 = response.a7;\n");
      out.write("                    answerMap.A8 = response.a8;\n");
      out.write("                    answerMap.A9 = response.a9;\n");
      out.write("                    answerMap.A10 = response.a10;\n");
      out.write("                    answerMap.A11 = response.a11;\n");
      out.write("                    answerMap.A12 = response.a12;\n");
      out.write("                    answerMap.A13 = response.a13;\n");
      out.write("                    answerMap.A14 = response.a14;\n");
      out.write("                    answerMap.A15 = response.a15;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if(response.msg == \"Display\"){\n");
      out.write("                    display();\n");
      out.write("                }\n");
      out.write("                else{\n");
      out.write("                    document.getElementById(\"A2\").value = answerMap.A2;\n");
      out.write("                    document.getElementById(\"A3\").value = answerMap.A3;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function display(){\n");
      out.write("                document.getElementById(\"A1\").value = answerMap.A1;\n");
      out.write("                document.getElementById(\"A2\").value = answerMap.A2;\n");
      out.write("                document.getElementById(\"A3\").value = answerMap.A3;\n");
      out.write("                if(answerMap.A4 != \"\"){\n");
      out.write("                    document.getElementById(\"A4-\".concat(answerMap.A4)).checked = true;\n");
      out.write("                }\n");
      out.write("                if(answerMap.A5 != \"\"){\n");
      out.write("                    document.getElementById(\"A5-\".concat(answerMap.A5)).checked = true;\n");
      out.write("                }\n");
      out.write("                if(answerMap.A6 != \"\"){\n");
      out.write("                    document.getElementById(\"A6-\".concat(answerMap.A6)).checked = true;\n");
      out.write("                }\n");
      out.write("                if(answerMap.A7 != \"\"){\n");
      out.write("                    document.getElementById(\"A7-\".concat(answerMap.A7)).checked = true;\n");
      out.write("                }\n");
      out.write("                if(answerMap.A8 != \"\"){\n");
      out.write("                    document.getElementById(\"A8-\".concat(answerMap.A8)).checked = true;\n");
      out.write("                }\n");
      out.write("                if(answerMap.A9 != \"\"){\n");
      out.write("                    document.getElementById(\"A9-\".concat(answerMap.A9)).checked = true;\n");
      out.write("                }\n");
      out.write("                if(answerMap.A10 != \"\"){\n");
      out.write("                    document.getElementById(\"A10-\".concat(answerMap.A10)).checked = true;\n");
      out.write("                }\n");
      out.write("                if(answerMap.A11 != \"\"){\n");
      out.write("                    document.getElementById(\"A11-\".concat(answerMap.A11)).checked = true;\n");
      out.write("                }\n");
      out.write("                document.getElementById(\"A12\").value = answerMap.A12;\n");
      out.write("                document.getElementById(\"A13\").value = answerMap.A13;\n");
      out.write("                document.getElementById(\"A14\").value = answerMap.A14;\n");
      out.write("                document.getElementById(\"A15\").value = answerMap.A15;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            dojo.ready(function(){\n");
      out.write("                dojo.xhrPost({\n");
      out.write("                   url:  \"/PMA/student/getAssessment\",\n");
      out.write("                   handleAs: \"json\",\n");
      out.write("                   content: {\n");
      out.write("                       \"AID\": answerMap.AID,\n");
      out.write("                       \"UCA\": answerMap.UCA,\n");
      out.write("                       \"GID\": answerMap.GID,\n");
      out.write("                       \"Name\": answerMap.Name\n");
      out.write("                   },\n");
      out.write("                   load: loadAssessment\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"claro\">\n");
      out.write("        <div style=\"width: 150px; margin: auto;\">Peer Evaluation Form</div>\n");
      out.write("        <br><br>\n");
      out.write("        <div style=\"width: 80%; margin: auto;\">\n");
      out.write("            <label for=\"date\">Date:</label>\n");
      out.write("            <input type=\"text\" name=\"date\" id=\"A1\" title=\"Date\"\n");
      out.write("            data-dojo-type=\"dijit/form/DateTextBox\"\n");
      out.write("            required=\"true\" />\n");
      out.write("            <label for=\"teamMemberName\" >Team Member Name:</label>\n");
      out.write("            <input type=\"text\" name=\"teamMemberName\" title=\"Team Member Name\"\n");
      out.write("            data-dojo-type=\"dijit/form/TextBox\"\n");
      out.write("            data-dojo-props=\"trim:true\" id=\"A2\" />\n");
      out.write("            <label for=\"project\" >Project:</label>\n");
      out.write("            <input type=\"text\" name=\"project\" title=\"Project\"\n");
      out.write("            data-dojo-type=\"dijit/form/TextBox\"\n");
      out.write("            data-dojo-props=\"trim:true\" id=\"A3\" />\n");
      out.write("            <button data-dojo-type=\"dijit/form/Button\" type=\"button\" id=\"saveButton\" label=\"Save\" onclick=\"saveSelfAssessment\"></button>\n");
      out.write("        </div>\n");
      out.write("        <br><br>\n");
      out.write("        <div style=\"font-weight: bold;\">1.  Please rate your peer on the following*:</div>\n");
      out.write("        <br>\n");
      out.write("        <table class=\"tg\">\n");
      out.write("            <tr>\n");
      out.write("                <th class=\"tg-yw4l\"></th>\n");
      out.write("                <th class=\"tg-yfvh\">Excellent</th>\n");
      out.write("                <th class=\"tg-yfvh\">Good</th>\n");
      out.write("                <th class=\"tg-yfvh\">Average</th>\n");
      out.write("                <th class=\"tg-yfvh\">Poor</th>\n");
      out.write("                <th class=\"tg-yfvh\">Unacceptable</th>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td class=\"tg-yw4l\">Meeting attendance</td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A4-5\" value=\"5\" /></td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A4-4\" value=\"4\" /></td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A4-3\" value=\"3\" /></td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A4-2\" value=\"2\" /></td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A4-1\" value=\"1\" /></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td class=\"tg-yw4l\">Preparation for meeting</td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A5-5\" value=\"5\" /></td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A5-4\" value=\"4\" /></td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A5-3\" value=\"3\" /></td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A5-2\" value=\"2\" /></td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A5-1\" value=\"1\" /></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td class=\"tg-yw4l\">Efficiency of meeting</td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A6-5\" value=\"5\" /></td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A6-4\" value=\"4\" /></td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A6-3\" value=\"3\" /></td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A6-2\" value=\"2\" /></td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A6-1\" value=\"1\" /></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td class=\"tg-yw4l\">Communication skills</td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A7-5\" value=\"5\" /></td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A7-4\" value=\"4\" /></td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A7-3\" value=\"3\" /></td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A7-2\" value=\"2\" /></td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A7-1\" value=\"1\" /></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td class=\"tg-yw4l\">Equal sharing of workload</td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A8-5\" value=\"5\" /></td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A8-4\" value=\"4\" /></td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A8-3\" value=\"3\" /></td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A8-2\" value=\"2\" /></td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A8-1\" value=\"1\" /></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td class=\"tg-yw4l\">Motivation</td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A9-5\" value=\"5\" /></td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A9-4\" value=\"4\" /></td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A9-3\" value=\"3\" /></td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A9-2\" value=\"2\" /></td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A9-1\" value=\"1\" /></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td class=\"tg-yw4l\">Supportiveness</td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A10-5\" value=\"5\" /></td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A10-4\" value=\"4\" /></td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A10-3\" value=\"3\" /></td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A10-2\" value=\"2\" /></td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A10-1\" value=\"1\" /></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td class=\"tg-yw4l\">Overall performance</td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A11-5\" value=\"5\" /></td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A11-4\" value=\"4\" /></td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A11-3\" value=\"3\" /></td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A11-2\" value=\"2\" /></td>\n");
      out.write("                <td class=\"tg-yw4l\"><input type=\"checkbox\" id=\"A11-1\" value=\"1\" /></td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        <br><br>\n");
      out.write("        <div style=\"font-weight: bold;\">\n");
      out.write("        2.  Please provide a narrative with evidence to support any factors for which you have rated your peer as Excellent or Unacceptable.\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <textarea id=\"A12\" name=\"textarea1\" style=\"width:50%;\"></textarea>\n");
      out.write("        <br><br>\n");
      out.write("        <div style=\"font-weight: bold;\">\n");
      out.write("        3.  Please list any additional factors that you believe are important for consideration in assessing the performance of your peer to date.\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <textarea id=\"A13\" name=\"textarea2\" style=\"width:50%;\"></textarea>\n");
      out.write("        <br><br>\n");
      out.write("        <div style=\"font-weight: bold;\">\n");
      out.write("        4. Describe two strengths that this team member brings to your team.\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <textarea id=\"A14\" name=\"textarea3\" style=\"width:50%;\"></textarea>\n");
      out.write("        <br><br>\n");
      out.write("        <div style=\"font-weight: bold;\">\n");
      out.write("        5. Describe the two most significant areas for improvement for this team member.\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <textarea id=\"A15\" name=\"textarea4\" style=\"width:50%;\"></textarea>\n");
      out.write("        <br><br>\n");
      out.write("        <hr>\n");
      out.write("        <br>\n");
      out.write("        <div>*Adapted from the \"Management Communications for Undergraduates\" (15.279), Sloan School of Management, MIT, by Dr. Lori Breslow, 2000</div>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
