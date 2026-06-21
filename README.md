# 🎵 ScreenSound - Java + Spring Boot

Aplicação backend desenvolvida em Java utilizando Spring Boot para
gerenciamento de artistas e músicas.

O projeto permite cadastrar, consultar e organizar informações musicais
utilizando persistência de dados em PostgreSQL e consultas
personalizadas através do Spring Data JPA.

Além disso, a aplicação possui integração com a API do Google Gemini
para buscar informações adicionais sobre artistas.

------------------------------------------------------------------------

## 🚀 Funcionalidades

-   Cadastro de artistas
-   Cadastro de músicas
-   Consulta de músicas por artista
-   Persistência de dados em PostgreSQL
-   Consultas personalizadas com JPQL
-   Consultas utilizando Derived Queries
-   Integração com API do Google Gemini

------------------------------------------------------------------------

## 🧠 Fluxo da aplicação

``` text
Usuário
   ↓
Terminal
   ↓
Aplicação Spring Boot
   ↓
Camada de Serviço
   ↓
Repository (Spring Data JPA)
   ↓
PostgreSQL
```

------------------------------------------------------------------------

## 🛠️ Tecnologias utilizadas

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)

![SpringBoot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)

![Spring DataJPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white)

![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)

![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)

![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

------------------------------------------------------------------------

## 📚 Conceitos aplicados

-   Desenvolvimento backend com Spring Boot
-   Persistência de dados com JPA/Hibernate
-   Modelagem de entidades
-   Criação de repositories
-   Consultas JPQL
-   Derived Queries
-   Consumo de APIs externas
-   Organização em camadas

------------------------------------------------------------------------

## ▶️ Como executar o projeto

### Pré-requisitos

-   Java 17+
-   Maven
-   PostgreSQL

Clone o repositório:

``` bash
git clone https://github.com/pedrobuzolin/ScreenSound.git
```

Configure o banco de dados no arquivo `application.properties`.

Execute:

``` bash
mvn spring-boot:run
```

------------------------------------------------------------------------

## 🤖 Integração com Google Gemini

A aplicação utiliza a API do Google Gemini para buscar informações
complementares sobre artistas.

O fluxo consiste em:

-   Enviar uma solicitação para a API
-   Processar a resposta recebida
-   Apresentar as informações ao usuário

Essa integração permitiu explorar comunicação entre aplicações backend e
serviços de inteligência artificial.

------------------------------------------------------------------------

## 🔮 Possíveis melhorias

-   Criar uma API REST utilizando Spring Web
-   Implementar autenticação com Spring Security e JWT
-   Criar testes automatizados
-   Documentar endpoints com Swagger
-   Containerizar aplicação com Docker
