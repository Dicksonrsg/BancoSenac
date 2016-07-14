
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cliente;
import model.Sexo;

public class SexoDAO {
    private final DataBase db;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    
    public SexoDAO(){
        db = new DataBase();
    }
    
    public Sexo buscaPorId(int id){
        if(db.connect()){
            sql = "SELECT * FROM tb_sexos WHERE sex_id = ?";
            try{
                ps = db.connection.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                if(rs.next()){
                    Cliente cliente = new Cliente();
                    SexoDAO dao = new SexoDAO();
                    rs.close();
                    ps.close();
                    db.disconnect();
                    return sexo;
                }
                    rs.close();
                    ps.close();
                    db.disconnect();               
            }catch(SQLException error){
                return null;
            }
        }
    }
}
