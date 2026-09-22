# API REST

API REST desenvolvida com Java e Spring Boot para gerenciamento de clientes e endereços.

O projeto foi desenvolvido com foco na prática de desenvolvimento backend, aplicando conceitos de APIs REST, Spring Data JPA, Hibernate, integração com APIs externas, OpenFeign, tratamento de exceções e persistência de dados.

A aplicação também utiliza a interface Swagger/OpenAPI para visualizar os endpoints e realizar testes das requisições HTTP.

---

## Sobre o projeto

A aplicação permite realizar operações de cadastro, consulta, atualização e exclusão de clientes.

Um dos principais recursos do projeto é a integração com a API ViaCEP.

Ao cadastrar ou atualizar um cliente, é possível informar apenas o CEP do endereço. A aplicação consulta automaticamente o ViaCEP para obter as demais informações do endereço.

Exemplo:

```json
{
    "name": "Duda",
    "address": {
        "cep": "05265040"
    }
}
