/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ara
 */
public class BBDD
{
    private String driver = "com.mysql.jdbc.Driver";
    private String servidor = "localhost";
    private String url = "jdbc:mysql://";
    private int puerto = 3306;
    private String usuario = "root";
    private String password = "";
    private String BD = "logueo";
    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultado;

    public BBDD() throws Exception
    {
        url = url + servidor + ":" + puerto + "/" + BD;
        this.conectar();
    }

    public void conectar() throws Exception
    {
        try
        {
            Class.forName(getDriver());
        } catch (ClassNotFoundException e)
        {
            throw new Exception("Error de driver" + e.getMessage());
        }
        try
        {
            setConexion(DriverManager.getConnection(getUrl(), getUsuario(), getPassword()));
        } catch (SQLException e)
        {
            throw new Exception("Error en la conexion \n codigo" + e.getErrorCode() + "Explicacion:" + e.getMessage());
        }
    }

    public int actualizar(PreparedStatement sentencia) throws Exception
    {
        try
        {
            int res = sentencia.executeUpdate();
            return res;
        } catch (SQLException e)
        {
            throw new Exception("Error al ejecutar sentencia \n codigo" + e.getErrorCode() + "Explicacion:" + e.getMessage());
        }
    }

    public ResultSet consultar(PreparedStatement sentencia) throws Exception
    {
        try
        {
            ResultSet rows = sentencia.executeQuery();
            return rows;
        } catch (SQLException e)
        {
            throw new SQLException("Error al ejecutar consulta" + e.getMessage());
        }
    }

    public void desconectar()
    {
        try
        {
            getConexion().close();
        } catch (SQLException e)
        {
            setConexion(null);
        }
    }

    public PreparedStatement crearSentencia(String sql) throws Exception
    {
        try
        {
            PreparedStatement s = getConexion().prepareStatement(sql);
            return s;
        } catch (SQLException e)
        {
            throw new SQLException("Error al ejecutar sentencia \n codigo" + e.getErrorCode() + "Explicacion:" + e.getMessage());
        }
    }

    /**
     * @return the driver
     */
    public String getDriver()
    {
        return driver;
    }

    /**
     * @param driver the driver to set
     */
    public void setDriver(String driver)
    {
        this.driver = driver;
    }

    /**
     * @return the servidor
     */
    public String getServidor()
    {
        return servidor;
    }

    /**
     * @param servidor the servidor to set
     */
    public void setServidor(String servidor)
    {
        this.servidor = servidor;
    }

    /**
     * @return the url
     */
    public String getUrl()
    {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url)
    {
        this.url = url;
    }

    /**
     * @return the puerto
     */
    public int getPuerto()
    {
        return puerto;
    }

    /**
     * @param puerto the puerto to set
     */
    public void setPuerto(int puerto)
    {
        this.puerto = puerto;
    }

    /**
     * @return the usuario
     */
    public String getUsuario()
    {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }

    /**
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * @return the BD
     */
    public String getBD()
    {
        return BD;
    }

    /**
     * @param BD the BD to set
     */
    public void setBD(String BD)
    {
        this.BD = BD;
    }

    /**
     * @return the conexion
     */
    public Connection getConexion()
    {
        return conexion;
    }

    /**
     * @param conexion the conexion to set
     */
    public void setConexion(Connection conexion)
    {
        this.conexion = conexion;
    }

    /**
     * @return the sentencia
     */
    public PreparedStatement getSentencia()
    {
        return sentencia;
    }

    /**
     * @param sentencia the sentencia to set
     */
    public void setSentencia(PreparedStatement sentencia)
    {
        this.sentencia = sentencia;
    }

    /**
     * @return the resultado
     */
    public ResultSet getResultado()
    {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(ResultSet resultado)
    {
        this.resultado = resultado;
    }
}
