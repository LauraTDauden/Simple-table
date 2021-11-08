

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author LauraTD
 */
public class Consultas {

    private Statement statement;
    private ResultSet results;
    Conexion con;

    public Consultas() throws SQLException {
        con = new Conexion();
    }
    
    public ResultSet getResultset() {
        return results;
    }    
    
    //consulta
    public void SQLQuery(String sql) throws SQLException{
        statement = con.getCon().createStatement();
        results = statement.executeQuery(sql);
    }
    
    //actualización
     public void SQLUpdate(String sql) throws SQLException{
        statement = con.getCon().createStatement();
        statement.executeUpdate(sql);
        statement.close();
    }
    
    public void closeQuery() throws SQLException {
        statement.close();
        results.close();
    }
 
}
