# 📦 ProdutoDAO - Cadastro de Produtos com Java + MySQL

Este projeto é um sistema simples de **cadastro e listagem de produtos**, desenvolvido em **Java**, utilizando o padrão **DAO (Data Access Object)** e integração com banco de dados **MySQL** via JDBC.

O objetivo principal é praticar conceitos como:

- Conexão com banco de dados  
- Inserção e leitura de dados (CRUD básico)  
- Organização em camadas (Model, DAO, Config e App)  
- Uso de PreparedStatement (evitando SQL Injection)

---

## 🛠️ Funcionalidades

✅ Cadastrar produtos no banco de dados  
✅ Listar todos os produtos cadastrados  
✅ Entrada de dados pelo terminal (Scanner)  
✅ Estrutura organizada em pacotes  

---

# 📁 Estrutura do Projeto

O projeto está dividido em 4 pacotes principais:

- br.com.app
- br.com.DAO
- br.com.config
- br.com.model

Cada pacote possui uma classe responsável por uma parte do sistema.

---

## 📌 Pacote `br.com.model`

### Classe: `Produto`

Representa a entidade principal do sistema.

Essa classe armazena os dados do produto, como:

- `id`
- `nome`
- `valor`
- `setorProduto`

Ela contém construtores, getters e setters.

## 📌 Pacote `br.com.config`

### Classe: `connetion`

A classe **`connetion`** é responsável por realizar a conexão com o banco de dados **MySQL**.

Ela centraliza as principais configurações do sistema, como:

- URL do banco de dados  
- Usuário do MySQL  
- Senha de acesso  

Além disso, fornece o método:

**java**:
public static Connection getConnection()

## 📌 Pacote `br.com.DAO`

### Classe: `ProdutoDAO`

A classe **`ProdutoDAO`** é responsável por realizar a comunicação entre o sistema e o banco de dados.

Ela segue o padrão **DAO (Data Access Object)**, organizando as operações de acesso aos dados de forma separada da lógica principal do programa.

Essa classe implementa funcionalidades como:

---

### ✔️ CREATE - Cadastrar Produto

**java**:
public void cadastrar(Produto produto)

## 📌 Pacote `br.com.app`

### Classe: `main`

A classe **`main`** é a classe principal do sistema, responsável por executar o programa.

Ela permite que o usuário interaja pelo terminal, realizando ações como:

- Informar quantos produtos deseja cadastrar  
- Inserir os dados utilizando `Scanner`  
- Salvar os produtos no banco de dados através do `ProdutoDAO`  
- Exibir todos os produtos cadastrados no final da execução  

Trecho principal do funcionamen

# 🗄️ Banco de Dados

O projeto utiliza o banco de dados **MySQL**, com uma tabela chamada **`produtos`**.

Essa tabela armazena as informações principais de cada produto cadastrado no sistema, como:

- ID do produto  
- Nome  
- Valor  
- Setor do produto  

Exemplo da estrutura SQL utilizada:

```sql
CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    valor INT,
    SetorProfuto VARCHAR(100)
);










