/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

import Modelo.Usuario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;


//import org.apache.http.client.HttpClient;

/*
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
*/

/**
 *
 * @author alejo
 */
public class ConexionAPI {
  
    private	HttpClient      httpClient = null;  // Objeto a través del cual realizamos las peticiones
    private	HttpMethodBase  request = null;     // Objeto para realizar las peticiines HTTP GET o POST
    private	int             status = 0;         // Código de la respuesta HTTP
    private	BufferedReader  reader = null;      // Se usa para leer la respuesta a la petición
    private	String          line   = null;      // Se usa para leer cada una de las lineas de texto de la respuesta
        
    // HTTP POST request
    public String sendPost(String nombre, String pass){
	httpClient = null;  // Objeto a través del cual realizamos las peticiones
        request = null;     // Objeto para realizar las peticiines HTTP GET o POST
	status = 0;         // Código de la respuesta HTTP
	reader = null;      // Se usa para leer la respuesta a la petición
	line   = null;      // Se usa para leer cada una de las lineas de texto de la respuesta
        String token = null;
        String tkn = null;

	// Instanciamos el objeto
	httpClient = new HttpClient();
        // Invocamos por POST
        String url = "http://localhost:8090/login";
	request = new PostMethod(url);
	// Añadimos los parámetros que deseemos a la petición 
	((PostMethod) request).addParameter("usuario", nombre);
        ((PostMethod) request).addParameter("password", pass);
        try {
            // Leemos el código de la respuesta HTTP que nos devuelve el servidor
            status = httpClient.executeMethod(request);
            // Vemos si la petición se ha realizado satisfactoriamente
            if (status != HttpStatus.SC_OK) {
		System.out.println("Error\t" + request.getStatusCode() + "\t" + 
                request.getStatusText() + "\t" + request.getStatusLine());	        	 
		} 
            else {
                // Leemos el contenido de la respuesta y realizamos el tratamiento de la misma.
                // En nuestro caso, simplemente mostramos el resultado por la salida estándar
                reader = new BufferedReader(
                        new InputStreamReader(request.getResponseBodyAsStream(), request.getResponseCharSet()));
                line   = reader.readLine();
                while (line != null) {
                    token = line;
                    line = reader.readLine(); 
                    }
                JSONParser parser = new JSONParser();
                JSONObject jo = (JSONObject) parser.parse(token);
                tkn = (String) jo.get("token");
                }
            } catch (Exception ex){
		System.out.println("Error\t: " + ex.getMessage());
	/*		
			ex.printStackTrace();*/
            } finally {
		// Liberamos la conexión. (También libera los stream asociados)
		request.releaseConnection();
            }   
    return tkn;
  }
    
/* +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
// HTTP GET request
/* +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
public List<Usuario> sendGetListaUsuarios(String token){
    httpClient = null;  // Objeto a través del cual realizamos las peticiones
    request = null;     // Objeto para realizar las peticiines HTTP GET o POST
    status = 0;         // Código de la respuesta HTTP
    reader = null;      // Se usa para leer la respuesta a la petición
    line   = null;      // Se usa para leer cada una de las lineas de texto de la respuesta
    
    List<Usuario> listaauxiliar = new ArrayList<Usuario>();
    Usuario usuario = new Usuario();
       
    // Instanciamos el objeto
    httpClient = new HttpClient();
    // Invocamos por GET
    String url = "http://localhost:8090/api/usuarios/";
    request = new GetMethod(url);
    // Añadimos los parámetros que deseemos a la petición 
    request.setRequestHeader("token", token);	    
    try {
        // Leemos el código de la respuesta HTTP que nos devuelve el servidor
        status = httpClient.executeMethod(request);
        // Vemos si la petición se ha realizado satisfactoriamente
        if (status != HttpStatus.SC_OK) {
            System.out.println("Error\t" + request.getStatusCode() + "\t" + 
            request.getStatusText() + "\t" + request.getStatusLine());	        	 
            }
        else {
            // Leemos el contenido de la respuesta y realizamos el tratamiento de la misma.
            // En nuestro caso, simplemente mostramos el resultado por la salida estándar
            reader = new BufferedReader(
                new InputStreamReader(request.getResponseBodyAsStream(), request.getResponseCharSet()));

            
            JSONParser parser = new JSONParser();
            
            JSONValue jsonvalue = new JSONValue();
            
            String tkn = null;
                    
            System.out.println("entro AL WHILE");
                    
            listaauxiliar = null;  
            line   = reader.readLine();
            while (line != null) {
                System.out.println(line);
      
                  System.out.println("uno");
               // JSONObject jso = (JSONObject) parser.parse(line);
                JSONArray jo =  (JSONArray) jsonvalue.parse(line);
                        //(JSONArray) jso.get("");
                System.out.println("antes de iterar");
                Iterator<String> iterator = jo.iterator();
                System.out.println("depues de iterar");
            while (iterator.hasNext()) {
                System.out.println("Entro al while iterador");
                System.out.println(iterator.next());
            }
                            System.out.println("SALIO al while iterador");
                /*usuario.setMail((String) jo.get("mail"));
                usuario.setNombre((String) jo.get("nombre"));
                usuario.setUsuario((String) jo.get("usuario"));
                listaauxiliar.add(usuario);
                
                System.out.println((String) jo.get("mail"));
                System.out.println((String) jo.get("nombre"));
                System.out.println((String) jo.get("usuario"));*/
            
            line = reader.readLine();
            }
        }
    } 
    catch (Exception ex){
        System.err.println("Error\t: " + ex.getMessage());
			
	ex.printStackTrace();
	} 
    finally {
	// Liberamos la conexión. (También libera los stream asociados)
    	request.releaseConnection();
	}
    return listaauxiliar;
}

}
