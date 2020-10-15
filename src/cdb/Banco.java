
package cdb;

import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {
    private String hostname;
    private String username;
    private String database;
    private int port;
    private String password;
    
    private Connection connection;
    
    public Constructor DataSource(){
        try{
            hostname = "localhost";
            port = 3306;
            username = "root";
            database = "projeto";
            password = "";
            
            String url= "jdbc:mysql://"+hostname+":"+port+"/"+database;
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conectado!");
        }
        catch(SQLException ex){
            System.err.println("Erro na Conexão"+ex.getMessage());
        }
        catch(Exception ex){
            System.err.println("Erro"+ex.getMessage());
        }
    }
    public Connection getConnection(){
        return this.connection;
    }
    public void closeDataSource(){
        try{
            connection.close();
        }
        catch(SQLException ex){
            System.err.println("Erro na desconexão"+ex.getMessage());
    }
    
}
