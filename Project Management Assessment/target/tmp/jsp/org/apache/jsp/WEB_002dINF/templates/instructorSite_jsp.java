/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.2.11.v20150529
 * Generated at: 2016-04-20 19:21:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.templates;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class instructorSite_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("file:/C:/Users/Chris/.m2/repository/javax/servlet/jstl/1.2/jstl-1.2.jar", Long.valueOf(1461179699183L));
    _jspx_dependants.put("jar:file:/C:/Users/Chris/.m2/repository/javax/servlet/jstl/1.2/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153399482000L));
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

      out.write("\r\n");
      out.write("<!DOCTYPE HTML>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<title>PM Assessment</title>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"http://ajax.googleapis.com/ajax/libs/dojo/1.10.4/dijit/themes/claro/claro.css\" > \r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("html, body { \r\n");
      out.write("    height: 100%; \r\n");
      out.write("    margin: 0; \r\n");
      out.write("    overflow: hidden; \r\n");
      out.write("    padding: 0; \r\n");
      out.write("} \r\n");
      out.write("\r\n");
      out.write("#appLayout { \r\n");
      out.write("    height: 100%; \r\n");
      out.write("} \r\n");
      out.write("#leftCol { \r\n");
      out.write("    width: 14em; \r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write(" <script src=\"http://ajax.googleapis.com/ajax/libs/dojo/1.10.4/dojo/dojo.js\"     \r\n");
      out.write("    data-dojo-config=\"parseOnLoad: true\">\r\n");
      out.write(" </script>  \r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    dojo.require(\"dojo.parser\");\r\n");
      out.write("    dojo.require(\"dojo.query\");\r\n");
      out.write("    dojo.require(\"dojo.dom-attr\");\r\n");
      out.write("    dojo.require(\"dojo.on\");\r\n");
      out.write("    dojo.require(\"dojo.ready\");\r\n");
      out.write("    dojo.require(\"dijit.layout.BorderContainer\");\r\n");
      out.write("    dojo.require(\"dijit.layout.TabContainer\");\r\n");
      out.write("    dojo.require(\"dijit.layout.ContentPane\");\r\n");
      out.write("    dojo.require(\"dijit.form.Button\")\r\n");
      out.write("    dojo.require(\"dijit.registry\")\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    var classes = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.classes}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\".split(\",\");\r\n");
      out.write("    var assessments = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.assessments}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\".split(\",\");\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("    require([\"dijit/layout/AccordionContainer\", \"dijit/layout/ContentPane\", \"dojo/domReady!\"],\r\n");
      out.write("        function(AccordionContainer, ContentPane){\r\n");
      out.write("            var aContainer = new AccordionContainer({style: \"height:20%;\"}, \"tabContainer\");\r\n");
      out.write("            for(i=0; i< classes.length; i++){\r\n");
      out.write("                aContainer.addChild(new ContentPane({\r\n");
      out.write("                title: classes[i],\r\n");
      out.write("                id: classes[i].replace(\" \",\"\")\r\n");
      out.write("                }));\r\n");
      out.write("                \r\n");
      out.write("                console.log(dijit.byId(classes[i].replace(\" \",\"\")).get(\"id\"));\r\n");
      out.write("            }\r\n");
      out.write("            aContainer.startup();\r\n");
      out.write("            createButtons();\r\n");
      out.write("    });\r\n");
      out.write("    \r\n");
      out.write("    function createLabel(type) {\r\n");
      out.write("        if(type == \"peer\"){\r\n");
      out.write("            return \"Peer Assessment\";\r\n");
      out.write("        }\r\n");
      out.write("        else if(type == \"self\"){\r\n");
      out.write("            return \"Self Evaluation\";\r\n");
      out.write("        }\r\n");
      out.write("        else{\r\n");
      out.write("            return \"Assessment not found\";\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    function setAssessmentButtonEvent(type){\r\n");
      out.write("        console.log(type);\r\n");
      out.write("        if(type == \"peer\"){\r\n");
      out.write("            dojo.place(\"<iframe id='assessmentDiv' src='/PMA/peer' style='height:75%;width:100%;'></iframe>\", \"assessmentDiv\", \"replace\");\r\n");
      out.write("        }\r\n");
      out.write("        else if(type == \"self\"){\r\n");
      out.write("            dojo.place(\"<iframe id='assessmentDiv' src='/PMA/self' style='height:75%;width:100%;'></iframe>\", \"assessmentDiv\", \"replace\");\r\n");
      out.write("        }\r\n");
      out.write("        else{\r\n");
      out.write("            console.log(\"Nothing here\");\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    function createButtons(){\r\n");
      out.write("//        dojo.place(\"<button id='\"classes[0].replace(\" \",\"\") + i\"' type='button'></button>\", classes[0].replace(\" \",\"\"), \"after\");\r\n");
      out.write("        for(i=0;i<assessments.length; i++){\r\n");
      out.write("            var buttonId = classes[0].replace(\" \",\"\").concat(i);\r\n");
      out.write("            var nodePath = \"<button id='\".concat(buttonId.concat(\"' type='button'></button>\"));\r\n");
      out.write("            dojo.place(nodePath, classes[0].replace(\" \",\"\"), \"after\");\r\n");
      out.write("            var myButton = new dijit.form.Button({\r\n");
      out.write("                label: createLabel(assessments[i]),\r\n");
      out.write("                title: assessments[i],\r\n");
      out.write("                onClick: function(event){var button = dijit.registry.getEnclosingWidget(event.target);\r\n");
      out.write("                    setAssessmentButtonEvent(button.title)}\r\n");
      out.write("            }, buttonId).startup();\r\n");
      out.write("            \r\n");
      out.write("            //dojo.on(dijit.byId(buttonId), \"click\", setAssessmentButtonEvent(assessments[i]));\r\n");
      out.write("//            dojo.place(myButton, classes[0].replace(\" \",\"\"), \"after\");\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("\tfunction gradingFunction() {\r\n");
      out.write("    document.getElementById(\r\n");
      out.write("\"weighted1\").value = document.getElementById(\"weight1\").value * document.getElementById(\"grade1\").value;\r\n");
      out.write("    document.getElementById(\r\n");
      out.write("\"weighted2\").value = document.getElementById(\"weight2\").value * document.getElementById(\"grade2\").value;\r\n");
      out.write("    document.getElementById(\r\n");
      out.write("\"weighted3\").value = document.getElementById(\"weight3\").value * document.getElementById(\"grade3\").value;\r\n");
      out.write("    document.getElementById(\r\n");
      out.write("\"weighted4\").value = document.getElementById(\"weight4\").value * document.getElementById(\"grade4\").value;\r\n");
      out.write("    document.getElementById(\r\n");
      out.write("\"total\").value = Number(document.getElementById(\"weighted1\").value) + Number(document.getElementById(\"weighted2\").value) + Number(document.getElementById(\"weighted3\").value) + Number(document.getElementById(\"weighted4\").value);\r\n");
      out.write("}\r\n");
      out.write("   \r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body class=\"claro\">\r\n");
      out.write("    <div id=\"appLayout\" class=\"demoLayout\"\r\n");
      out.write("        data-dojo-type=\"dijit.layout.BorderContainer\"\r\n");
      out.write("        data-dojo-props=\"design: 'headline'\">\r\n");
      out.write("        <div class=\"centerPanel\" data-dojo-type=\"dijit.layout.ContentPane\"\r\n");
      out.write("             data-dojo-props=\"region: 'center'\"> <!-- href=\"/PMA/instructorTabContainer\"-->\r\n");
      out.write("            <div id=\"tabContainer\" style=\"width:100%; height:25%;\"></div>\r\n");
      out.write("            <div id='assessmentDiv'>No assessment is currently selected</div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"edgePanel\" data-dojo-type=\"dijit.layout.ContentPane\"\r\n");
      out.write("            data-dojo-props=\"region: 'top'\">Header</div>\r\n");
      out.write("        <div id=\"leftCol\" class=\"edgePanel\"\r\n");
      out.write("            data-dojo-type=\"dijit.layout.ContentPane\"\r\n");
      out.write("            data-dojo-props=\"region: 'right', splitter: true\">\r\n");
      out.write("                <div style=\"width: auto; height: 300px\">\r\n");
      out.write("                    <div data-dojo-type=\"dijit/layout/AccordionContainer\" style=\"height: 300px;\">\r\n");
      out.write("                        <div data-dojo-type=\"dijit/layout/ContentPane\" title=\"Presentation Grade\" selected=\"true\">\r\n");
      out.write("                            <form>\r\n");
      out.write("\t\t\t\t\t\t\t<table border = 1 style=\"width:10%\">\r\n");
      out.write("\t\t\t\t\t\t\t  <tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input type = \"text\" id=\"teachName1\" value=\"Prof. Devine\" style=\"width:auto;\"</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input type = \"text\" id=\"grade1\" value=\"\" style=\"width:auto;\"</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input type = \"text\" id=\"weight1\" value=\"\" onblur=\"gradingFunction()\" style=\"width:auto;\"</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input type = \"text\" id=\"weighted1\" value=\"\" style=\"width:auto;\"</td>\r\n");
      out.write("\t\t\t\t\t\t\t  </tr>\r\n");
      out.write("\t\t\t\t\t\t\t  <tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input type = \"text\" id=\"teachName2\" value=\"Dr. Giorcelli\" style=\"width:auto;\"</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input type = \"text\" id=\"grade2\" value=\"\" style=\"width:auto;\"</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input type = \"text\" id=\"weight2\" value=\"\" onblur=\"gradingFunction()\"style=\"width:auto;\"</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input type = \"text\" id=\"weighted2\" value=\"\" style=\"width:auto;\"</td>\r\n");
      out.write("\t\t\t\t\t\t\t  </tr>\r\n");
      out.write("\t\t\t\t\t\t\t  <tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input type = \"text\" id=\"teachName3\" value=\"Ms. RaeAnne\" style=\"width:auto;\"</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input type = \"text\" id=\"grade3\" value=\"\" style=\"width:auto;\"</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input type = \"text\" id=\"weight3\" value=\"\" onblur=\"gradingFunction()\"style=\"width:auto;\"</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input type = \"text\" id=\"weighted3\" value=\"\" style=\"width:auto;\"</td>\r\n");
      out.write("\t\t\t\t\t\t\t  </tr>\r\n");
      out.write("\t\t\t\t\t\t\t  <tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input type = \"text\" id=\"teachName4\" value=\"Ms. Jennifer\" style=\"width:auto;\"</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input type = \"text\" id=\"grade4\" value=\"\" style=\"width:auto;\"</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input type = \"text\" id=\"weight4\" value=\"\" onblur=\"gradingFunction()\"style=\"width:auto;\"</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input type = \"text\" id=\"weighted4\" value=\"\" style=\"width:auto;\"</td>\r\n");
      out.write("\t\t\t\t\t\t\t  </tr>\r\n");
      out.write("\t\t\t\t\t\t\t  <tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th colspan=\"3\">Weighted Total</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input type = \"text\" id=\"total\" value=\"0\" </td>\r\n");
      out.write("\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t</form>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div data-dojo-type=\"dijit/layout/ContentPane\" title=\"Instructor Options\">\r\n");
      out.write("                            Feature to be implemented in future release\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div data-dojo-type=\"dijit/layout/ContentPane\" title=\"Instructor Options\">\r\n");
      out.write("                            Feature to be implemented in future release\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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