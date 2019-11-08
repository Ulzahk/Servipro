
package Controles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
    
    private String USERNAME = "contable19";
    private String PASSWORD = "contable19";
    private String HOST = "10.0.0.98";
    private String PORT = "1433";
    private String DATABASE = "sssacontable";
    private String CLASSNAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String URL = "jdbc:sqlserver://"+HOST+":"+PORT+";databaseName="+DATABASE+";user="+USERNAME
            +";password="+PASSWORD+";";
    private Connection con;
    
    public Conexion(){
        try {
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("Error"+e);
        } catch (SQLException e){
            System.err.println("Error"+e);
        } catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    public Connection getConexion(){
        return con;
    }
    
    public static void main(String[] args) {
        Conexion con = new Conexion();
    }
   
}
