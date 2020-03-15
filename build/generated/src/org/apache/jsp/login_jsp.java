package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.Beans.Reporter;
import com.DAOS.ReporterDaos;
import java.util.Date;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"Mark Otto, Jacob Thornton, and Bootstrap contributors\">\n");
      out.write("    <meta name=\"generator\" content=\"Jekyll v3.8.6\">\n");
      out.write("    <title>Signin Template · Bootstrap</title>\n");
      out.write("\n");
      out.write("    <link rel=\"canonical\" href=\"https://getbootstrap.com/docs/4.4/examples/sign-in/\">\n");
      out.write("\n");
      out.write("    <!-- Bootstrap core CSS -->\n");
      out.write("<link href=\"https://getbootstrap.com/docs/4.4/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("    <!-- Favicons -->\n");
      out.write("<link rel=\"apple-touch-icon\" href=\"https://getbootstrap.com/docs/4.4/assets/img/favicons/apple-touch-icon.png\" sizes=\"180x180\">\n");
      out.write("<link rel=\"icon\" href=\"https://getbootstrap.com/docs/4.4/assets/img/favicons/favicon-32x32.png\" sizes=\"32x32\" type=\"image/png\">\n");
      out.write("<link rel=\"icon\" href=\"https://getbootstrap.com/docs/4.4/assets/img/favicons/favicon-16x16.png\" sizes=\"16x16\" type=\"image/png\">\n");
      out.write("<link rel=\"manifest\" href=\"https://getbootstrap.com/docs/4.4/assets/img/favicons/manifest.json\">\n");
      out.write("<link rel=\"mask-icon\" href=\"https://getbootstrap.com/docs/4.4/assets/img/favicons/safari-pinned-tab.svg\" color=\"#563d7c\">\n");
      out.write("<link rel=\"icon\" href=\"https://getbootstrap.com/docs/4.4/assets/img/favicons/favicon.ico\">\n");
      out.write("<meta name=\"msapplication-config\" content=\"https://getbootstrap.com/docs/4.4/assets/img/favicons/browserconfig.xml\">\n");
      out.write("<meta name=\"theme-color\" content=\"#563d7c\">\n");
      out.write("\n");
      out.write("\n");
      out.write("    <style>\n");
      out.write("      .bd-placeholder-img {\n");
      out.write("        font-size: 1.125rem;\n");
      out.write("        text-anchor: middle;\n");
      out.write("        -webkit-user-select: none;\n");
      out.write("        -moz-user-select: none;\n");
      out.write("        -ms-user-select: none;\n");
      out.write("        user-select: none;\n");
      out.write("      }\n");
      out.write("\n");
      out.write("      @media (min-width: 768px) {\n");
      out.write("        .bd-placeholder-img-lg {\n");
      out.write("          font-size: 3.5rem;\n");
      out.write("        }\n");
      out.write("      }\n");
      out.write("    </style>\n");
      out.write("    <!-- Custom styles for this template -->\n");
      out.write("    <link href=\"https://getbootstrap.com/docs/4.4/examples/sign-in/signin.css\" rel=\"stylesheet\">\n");
      out.write("  </head>\n");
      out.write("  <body class=\"text-center\">\n");
      out.write("      ");

          //Reading cookie 
           Cookie cookies[] = request.getCookies();
           String userid="",password="";
           
           for(Cookie c : cookies){
               if(c.getName().equals("userid"))
               {
                   userid=c.getValue();
               }
               if (c.getName().equals("password"))
               {
                   password = c.getValue();
               }
           }
       
      out.write("\n");
      out.write("      \n");
      out.write("      \n");
      out.write("      <form class=\"form-signin\"  method=\"post\">\n");
      out.write("  <img class=\"mb-4\" src=\"Assets/images/login.ico\" alt=\"\" width=\"72\" height=\"72\">\n");
      out.write("  <h1 class=\"h3 mb-3 font-weight-normal\">Please sign in</h1>\n");
      out.write("  <label for=\"inputEmail\" class=\"sr-only\">Email address</label>\n");
      out.write("  <input type=\"text\" id=\"inputEmail\" class=\"form-control\" placeholder=\"userid\" value=\"");
      out.print(userid);
      out.write("\"  autocomplete=\"off\" required autofocus name=\"userid\">\n");
      out.write("  <label for=\"inputPassword\" class=\"sr-only\">Password</label>\n");
      out.write("  <input type=\"password\" id=\"inputPassword\" class=\"form-control\" placeholder=\"Password\"  value=\"");
      out.print(password);
      out.write("\" name=\"password\" required>\n");
      out.write("  <div class=\"checkbox mb-3\">\n");
      out.write("    <label>\n");
      out.write("      <input type=\"checkbox\" name=\"remember\" value=\"remember\"> Remember me\n");
      out.write("    </label>\n");
      out.write("  </div>\n");
      out.write("  <button class=\"btn btn-lg btn-primary btn-block\" type=\"submit\" name=\"submit\">Sign in</button>\n");
      out.write("  <p class=\"mt-5 mb-3 text-muted\">&copy; 2017-");
      out.print(new Date().getYear()+1900 );
      out.write("</p>\n");
      out.write("  <p>\n");
      out.write("      <span style=\"color:red; font-family: corble; font-size: 16px\">\n");
      out.write("    ");
      out.print(request.getParameter("msg")!=null?request.getParameter("msg"):"");
      out.write("\n");
      out.write("</span>\n");
      out.write("  </p>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("      ");
 if(request.getParameter("submit")!=null){
           userid= request.getParameter("userid");
           password = request.getParameter("password");
          
           ReporterDaos rd = new ReporterDaos();
           int id = rd.isValid(userid, password);
           if(id!=-1)
           {
               Reporter reporter = rd.getById(id);
               session.setAttribute("reporter", reporter);
               response.sendRedirect("reporter/addNews.jsp");
           }
           else
            response.sendRedirect("login.jsp?msg=Invalid Userid or Password");
      }
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
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
