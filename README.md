# DesafioHackatonDSM
 
# Sistema de Reservas de Voos
 
## Descrição
Este é um sistema simples para realizar reservas de voos, efetuar pagamentos e imprimir passagens. O sistema é construído em Java e utiliza um banco de dados MySQL para armazenar informações sobre voos, reservas e pagamentos.
 
## Estrutura do Projeto
- **Sistema**
  - **Conexao.java**: Classe para estabelecer a conexão com o banco de dados.
  - **CadastrarReserva.java**: Interface para cadastrar reservas.
  - **Pagamento.java**: Interface para realizar pagamentos.
  - **ImprimirPassagem.java**: Interface para imprimir passagens.
  - **Voo.java**: Classe que representa um voo.
 
## Configuração do Banco de Dados
1. Certifique-se de ter o MySQL instalado.
2. Crie um banco de dados chamado `dados`.
3. Execute o script SQL fornecido em `script.sql` para criar as tabelas necessárias.
 
## Como Executar
1. Abra o projeto em um ambiente de desenvolvimento Java.
2. Execute a classe `CadastrarReserva` para iniciar o processo de reserva.
 
## Observações
- Certifique-se de ter o driver MySQL JDBC no classpath do projeto.
- Os detalhes de conexão com o banco de dados (URL, usuário, senha) estão configurados em `Conexao.java`.
 
## Contribuições
Contribuições são bem-vindas! Se encontrar problemas ou tiver melhorias, sinta-se à vontade para abrir uma issue ou enviar um pull request.
 
## Licença
Este projeto está licenciado sob a licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.
