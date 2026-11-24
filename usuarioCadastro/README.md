# Cadastro de Usuário API

API REST desenvolvida em Java com Spring Boot para cadastro, autenticação e gerenciamento de usuários, endereços e telefones.

## Visão geral

Este projeto oferece endpoints para:

- cadastrar usuários
- realizar login com autenticação JWT
- buscar usuário por e-mail
- atualizar dados do usuário
- cadastrar e atualizar endereço
- cadastrar e atualizar telefone
- remover usuário por e-mail

A aplicação usa:

- Java 21
- Spring Boot 4.1.1
- Spring Security
- Spring Data JPA
- PostgreSQL
- JWT (JSON Web Token)

## Estrutura do projeto

```text
usuarioCadastro/
├── src/
│   ├── main/
│   │   ├── java/com/rodrigo/usuarioCadastro/
│   │   │   ├── business/
│   │   │   ├── controller/
│   │   │   ├── infrastructure/
│   │   │   └── UsuarioCadastroApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/com/rodrigo/usuarioCadastro/
├── build.gradle
├── gradlew
├── gradlew.bat
├── settings.gradle
└── README.md
```

## Pré-requisitos

Antes de executar a aplicação, certifique-se de que você tenha instalado:

- Java 21+
- Gradle (ou use o wrapper do projeto)
- PostgreSQL

## Configuração do banco de dados

A aplicação está configurada para usar o PostgreSQL no banco `db_usuario`.

Edite o arquivo:

```text
src/main/resources/application.properties
```

e ajuste as credenciais do banco conforme seu ambiente:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/db_usuario
spring.datasource.username=postgres
spring.datasource.password=SuaSenha
spring.jpa.hibernate.ddl-auto=update
```

Configure também `JWT_SECRET` com uma chave aleatória de pelo menos 32 bytes. Não use uma chave fixa no código nem compartilhe a chave entre ambientes. No PowerShell:

```powershell
$env:JWT_SECRET = "<chave-aleatoria-com-pelo-menos-32-bytes>"
```

No Bash, use `export JWT_SECRET="<chave-aleatoria-com-pelo-menos-32-bytes>"`.

Caso o banco não exista, crie-o antes da execução:

```sql
CREATE DATABASE db_usuario;
```

## Como executar

Na pasta `usuarioCadastro`, execute:

```bash
./gradlew bootRun
```

No Windows:

```bash
gradlew.bat bootRun
```

A aplicação iniciará na porta padrão do Spring Boot:

```text
http://localhost:8080
```

## Endpoints

### 1. Cadastrar usuário

```http
POST /usuario
```

Body exemplo:

```json
{
  "nome": "João da Silva",
  "email": "joao@email.com",
  "senha": "123456",
  "enderecos": [],
  "telefones": []
}
```

---

### 2. Login

```http
POST /usuario/login
```

Body exemplo:

```json
{
  "email": "joao@email.com",
  "senha": "123456"
}
```

Resposta:

```text
Bearer <token>
```

---

### 3. Buscar usuário por e-mail

```http
GET /usuario?email=joao@email.com
```

---

### 4. Atualizar dados do usuário

```http
PUT /usuario
```

Headers:

```http
Authorization: Bearer <token>
```

Body exemplo:

```json
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "senha": "novaSenha123"
}
```

---

### 5. Deletar usuário por e-mail

```http
DELETE /usuario/{email}
```

Exemplo:

```http
DELETE /usuario/joao@email.com
```

---

### 6. Cadastrar endereço

```http
POST /usuario/endereco
```

Headers:

```http
Authorization: Bearer <token>
```

Body exemplo:

```json
{
  "rua": "Rua das Flores",
  "numero": 123,
  "bairro": "Centro",
  "cidade": "São Paulo",
  "estado": "SP",
  "cep": "01000-000"
}
```

---

### 7. Atualizar endereço

```http
PUT /usuario/endereco?id=1
```

Body exemplo:

```json
{
  "rua": "Avenida Paulista",
  "numero": 1000,
  "bairro": "Bela Vista",
  "cidade": "São Paulo",
  "estado": "SP",
  "cep": "01310-100"
}
```

---

### 8. Cadastrar telefone

```http
POST /usuario/telefone
```

Headers:

```http
Authorization: Bearer <token>
```

Body exemplo:

```json
{
  "numero": "11999999999",
  "ddd": "11"
}
```

---

### 9. Atualizar telefone

```http
PUT /usuario/telefone?id=1
```

Body exemplo:

```json
{
  "numero": "11888888888",
  "ddd": "11"
}
```

## Segurança

A API usa autenticação JWT via Spring Security. Os endpoints de cadastro e login são públicos, enquanto os demais endpoints exigem um token válido no header. Consulta, atualização e exclusão são limitadas aos dados do usuário autenticado. O token deve ser enviado no formato `Authorization: Bearer <token>`.

```http
Authorization: Bearer <token>
```

## Testes

Para rodar os testes automatizados:

```bash
./gradlew test
```

## Observações

- O projeto foi desenvolvido com foco em cadastro e autenticação de usuários.
- O campo `senha` é armazenado criptografado com BCrypt.
- O banco é atualizado automaticamente com `spring.jpa.hibernate.ddl-auto=update`.

## Autor

Projeto desenvolvido por Rodrigo.
