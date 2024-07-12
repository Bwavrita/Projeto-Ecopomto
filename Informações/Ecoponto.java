package Informações;

public class Ecoponto {
    private String nome;
    private Endereco endereco;
    private Pessoa pessoaResponsavel;
    private int quantidadeResiduos = 0;
    private String[] residuos = new String[10];
    private int tamanhoResiduos = 10;
    
    public int getQuantidadeResiduos() {
        return quantidadeResiduos;
    }

    public Ecoponto(String nome, Pessoa pessoaResponsavel, Endereco endereco) {
        this.nome = nome;
        this.pessoaResponsavel = pessoaResponsavel;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Pessoa getPessoaResponsavel() {
        return pessoaResponsavel;
    }

    public void setPessoaResponsavel(Pessoa pessoaResponsavel) {
        this.pessoaResponsavel = pessoaResponsavel;
    }

    public boolean inserirResiduo(String residuo) {
            if(quantidadeResiduos > tamanhoResiduos){
                return false;
            }else{
                residuos[quantidadeResiduos++] = residuo;
            }
            return true;
        }

        public boolean excluirResiduo(String residuo) {
            for (int i = 0; i < quantidadeResiduos; i++) {
                if (residuos[i].equals(residuo)) {
                    for (int j = i; j < quantidadeResiduos - 1; j++) {
                        residuos[j] = residuos[j + 1];
                    }
                    residuos[quantidadeResiduos - 1] = null;
                    quantidadeResiduos--;
                    return true;
                }
            }
            return false;
        }
        

    public String listarResiduos(int i) {
            return residuos[i];
    }

    @Override
    public String toString() {
        return nome;
    }
}
