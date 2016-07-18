package view;

import java.util.Scanner;

import controller.ContaController;
import dao.ContaDAO;
import model.Conta;

public class ContaGUI {
	
	Scanner input = new Scanner(System.in);
	
	ContaController coc = new ContaController();
	
	ContaDAO cod = new ContaDAO();
	
	Conta con = new Conta();
	
	public ContaGUI(){}
	
	public void inserir(){
		System.out.print("Cliente Id: ");
		int id = input.nextInt();
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
		System.out.print("Cliente id: ");
		con = cod.listByCli(input.nextInt());
		if (con == null){
			System.out.println("Conta inexistente");
		}else{
			System.out.println(con.toString());
		}
	}
	
	public void listByCntId(){
		System.out.print("Conta Id: ");
		con  = cod.listById(input.nextInt());
		if (con == null){
			System.out.println("Conta inexistente.");
		}else{
			System.out.println(con.toString());
		}
	}
	
	public void deposito(){
		System.out.print("Conta Id: ");
		con  = cod.listById(input.nextInt());
		if (con == null){
			System.out.println("Conta inexistente.");
		}else{
			System.out.print("Deposito, R$: ");
			con.setSaldo(con.getSaldo() + input.nextFloat());
		}		
	}
	
	public void saque(){
		System.out.print("Conta Id: ");
		con  = cod.listById(input.nextInt());
		if (con == null){
			System.out.println("Conta inexistente.");
		}else{
			System.out.print("Saque, R$: ");
			con.setSaldo(con.getSaldo() - input.nextFloat());
		}		
	}
	
	public void transf(){
		float r = 0;
		System.out.print("Valor R$: ");
		r = input.nextFloat();
		
		System.out.print("Conta Origem Id: ");
		con  = cod.listById(input.nextInt());
		if (con == null){
			System.out.println("Conta inexistente.");
		}else{
			con.setSaldo(con.getSaldo() - r);
		}
		
		System.out.print("Conta Beneficiada Id: ");
		con  = cod.listById(input.nextInt());
		if (con == null){
			System.out.println("Conta inexistente.");
		}else{
			con.setSaldo(con.getSaldo() + r);
		}		
	}
	
	public void editCnt(){
		System.out.print("Conta Id: ");
		con  = cod.listById(input.nextInt());
		if (con == null){
			System.out.println("Conta inexistente.");
		}else{
			System.out.print("Novo Saldo R$: ");
			con.setSaldo(input.nextFloat());
		}		
	}
	
	public void excluir(){
		System.out.print("Conta Id: ");
		con  = cod.listById(input.nextInt());
		if (con == null){
			System.out.println("Conta inexistente.");
		}else{
			cod.delete(con);
		}		
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
					+"\n8-Atualizar Conta"
					+"\n9-Deletar Conta"
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
					editCnt();
					break;
				case 9:
					excluir();
					break;
			}
		}while(call != 0);
	}
}
