package factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static void main(String[] args) throws SQLException {
        
        Connection connection = new ConnectionFactory().getConnection();
        System.out.println("Conexao aberta.");
        connection.close();
    }
    
}