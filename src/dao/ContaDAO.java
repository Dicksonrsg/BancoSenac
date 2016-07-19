
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Conta;

public class ContaDAO {
    
    private final DataBase db;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    
    public ContaDAO(){
        db = new DataBase();
    }
    
    public boolean insert(Conta conta){
        if(db.connect()){
            sql = "INSERT INTO tb_contas(cnt_saldo, cnt_cli_id) VALUES (?, ?)";
            try{
                ps = db.connection.prepareStatement(sql);
                ps.setFloat(1, conta.getSaldo());
                ps.setInt(2, conta.getCliente().getId());
                if(ps.executeUpdate() == 1){
                    ps.close();
                    db.disconnect();
                    return true;
                }
            }catch(SQLException mistake){
                return false;
            }
        }
        return false;
    }
    
    public boolean delete(Conta conta){
        if(db.connect()){
            sql = "DELETE FROM tb_contas WHERE cnt_id = ?";
            try{
                ps = db.connection.prepareStatement(sql);
                ps.setInt(1, conta.getId());
                if(ps.executeUpdate() == 1){
                    return true;
                }
                ps.close();
                db.disconnect();
            }catch(SQLException mistake){
                return false;
            }
        }
        return false;
    }
    
    public boolean edit(Conta conta){
        if(db.connect()){
            sql = "UPDATE tb_contas SET cnt_saldo = ?, cnt_cli_id = ?, WHERE cnt_id = ?";
            try{
                ps = db.connection.prepareStatement(sql);
                ps.setFloat(1, conta.getSaldo());
                ps.setInt(2, conta.getCliente().getId());
                if(ps.executeUpdate() ==1){
                    return true;
                }
                ps.close();
                db.disconnect();
            }catch(SQLException mistake){
                return false;
            }
        }
        return false;
    }
    
    public List<Conta> listAll(){
        if(db.connect()){
            List<Conta> contas = new ArrayList<Conta>();
            sql = "SELECT * FROM tb_contas JOIN tb_clientes ON cli_id = cnt_cli_id";
            try{
                ps = db.connection.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()){
                    Conta conta  = new Conta();
                    ClienteDAO  cldao = new ClienteDAO();
                    conta.setId(rs.getInt("cnt_id"));
                    conta.setSaldo(rs.getFloat("cnt_saldo"));
                    conta.setCliente(cldao.buscarPorId(rs.getInt("cnt_cli_id")));
                    contas.add(conta);
                }
            }catch(SQLException mistake){
                return null;
            }
        }
        return null;
    }
    
    public Conta listById(int id){
        if(db.connect()){
            sql = "SELECT * FROM tb_contas JOIN tb_clientes ON cli_id = cnt_cli_id WHERE cnt_id  = ?";
            try{
                ps = db.connection.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                if(rs.next()){
                    Conta conta  = new Conta();
                    ClienteDAO  cldao = new ClienteDAO();
                    conta.setId(rs.getInt("cnt_id"));
                    conta.setSaldo(rs.getFloat("cnt_saldo"));
                    conta.setCliente(cldao.buscarPorCpf(rs.getString("cnt_cli_id")));
                    rs.close();
                    ps.close();
                    db.disconnect();
                    return conta;
                }
                rs.close();
                ps.close();
                db.disconnect();
            }catch(SQLException mistake){
                return null;
            }
        }
        return null;
    }
    
    public List<Conta> listByCli(int id){
        if(db.connect()){
            List<Conta> contas = new ArrayList<Conta>();        	
            sql = "SELECT * FROM tb_contas JOIN tb_clientes ON cli_id = cnt_cli_id WHERE cnt_cli_id  = ?";
            try{
                ps = db.connection.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                if(rs.next()){
                    Conta conta  = new Conta();
                    ClienteDAO  cldao = new ClienteDAO();
                    conta.setId(rs.getInt("cnt_id"));
                    conta.setSaldo(rs.getFloat("cnt_saldo"));
                    conta.setCliente(cldao.buscarPorId(rs.getInt("cnt_cli_id")));
                    contas.add(conta);
                    rs.close();
                    ps.close();
                    db.disconnect();
                }
                rs.close();
                ps.close();
                db.disconnect();
            }catch(SQLException mistake){
                return null;
            }
        }
        return null;    
    }
}
