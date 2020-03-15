<%-- 
    Document   : edit
    Created on : Feb 27, 2020, 9:54:18 AM
    Author     : Arpit mishra
--%>



<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*,com.DAOS.PersonDao,com.Beans.Person"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="base.jsp"></jsp:include>
            <script type="text/javascript">

                function readURL(input) {
                    //       alert('hello');
                    if (input.files && input.files[0]) {
                        var reader = new FileReader();

                        reader.onload = function (e) {
                            preview.src = e.target.result;
                        };

                        reader.readAsDataURL(input.files[0]);
                    }
                }
            </script>
        </head>
        <body>
        <jsp:useBean class="com.Beans.Person" id="person1" scope="session"></jsp:useBean>
        <%
            int id = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0;
            PersonDao pd = new PersonDao();
            person1 = pd.getById(id);
            session.setAttribute("person", person1);

        %>

    <center><h2> Updation page </h2></center>

    <form method='post' class="form" > 
        <input type="text" value="<%=person1.getId()%>" readonly="readonly" name="id"/>
        <table width="600">
            <tr>
                <td>Enter Name </td>
                <td><input type="text" name="name" required="required" value="<%=person1.getName()%>"></td>
            </tr>
            <tr>
                <td>Enter Father Name </td>
                <td><input type="text" name="fname" required="required" value="<%=person1.getFname()%>"></td>
            </tr>
            <tr>
                <td>Enter Age</td>
                <td><input type="number" name="age"  value="<%=person1.getAge()%>"></td>
            </tr>

            <tr>
                <td>Your UserID</td>
                <td><input type="text" name="userid"  value="<%=person1.getUserid()%>" readonly="readonly"></td>
            </tr>
            <tr>
                <td>Select Gender </td>
                <td>
                    <input type="radio" name="gender" value="Male"<%if (person1.getGender().equalsIgnoreCase("Male")) {
                            out.println("checked='checked'");
                        } %>/>Male
                    <br/>
                    <input type="radio" name="gender" value="Female" <%if (person1.getGender().equalsIgnoreCase("Female")) {
                            out.println("checked='checked'");
                        } %>/> Female
                </td>
            </tr>
            <tr>
                <td>Select Your Hobbies : </td>
                <td>
                    <input type="checkbox" name="hobbies" value="Dancing" <%if (person1.getHobbies().contains("Dancing")) {
                            out.println("checked='checked'");
                        } %>>Dancing
                    <input type="checkbox" name="hobbies" value="Singing" <%if (person1.getHobbies().contains("Singing")) {
                            out.println("checked='checked'");
                        } %>>Singing <br/>
                    <input type="checkbox" name="hobbies" value="Cooking" <%if (person1.getHobbies().contains("Cooking")) {
                            out.println("checked='checked'");
                        } %>>Cooking
                    <input type="checkbox" name="hobbies" value="Drawing" <%if (person1.getHobbies().contains("Drawing")) {
                            out.println("checked='checked'");
                        }%>>Drawing <br/>

                </td>
            </tr>
            <tr>
                <th colspan="2"><input type="submit" name="submit" value="Click here to Check Profile Image" class="btn btn-primary"> </th>
            </tr>
        </table>

    </form>

    <%if (request.getParameter("submit") != null) {%> 
    <jsp:setProperty name="person" property="*"></jsp:setProperty>

        <form action="PersonController?op=update" method="post" enctype="multipart/form-data" class="form"> 
            <img src="${person.image}" class="img img-thumbnail" width="20%" height="20%" id="preview"/> <br/>
        <input type="file" name="photo"   onchange="readURL(this);"/><br/><br>
        <input type="submit" value="Update" class="btn btn-primary form-control"/>
    </form>  

<%}%>

</body>
</html>
