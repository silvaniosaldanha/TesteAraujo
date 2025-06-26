📌 Visão Geral
Este projeto implementa testes automatizados utilizando Java + TestNG + RestAssured para a API pública [Swagger Petstore](https://petstore.swagger.io/).

✅ Casos de Teste Implementados

1. **Cadastrar novo pedido de pet com sucesso**  
   ➤ Método: `POST`  
   ➤ Endpoint: `/store/order`

2. **Pesquisar por um pet inexistente**  
   ➤ Método: `GET`  
   ➤ Endpoint: `/pet/{petId}`

3. **Atualizar dados de um pet existente**  
   ➤ Método: `PUT`  
   ➤ Endpoint: `/pet`

4. **Pesquisar por pets com status “pending”**  
   ➤ Método: `GET`  
   ➤ Endpoint: `/pet/findByStatus?status=pending`

🛠 Tecnologias Utilizadas

Java 17
RestAssured 5.4.0
TestNG 6.14.3
Maven
JSON-Simple 1.1.1

📁 Estrutura de Pastas
src/
├── main/
│ └── java/
│ └── desafioTecnico/
│ ├── Category.java
│ ├── Pet.java
│ ├── Store.java
│ ├── Tag.java
├── test/
│ └── java/
│ └── desafioTecnico/
│ └── Practice.java

⚙️ Configuração do Ambiente
Pré-requisitos: 
JDK 17 instalado
Maven instalado
IDE de sua preferência (IntelliJ, Eclipse, etc.)

Como Executar os Testes

1- Clone o repositório:
git clone [https://github.com/silvaniosaldanha/TesteAraujo]

2-Navegue até o diretório do projeto:
cd teste-araujo

3- Execute os testes com Maven:
mvn test

4- Para executar um teste específico:
mvn test -Dtest=Practice

📝 Dependências do Projeto
As dependências estão configuradas no arquivo pom.xml:

<dependencies>
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>6.14.3</version>
    </dependency>
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>5.4.0</version>
    </dependency>
    <dependency>
        <groupId>com.aventstack</groupId>
        <artifactId>extentreports</artifactId>
        <version>5.1.2</version>
    </dependency>
    <dependency>
        <groupId>com.googlecode.json-simple</groupId>
        <artifactId>json-simple</artifactId>
        <version>1.1.1</version>
    </dependency>
</dependencies>

📌 Observações
Todos os testes são executados com dados simples e estáticos.

A API utilizada é pública e pode retornar resultados inconsistentes dependendo do estado atual do sistema.

IDs estão fixos, podendo causar falhas se já existirem registros com esses valores.




