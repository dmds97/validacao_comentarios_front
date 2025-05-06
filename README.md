
# 🗨️ Comentários API

Uma API RESTful desenvolvida com **Spring Boot** para cadastro e listagem de comentários. O objetivo é permitir que os comentários sejam analisados por um **agente de inteligência artificial**, garantindo que apenas conteúdos apropriados sejam publicados.

---

## 🔧 Tecnologias Utilizadas

* Java 17+
* Spring Boot
* Spring Web
* Spring Data JPA
* Spring Security (em desenvolvimento)
* H2 Database
* Maven
* Swagger (documentação da API)

---

## 📌 Endpoints Disponíveis

### ✅ `POST /comentarios`

Cria um novo comentário.

#### 🔸 Requisição

```json
{
  "texto": "Este é um comentário de teste"
}
```

#### 🔹 Resposta

```json
{
  "id": 1,
  "texto": "Este é um comentário de teste",
  "criadoEm": "2025-05-03T14:30:00"
}
```

---

### 📄 `GET /comentarios`

Lista todos os comentários cadastrados.

#### 🔹 Resposta

```json
[
  {
    "id": 1,
    "texto": "Este é um comentário de teste",
    "criadoEm": "2025-05-03T14:30:00"
  }
]
```

---

## 🤖 Integração com Inteligência Artificial (em desenvolvimento)

Uma camada de validação com IA será adicionada ao projeto em breve. Essa funcionalidade irá:

* Detectar linguagem ofensiva, spam ou conteúdo inapropriado.
* Rejeitar automaticamente comentários que violem as diretrizes da plataforma.
* Retornar uma resposta indicando se o comentário foi aceito ou rejeitado.

A integração será implementada no `ComentarioService`, utilizando serviços externos ou modelos treinados localmente.

---

## ▶️ Como Executar o Projeto

1. **Clone o repositório**:

   ```bash
   git clone https://github.com/seuusuario/comentarios-api.git
   ```

2. **Acesse o diretório do projeto**:

   ```bash
   cd comentarios-api
   ```

3. **Execute a aplicação com Maven**:

   ```bash
   ./mvnw spring-boot:run
   ```

4. **Acesse o console do banco H2 (opcional)**:

   ```
   URL: http://localhost:8080/h2-console
   JDBC URL: jdbc:h2:mem:comentariosdb
   ```

---

## 📝 Observações

* Este projeto está em fase de desenvolvimento.
* A camada de filtragem com IA será incluída futuramente.
* Autenticação e segurança com JWT estão previstas para a próxima versão.

---

## 📄 Licença

Este projeto está licenciado sob a [Licença MIT](https://opensource.org/licenses/MIT).
