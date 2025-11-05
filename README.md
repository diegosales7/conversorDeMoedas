💱 Conversor de Moedas em Java

Este projeto foi desenvolvido como parte de um desafio prático de consumo de API em Java, com o objetivo de aplicar conceitos de requisições HTTP, manipulação de JSON e orientação a objetos.

🚀 Objetivo do Projeto

Criar um conversor de moedas que obtém taxas de câmbio em tempo real através da API ExchangeRate, permitindo converter entre diferentes moedas e registrar os resultados em arquivos JSON.

🧩 Tecnologias Utilizadas

☕ Java 17+

🌐 API ExchangeRate

📦 Biblioteca Gson (para leitura e manipulação de JSON)

📝 JSON File Output (armazenamento das consultas)

💻 IDE: IntelliJ IDEA / VS Code / Eclipse

🧠 Etapas do Projeto

Criação das classes de moedas
Cada moeda (Dólar, Euro, Libra, etc.) foi representada por uma classe que herda da classe Moeda.

Implementação da classe ApiService
Responsável por se conectar à API ExchangeRate e buscar as taxas de câmbio utilizando o formato:

https://v6.exchangerate-api.com/v6/<SUA-CHAVE>/pair/USD/BRL


Leitura e análise da resposta JSON com Gson
A resposta da API é processada com as classes JsonParser e JsonObject, permitindo acessar os dados da conversão.

Criação da classe Conversor
Define a lógica principal de criação de objetos de moeda, conversão e integração com a API.

Armazenamento das consultas em arquivos JSON
Cada consulta é salva em um arquivo dentro da pasta /consultas_json, com o nome indicando as moedas e a data/hora da operação.

⚙️ Métodos Aplicados

converter() – realiza a conversão da moeda

criarMoeda() – instancia a moeda escolhida

buscarTaxa() – faz a requisição na API

salvarConsultaComoJson() – grava os resultados em um arquivo JSON

salvarConsulta() – organiza os registros salvos

📂 Estrutura do Projeto
src/
 ├── ApiService.java
 ├── Conversor.java
 ├── Moeda.java
 ├── Dolar.java
 ├── Euro.java
 ├── Libra.java
 ├── ieneJapones.java
 ├── francosuico.java
 ├── YuanChines.java
 └── consultas_json/
      ├── consulta_USD_BRL_2025-11-05_10-30.json

🧪 Exemplo de Uso
Digite a moeda de origem: USD
Digite a moeda de destino: BRL
Valor a converter: 100
Taxa atual: 5.35
Resultado: 535.00 BRL
Arquivo JSON gerado: consulta_USD_BRL_2025-11-05_10-30.json

🧰 Ferramentas de Apoio

🧾 Postman — para testar as requisições da API

🔍 Gson — para interpretar e manipular o JSON retornado

👨‍💻 Autor

Diego Sales Fernandes
💼 Estudante de Análise e Desenvolvimento de Sistemas – UFBRA
📘 Participante do programa Oracle Next Education (ONE)
📍 Brasil
