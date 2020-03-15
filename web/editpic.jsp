<%-- 
    Document   : editpic
    Created on : Feb 27, 2020, 11:14:31 PM
    Author     : Arpit mishra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*" import="com.Beans.Person,com.DAOS.PersonDao, java.util.ArrayList"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Pic</title>
    </head>
    <body>
        <h1> </h1>
        
         <%if (request.getParameter("submit")!=null){%>
            <jsp:useBean class="com.Beans.Person" id="person1" scope="request"></jsp:useBean>
            <jsp:setProperty name="person1"  property="*"></jsp:setProperty>
            
            <%
                if(pd.update(person1))
                    response.sendRedirect("show.jsp");
            }%>

    
    
    
    </body>
</html>
