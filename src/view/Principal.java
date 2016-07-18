
package view;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char ch = 'z';
		
		ClienteGui cg = new ClienteGui();
		ContaGUI ctg = new ContaGUI();
		
		do{
			System.out.println(
					"******* Banco Senac *******"
					+"\nA-Menu Cliente"
					+"\nB-Menu Conta"
					+"\nS-Sair"
					+"***************************"
					+"Opçâo: ");
			ch = input.next().charAt(0);
			
			switch(ch){
			case 'A': case 'a':
				cg.exeCli();
				break;
			case 'B': case 'b':
				ctg.exeCon();
				break;
			case 'S': case 's':
				ch = 'S';
				break;
			default:
				System.out.println("Opção invalida!");
				break;
			}
		}while(ch != 'S');
	}
    
}
