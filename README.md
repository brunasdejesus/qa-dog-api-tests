# Dog API Automated Tests

## CI Pipeline

Os testes são executados automaticamente via GitHub Actions.

Status do pipeline:
[![API Tests](https://github.com/brunasdejesus/qa-dog-api-tests/actions/workflows/test.yml/badge.svg)](https://github.com/brunasdejesus/qa-dog-api-tests/actions/workflows/test.yml)

Projeto de automação de testes desenvolvido para validar endpoints da Dog API.

API utilizada:
https://dog.ceo/dog-api/

## Objetivo

Garantir que os endpoints da Dog API respondam corretamente e retornem dados no formato esperado.

## Tecnologias utilizadas

- Java
- Gradle
- JUnit 5
- RestAssured
- GitHub Actions (CI)

## Estrutura do projeto

src/test/java

utils
- BaseTest.java → configuração base da API

tests
- BreedsTest.java → testes dos endpoints

## Endpoints testados

GET /breeds/list/all  
Retorna todas as raças disponíveis

GET /breed/{breed}/images  
Retorna imagens de uma raça específica

GET /breeds/image/random  
Retorna uma imagem aleatória de cachorro

## Validações implementadas

- Status code das respostas
- Estrutura do JSON retornado
- Conteúdo da resposta
- Tempo de resposta
- Logs automáticos em caso de falha

## Como executar o projeto

Clone o repositório:

git clone https://github.com/brunasdejesus/qa-dog-api-tests

Entre na pasta do projeto:

cd qa-dog-api-tests

Execute os testes:

./gradlew test

## Integração contínua

O projeto possui pipeline configurado no GitHub Actions que executa automaticamente os testes a cada push ou pull request.

## Autora

Bruna Soares de Jesus
QA Engineer

