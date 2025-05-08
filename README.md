
# 🗨️ Comentários API

Uma API RESTful desenvolvida com **Spring Boot** para cadastro, listagem e gerenciamento de comentários. O objetivo é permitir que os comentários sejam analisados por um **agente de inteligência artificial**, garantindo que apenas conteúdos apropriados sejam publicados.

---

## 🔧 Tecnologias Utilizadas

* Java 17+
* Spring Boot
* Spring Web
* Spring Data JPA
* Bean Validation (`jakarta.validation`)
* PostgreSQL (produção)
* H2 Database (testes)
* Swagger/OpenAPI
* Maven

---

## 🗃️ Banco de Dados

A aplicação utiliza dois bancos, conforme o ambiente:

- **Produção:** PostgreSQL
- **Testes/Desenvolvimento local:** H2 (em memória)

As configurações estão nos arquivos `application-prod.properties` e `application-test.properties`.

---

## 📌 Endpoints Disponíveis

### ✅ `POST /comentarios`

Cria um novo comentário.

#### 🔸 Requisição (JSON)

```json
{
  "texto": "Este é um comentário de teste"
}
````

#### 🔹 Resposta de sucesso (`201 Created`)

```json
{
  "id": 1,
  "texto": "Este é um comentário de teste",
  "criadoEm": "2025-05-08T14:30:00"
}
```

#### ❗ Resposta de erro - Validação (`400 Bad Request`)

```json
{
  "texto": "O texto do comentário é obrigatório."
}
```

---

### 📄 `GET /comentarios`

Lista todos os comentários cadastrados.

#### 🔹 Resposta (`200 OK`)

```json
[
  {
    "id": 1,
    "texto": "Este é um comentário de teste",
    "criadoEm": "2025-05-08T14:30:00"
  }
]
```

---

### 📌 `GET /comentarios/{id}`

Retorna um comentário específico por ID.

#### 🔹 Resposta de sucesso (`200 OK`)

```json
{
  "id": 1,
  "texto": "Este é um comentário de teste",
  "criadoEm": "2025-05-08T14:30:00"
}
```

#### ❗ Comentário não encontrado (`404 Not Found`)

```json
{
  "erro": "Comentário não encontrado com o id: 999"
}
```

---

## ⚠️ Tratamento de Erros

A API conta com um tratamento global de erros, que retorna mensagens claras e padronizadas:

| Erro                          | Status | Exemplo de resposta                                    |
| ----------------------------- | ------ | ------------------------------------------------------ |
| Comentário não encontrado     | 404    | `{ "erro": "Comentário não encontrado com o id: 10" }` |
| Campo texto em branco         | 400    | `{ "texto": "O texto do comentário é obrigatório." }`  |
| Argumento inválido (genérico) | 400    | `{ "erro": "Texto muito longo" }`                      |

---

## 🤖 Integração com Inteligência Artificial (em desenvolvimento)

Está prevista a inclusão de uma camada de **validação automática via IA**:

* Detectar linguagem ofensiva, spam ou conteúdo inapropriado.
* Rejeitar comentários automaticamente com base em critérios de moderação.
* Integrar com serviços externos ou modelos de IA próprios.

---

## ▶️ Como Executar o Projeto

### 1. Clone o repositório:

```bash
git clone https://github.com/seuusuario/comentarios-api.git
```

### 2. Acesse o diretório:

```bash
cd comentarios-api
```

### 3. Execute em modo desenvolvimento/testes:

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=test
```

### 4. Execute em produção (PostgreSQL):

Configure o `application-prod.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/comentarios
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.profiles.active=prod
```

---

## 📚 Documentação Swagger

Acesse a documentação Swagger da API no navegador:

```
http://localhost:8080/swagger-ui.html
```

Ela permite testar os endpoints de forma interativa.

---

## 🔒 Próximas Funcionalidades

* 🔐 Autenticação e autorização com Spring Security + JWT
* 🤖 Integração com IA para moderação de conteúdo
* ✅ Paginação e ordenação de comentários
* 📁 Upload de imagens com comentários

---

## 📝 Observações

* Projeto em desenvolvimento ativo.
* Comentários ofensivos serão futuramente moderados via IA.
* O código segue boas práticas com DTOs, validação e tratamento de erros centralizado.

---

## 📄 Licença

Este projeto está licenciado sob a [Licença MIT](https://opensource.org/licenses/MIT).

