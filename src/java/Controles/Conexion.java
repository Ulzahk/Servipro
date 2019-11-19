package Controles;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
    
    public static Connection conectar(){
        Connection conn=null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                    
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return conn;
    }
}