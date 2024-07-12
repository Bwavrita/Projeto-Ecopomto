# Projeto Ecoponto

Este projeto foi desenvolvido para a disciplina de Programação Orientada a Objetos (POO) e aplica os princípios básicos de orientação a objetos.

## Descrição

O objetivo do projeto é criar um sistema para o cadastramento e gerenciamento de ecopontos. Ecopontos são locais designados para a coleta seletiva de materiais recicláveis. O sistema permite:

- **Cadastramento de Ecopontos**: Registra novos ecopontos no sistema com informações detalhadas.
- **Gerenciamento de Responsáveis**: Associa um responsável a cada ecoponto, facilitando a comunicação e a gestão.
- **Localização dos Ecopontos**: Armazena e exibe a localização geográfica de cada ecoponto, permitindo a fácil localização pelos usuários.
- **Materiais Aceitos**: Especifica os tipos de materiais recicláveis que cada ecoponto aceita, ajudando na separação correta dos resíduos.

## Funcionalidades

- **Cadastro de Responsáveis**: Permite registrar e gerenciar informações dos responsáveis pelos ecopontos, incluindo nome, contato e detalhes adicionais.
- **Registro de Localização**: Utiliza coordenadas geográficas (latitude e longitude) para mapear a localização exata dos ecopontos.
- **Gestão de Materiais**: Define e gerencia a lista de materiais que cada ecoponto está preparado para receber, como papel, plástico, metal, vidro, entre outros.
- **Interface de Usuário**: Fornece uma interface intuitiva para o cadastramento e gerenciamento das informações dos ecopontos, tornando o sistema acessível e fácil de usar.

## Estrutura do Código

### Classes Principais

1. **Ecoponto**:
    - Responsável por armazenar as informações do ecoponto, incluindo nome, endereço, pessoa responsável e resíduos aceitos.
    - Métodos principais:
        - `inserirResiduo(String residuo)`: Adiciona um resíduo ao ecoponto.
        - `excluirResiduo(String residuo)`: Remove um resíduo do ecoponto.
        - `listarResiduos(int i)`: Lista os resíduos aceitos pelo ecoponto.

2. **Endereco**:
    - Armazena os detalhes do endereço do ecoponto, como rua, número, complemento, CEP, cidade e estado.

3. **Pessoa**:
    - Armazena as informações do responsável pelo ecoponto, como nome e CPF.
    - Métodos principais:
        - `verificarCpf()`: Verifica se o CPF fornecido é válido.

4. **Interface**:
    - Fornece uma interface para interação com o usuário, permitindo o cadastro, exclusão e visualização de ecopontos e resíduos.
    - Métodos principais:
        - `cadastrarEcoponto(Scanner scan)`: Cadastra um novo ecoponto.
        - `excluirEcoponto(Scanner scan)`: Exclui um ecoponto existente.
        - `mostrarEcopontoComResiduo(Scanner scan)`: Mostra ecopontos que aceitam um determinado resíduo.
        - `escreverEcopontos()`: Lista todos os ecopontos cadastrados.
        - `cadastrarResiduo(Scanner scan)`: Cadastra resíduos em um ecoponto.
        - `excluirResiduo(Scanner scan)`: Exclui resíduos de um ecoponto.

## Tecnologias Utilizadas

- **Linguagem de Programação**: Java
- **Paradigma**: Programação Orientada a Objetos
- **Ferramentas de Desenvolvimento**: Eclipse
- **Controle de Versão**: Git

## Conclusão

O Projeto Ecoponto visa facilitar a gestão e o acesso a informações sobre ecopontos, promovendo a reciclagem e a sustentabilidade. Utilizando os princípios da Programação Orientada a Objetos, o sistema é modular, extensível e fácil de manter. Através de uma interface amigável, usuários podem cadastrar, gerenciar e localizar ecopontos de forma eficiente.
