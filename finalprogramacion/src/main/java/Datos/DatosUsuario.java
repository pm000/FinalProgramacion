/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ara
 */
public class DatosUsuario extends BBDD
{
    public DatosUsuario() throws Exception {
        super();
    }

    public boolean login(String usuario, String pass) throws Exception
    {
        conectar();
        String sql = "SELECT * FROM usuarios WHERE usuario='"+usuario+"' AND pass='"+pass+"'";
        PreparedStatement s = crearSentencia(sql);
        
        System.out.println(sql);
        ResultSet rows = consultar(s);
        if (rows.next()){           
            return true;
        }        
        return false;
    }
}
