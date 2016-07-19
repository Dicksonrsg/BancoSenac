
package controller;

import dao.ClienteDAO;
import dao.ContaDAO;
import model.Cliente;
import model.Conta;

public class ContaController {
	
    ContaDAO cdao = new ContaDAO();
    
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
 
        for(Conta ct : cdao.listAll()){
            System.out.println("Id: "+ ct.getId()
            + "\tSaldo: "+ ct.getSaldo()
            + "\tCliente: "+ ct.getCliente().getNome());
        }
    }
    
    public void deposito(int id, float depo){
		Conta con = cdao.listById(id);
		if (con == null){
			System.out.println("Conta inexistente.");
		}else{
			System.out.print("Deposito, R$: ");
			con.setSaldo(con.getSaldo() + depo);
			cdao.edit(con);
		}    	
    }
    
    public void saque(int id, float saque){
		Conta con = cdao.listById(id);
		if (con == null){
			System.out.println("Conta inexistente.");
		}else{
			System.out.print("Deposito, R$: ");
			con.setSaldo(con.getSaldo() - saque);
			cdao.edit(con);
		}    	
    }
    
    public void transf(int id1,  int id2, float trf){
		Conta con1 = cdao.listById(id1);
		if (con1 == null){
			System.out.println("Conta inexistente.");
		}else{
			System.out.print("Deposito, R$: ");
			con1.setSaldo(con1.getSaldo() - trf);
			cdao.edit(con1);
		}
			    
		Conta con2 = cdao.listById(id2);
		if (con2 == null){
				System.out.println("Conta inexistente.");
		}else{
			System.out.print("Deposito, R$: ");
			con2.setSaldo(con2.getSaldo() + trf);
			cdao.edit(con2);
			}		
    }
    
    public void delete(int id){
    	Conta cnt = cdao.listById(id);
    	if(cnt == null){
    		System.out.println("Conta inexistente.");
    	}else{
    		cdao.delete(cnt);
    		System.out.println("Conta excluida.");
    	}
    }
    
    public void listConta(int id){
    	Conta ct = cdao.listById(id);
    	System.out.println(ct.toString());
    }
    
    public void listByCli(int id){
    	System.out.println(cdao.listByCli(id).toString());
    }
}
