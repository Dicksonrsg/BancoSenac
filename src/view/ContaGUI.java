package view;

import java.util.Scanner;

import controller.ContaController;
import dao.ContaDAO;
import model.Conta;

public class ContaGUI {
	
	Scanner input = new Scanner(System.in);
	
	ContaController coc = new ContaController();
	
	ContaDAO cod = new ContaDAO();
	
	int id = 0, id1 = 0, id2 = 0;
	float real = 0;
	
	
	public ContaGUI(){}
	
	public void inserir(){
		System.out.print("Cliente Id: ");
		id = input.nextInt();
		System.out.print("Saldo: ");
		float saldo = input.nextFloat();
		
		ContaController coc = new ContaController();
		if(coc.save(saldo, id)){
			System.out.println("Uhuuul, deu certo");
		}else{
			System.out.println("Errrrrroouuu!");
		} 
	}
	
	public void listAll(){
		for(Conta ct : cod.listAll()){
			System.out.println(ct.toString());
		} 
	}
	
	public void listByCliente(){		
		System.out.println("Cliente id: ");
		id = input.nextInt();
		coc.listByCli(id);
	}
	
	public void listByCntId(){
		System.out.print("Conta id:");
		coc.listConta(id);
	}
	
	public void deposito(){
		System.out.print("Conta id: ");
		id = input.nextInt();
		System.out.print("Deposito, R$: ");
		real = input.nextFloat();
		
		coc.deposito(id, real);
	}
	
	public void saque(){
		System.out.print("Conta id: ");
		id = input.nextInt();
		System.out.print("Saque, R$: ");
		real = input.nextFloat();
		
		coc.saque(id, real);
	}
	
	public void transf(){
		System.out.print("Conta origem: ");
		id1 = input.nextInt();
		System.out.print("Transferencia, R$: ");
		real = input.nextFloat();
		System.out.print("Conta beneficiada: ");
		id2 = input.nextInt();
		
		coc.transf(id1, id2, real);
				
	}
	
	public void excluir(){
		System.out.println("Informe Id da conta a ser excluida, Id: ");
		id = input.nextInt();
		coc.delete(id);
	}
	
	public void exeCon(){
		int call = -1;
		do{
			System.out.println(
					"******* Menu Conta *******"
					+"\n1-Abrir Conta"
					+"\n2-Listar Todas"
					+"\n3-Mostrar por Cliente"
					+"\n4-Mostrar por Conta Id"
					+"\n5-Deposito"
					+"\n6-Saque"
					+"\n7-Transferencia"
					+"\n8-Deletar Conta"
					+"\n0-Sair"
					+"\n************************"
					+"\nOpçâo: ");
			call = input.nextInt();
			switch(call){
				case 1:
					inserir();
					break;
				case 2:
					listAll();
					break;
				case 3:
					listByCliente();
					break;
				case 4:
					listByCntId();
					break;
				case 5:
					deposito();
					break;
				case 6:
					saque();
					break;
				case 7:
					transf();
					break;
				case 8:
					excluir();
					break;
			}
		}while(call != 0);
	}
}
