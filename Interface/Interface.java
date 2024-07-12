package Interface;

import java.util.Scanner;

import Informações.Ecoponto;
import Informações.Endereco;
import Informações.Pessoa;

public class Interface {
    private int tamanhoEcopontos = 0;
    private Ecoponto[] ecopontos = new Ecoponto[10];
    private int capacidadeEcopontos = 10;
    
    private void inserirEcoponto(Ecoponto ecoponto) {
        if(tamanhoEcopontos > capacidadeEcopontos){
            System.out.println("Vetor Cheio");
        }else{
            ecopontos[tamanhoEcopontos++] = ecoponto;
        }
    }

    public int opcoes(Scanner scan){
        int n = 0;
        System.out.println("-----------------------------------------------------");
        System.out.println("Digite |1| para cadastrar Ecoponto");
        System.out.println("Digite |2| para excluir Ecoponto");
        System.out.println("Digite |3| para mostrar todos os Ecopontos");
        System.out.println("Digite |4| para cadastrar Residuos em um Ecoponto");
        System.out.println("Digite |5| para excluir Residuos em um Ecoponto");
        System.out.println("Digite |6| para procurar Ecoponto de acordo com um Residuo");
        System.out.println("Digite |0| para sair");
        System.out.println("-----------------------------------------------------");
        n = scan.nextInt();
        return n;
    }
   public void cadastrarEcoponto(Scanner scan) {
        scan.nextLine();
        System.out.println("Digite o nome do ecoponto:");
        String nome = scan.nextLine();

        System.out.println("Digite o nome da pessoa responsável:");
        String nomeResponsavel = scan.nextLine();
        System.out.println("Digite o CPF da pessoa responsável:");
        String cpfResponsavel = scan.nextLine();
        Pessoa pessoaResponsavel = new Pessoa(nomeResponsavel, cpfResponsavel);
        boolean cpfValido = false;
        if(pessoaResponsavel.verificarCpf()){
            cpfValido = true;
        }
        while (!cpfValido) {
            System.out.println("CPF inválido, digite-o novamente:");
            cpfResponsavel = scan.nextLine();
            pessoaResponsavel.setCpf(cpfResponsavel);
            if (pessoaResponsavel.verificarCpf()) {
                cpfValido = true;
            }
        }
        
        System.out.println("Digite a rua do endereço:");
        String rua = scan.nextLine();
        System.out.println("Digite o número do endereço:");
        int numero = scan.nextInt();
        scan.nextLine();
        System.out.println("Digite o complemento do endereço:");
        String complemento = scan.nextLine();
        System.out.println("Digite o CEP do endereço:");
        String cep = scan.nextLine();
        System.out.println("Digite a cidade do endereço:");
        String cidade = scan.nextLine();
        System.out.println("Digite o estado do endereço:");
        String estado = scan.nextLine();
        Endereco endereco = new Endereco(rua, numero, complemento, cep, cidade, estado);
        
        System.out.println("Digite a quantidade de residuos que este Ecoponto recebe:");
        int tam = scan.nextInt();
        scan.nextLine();
        int i;
        Ecoponto ecoponto = new Ecoponto(nome,pessoaResponsavel,endereco);
        for(i=0;i<tam;i++){
            System.out.println("Digite o residuo");
           String residuo = scan.nextLine();
           ecoponto.inserirResiduo(residuo);
        }
        inserirEcoponto(ecoponto);
        
}
public void excluirEcoponto(Scanner scan) {
    scan.nextLine();
    System.out.println("Digite o nome do ecoponto:");
    String nome = scan.nextLine();

    for (int i = 0; i < tamanhoEcopontos; i++) {
        if (ecopontos[i] != null && ecopontos[i].getNome().equals(nome)) {
            for (int j = i; j < tamanhoEcopontos - 1; j++) {
                ecopontos[j] = ecopontos[j + 1];
            }
            ecopontos[tamanhoEcopontos - 1] = null;
            tamanhoEcopontos--;
            System.out.println("Ecoponto removido com sucesso!");
            return;
        }
    }

    System.out.println("Ecoponto não encontrado.");
}
public void mostrarEcopontoComResiduo(Scanner scan){
    scan.nextLine();
    System.out.println("Digite o residuo que deseja verificar se tem Ecoponto");
    String residuo = scan.nextLine();
    boolean tem = false;
    System.out.println("-----------------------------------------------------");
    for(int i = 0;i<tamanhoEcopontos;i++){
        Ecoponto ecoponto = ecopontos[i];
        int tam = ecoponto.getQuantidadeResiduos();
        for(int j=0;j<tam;j++){
            if(ecoponto.listarResiduos(j).equals(residuo)){
                System.out.println("Nome do Ecoponto: " + ecoponto.getNome());
                System.out.println("Pessoa responsável: " + ecoponto.getPessoaResponsavel());
                System.out.println("-----------------------------------------------------");
                tem = true;
                break;
            }
        }


    }
    if(!tem){
        System.out.println("Não possui Ecoponto com este residuo");
    }
}


public void escreverEcopontos() {
    for (int i = 0; i < tamanhoEcopontos; i++) {
        Ecoponto ecoponto = ecopontos[i];   
            System.out.println("Nome do Ecoponto: " + ecoponto.getNome());
            System.out.println("Pessoa responsável: " + ecoponto.getPessoaResponsavel());
            System.out.println("Resíduos:");
            int tam = ecoponto.getQuantidadeResiduos();
            for(int j = 0;j<tam;j++){
                System.out.println(ecoponto.listarResiduos(j));
            }
            System.out.println("-----------------------------------------------------");
        
    }
}

public void cadastrarResiduo(Scanner scan) {
    scan.nextLine();
    System.out.println("Digite o nome do ecoponto:");
    String nome = scan.nextLine();

    for (int i = 0; i < tamanhoEcopontos; i++) {
        Ecoponto ecoponto = ecopontos[i];
        if (ecoponto != null && ecoponto.getNome().equals(nome)) {
            System.out.println("Digite a quantidade de resíduos que deseja cadastrar:");
            int quantidade = scan.nextInt();
            scan.nextLine(); 

            for (int j = 0; j < quantidade; j++) {
                System.out.println("Digite o nome do resíduo:");
                String nomeResiduo = scan.nextLine();
                if(ecoponto.inserirResiduo(nomeResiduo)){
                    System.out.println("Residuo cadastrado com sucesso");
                }else{
                    System.out.println("Vetor cheio");
                }
            }   
        }
    }

    System.out.println("Ecoponto não encontrado.");
}


public void excluirResiduo(Scanner scan) {
    scan.nextLine();
    System.out.println("Digite o nome do ecoponto:");
    String nome = scan.nextLine();

    for (int i = 0; i < tamanhoEcopontos; i++) {
        Ecoponto ecoponto = ecopontos[i];
        if (ecoponto != null && ecoponto.getNome().equals(nome)) {
            System.out.println("Digite o residuo:");
            String nomeResiduo = scan.nextLine();
            if(ecoponto.excluirResiduo(nomeResiduo)){
                System.out.println("Resíduo removido com sucesso.");
                return;
            }else{
                System.out.println("Resíduo não encontrado");
                return;
            }
        }
    }

    System.out.println("Ecoponto não encontrado.");
}



public void inter(Scanner scan){
    boolean exit = false;
    int n = 7;
    while(!exit){
        switch(n){
            case 1:
                cadastrarEcoponto(scan);
                n = 7;
                break;
            case 2:
                excluirEcoponto(scan);
                n = 7;
                break;
            case 3:
                 System.out.println("-----------------------------------------------------");
                escreverEcopontos();
                n=7;
                break;
            case 4:
                cadastrarResiduo(scan);
                n = 7;
                break;
            case 5:
                excluirResiduo(scan);
                n = 7;
                break;
            case 6:
                mostrarEcopontoComResiduo(scan);
                n = 7;
                break;
            case 7:
                n = opcoes(scan);
                break;
            case 0:
                System.out.println("Encerrando");
                exit = true;
                break;
            default:
                System.out.println("Inválido");
                n = 7;
                break;
        }   
    }
}
}




