
package controller;

import dao.ClienteDAO;
import dao.SexoDAO;
import model.Cliente;
import model.Sexo;

public class ClienteController {
    
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
    
}
