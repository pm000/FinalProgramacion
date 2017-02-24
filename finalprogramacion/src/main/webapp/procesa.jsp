
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="Controladora.ConexionAPI"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- jsp:useBean id="usuario" class="Modelo.Usuario" scope="session"/> -->

<!--jsp:useBean es analogo a declarar una variable, la diferencia es que el scope (alcance)  -->
<!--lo definimos nosotros, ¿como es esto ?-->
<!--osea, si la guardamos en la session, aplication o solo la usamos en esta pagina -->
<!--scope="page"  -  solo en esta pagina -->
<!--scope="session"  -  solo en esta sesion -->
<!--scope="aplication"  -  en toda la aplicacion -->
        
<!-- jsp:setProperty name="usuario" property="*" /> -->

<!--jsp:setProperty es una forma de hacer set a uno o todos los campos de un bean-->
<!--se puede hacer de 2 maneras una es cuando los datos vienen en un formulario -->
<!--y tienen los mismos nombres de las variables en los beans -->

<!-- la otra forma seria 
jsp : setProperty name="usuario" property="usuario" value="< %=request.getParameter("usuario")%>"/ 
para cargar solamente el nombre de usuario
-->


<%!    ConexionAPI aux;
%>
<%
String tokenlogueado =(String)session.getAttribute("tokenlogueado");

if(tokenlogueado == null)
{
  System.out.println("NO ESTA LOGUEADO AUN ");
}
 %>



        
 

 <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <%

    //try {
        System.out.println("Antes de user/pass");
        aux = new ConexionAPI();
        

        String miValor2 = "";
        if(request.getParameter("usuario")!=null) {
            miValor2 = request.getParameter("usuario");
        }
        System.out.println("Usuario: " + miValor2);
        String miValor3 = "";
        if(request.getParameter("password")!=null) {
            miValor3 = request.getParameter("password");
        }
        System.out.println("Pass: " + miValor3);
        System.out.println("DESPUES de user/pass");

  //  } finally {
    //    if (datosUsr != null) {
      //      datosUsr.desconectar();
       // }
   // }

%>  
        Usuario:  <%=miValor2%>
        Password: <%=miValor3%>
 
        
  

<%
    String token = aux.sendPost(miValor2,miValor3);
   
    if (token == null){
        System.out.println("ERROR NO CORRESPONDE ESE USUARIO O CLAVE ");
        response.sendRedirect("errorLogin.jsp");
}
%>
                    el TOKEN de la funcion es: <%=token%>
        <%


    session.setAttribute("tokenlogueado", token);


 tokenlogueado =(String)session.getAttribute("tokenlogueado");

if(tokenlogueado!=null)
{
  System.out.println("User name: " + tokenlogueado);
}
 %>  
 
           
        <form action="pruebaseccion.jsp">
            <input type=submit value="Aceptar">
            
        </form>
    </body>
</html>