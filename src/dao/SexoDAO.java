
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Sexo;

public class SexoDAO {
   
    private final DataBase db;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    
    public SexoDAO(){
        db = new DataBase();    
    }
    
    public Sexo buscarPorId(int id){
        if(db.connect() ){
            sql = "SELECT *  FROM tb_sexos WHERE sex_id =?";
            try{
                ps = db.connection.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                if(rs.next()){
                    Sexo sexo = new Sexo();
                    sexo.setId(rs.getInt("sex_id"));
                    sexo.setSexo(rs.getString("sex_sexo"));
                    sexo.setSigla(rs.getString("sex_sigla").charAt(0));
                    rs.close();
                    ps.close();
                    db.disconnect();
                    return sexo;  
                }
                rs.close();
                ps.close();
                db.disconnect();
            }catch (SQLException erro){
                return null;
            }
        }
        return null;
    }
    
    
        public Sexo buscarPorSexo(String sexo){
        if(db.connect() ){
            sql = "SELECT *  FROM tb_sexos WHERE sex_sexo =?";
            try{
                ps = db.connection.prepareStatement(sql);
                ps.setString(1,sexo.trim());
                rs = ps.executeQuery();
                if(rs.next()){
                    Sexo s = new Sexo();
                    s.setId(rs.getInt("sex_id"));
                    s.setSexo(rs.getString("sex_sexo"));
                    s.setSigla(rs.getString("sex_sigla").charAt(0));
                    rs.close();
                    ps.close();
                    db.disconnect();
                    return s;  
                }
                rs.close();
                ps.close();
                db.disconnect();
            }catch (SQLException erro){
                return null;
            }
        }
        return null;
    }
        
        
        public Sexo buscarPorSigla(char sigla){
        if(db.connect() ){
            sql = "SELECT *  FROM tb_sexos WHERE sex_sigla =?";
            String nsigla = "" + sigla;
            try{
                ps = db.connection.prepareStatement(sql);
                ps.setString(1,nsigla.trim());
                rs = ps.executeQuery();
                if(rs.next()){
                    Sexo s = new Sexo();
                    s.setId(rs.getInt("sex_id"));
                    s.setSexo(rs.getString("sex_sexo"));
                    s.setSigla(rs.getString("sex_sigla").charAt(0));
                    rs.close();
                    ps.close();
                    db.disconnect();
                    return s;  
                }
                rs.close();
                ps.close();
                db.disconnect();
            }catch (SQLException erro){
                return null;
            }
        }
        return null;
    }    
}

