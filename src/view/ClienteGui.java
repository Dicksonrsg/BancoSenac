
package view;

import controller.ClienteController;
import java.util.Scanner;


public class ClienteGui {
    
    Scanner input = new Scanner(System.in);
    
    public ClienteGui(){}
    
//    public void cadastrar(){
//        System.out.print("Nome: ");
//        String nome = input.next();
//        System.out.print("CPF: ");
//        String cpf = input.next();
//        System.out.print("Sexo: ");
//        String sexo = input.next();
//        
//        ClienteController cc = new ClienteController();
//        if (cc.cadastrar(nome, cpf, sexo)){
//            System.out.println("SUCESSO");
//        }
//        else {
//            System.out.println("Falha!");
//        }
//    }
    
    public static void main(String[] args) {
       ClienteGui gui = new ClienteGui();
       gui.buscar();
//       gui.cadastrar();
    }
    
    public void buscar(){
        System.out.print("CPF: ");
        String cpf = input.next();
        
        ClienteController cc = new ClienteController();
        
        if(cc.buscarPorCpf(cpf)){
            System.out.println("Sucesso");
        }
        else{
            System.out.println("Falha");
        }
    }
}
