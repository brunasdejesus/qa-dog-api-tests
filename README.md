## Dog API Automated Tests 🐶

## CI Pipeline

Os testes são executados automaticamente via GitHub Actions.

Status do pipeline:
[![API Tests](https://github.com/brunasdejesus/qa-dog-api-tests/actions/workflows/test.yml/badge.svg)](https://github.com/brunasdejesus/qa-dog-api-tests/actions/workflows/test.yml)
[![Java Version](https://img.shields.io/badge/java-17-brightgreen)](https://www.oracle.com/java/)  
[![Gradle Version](https://img.shields.io/badge/gradle-8.3-blue)](https://gradle.org/)


---

## 📌 Descrição do Projeto

Este projeto contém **testes automatizados para a Dog API** ([dog.ceo](https://dog.ceo/dog-api/)), usando **Java, JUnit 5 e RestAssured**.  
O objetivo é validar endpoints da API, garantindo:

- Respostas corretas (status code)
- Estrutura JSON esperada
- Conteúdo válido
- Tempo de resposta aceitável
- Logs automáticos em caso de falha

---

## 🎯 Objetivo

Garantir que os endpoints da Dog API respondam corretamente e retornem dados no formato esperado, permitindo que o serviço seja confiável e utilizável por aplicações que dependam dele.

---

## 🛠️ Tecnologias Utilizadas

- Java 17
- Gradle
- JUnit 5
- RestAssured
- GitHub Actions (CI)

---

## 📁 Estrutura do Projeto

```text
src/
└── test/
    └── java/
        ├── utils/
        │   └── BaseTest.java        # Configuração base da API
        └── tests/
            └── BreedsTest.java      # Testes dos endpoints da Dog API

```

---

## 🔹 Endpoints Testado

| Endpoint                    | Descrição                                |
| --------------------------- | ---------------------------------------- |
| `GET /breeds/list/all`      | Retorna todas as raças disponíveis       |
| `GET /breed/{breed}/images` | Retorna imagens de uma raça específica   |
| `GET /breeds/image/random`  | Retorna uma imagem aleatória de cachorro |

---

## ✅ Validações Implementadas

- Status code da resposta

- Estrutura do JSON retornado

- Conteúdo da resposta

- Tempo de resposta (<3s)

- Logs automáticos caso haja falha

---

## 💻 Como Executar o Projeto

- 1️⃣ Clone o repositório

`git clone https://github.com/brunasdejesus/qa-dog-api-tests.git
cd qa-dog-api-tests`

- 2️⃣ Execute os testes


  - No Linux/macOS:

  `./gradlew test`
  - No Windows:
  
  `gradlew.bat test`
    

- 3️⃣ Logs e relatórios 

Todos os logs de requisição e resposta são exibidos automaticamente em caso de falha, configurados no `BaseTest.java`.

## 📄 Base Test (BaseTest.java)

    package utils;

    import io.restassured.RestAssured;
    import org.junit.jupiter.api.BeforeAll;

    public class BaseTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://dog.ceo/api";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
     }
    }


## 📄 Exemplo de Teste (BreedsTest.java)

    package tests;

    import org.junit.jupiter.api.Test;
    import utils.BaseTest;
    import static io.restassured.RestAssured.*;
    import static org.hamcrest.Matchers.*;

    public class BreedsTest extends BaseTest {

    @Test
    void shouldListAllBreeds() {
        given()
        .when()
            .get("/breeds/list/all")
        .then()
            .statusCode(200)
            .time(lessThan(3000L))
            .body("status", equalTo("success"))
    .body("message", not(empty()));
    }

    @Test
    void shouldReturnRandomImage() {
        given()
        .when()
            .get("/breeds/image/random")
        .then()
            .statusCode(200)
            .time(lessThan(3000L))
            .body("status", equalTo("success"))
            .body("message", containsString("https://"));
    }
    }

---

## ⚙️ Integração Contínua (GitHub Actions)

Arquivo de workflow `.github/workflows/test.yml`:

    name: Dog API Tests

    on:
    push:
    branches: [main]
    pull_request:

    jobs:
    test:
    runs-on: ubuntu-latest
    steps:
    - name: Checkout code
    uses: actions/checkout@v4

      - name: Setup Java
        uses: actions/setup-java@v4
        with:
          distribution: 'temurin'
          java-version: '17'

      - name: Grant execute permission
        run: chmod +x gradlew

      - name: Run tests
        run: ./gradlew test

O badge de pipeline está no topo do README e será atualizado automaticamente a cada push ou pull request.

---


## 🤝 Como Contribuir

- Fork este repositório

- Crie uma branch com sua feature (`git checkout -b feature/nova-feature`)

- Faça commit das alterações (`git commit -m 'Adiciona nova feature'`)

- Push para sua branch (`git push origin feature/nova-feature`)

- Abra um Pull Request descrevendo suas alterações

---

📞 Contato

Bruna Soares

E-mail: bruna.mec51@yahoo.com.br































