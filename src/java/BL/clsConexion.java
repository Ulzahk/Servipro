package BL;
import java.sql.DriverManager;
import java.sql.Connection;

public class clsConexion {
    Connection conn = null;
    String stServidor, stUsuario, stPassword, stDB = "";
    
    public clsConexion(){
        
        try {
           
            stServidor="10.0.0.98";
            stUsuario="contable19";
            stPassword="contable19";
            stDB= "sssacontable";
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String stConexion = "jdbc:sqlserver://"+stServidor+":1433;databaseName="+stDB;
            
            conn= DriverManager.getConnection(stConexion, stUsuario, stPassword);
        } 
        catch (Exception ex) 
        {
            
        }
    }
    
    
    
    public Connection getConexion(){
        return conn;
    }
    
    public void closeConexion(Connection conn){
        
        try {
            conn.close();
        } 
        catch (Exception e) {
            
        }
    }
    
}
