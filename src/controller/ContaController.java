
package controller;

import dao.ClienteDAO;
import dao.ContaDAO;
import model.Cliente;
import model.Conta;

public class ContaController {
    
    public boolean save(float saldo, int id){
        ClienteDAO cldao = new ClienteDAO();
        Cliente cl = new Cliente();
        if(cldao.buscarPorId(id) != null){
            cl = cldao.buscarPorId(id);
            Conta conta  = new Conta(cl, saldo);
            ContaDAO cdao = new ContaDAO();
            if(cdao.insert(conta)){
                return true;
            }
        }
        return false;
    }
    
    public void list(){
        ContaDAO cdao = new ContaDAO();
        for(Conta ct : cdao.listAll()){
            System.out.println("Id: "+ ct.getId()
            + "\tSaldo: "+ ct.getSaldo()
            + "\tCliente: "+ ct.getCliente().getNome());
        }
    }
}
