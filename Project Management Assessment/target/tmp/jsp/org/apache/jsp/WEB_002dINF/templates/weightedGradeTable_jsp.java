/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.2.11.v20150529
 * Generated at: 2016-05-08 19:36:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.templates;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class weightedGradeTable_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!-- simple presentation grading tool, requested by Girocialli-->\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"http://ajax.googleapis.com/ajax/libs/dojo/1.10.4/dijit/themes/claro/claro.css\" >\r\n");
      out.write("    <script src=\"http://ajax.googleapis.com/ajax/libs/dojo/1.10.4/dojo/dojo.js\"     \r\n");
      out.write("        data-dojo-config=\"parseOnLoad: true\">\r\n");
      out.write("    </script>\r\n");
      out.write("<style> <!-- Styles the background, change background style here-->\r\n");
      out.write("input[type=text] {\r\n");
      out.write("    background-color: #860038;\r\n");
      out.write("    color: #FFDE00;\r\n");
      out.write("    border: none;\r\n");
      out.write("}\r\n");
      out.write("body{\r\n");
      out.write("    background-color: #860038;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("    dojo.require(\"dojo.parser\");\r\n");
      out.write("    \r\n");
      out.write("    var gid;\r\n");
      out.write("//These functions, gradingFunctions 1- 10, grade each individual line once stuff is entered into the lines, then calls addValues to compute the total.\r\n");
      out.write("function gradingFunction1() {\r\n");
      out.write("    document.getElementById(\"weighted1\").value = document.getElementById(\"grade1\").value / document.getElementById(\"possible1\").value * document.getElementById(\"weight1\").value;\r\n");
      out.write("    addValues();\r\n");
      out.write("}\r\n");
      out.write("function gradingFunction2() {\r\n");
      out.write("    document.getElementById(\"weighted2\").value = document.getElementById(\"grade2\").value / document.getElementById(\"possible2\").value * document.getElementById(\"weight2\").value;\r\n");
      out.write("    addValues();\r\n");
      out.write("}\r\n");
      out.write("function gradingFunction3() {\r\n");
      out.write("    document.getElementById(\"weighted3\").value = document.getElementById(\"grade3\").value / document.getElementById(\"possible3\").value * document.getElementById(\"weight3\").value;\r\n");
      out.write("    addValues();\r\n");
      out.write("}\r\n");
      out.write("function gradingFunction4() {\r\n");
      out.write("    document.getElementById(\"weighted4\").value = document.getElementById(\"grade4\").value / document.getElementById(\"possible4\").value * document.getElementById(\"weight4\").value;\r\n");
      out.write("    addValues();\r\n");
      out.write("}\r\n");
      out.write("function gradingFunction5() {\r\n");
      out.write("    document.getElementById(\"weighted5\").value = document.getElementById(\"grade5\").value / document.getElementById(\"possible5\").value * document.getElementById(\"weight5\").value;\r\n");
      out.write("    addValues();\r\n");
      out.write("}\r\n");
      out.write("function gradingFunction6() {\r\n");
      out.write("    document.getElementById(\"weighted6\").value = document.getElementById(\"grade6\").value / document.getElementById(\"possible6\").value * document.getElementById(\"weight6\").value;\r\n");
      out.write("    addValues();\r\n");
      out.write("}\r\n");
      out.write("function gradingFunction7() {\r\n");
      out.write("    document.getElementById(\"weighted7\").value = document.getElementById(\"grade7\").value / document.getElementById(\"possible7\").value * document.getElementById(\"weight7\").value;\r\n");
      out.write("    addValues();\r\n");
      out.write("}\r\n");
      out.write("function gradingFunction8() {\r\n");
      out.write("    document.getElementById(\"weighted8\").value = document.getElementById(\"grade8\").value / document.getElementById(\"possible8\").value * document.getElementById(\"weight8\").value;\r\n");
      out.write("    addValues();\r\n");
      out.write("}\r\n");
      out.write("function gradingFunction9() {\r\n");
      out.write("    document.getElementById(\"weighted9\").value = document.getElementById(\"grade9\").value / document.getElementById(\"possible9\").value * document.getElementById(\"weight9\").value;\r\n");
      out.write("    addValues();\r\n");
      out.write("}\r\n");
      out.write("function gradingFunction10() {\r\n");
      out.write("    document.getElementById(\"weighted10\").value = document.getElementById(\"grade10\").value / document.getElementById(\"possible10\").value * document.getElementById(\"weight10\").value;\r\n");
      out.write("    addValues();\r\n");
      out.write("}\r\n");
      out.write("function addValues() //computes the final total by addding each of the weighted grades and multiplying by 100.\r\n");
      out.write("{\r\n");
      out.write("    document.getElementById(\"total\").value = (Number(document.getElementById(\"weighted1\").value) + Number(document.getElementById(\"weighted2\").value) + Number(document.getElementById(\"weighted3\").value) + Number(document.getElementById(\"weighted4\").value)+ Number(document.getElementById(\"weighted5\").value)+ Number(document.getElementById(\"weighted6\").value)+ Number(document.getElementById(\"weighted7\").value)+ Number(document.getElementById(\"weighted8\").value)+ Number(document.getElementById(\"weighted9\").value)+ Number(document.getElementById(\"weighted10\").value)) * 100 + \"%\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function populateTable(response){\r\n");
      out.write("    if(response.recordsExist){\r\n");
      out.write("        for(i = 0; i < response.evaluators.length; i++){\r\n");
      out.write("            document.getElementById(\"teachName\".concat(i+1)).value = response.evaluators[i];\r\n");
      out.write("            document.getElementById(\"grade\".concat(i+1)).value = response.pointsEarned[i];\r\n");
      out.write("            document.getElementById(\"possible\".concat(i+1)).value = response.pointsTotal[i];\r\n");
      out.write("            document.getElementById(\"weight\".concat(i+1)).value = response.weighting[i];\r\n");
      out.write("            fireRowMath(i+1);\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function fireRowMath(row){\r\n");
      out.write("    if(row==1){\r\n");
      out.write("        gradingFunction1();\r\n");
      out.write("    }\r\n");
      out.write("    else if(row==2){\r\n");
      out.write("        gradingFunction2();\r\n");
      out.write("    }\r\n");
      out.write("    else if(row==3){\r\n");
      out.write("        gradingFunction3();\r\n");
      out.write("    }\r\n");
      out.write("    else if(row==4){\r\n");
      out.write("        gradingFunction4();\r\n");
      out.write("    }\r\n");
      out.write("    else if(row==5){\r\n");
      out.write("        gradingFunction5();\r\n");
      out.write("    }\r\n");
      out.write("    else if(row==6){\r\n");
      out.write("        gradingFunction6();\r\n");
      out.write("    }\r\n");
      out.write("    else if(row==7){\r\n");
      out.write("        gradingFunction7();\r\n");
      out.write("    }\r\n");
      out.write("    else if(row==8){\r\n");
      out.write("        gradingFunction8();\r\n");
      out.write("    }\r\n");
      out.write("    else if(row==9){\r\n");
      out.write("        gradingFunction9();\r\n");
      out.write("    }\r\n");
      out.write("    else if(row==10){\r\n");
      out.write("        gradingFunction10();\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function save(){\r\n");
      out.write("    var evaluators = \"\";\r\n");
      out.write("    var ptsErnd = \"\";\r\n");
      out.write("    var ptsPos = \"\";\r\n");
      out.write("    var weights = \"\";\r\n");
      out.write("    for(i = 1; i<=10; i++){\r\n");
      out.write("        if(document.getElementById(\"teachName\".concat(i)).value.trim() != \"\" || document.getElementById(\"grade\".concat(i)).value.trim() != \"\" ||\r\n");
      out.write("           document.getElementById(\"possible\".concat(i)).value.trim() != \"\" || document.getElementById(\"weight\".concat(i)).value.trim() != \"\"){\r\n");
      out.write("            if(evaluators == \"\"){\r\n");
      out.write("                evaluators = document.getElementById(\"teachName\".concat(i)).value.trim();\r\n");
      out.write("            }\r\n");
      out.write("            else{\r\n");
      out.write("                evaluators = evaluators.concat(\",\").concat(document.getElementById(\"teachName\".concat(i)).value.trim());\r\n");
      out.write("            }\r\n");
      out.write("            if(ptsErnd == \"\"){\r\n");
      out.write("                ptsErnd = document.getElementById(\"grade\".concat(i)).value.trim();\r\n");
      out.write("            }\r\n");
      out.write("            else{\r\n");
      out.write("                ptsErnd = ptsErnd.concat(\",\").concat(document.getElementById(\"grade\".concat(i)).value.trim());\r\n");
      out.write("            }\r\n");
      out.write("            if(ptsPos == \"\"){\r\n");
      out.write("                ptsPos = document.getElementById(\"possible\".concat(i)).value.trim();\r\n");
      out.write("            }\r\n");
      out.write("            else{\r\n");
      out.write("                ptsPos = ptsPos.concat(\",\").concat(document.getElementById(\"possible\".concat(i)).value.trim());\r\n");
      out.write("            }\r\n");
      out.write("            if(weights == \"\"){\r\n");
      out.write("                weights = document.getElementById(\"weight\".concat(i)).value.trim();\r\n");
      out.write("            }\r\n");
      out.write("            else{\r\n");
      out.write("                weights = weights.concat(\",\").concat(document.getElementById(\"weight\".concat(i)).value.trim());\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            dojo.xhrPost({\r\n");
      out.write("                url: \"/PMA/instructor/savePresentationGrades\",\r\n");
      out.write("                handleAs: \"json\",\r\n");
      out.write("                content:{\r\n");
      out.write("                  \"gid\": gid,\r\n");
      out.write("                  \"evaluators\": evaluators, \r\n");
      out.write("                  \"ptsErnd\": ptsErnd,\r\n");
      out.write("                  \"ptsPos\": ptsPos,\r\n");
      out.write("                  \"weights\": weights\r\n");
      out.write("                },\r\n");
      out.write("                load: saveResponse\r\n");
      out.write("            });\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function saveResponse(response){\r\n");
      out.write("    if(response){\r\n");
      out.write("        alert(\"Save Successful\");\r\n");
      out.write("    }\r\n");
      out.write("    else{\r\n");
      out.write("        alert(\"Save Unsuccessful\");\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("dojo.ready(function(){\r\n");
      out.write("    gid = parent.selectedGroupId;\r\n");
      out.write("    dojo.xhrPost({\r\n");
      out.write("        url: \"/PMA/instructor/presentationGrades\",\r\n");
      out.write("        handleAs: \"json\",\r\n");
      out.write("        content:{\r\n");
      out.write("            \"gid\": gid\r\n");
      out.write("        },\r\n");
      out.write("        load: populateTable\r\n");
      out.write("    });\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!--Building the table row by row. Each <tr> tag is a new row, each <td> tag is a new cell -->\r\n");
      out.write("<table border = 1 style=\"width:10%; border-color:#F58026 ; color:#FFDE00; border-width:5px\"> \r\n");
      out.write("  <tr>\r\n");
      out.write("\t<td style= \"background-color:#860038\"> Evaluator</td>\r\n");
      out.write("\t<td style= \"background-color:#860038\"> Points Earned</td>\r\n");
      out.write("\t<td style= \"background-color:#860038\"> Points Possible </td>\r\n");
      out.write("\t<td style= \"background-color:#860038\"> Weighting</td>\r\n");
      out.write("\t<td style= \"background-color:#860038\"> Weighted Grade</td>\r\n");
      out.write("\t\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td><input type = \"text\" id=\"teachName1\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("\t<td><input type = \"text\" id=\"grade1\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("    <td><input type = \"text\" id=\"possible1\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("\t<td><input type = \"text\" id=\"weight1\" value=\"\" onblur=\"gradingFunction1()\" style=\"width:auto;\"></td>\r\n");
      out.write("    <td><input type = \"text\" id=\"weighted1\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td><input type = \"text\" id=\"teachName2\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("\t<td><input type = \"text\" id=\"grade2\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("\t<td><input type = \"text\" id=\"possible2\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("    <td><input type = \"text\" id=\"weight2\" value=\"\" onblur=\"gradingFunction2()\"style=\"width:auto;\"></td>\r\n");
      out.write("    <td><input type = \"text\" id=\"weighted2\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td><input type = \"text\" id=\"teachName3\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("\t<td><input type = \"text\" id=\"grade3\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("\t<td><input type = \"text\" id=\"possible3\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("    <td><input type = \"text\" id=\"weight3\" value=\"\" onblur=\"gradingFunction3()\"style=\"width:auto;\"></td>\r\n");
      out.write("    <td><input type = \"text\" id=\"weighted3\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td><input type = \"text\" id=\"teachName4\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("\t<td><input type = \"text\" id=\"grade4\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("\t<td><input type = \"text\" id=\"possible4\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("    <td><input type = \"text\" id=\"weight4\" value=\"\" onblur=\"gradingFunction4()\"style=\"width:auto;\"></td>\r\n");
      out.write("    <td><input type = \"text\" id=\"weighted4\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("    <td><input type = \"text\" id=\"teachName5\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("\t<td><input type = \"text\" id=\"grade5\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("\t<td><input type = \"text\" id=\"possible5\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("    <td><input type = \"text\" id=\"weight5\" value=\"\" onblur=\"gradingFunction5()\"style=\"width:auto;\"></td>\r\n");
      out.write("    <td><input type = \"text\" id=\"weighted5\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("    <td><input type = \"text\" id=\"teachName6\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("\t<td><input type = \"text\" id=\"grade6\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("\t<td><input type = \"text\" id=\"possible6\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("    <td><input type = \"text\" id=\"weight6\" value=\"\" onblur=\"gradingFunction6()\"style=\"width:auto;\"></td>\r\n");
      out.write("    <td><input type = \"text\" id=\"weighted6\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("    <td><input type = \"text\" id=\"teachName7\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("\t<td><input type = \"text\" id=\"grade7\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("\t<td><input type = \"text\" id=\"possible7\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("    <td><input type = \"text\" id=\"weight7\" value=\"\" onblur=\"gradingFunction7()\"style=\"width:auto;\"></td>\r\n");
      out.write("    <td><input type = \"text\" id=\"weighted7\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("    <td><input type = \"text\" id=\"teachName8\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("\t<td><input type = \"text\" id=\"grade8\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("\t<td><input type = \"text\" id=\"possible8\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("    <td><input type = \"text\" id=\"weight8\" value=\"\" onblur=\"gradingFunction8()\"style=\"width:auto;\"></td>\r\n");
      out.write("    <td><input type = \"text\" id=\"weighted8\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("    <td><input type = \"text\" id=\"teachName9\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("\t<td><input type = \"text\" id=\"grade9\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("\t<td><input type = \"text\" id=\"possible9\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("    <td><input type = \"text\" id=\"weight9\" value=\"\" onblur=\"gradingFunction9()\"style=\"width:auto;\"></td>\r\n");
      out.write("    <td><input type = \"text\" id=\"weighted9\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("    <td><input type = \"text\" id=\"teachName10\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("\t<td><input type = \"text\" id=\"grade10\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("\t<td><input type = \"text\" id=\"possible10\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("    <td><input type = \"text\" id=\"weight10\" value=\"\" onblur=\"gradingFunction10()\"style=\"width:auto;\"></td>\r\n");
      out.write("    <td><input type = \"text\" id=\"weighted10\" value=\"\" style=\"width:auto;\"></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("\t<th colspan=\"4\" style= \"background-color:#860038\">Weighted Total</th>\r\n");
      out.write("\t<td><input type = \"text\" id=\"total\" value=\"0\" ></td>\r\n");
      out.write("</table>\r\n");
      out.write("<button onclick=\"save();\" title=\"Save Grades\">Save</button>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
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
