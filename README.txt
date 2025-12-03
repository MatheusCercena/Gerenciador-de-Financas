# 💰 Gerenciador de Finanças

## Descrição do Projeto

O **Gerenciador de Finanças** é uma aplicação desenvolvida com o objetivo de fornecer uma interface para o registo e gestão de transações financeiras pessoais. O projeto serve como uma atividade de integração curricular, aplicando conceitos de **Programação Orientada a Objetos (POO)** e persistência de dados através de um **Sistema de Gestão de Banco de Dados (SGBD)**.

Este projeto foi realizado no como atividade prática supervisionada (APS) do 3º semestre do curso de Ciências da Computação, focado na integração de Java com um sistema de gerenciamento de banco de dados.

## Funcionalidades Principais

O sistema permite a execução das seguintes operações essenciais de gestão financeira:

* **Registo de Transações:** Inserção de receitas e despesas com detalhes como valor, data, descrição e categoria.
* **Categorização:** Gestão e associação de categorias para melhor classificação dos fluxos financeiros.
* **Visualização de Saldo:** Apresentação do saldo atual consolidado.
* **Persistência de Dados:** Armazenamento seguro de todas as informações financeiras em um banco de dados relacional.
* **Relatórios Básicos:** Consulta e filtragem de transações por período ou categoria (ainda não implementado) na interface.

## Arquitetura e Tecnologias

O projeto utiliza uma arquitetura baseada nos princípios de POO e opera com as seguintes tecnologias:

### Tecnologias Utilizadas

| Componente | Tecnologia | Observações |
| :--- | :--- | :--- |
| **Linguagem Principal** | Java | Desenvolvimento da lógica de negócio e interface. |
| **Banco de Dados** | *MySQL | Responsável pela persistência e integridade dos dados. |
| **Conexão BD** | JDBC | Utilizado para a comunicação entre a aplicação Java e o SGBD. |

## Instalação e Configuração

Para executar a aplicação localmente, é necessário ter instalado o seguinte software:

* **Java Development Kit (JDK):** Versão 8 ou superior.
* **MySQL (SGBD):** Configurado em uma conexão, foi usado a porta 127.0.0.1::3306 com Admin "root", senha 1234, mas podem ser alterados na Classe ConexaoDB em src > model.
* **Em seguida, executar o script
