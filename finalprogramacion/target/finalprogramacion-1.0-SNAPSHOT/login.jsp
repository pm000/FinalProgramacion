
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page session="true" %>


<% session.setAttribute("tokenlogueado", null); %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%-- <form action="Logueo" method="post">   --%>     
         <form action="procesa.jsp" method="post"> 
        
       <%-- podemos utilizar un servlet como comtroladora --%>
          
            <h2> Login </h2> <br><br>
            Usuario <input type="text" name="usuario"> <br><br>
            Password <input type="password" name="password"> <br><br>
            <input type=submit value="Aceptar">
            
        </form>
    </body>
</html>
