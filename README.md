# Introdução
Desafio da casa de câmbio de bitcoins.
Projeto realizado por Lucas Matheus Valú Batista. 

# Documentação dos endpoints

Descrição: Cadastrar cliente  
Método: Post  
Endpoint: http://localhost:8080/cliente  
Tipo de conteúdo (Content-type): application/json  
Códigos de retorno:
- Status HTTP 201 se o cliente foi criado com sucesso.

Exemplo de carga útil:
```json
{
    "cpf": "12345678900",
    "nome": "Lucas Matheus Valú Batista",
    "conta": {
        "id": "12345678900-0001",
        "saldo": 0.0,
        "saldoBitcoin": 0.0,
        "investimentoTotal": 0.0,
        "lucro": 0.0
    }
}
```

---

Descrição: Alterar cliente  
Método: Post  
Endpoint: http://localhost:8080/cliente/{cpf}  
Tipo de conteúdo (Content-type): application/json  
Códigos de retorno:
- Status HTTP 201 se o cliente foi criado com sucesso.

Exemplo de carga útil:
```json
{
    "cpf": "12345678900",
    "nome": "Lucas Valú Batista",
    "conta": {
        "id": "12345678900-0001",
        "saldo": 0.0,
        "saldoBitcoin": 0.0,
        "investimentoTotal": 0.0,
        "lucro": 0.0
    }
}
```

---

Descrição: Listar todos os clientes  
Método: GET  
Endpoint: http://localhost:8080/cliente  
Tipo de conteúdo (Content-type): application/json  
Códigos de retorno:
- Status HTTP 200 se a requisição foi realizada com sucesso

Exemplo de retorno:
```json
[
    {
        "cpf": "12345678901",
        "nome": "Maria da Silva",
        "conta": {
            "id": "12345678901-0001",
            "saldo": 100.0,
            "saldoBitcoin": 0.0,
            "investimentoTotal": 0.0,
            "lucro": 0.0,
            "credito": 0.0
        }
    },
    {
        "cpf": "12345678900",
        "nome": "Lucas Matheus Valú Batista",
        "conta": {
            "id": "12345678900-0001",
            "saldo": 0.0,
            "saldoBitcoin": 0.0,
            "investimentoTotal": 0.0,
            "lucro": 0.0,
            "credito": 0.0
        }
    }
]
```

---

Descrição: Listar cliente específico  
Método: GET  
Endpoint: http://localhost:8080/cliente/{cpf}  
Tipo de conteúdo (Content-type): application/json  
Códigos de retorno:
- Status HTTP 200 se a requisição foi realizada com sucesso

Exemplo de retorno:
```json
{
    "cpf": "12345678900",
    "nome": "Lucas Matheus Valú Batista",
    "conta": {
        "id": "12345678900-0001",
        "saldo": 0.0,
        "saldoBitcoin": 0.0,
        "investimentoTotal": 0.0,
        "lucro": 0.0,
        "credito": 0.0
    },
    "hibernateLazyInitializer": {}
}
```

---

Descrição:  Excluir cliente  
Método: DELETE  
Endpoint: http://localhost:8080/cliente/{cpf}  
Tipo de conteúdo (Content-type): application/json  
Códigos de retorno:
- Status HTTP 204 se a requisição foi realizada com sucesso

Exemplo de retorno:
```json
1
```

---

Descrição: Realizar transferência de saldo  
Método: POST  
Endpoint: http://localhost:8080/cliente/{cpf}/creditar  
Tipo de conteúdo (Content-type): application/json  
Códigos de retorno:
- Status HTTP 200 se a requisição foi realizada com sucesso

Exemplo de carga útil:
```json
{
    "cpf":"12345678900",
    "nome":"Lucas Valú Batista",
    "conta":{
        "id":"12345678900-0001",
        "credito": 80000.00
    }
}
```

---

Descrição: Realizar compra de Bitcoin  
Método: GET  
Endpoint: http://localhost:8080/cliente/comprarBitcoin/{cpf}?quantidadeBitcoin=2.5  
Tipo de conteúdo (Content-type): application/json  
Códigos de retorno:
- Status HTTP 200 se a requisição foi realizada com sucesso

Exemplo de retorno:
```json
{
    "cpf": "12345678900",
    "nome": "Lucas Valú Batista",
    "conta": {
        "id": "12345678900-0001",
        "saldo": 322032.10939625,
        "saldoBitcoin": 2.5,
        "investimentoTotal": 157967.89060375,
        "lucro": 0.0,
        "credito": 80000.0
    },
    "hibernateLazyInitializer": {}
}
```

---


Descrição: Listar todas as contas  
Método: GET  
Endpoint: http://localhost:8080/conta  
Tipo de conteúdo (Content-type): application/json  
Códigos de retorno:
- Status HTTP 200 se a requisição foi realizada com sucesso

Exemplo de retorno:
```json
[
    {
        "id": "12345678900-0001",
        "saldo": 480000.0,
        "saldoBitcoin": 0.0,
        "investimentoTotal": 0.0,
        "lucro": 0.0,
        "credito": 80000.0
    }
]
```

---

Descrição: Listar conta específica  
Método: GET  
Endpoint: http://localhost:8080/conta/{id}  
Tipo de conteúdo (Content-type): application/json  
Códigos de retorno:
- Status HTTP 200 se a requisição foi realizada com sucesso

Exemplo de retorno:
```json
{
    "id": "12345678900-0001",
    "saldo": 480000.0,
    "saldoBitcoin": 0.0,
    "investimentoTotal": 0.0,
    "lucro": 0.0,
    "credito": 80000.0,
    "hibernateLazyInitializer": {}
}
```

---

Descrição: Verificar cotação atual de Bitcoin em reais (BRL)  
Método: GET  
Endpoint: http://localhost:8080/bitcoin  
Tipo de conteúdo (Content-type): application/json  
Códigos de retorno:  
- Status HTTP 200 se a requisição foi realizada com sucesso 

Exemplo de retorno:
```json
{
    "data": {
        "base": "BTC",
        "currency": "BRL",
        "amount": "62975.3529"
    }
}
```
