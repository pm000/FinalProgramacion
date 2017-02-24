

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    session.removeAttribute("token"); 

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Nombre de usuario o contraseña incorrectos</h2>
        <br>
        <h3>Cheque la informacion e intente nuevamente</h3>
        <br>
        <form action="login.jsp">
            <input type=submit value="Volver">
        </form>
    </body>
</html>
