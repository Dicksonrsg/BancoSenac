
package controller;

import java.util.Scanner;

import dao.ClienteDAO;
import dao.SexoDAO;
import model.Cliente;
import model.Sexo;

public class ClienteController {
	
    ClienteDAO cd = new ClienteDAO();
    
    Scanner input = new Scanner(System.in);
    
    public boolean cadastrar(String nome, String cpf, String sexo){
        SexoDAO sdao = new SexoDAO();
        Sexo so = new Sexo();
        if(sdao.buscarPorSexo(sexo) != null){
            so = sdao.buscarPorSexo(sexo);
            Cliente cliente = new Cliente(nome, so, cpf);
            ClienteDAO cdao = new ClienteDAO();
            if(cdao.inserir(cliente)){
                return true;
            }
        }
        return false;
    }

	public void listar(){
	    ClienteDAO cdao = new ClienteDAO();
	    for(Cliente c : cdao.listarTudo()){
	        System.out.println("Id: " + c.getId() +
	                "\tCPF: " + c.getCpf() + 
	                "\tNome: " + c.getNome() + 
	                "\tSexo: " + c.getSexo().getSigla());
	    }
	}
	
	public void listById(int id){
    	Cliente cli = cd.buscarPorId(id);
    	if(cli == null){
    		System.out.println("Cliente não encontrado");
    	}else{
    		System.out.println(cli.toString());
    	}		
	}
	
	public void editCli(int id){
    	Cliente cli = cd.buscarPorId(id);
    	if(cli == null){
    		System.out.println("Cliente não encontrado");
    	}else{
    		System.out.print("Novo nome: ");
    		cli.setNome(input.next());
    		System.out.print("Novo CPF: ");
    		cli.setCpf(input.next());		
    	}		
	}
	
	public void excluirCli(int id){
    	Cliente cli = cd.buscarPorId(id);
    	if(cli == null){
    		System.out.println("Cliente não encontrado");
    	}else{
    		cd.excluir(cli);
    	}		
	}
}
