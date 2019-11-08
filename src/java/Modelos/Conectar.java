
package Modelos;

import org.springframework.jdbc.datasource.DriverManagerDataSource;



public class Conectar {
    
    public DriverManagerDataSource conectar(){
        
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable");
        dataSource.setUsername("contable19");
        dataSource.setPassword("contable19");
        return dataSource;
    }
}
