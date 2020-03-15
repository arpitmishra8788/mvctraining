<%-- 
    Document   : jquery
    Created on : Feb 28, 2020, 10:19:12 AM
    Author     : Arpit mishra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JQuery page</title>
        <jsp:include page="base.jsp"></jsp:include>
        
    </head>
    <body>
        <input type="button" value="Hide div" id="b1"/>
           <input type="button" value="Show div" id="b2"/>
           <input type="button" value="Show/hide div" id="b3"/>
           
           <div id="div1" style="background-color: gray; height: 100px "></div>
           <script>
            
                $("#b1").click(function(){
                    $("#div1").slideUp(2000,function(){ alert("Div is Hidden now");});
                    
                });
                $("#b2").click(function(){
                    $("#div1").slideDown(2000,function(){ alert("Div is Show now");});
                });
                $("#b3").click(function(){
                    $("#div1").slideToggle(2000);
                });
            
            </script>
    </body>
</html>
