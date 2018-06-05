<%-- 
    Document   : newjsp
    Created on : 30/05/2018, 09:08:41 PM
    Author     : Aníbal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String msg = request.getParameter("msg");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <title>Ingreso</title>
    </head>
    <body>
        <h1>Ingreso SGC</h1>
        <h1>
            <form method="post" action="login">
                Usuario:<input type="text" name="usuario"><br><br>
                Contraseña:<input type="text" name="contr"><br><br>
                <input type="submit" value="Login">
            </form>
           <br>
            <%
                if(msg!=null) out.println("Error: " + msg);
            %>
        </h1>
    </body>
</html>
 
