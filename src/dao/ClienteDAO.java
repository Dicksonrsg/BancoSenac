
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;


public class ClienteDAO {
    
    private final DataBase db;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    public ClienteDAO(){
    db = new DataBase();
    }
        


    public boolean inserir(Cliente cliente){
        if (db.connect()){
            sql = "INSERT INTO tb_clientes(cli_nome, cli_cpf, cli_sex_id) VALUES (?, ?, ?)";
        try{
            ps = db.connection.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setInt(3, cliente.getSexo().getId());
            if(ps.executeUpdate() ==1){
                ps.close();
                db.disconnect();
                return true;
}
            ps.close();
            db.disconnect();
        }catch(SQLException error){
            return false;
}
}
return false;
} 

    public boolean excluir(Cliente cliente){
            if (db.connect()){
                sql = "DELETE FROM tb_clientes WHERE cli_id = ?";
            try{
                ps = db.connection.prepareStatement(sql);
                ps.setInt(1, cliente.getId());
                if(ps.executeUpdate() ==1){
                    return true;
                }
                    ps.close();
                    db.disconnect();            
            }catch(SQLException error){
                return false;
            }
            }
    return false;
    }
public boolean editar(Cliente cliente){
        if (db.connect()){
            sql = "UPDATE tb_clientes SET cli_nome = ?, cli_cpf = ?, cli_sex_id = ?, WHERE cli_id = ?";
        try{
            ps = db.connection.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setInt(3, cliente.getSexo().getId());
            ps.setInt(4, cliente.getId());
            if(ps.executeUpdate() ==1){
                return true;
            }
                ps.close();
                db.disconnect();            
        }catch(SQLException error){
            return false;
}
}
return false;
   
}

public List<Cliente> listarTudo(){
        if (db.connect()){
            List<Cliente> clientes = new ArrayList<Cliente>(); 
            sql = "SELECT * FROM tb_clientes JOIN tb_sexos ON sex_id = cli_sex_id";
        try{
            ps = db.connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Cliente cliente = new Cliente();
                SexoDAO dao = new SexoDAO();
                cliente.setId(rs.getInt("cli_id"));
                cliente.setNome(rs.getString("cli_nome"));
                cliente.setCpf(rs.getString("cli_cpf"));
                cliente.setSexo(dao.buscarPorId(rs.getInt("cli_sex_id")));
                clientes.add(cliente);
            }
            rs.close();
            ps.close();
            db.disconnect();
            return clientes;
        }catch(SQLException error){
            return null;
}
}
return null;
}

public Cliente buscarPorCpf(String cpf){
        if (db.connect()){
            sql = "SELECT * FROM tb_clientes JOIN tb_sexos ON sex_id = cli_sex_id WHERE cli_cpf = ?";
        try{
            ps = db.connection.prepareStatement(sql);
            ps.setString(1, cpf);
            rs = ps.executeQuery();
            if(rs.next()){
                Cliente cliente = new Cliente();
                SexoDAO dao = new SexoDAO();
                cliente.setId(rs.getInt("cli_id"));
                cliente.setNome(rs.getString("cli_nome"));
                cliente.setCpf(rs.getString("cli_cpf"));
                cliente.setSexo(dao.buscarPorId(rs.getInt("cli_sex_id")));
                rs.close();
                ps.close();
                db.disconnect();                
                return cliente;
            }
            rs.close();
            ps.close();
            db.disconnect();
        }catch(SQLException error){
            return null;
}
}
return null;   
}

public Cliente buscarPorId(int id){
        if (db.connect()){
            sql = "SELECT * FROM tb_clientes JOIN tb_sexos ON sex_id = cli_sex_id WHERE cli_id = ?";
        try{
            ps = db.connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                Cliente cliente = new Cliente();
                SexoDAO dao = new SexoDAO();
                cliente.setId(rs.getInt("cli_id"));
                cliente.setNome(rs.getString("cli_nome"));
                cliente.setCpf(rs.getString("cli_cpf"));
                cliente.setSexo(dao.buscarPorId(rs.getInt("cli_sex_id")));
                rs.close();
                ps.close();
                db.disconnect();                
                return cliente;
            }
            rs.close();
            ps.close();
            db.disconnect();
        }catch(SQLException error){
            return null;
}
}
return null;   
}
}
