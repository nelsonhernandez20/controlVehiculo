
package datos;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;



public class Conexion  {
    static Connection con;
    private static final String JDBC_URL = "jdbc:postgresql://localhost/control_vehiculos";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "1234";
    
    private static BasicDataSource dataSource;
      //Class.forName("org.postgresql.Driver");
    // Pool de conexiones (apache.commons)
    
//    public static Connection publicConnection() throws SQLException{
//        Connection conn = null;
//        try{
//        Class.forName("org.postgresql.Driver");
//        String url = "jdbc:postgresql://localhost/control_vehiculos"; //Local
//           Properties props = new Properties();
//           props.setProperty("user","postgres"); //usuario localhost
//           props.setProperty("password","1234"); //Clave localhost
//           conn = DriverManager.getConnection(url, props);
//        
//        }catch(ClassNotFoundException ex){
//         ex.printStackTrace(System.out);
//        }
//        return conn;
//    
//    
//    }
    
    public static DataSource getDataSource() {
        if(dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl(JDBC_URL);
            dataSource.setUsername(JDBC_USER);
            dataSource.setPassword(JDBC_PASSWORD);
            dataSource.setInitialSize(50);  // Tamaño inicial del pool de conexiones
        }
        return dataSource;
    }
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
            Class.forName("org.postgresql.Driver");
            
            return getDataSource().getConnection(); 
        
        
    }
    
    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch(SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement stmt) {
        try {
            stmt.close();
        } catch(SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
