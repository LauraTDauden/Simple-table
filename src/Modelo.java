
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author LauraTD
 */
public class Modelo {
    
    Consultas consulta;
    public Modelo(){
        try {
            consulta = new Consultas();
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void generarTabla(DefaultTableModel table) {
        try {
            consulta.SQLQuery("SELECT * FROM alumnos");
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (consulta.getResultset().next()) {
                int registro = consulta.getResultset().getInt("registro");
                String dni = consulta.getResultset().getString("dni");
                String nombre = consulta.getResultset().getString("nombre");
                String apellido1 = consulta.getResultset().getString("apellido1");
                String apellido2 = consulta.getResultset().getString("apellido2");
                
                table.addRow(new Object[]{registro, dni, nombre, apellido1, apellido2});               
            }
            consulta.closeQuery();
        } catch (SQLException ex) {           
        }
    }         
}
