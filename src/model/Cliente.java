
package model;

public class Cliente {
    
    private int id;
    private String nome;
    private Sexo sexo;
    private String cpf;
    
    public Cliente() {}

    public Cliente(String nome, Sexo sexo, String cpf) {
        this.nome = nome;
        this.sexo = sexo;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", sexo=" + sexo.toString() + ", cpf=" + cpf + '}';
    }
    
    
    
}
