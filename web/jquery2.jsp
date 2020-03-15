<%-- 
    Document   : jquery2
    Created on : Feb 28, 2020, 11:03:47 AM
    Author     : Arpit mishra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="base.jsp"></jsp:include>
    </head>
    <body>
        <pre>
            Enter first No: <input type="text" id="t1"/><br/>
            Enter second No: <input type="text" id="t2"/><br/>
                    <input type="button" value="Find Sum" id="b1"/>
                    <span id="result"></span>
                    
        </pre>
        <script>
            $("#b1").click(function(){
                a = Number($("#t1").val())+Number($("#t2").val());
                $("#result").html("<b> SUM = " + a +"</b>");
            });
            $("input").focus(function(){
            $("#result").html("");
        });

        </script>
    </body>
</html>
