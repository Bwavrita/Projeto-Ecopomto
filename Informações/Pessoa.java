package Informações;

public class Pessoa {
    private String nome;
    private String cpf;
    
    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean verificarCpf(){
        if(cpf.length() == 11){
            return true;
        }
        return false;
    }

    public String toString() {
        return nome;
    }
    
}
