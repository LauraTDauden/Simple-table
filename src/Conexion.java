
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LauraTD
 */
public class Conexion {

    //Ajustar los datos de conexión a los de tu proyecto
    private final String user = "root";
    private final String password = "admin1234";
    private final String url = "jdbc:mysql://localhost/dad_biblioteca";
    private Connection con;

    public Conexion() throws SQLException {
        loadDriver();
        con = DriverManager.getConnection(url, user, password);
        //JOptionPane.showMessageDialog(null, "Conectado a la base de datos.");
    }
    
    public Connection getCon() {
        return con;
    }

    private static void loadDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("No se encontró el driver de MySQL");
        }
    }
}
