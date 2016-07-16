
package model;

public class Conta {
    
    private int id;
    private Cliente cliente;
    private float saldo;
    
    public Conta(){}

    public Conta(Cliente cliente, float saldo) {
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Conta{" + "id=" + id + ", cliente=" + cliente + ", saldo=" + saldo + '}';
    }
    
    
    
}
