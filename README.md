# Rotina de Transações

Projeto desafio sobre gerenciamento de transações.

## Operações Disponíveis

### Cadastro de Conta:

```
POST http://localhost:8080/v1/accounts
```
```JSON
{
  "document_number":"53456789001"
}
```

Resposta:
```JSON
{
  "id": 1,
  "document_number": "53456789001"
}
```


### Buscar conta por id:

```
GET http://localhost:8080/v1/accounts/1
```

Resposta:
```JSON
{
  "id": 1,
  "document_number": "53456789001"
}
```

### Cadastrar transação:

```
POST http://localhost:8080/v1/transactions
```

```JSON
{
  "account_id":"1",
  "operation_type_id":"4",
  "amount":"123.45"
}
```

Resposta:
```JSON
{
  "amount": 123.45,
  "id": 1,
  "account_id": 1,
  "operation_type_id": 4,
  "event_date": "2021-05-06"
}
```

## Tipos de Operações

A tabela abaixo lista os tipos de operações possíveis para realização de transações.

| operation_type_id | Description      |
|-------------------|------------------|
| 1                 | COMPRA A VISTA   |
| 2                 | COMPRA PARCELADA |
| 3                 | SAQUE            |
| 4                 | PAGAMENTO        |

Obs: As transações 'COMPRA A VISTA', 'COMPRA PARCELADA' e 'SAQUE' são registradas com valores negativos,
enquanto que 'PAGAMENTO' são registradas com valor positivo.

## Dependências
* Java 11
* Maven 4
* Docker
* Docker-Compose

## Executando o projeto:
```SHELL
> git clone https://github.com/Dguarines/rotinatransacoes.git
> cd rotinatransacoes
> (sudo) docker-compose up
```

## Executando os testes:
```SHELL
> git clone https://github.com/Dguarines/rotinatransacoes.git
> cd rotinatransacoes
> mvn test
```
## Swagger:
* Com a aplicação rodando acesse: http://localhost:8080/swagger-ui.html