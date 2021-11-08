
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LauraTD
 */
public class EjemploTabla implements ActionListener {

    VistaTabla vista;
    Modelo modelo;
    DefaultTableModel tabla;

    public EjemploTabla(VistaTabla vista) {
        this.vista = vista;
        modelo = new Modelo();
        vista.setVisible(true);
        inicializarBotones();
    }

    public void inicializarBotones() {
        vista.getJButtonListar().addActionListener(this);
    }

    //Para crear una nueva tabla con un número y nombre de columnas específicos
    //Si determinas las columnas en el asistente de diseño, este método no es necesario
    public void crearNuevaTabla(String[] cabecera) {
        vista.getjTable1().setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                cabecera
        ));
    }

    private void limpiarTabla() {
        tabla = (DefaultTableModel) vista.getjTable1().getModel();
        tabla.setRowCount(0);
    }

    public void listar() {
        limpiarTabla();
        modelo.generarTabla(tabla);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        crearNuevaTabla(new String[]{
            "Registro", "DNI", "Nombre", "Apellido 1", "Apellido 2"
        });
        listar();
    }
}
