# <div align="center"> Service Desk (Kotlin)  </div>

<br/>

# <div align="center"> 🚧 Concluído 🚧  </div>

<br/>

## Conteúdos

* [Pré-requisitos](#pré-requisitos)
* [Sobre](#sobre)
* [Como usar](#como-usar)
* [Tecnologias](#tecnologias)

<br/>

## Pré-requisitos

- Mysql 8
- JDK 21
- Postman v9.31.0
- Intellij

<br/>

## Sobre

Este projeto foi desenvolvido para fins de estudo em Kotlin e consiste em uma ``API REST`` simples com dois endpoints:

``POST: /tickets`` – Para criar um novo chamado.

``GET: /tickets`` – Para listar todos os chamados.

Os endpoints estão protegidos por autenticação e autorização, garantindo que apenas usuários autorizados possam acessá-los.

### 🔐 Autenticação e Autorização

Para consumir os endpoints, é necessário gerar um token de acesso. Esse processo é realizado por um servidor de autenticação externo.

📌 O projeto responsável pela geração e validação do token está disponível em:

👉 Repositório <code>***[authorization-server](https://github.com/fmatheus21/authorization)***</code>

🔸 Importante: O ``authorization-server`` deve estar em execução para que o ``Service Desk`` valide os tokens corretamente.

<br/>

## Como Usar

Abra e edite o arquivo <code>***application.yml***</code> informando as seguintes variáveis de ambiente:

- <code>***${SPRING_DATASOURCE_USERNAME}***</code>Usuário do seu banco de dados
- <code>***${SPRING_DATASOURCE_PASSWORD}***</code>Senha do seu banco de dados

Agora entre na classe ``KotlinApiRestApplication`` e execute o método ``main``.

O projeto roda na url ``http://localhost:9100/api/v1``.

No <code>***Postman***</code>, utilize o curl abaixo para ``cadastrar`` e ``listar`` tickets. Substitua o `<token>` pelo token gerado no ``authorization-server``.

<br/>

#### CURL

🔸 ``Listar Tickets``

 ```sh
 curl --location --request GET 'http://localhost:9100/api/v1/tickets' \
--header 'Authorization: Bearer <token>'
 ```

<br/>

🔸 ``Cadastrar Ticket``

 ```sh
 curl --location --request POST 'http://localhost:9100/api/v1/tickets' \
--header 'Authorization: Bearer <token>' \
--header 'Content-Type: application/json' \
--data '{
    "title": "Título",
    "problemDescription": "Descrição do problema",
    "client": {
        "id": "ae46dc08-2c64-11ee-a204-581122c7752d"
    }
}'
 ```

<br/>

## Tecnologias

![Java](https://img.shields.io/static/v1?label=Java&message=17&color=green)
![Spring Boot](https://img.shields.io/static/v1?label=spring-boot&message=3.4.4&color=green)
![MySql](https://img.shields.io/static/v1?label=mysql&message=8&color=green)
![Caffeine](https://img.shields.io/static/v1?label=caffeine&message=3.1.8&color=green)
![FlywayDB](https://img.shields.io/static/v1?label=flyway-db&message=10.20.1&color=green)
![kotlin-reflect](https://img.shields.io/static/v1?label=kotlin-reflect&message=1.9.25&color=green)
![kotlin-stdlib](https://img.shields.io/static/v1?label=kotlin-stdlib&message=1.9.25&color=green)
![oauth2](https://img.shields.io/static/v1?label=oauth2&message=3.4.4&color=green)
 