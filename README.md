# API para E-commerce

## Descrição

Esta é uma API desenvolvida em Java utilizando Spring Boot, projetada para simular um sistema de e-commerce completo. A API gerencia o fluxo de compra online, desde o cadastro de clientes e produtos até o processamento de pedidos e integração com sistemas de pagamento e logística.

## Funcionalidades

- **Cadastro de Clientes e Endereços**
- **Gestão de Produtos e Estoque**
- **Processamento de Pedidos e Itens do Pedido**
- **Integração com Pagamentos**
- **Histórico de Pedidos e Rastreabilidade**
- **Promoções e Descontos**
- **Cancelamento Automático de Pedidos**

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.3.3**
- **Spring Data JPA**
- **Spring Boot Validation**
- **H2 Database** (Runtime)
- **Lombok** (Opcional)
- **Spring Boot DevTools**
- **Spring Boot Test** (Para testes unitários e de integração)

## Configuração do Projeto

O projeto utiliza Maven como ferramenta de gerenciamento de dependências e construção. O arquivo `pom.xml` inclui as principais dependências necessárias para o desenvolvimento e teste da API.

### Dependências Principais:

- `spring-boot-starter-data-jpa`: Integração com o JPA/Hibernate para persistência de dados.
- `spring-boot-starter-validation`: Validação de dados utilizando as anotações do Bean Validation.
- `spring-boot-starter-web`: Para desenvolvimento de APIs REST.
- `h2`: Banco de dados em memória para testes e desenvolvimento.
- `lombok`: Facilita a criação de código boilerplate, como getters, setters e construtores.
- `spring-boot-devtools`: Ferramenta de desenvolvimento para reinicialização automática de servidores.

### Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/ecommerce-api.git
   ```
2. Navegue até o diretório do projeto:
    ```bash
   cd ecommerce-api
   ```
3. Compile e execute a aplicação usando Maven:
   ```bash
   mvn spring-boot:run
   ```
4. Acesse a API em:
   ```bash
   http://localhost:8080
   ```
5. O banco de dados H2 pode ser acessado em:
   ```bash
   http://localhost:8080/h2-console
   ```
   (Credenciais padrão podem ser configuradas em application.properties)

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.
Licença

Este projeto está licenciado sob a licença MIT.
