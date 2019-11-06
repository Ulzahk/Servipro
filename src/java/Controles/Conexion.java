
package Controles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private String USERNAME = "contable19";
    private String PASSWORD = "contable19";
    private String HOST = "10.0.0.98";
    private String PORT = "1433";
    private String DATABASE = "sssacontable";
    private String CLASSNAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String URL = "jdbc:sqlserver://"+HOST+":"+PORT+";databaseName="+DATABASE;
    private Connection con;
    
    public Conexion(){
        try {
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR"+e);
        } catch (SQLException e){
            System.err.println("Error"+e);
        }
    }
    
    public Connection getConexion(){
        return con;
    }
    
    public static void main(String[] args) {
        Conexion con = new Conexion();
    }
}
