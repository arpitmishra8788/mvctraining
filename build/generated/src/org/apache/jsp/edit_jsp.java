package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import com.DAOS.PersonDao;
import com.Beans.Person;

public final class edit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "base.jsp", out, false);
      out.write("\n");
      out.write("         <script type=\"text/javascript\"> \n");
      out.write("            \n");
      out.write("               function readURL(input) {\n");
      out.write("            //       alert('hello');\n");
      out.write("            if (input.files && input.files[0]) {\n");
      out.write("                var reader = new FileReader();\n");
      out.write("\n");
      out.write("                reader.onload = function (e) {\n");
      out.write("                   preview.src= e.target.result;\n");
      out.write("                };\n");
      out.write("\n");
      out.write("                reader.readAsDataURL(input.files[0]);\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("      </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         ");
      com.Beans.Person person = null;
      synchronized (session) {
        person = (com.Beans.Person) _jspx_page_context.getAttribute("person", PageContext.SESSION_SCOPE);
        if (person == null){
          person = new com.Beans.Person();
          _jspx_page_context.setAttribute("person", person, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("        ");

            int id = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0;
            PersonDao pd = new PersonDao();
            person = pd.getById(id);
               session.setAttribute("person", person); 
            
        
      out.write("\n");
      out.write("\n");
      out.write("    <center><h2> Updation page </h2></center>\n");
      out.write("\n");
      out.write("    <form method='post' enctype=\"multipart/form-data\" class=\"form\" > \n");
      out.write("        <input type=\"text\" value=\"");
      out.print(person.getId());
      out.write("\" readonly=\"readonly\" name=\"id\"/>\n");
      out.write("        <table width=\"600\">\n");
      out.write("            <tr>\n");
      out.write("                <td>Enter Name </td>\n");
      out.write("                <td><input type=\"text\" name=\"name\" required=\"required\" value=\"");
      out.print(person.getName());
      out.write("\"></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Enter Father Name </td>\n");
      out.write("                <td><input type=\"text\" name=\"fname\" required=\"required\" value=\"");
      out.print(person.getFname());
      out.write("\"></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Enter Age</td>\n");
      out.write("                <td><input type=\"number\" name=\"age\"  value=\"");
      out.print(person.getAge());
      out.write("\"></td>\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>Your UserID</td>\n");
      out.write("                <td><input type=\"text\" name=\"userid\"  value=\"");
      out.print(person.getUserid());
      out.write("\" readonly=\"readonly\"></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Select Gender </td>\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"radio\" name=\"gender\" value=\"Male\"");
if (person.getGender().equalsIgnoreCase("Male")) {
                                    out.println("checked='checked'");
                                } 
      out.write("/>Male\n");
      out.write("                    <br/>\n");
      out.write("                    <input type=\"radio\" name=\"gender\" value=\"Female\" ");
if (person.getGender().equalsIgnoreCase("Female")) {
                out.println("checked='checked'");
            } 
      out.write("/> Female\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Select Your Hobbies : </td>\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"checkbox\" name=\"hobbies\" value=\"Dancing\" ");
if (person.getHobbies().contains("Dancing")) {
                                    out.println("checked='checked'");
                                } 
      out.write(">Dancing\n");
      out.write("                    <input type=\"checkbox\" name=\"hobbies\" value=\"Singing\" ");
if (person.getHobbies().contains("Singing")) {
                out.println("checked='checked'");
            } 
      out.write(">Singing <br/>\n");
      out.write("                    <input type=\"checkbox\" name=\"hobbies\" value=\"Cooking\" ");
if (person.getHobbies().contains("Cooking")) {
                out.println("checked='checked'");
            } 
      out.write(">Cooking\n");
      out.write("                    <input type=\"checkbox\" name=\"hobbies\" value=\"Drawing\" ");
if (person.getHobbies().contains("Drawing")) {
                out.println("checked='checked'");
            }
      out.write(">Drawing <br/>\n");
      out.write("\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <th colspan=\"2\"><input type=\"submit\" name=\"submit\" value=\"Click here to Check Profile Image\" class=\"btn btn-primary\"> </th>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("    </form>\n");
      out.write("            \n");
      out.write("             ");
if(request.getParameter("submit")!=null){
      out.write(" \n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("person"), request);
      out.write("\n");
      out.write("            \n");
      out.write("                <form action=\"PersonController?op=update\" method=\"post\" enctype=\"multipart/form-data\" class=\"form\"> \n");
      out.write("                <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${person.image}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"img img-thumbnail\" width=\"20%\" height=\"20%\" id=\"preview\"/> <br/>\n");
      out.write("                 <input type=\"file\" name=\"photo\"   onchange=\"readURL(this);\"/><br/><br>\n");
      out.write("                       <input type=\"submit\" value=\"Update\" class=\"btn btn-primary form-control\"/>\n");
      out.write("                </form>  \n");
      out.write("           \n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
}} catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
