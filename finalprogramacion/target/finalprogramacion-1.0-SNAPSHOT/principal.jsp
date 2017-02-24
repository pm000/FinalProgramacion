

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:useBean id="usuario" class="Modelo.Usuario" scope="session"/>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>        
        Que haces <jsp:getProperty name="usuario" property="usuario"/>!!        
        tu pass es <jsp:getProperty name="usuario" property="pass"/> 
        <br>
        (usando getProperty)
        <br>
        o tambien, tu nombre es             
        <%= usuario.getUsuario()%> y tu pass <%= usuario.getPass()%>
        <br>  
        (usando expresiones)
        <br>
        Estas son las formas de utilizar los jspBeans con set y get property...
        <br>
        <form action="login.jsp">
            <input type=submit value="Volver">
        </form>
     
    </body>
</html>
