
package view;

import controller.ClienteController;
import dao.ClienteDAO;
import model.Cliente;

import java.util.Scanner;


public class ClienteGui {
    
    Scanner input = new Scanner(System.in);
    
    ClienteController cc = new ClienteController();
    
    int id = 0;
    
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
    	cc.listById(id = input.nextInt());
    }
    
    public void editCliente(){
    	System.out.print("Digite Cliente Id: ");
    	cc.editCli(id = input.nextInt());
    }
    
    public void deleteCli(){
    	System.out.print("Cliente id: ");
    	cc.excluirCli(id = input.nextInt());
    }
    
    public void listAll(){
    	cc.listar();
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
