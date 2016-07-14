
package model;

public class Sexo {
    
    private int id;
    private String sexo;
    private char sigla;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public char getSigla() {
        return sigla;
    }

    public void setSigla(char sigla) {
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return "Sexo{" + "id=" + id + ", sexo=" + sexo + ", sigla=" + sigla + '}';
    }
    
    
    
}
