
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Usuario"%>
<%@page import="Controladora.ConexionAPI"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%    
ConexionAPI aux;
List<Usuario> listauxiliar;
%>
<%
String tokenlogueado =(String)session.getAttribute("tokenlogueado");
%>
        
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        

        Token es <%=tokenlogueado%>
        
<%     

        aux = new ConexionAPI();
        listauxiliar = new ArrayList<Usuario>();
        listauxiliar = aux.sendGetListaUsuarios(tokenlogueado);

        for(int x=0;x<listauxiliar.size();x++) {
            String nombre = listauxiliar.get(x).getNombre();
%>
        Nombre: <%= nombre%>
 <%
            }
%>





    </body>
</html>
