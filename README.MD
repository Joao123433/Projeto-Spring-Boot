### Projeto de Controle Financeiro

Este projeto é uma aplicação de controle financeiro desenvolvida em Java utilizando o **Spring Boot**, com operações CRUD (Create, Read, Update e Delete) para **Clientes**, **Fornecedores**, **Contas a Pagar**, e **Contas a Receber**. Utiliza o banco de dados **H2** em memória e o **Postman** para testar as requisições.

#### Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database** (banco de dados em memória)
- **Postman** (testes de API)

### Funcionalidades

O projeto possui os seguintes módulos:

1. **ClienteController**:
   - **POST /api/Cliente**: Cria um novo cliente.
   - **GET /api/Cliente**: Lista todos os clientes.
   - **GET /api/Cliente/{id}**: Busca um cliente por ID.
   - **PUT /api/Cliente/{id}**: Atualiza um cliente existente.
   - **DELETE /api/Cliente/{id}**: Exclui um cliente pelo ID.

2. **FornecedorController**:
   - **POST /api/Fornecedor**: Cria um novo fornecedor.
   - **GET /api/Fornecedor**: Lista todos os fornecedores.
   - **GET /api/Fornecedor/{id}**: Busca um fornecedor por ID.
   - **PUT /api/Fornecedor/{id}**: Atualiza um fornecedor existente.
   - **DELETE /api/Fornecedor/{id}**: Exclui um fornecedor pelo ID.

3. **ContasPagarController**:
   - **POST /api/ContasPagar**: Cria uma nova conta a pagar.
   - **GET /api/ContasPagar**: Lista todas as contas a pagar.
   - **GET /api/ContasPagar/{id}**: Busca uma conta a pagar por ID.
   - **PUT /api/ContasPagar/{id}**: Atualiza uma conta a pagar existente.
   - **DELETE /api/ContasPagar/{id}**: Exclui uma conta a pagar pelo ID.

4. **ContasReceberController**:
   - **POST /api/ContasReceber**: Cria uma nova conta a receber.
   - **GET /api/ContasReceber**: Lista todas as contas a receber.
   - **GET /api/ContasReceber/{id}**: Busca uma conta a receber por ID.
   - **PUT /api/ContasReceber/{id}**: Atualiza uma conta a receber existente.
   - **DELETE /api/ContasReceber/{id}**: Exclui uma conta a receber pelo ID.

5. **UserController** e **UsuarioController**:
   - **POST /api/user**: Cria um usuário local em memória.
   - **POST /api/usuario/register**: Registra um usuário com validações de nome e idade.

6. **ExercicioController**:
   - Exercícios de manipulação de strings e validações de idade para aprendizado.

### Configuração do Banco de Dados

O projeto utiliza o **H2 Database**, que é um banco de dados em memória, facilitando o desenvolvimento e testes. 

#### Configurações do H2 no `application.properties`:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
```

#### Acessando o H2 Console

- URL: `http://localhost:8090/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (deixe em branco)

### Testando com Postman

O **Postman** é utilizado para realizar as requisições HTTP para as APIs. Você pode testar as seguintes funcionalidades:

- **Criação de Cliente (POST)**:
  - URL: `http://localhost:8090/api/Cliente`
  - Body (JSON):
    ```json
    {
      "name": "Jorge",
    }
    ```
- **Listar Clientes (GET)**:
  - URL: `http://localhost:8090/api/Cliente`

### Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/FabioLopes34/controle-financeiro.git
   ```
2. Navegue até o diretório do projeto:
   ```bash
   cd controle-financeiro
   ```
3. Execute o projeto com o Maven:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Acesse a aplicação:
   - H2 Console: `http://localhost:8090/h2-console`
   - API Testes (via Postman): `http://localhost:8090/api/`

### Considerações Finais

Este projeto é uma base simples para um sistema de controle financeiro com operações CRUD e integrações básicas com banco de dados H2. Sinta-se à vontade para expandir e melhorar as funcionalidades de acordo com suas necessidades.

#### Autor

- Desenvolvido por Fábio - fabio.lopes28@fatec.sp.gov.br
