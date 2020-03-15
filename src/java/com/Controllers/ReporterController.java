 
package com.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.Beans.Reporter;
import com.DAOS.ReporterDaos;
import com.utilities.FileUploadUtility;

public class ReporterController extends HttpServlet {

    
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out= response.getWriter();
        response.setContentType("text/html");
        String op =request.getParameter("op");
        
        if (op!=null && op.equalsIgnoreCase("add")){
            HttpSession session = request.getSession();
            Reporter reporter = (Reporter)session.getAttribute("reporter");
            ReporterDaos rd = new ReporterDaos();
            
            String ImagePath = "";
            ImagePath  = FileUploadUtility.getUploadedPath(getServletContext(), "media/reporter", request);
            reporter.setImage(ImagePath);
            
            if(rd.add(reporter)){
                session.removeAttribute("reporter");
                out.println("Reproter Added Successfully !");
            }
        }
    }

     
}
