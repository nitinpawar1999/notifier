/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-02-16 11:03:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import hibernate.model.Notebook;
import hibernate.model.Note;
import hibernate.dao.UserDao;

public final class editNote_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("  ");
 UserDao userDao=null; List<Notebook> notebookList = null;
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("    .newNoteModal{\r\n");
      out.write("  display: \"block\";\r\n");
      out.write("  position: fixed; /* Stay in place */\r\n");
      out.write("  z-index: 1; /* Sit on top */\r\n");
      out.write("  left: 0;\r\n");
      out.write("  top: 0;\r\n");
      out.write("  width: 100%; /* Full width */\r\n");
      out.write("  height: 100%; /* Full height */\r\n");
      out.write("  overflow: auto; /* Enable scroll if needed */\r\n");
      out.write("  background-color: rgb(0,0,0); /* Fallback color */\r\n");
      out.write("  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".newNoteModal .new-note-page{\r\n");
      out.write("  width: 950px;\r\n");
      out.write("  padding: 4% 0 0;\r\n");
      out.write("  margin: auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".newNoteModal .new-note-page .form{\r\n");
      out.write("  position: relative;\r\n");
      out.write("    z-index: 1;\r\n");
      out.write("    background: #FFFFFF;\r\n");
      out.write("    max-width: 950px;\r\n");
      out.write("    margin: 0 auto 100px;\r\n");
      out.write("    padding: 45px;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".newNoteModal .new-note-page .form .noteClose{\r\n");
      out.write("  color: #aaa;\r\n");
      out.write("  float: right;\r\n");
      out.write("  font-size: 28px;\r\n");
      out.write("  font-weight: bold;\r\n");
      out.write("  margin-top: -40px;\r\n");
      out.write("  margin-right: -25px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".newNoteModal .new-note-page .form .noteClose:hover,\r\n");
      out.write(".newNoteModal .new-note-page .form .noteClose:focus{\r\n");
      out.write("color: black;\r\n");
      out.write("  text-decoration: none;\r\n");
      out.write("  cursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".newNoteModal .new-note-page .form label{\r\n");
      out.write("  padding: auto;\r\n");
      out.write("  float: left;\r\n");
      out.write("  font-size: large;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(".newNoteModal .new-note-page .form input{\r\n");
      out.write("  font-family: \"Roboto\", sans-serif;\r\n");
      out.write("  outline: 0;\r\n");
      out.write("  background: #f2f2f2;\r\n");
      out.write("  width: 100%;\r\n");
      out.write("  border: 0;\r\n");
      out.write("  margin: 0 0 15px;\r\n");
      out.write("  padding: 15px;\r\n");
      out.write("  box-sizing: border-box;\r\n");
      out.write("  font-size: 14px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".newNoteModal .new-note-page .form .dateEntry{\r\n");
      out.write("  display: flex;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".newNoteModal .new-note-page .form .dateEntry > div label {\r\n");
      out.write("  padding: auto;\r\n");
      out.write("  font-size: large;\r\n");
      out.write("}\r\n");
      out.write(".newNoteModal .new-note-page .form .dateEntry > div input[type=\"Date\"]{\r\n");
      out.write("  width: 61%;\r\n");
      out.write("  height: 5%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".newNoteModal .new-note-page .form select{\r\n");
      out.write("  font-family: \"Roboto\", sans-serif;\r\n");
      out.write("  outline: 0;\r\n");
      out.write("  background: #f2f2f2;\r\n");
      out.write("  width: 100%;\r\n");
      out.write("  border: 0;\r\n");
      out.write("  margin: 0 0 15px;\r\n");
      out.write("  padding: 15px;\r\n");
      out.write("  box-sizing: border-box;\r\n");
      out.write("  font-size: 14px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".newNoteModal .new-note-page .form .description{\r\n");
      out.write("  font-family: \"Roboto\", sans-serif;\r\n");
      out.write("  outline: 0;\r\n");
      out.write("  background: #f2f2f2;\r\n");
      out.write("  width: 100%;\r\n");
      out.write("  height: 16%;\r\n");
      out.write("  border: 0;\r\n");
      out.write("  margin: 0 0 15px;\r\n");
      out.write("  padding: 15px;\r\n");
      out.write("  box-sizing: border-box;\r\n");
      out.write("  font-size: 14px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".newNoteModal .new-note-page .form input[type=\"submit\"] {\r\n");
      out.write("  font-family: \"Roboto\", sans-serif;\r\n");
      out.write("  text-transform: uppercase;\r\n");
      out.write("  outline: 0;\r\n");
      out.write("  background: #242e42;\r\n");
      out.write("  width: 100%;\r\n");
      out.write("  border: 0;\r\n");
      out.write("  padding: 15px;\r\n");
      out.write("  color: #FFFFFF;\r\n");
      out.write("  font-size: 14px;\r\n");
      out.write("  -webkit-transition: all 0.3 ease;\r\n");
      out.write("  transition: all 0.3 ease;\r\n");
      out.write("  transition-duration: 0.4s;\r\n");
      out.write("  cursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- New Note Modal -->\r\n");
      out.write("<div id=\"newNoteModal\" class=\"newNoteModal\">\r\n");
      out.write("\r\n");
      out.write("    <!-- New Note Modal content -->\r\n");
      out.write("    <div class=\"new-note-page\">\r\n");
      out.write("\r\n");
      out.write("      <div class=\"form\">\r\n");
      out.write("        <h2>EDIT NOTE</h2>\r\n");
      out.write("        <span id=\"noteClose\" class=\"noteClose\" onclick=\"javascript:window.history.back(-1);return false;\">&times;</span>\r\n");
      out.write("        <br><br>\r\n");
      out.write("        <form action=\"");
      out.print(request.getContextPath());
      out.write("/editNote\" method=\"post\">\r\n");
      out.write("          <label>Note Name</label>\r\n");
      out.write("          <br>\r\n");
      out.write("          <input type=\"text\" name=\"noteName\" placeholder=\"");
      out.print(request.getParameter("noteName"));
      out.write("\" required />\r\n");
      out.write("          <br>\r\n");
      out.write("          <div id=\"dateEntry\" class=\"dateEntry\">\r\n");
      out.write("            <div>\r\n");
      out.write("              <label>StartDate</label>\r\n");
      out.write("              <input type=\"date\" id=\"startDate\" name=\"startDate\" required>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div>\r\n");
      out.write("              <label>EndDate</label>\r\n");
      out.write("              <input type=\"date\" id=\"endDate\" name=\"endDate\" required>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div>\r\n");
      out.write("              <label>ReminderDate</label>\r\n");
      out.write("              <input type=\"date\" id=\"reminderDate\" name=\"reminderDate\" required>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("          </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("          <label>Status</label>\r\n");
      out.write("          <select id=\"status\" name=\"status\" required>\r\n");
      out.write("            <option value=\"Started\">Started</option>\r\n");
      out.write("            <option value=\"In Progress\">In Progess</option>\r\n");
      out.write("            <option value=\"Completed\">Completed</option>\r\n");
      out.write("          </select>\r\n");
      out.write("          <br>\r\n");
      out.write("          <label>Tag</label>\r\n");
      out.write("          <select id=\"tag\" name=\"tag\" required>\r\n");
      out.write("            <option value=\"Private\">Private</option>\r\n");
      out.write("            <option value=\"Public\">Public</option>\r\n");
      out.write("          </select>\r\n");
      out.write("          <br>\r\n");
      out.write("          <label>Notebook Name (If No Selection Available Create a Notebook)</label>\r\n");
      out.write("          <select id=\"notebookId\" name=\"notebookId\" required>\r\n");
      out.write("            ");
 userDao=new UserDao(); notebookList=userDao.getNotebookList(request); if(notebookList !=null){ 
      out.write("\r\n");
      out.write("              ");
for(Notebook notebook: notebookList){
      out.write("\r\n");
      out.write("                <option value=\"");
      out.print(notebook.getId());
      out.write("\">\r\n");
      out.write("                  ");
      out.print(notebook.getNotebookName());
      out.write("\r\n");
      out.write("                </option>\r\n");
      out.write("                ");
}} notebookList=null;
      out.write("\r\n");
      out.write("          </select>\r\n");
      out.write("          <br>\r\n");
      out.write("          <label>Description</label>\r\n");
      out.write("          <textarea name=\"description\" id=\"description\" class=\"description\" placeholder=\"");
      out.print(request.getParameter("description"));
      out.write("\"\r\n");
      out.write("            required></textarea>\r\n");
      out.write("          <br>\r\n");
      out.write("          <input type=\"hidden\" name=\"noteId\" value=\"");
      out.print(request.getParameter("noteId"));
      out.write("\">\r\n");
      out.write("          <input type=\"submit\" value=\"Submit\" />\r\n");
      out.write("        </form>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("  </div>\r\n");
      out.write("  <!-------------------------------------------------------------------------------------------->\r\n");
      out.write("  <script>\r\n");
      out.write("    window.onclick = function(event) {\r\n");
      out.write("  if (event.target == newNoteModal) {\r\n");
      out.write("    window.history.back(-1);return false;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("  </script>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
