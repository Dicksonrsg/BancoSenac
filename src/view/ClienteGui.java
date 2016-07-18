
package view;

import controller.ClienteController;
import dao.ClienteDAO;
import model.Cliente;

import java.util.Scanner;


public class ClienteGui {
    
    Scanner input = new Scanner(System.in);
    
    ClienteController cc = new ClienteController();
    
    ClienteDAO cd = new ClienteDAO();
    
    Cliente cli = new Cliente();
    
    public ClienteGui(){}
    
    public void cadastrar(){
        System.out.print("Nome: ");
        String nome = input.next();
        System.out.print("CPF: ");
        String cpf = input.next();
        System.out.print("Sexo: ");
        String sexo = input.next();
        
        ClienteController cc = new ClienteController();
        if (cc.cadastrar(nome, cpf, sexo)){
            System.out.println("SUCESSO");
        }
        else {
            System.out.println("Falha!");
        }
    }
    
    public void buscarPorId(){
    	System.out.print("Digite Cliente Id: ");
    	cli = cd.buscarPorId(input.nextInt());
    	if(cli == null){
    		System.out.println("Cliente não encontrado");
    	}else{
    		System.out.println(cli.toString());
    	}
    }
    
    public void editCliente(){
    	System.out.print("Digite Cliente Id: ");
    	cli = cd.buscarPorId(input.nextInt());
    	if(cli == null){
    		System.out.println("Cliente não encontrado");
    	}else{
    		System.out.print("Novo nome: ");
    		cli.setNome(input.next());
    		System.out.print("Novo CPF: ");
    		cli.setCpf(input.next());		
    	}    	
    }
    
    public void deleteCli(){
    	System.out.print("Cliente id: ");
    	cli = cd.buscarPorId(input.nextInt());
    	if(cli == null){
    		System.out.println("Cliente não encontrado");
    	}else{
    		cd.excluir(cli);
    	}    	
    }
    
    public void listAll(){
    	for(Cliente c1 : cd.listarTudo()){
    		System.out.println(c1.toString());
    	}
    }
    
    public void exeCli(){
    	int call = -1;
    	
    	do{
    		System.out.println(
    						"******* Menu Cliente *******"+
    		                "\n1-Cadastrar"+
    		                "\n2-Listar Tudo"+
    		                "\n3-Mostrar por ID"+
    		                "\n4-Atualizar Cliente"+
    		                "\n5-Deletar Cliente"+
    		                "\n0-Sair"+
    		                "\n****************************"+
    		                "\nOpção: ");
    		        call = input.nextInt();	
    		        
    		        switch(call){
    		        case 1:
    		        	cadastrar();
    		        	break;
    		        case 2:
    		        	listAll();
    		        	break;
    		        case 3:
    		        	buscarPorId();
    		        	break;
    		        case 4:
    		        	editCliente();
    		        	break;
    		        case 5:
    		        	deleteCli();
    		        }
    	}while(call != 0); 
    }
}
