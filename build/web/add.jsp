<%-- 
    Document   : add
    Created on : 26-Jan-2020, 12:05:54
    Author     : Arpit mishra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="com.Beans.Person,com.DAOS.PersonDao"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Register</title>
        <link rel="icon" href="Assets/images/register.ico" type="x/image"/>
        <jsp:include page="base.jsp"></jsp:include>
            <script type="text/javascript">
               $(document).ready(function () {
                    $("#form1").submit(function (e) {

                        x = $("#password").val();
                        y = $("#cpassword").val();

                        if (x === y)
                            return true;
                        else
                        {
                            alert('sorry! password and confirm password not matched');
                            e.preventDefault();
                        }
                    });

                    $("#userid").blur(function () {
                        $("#sp1").load("PersonController?op=check_userid&userid=" + $(this).val());
                    });

                    $("#accept").change(function () {
                        if ($(this).prop("checked") == true) 
                            $("#submit").prop("disabled",false);
                       else  
                             $("#submit").prop("disabled",true);
                       
                    });

                });

                

            </script>

              
            
        </head>
        <body>
               <jsp:useBean class="com.Beans.Person" id="person" scope="session"></jsp:useBean>
        <center><h2>Registration page </h2></center>
        <form  method='post'  class="form" onsubmit="return matchPwd(password.value, cpassword.value);" action="addPic.jsp"> 
            <table width="600" class="table">
                <tr>
                    <td>Enter Name </td>
                    <td><input type="text" name="name" required="required" class="form-control" value="${person.name}"></td>
                </tr>
                <tr>
                    <td>Enter Father Name </td>
                    <td><input type="text" name="fname" required="required"  class="form-control" value="${person.fname}">

                    </td>
                </tr>   
                <tr>
                    <td>Enter UserID </td>
                    <td><input type="text" name="userid" required="required" class="form-control" id="userid" value="${person.userid}">
                        <span id ="sp1"> </span>
                    </td>
                </tr>
                <tr>
                    <td>Enter Password</td>
                    <td><input type="password" pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$" name="password" id="password" required="required" class="form-control" value="${person.password}">
                        <br/>
                        <b>Password must contains atleast one uppercase,one lowercase , one special char and more than 8 characters</b>
                    </td>
                </tr>
                <tr>
                    <td>Confirm Password</td>
                    <td><input type="password" name="cpassword" id="cpassword" required="required" class ="form-control" value="${person.password}"></td>
                </tr>
                <tr>
                    <td>Enter Age</td>
                    <td><input type="number" name="age"class="form-control" value="${person.age}"></td>
                </tr>
                <tr>
                    <td>Select Gender </td>
                    <td>
                        <input type="radio" name="gender" value="Male" ${person.gender eq "Male" ? "checked": ""} />Male
                        <br/>
                        <input type="radio" name="gender" value="Female" ${person.gender eq "Female" ? "checked": ""}/> Female
                    </td>
                </tr>
                <tr>
                    <td>Select Your Hobbies : </td>
                    <td>
                        <input type="checkbox" name="hobbies" value="Dacning"${person.hobbies.contains("Dacning") ? "checked": ""}>Dancing
                        <input type="checkbox" name="hobbies" value="Singing"${person.hobbies.contains("Singing") ? "checked": ""}>Singing <br/>
                        <input type="checkbox" name="hobbies" value="Cooking" ${person.hobbies.contains("Cooking") ? "checked": ""}>Cooking
                        <input type="checkbox" name="hobbies" value="Drawing"${person.hobbies.contains("Drawing") ? "checked": ""}>Drawing <br/>

                    </td>
                </tr>
               
                <tr>
                    <th> <input type="checkbox" value="accept" name="accept" id="accept" onchange="checkValue(this, submit)"/> Accept Terms and Contdi..</th>
                    <th><input type="submit" name="submit" id="submit" value="Next page" class="btn btn-primary" disabled="disabled"> </th>
                </tr>
            </table>

        </form>
</body>
</html>