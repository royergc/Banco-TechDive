# Banco-TechDive
Projeto Avaliativo 1 - Programa TechDive
Desenvolvimento de um sistema bancário simples

## Requisitos

A aplicação deverá conter os seguintes requisitos:
- sistema escrito em Java, utilizando conceitos básicos de POO como objetos, classes, herança, construtores
- a interface com o usuário seria via linha de comando
- o sistema deve conter contas do tipo: conta corrente, conta poupança, conta investimento
- todas as contas devem ser derivadas da classe conta, que possui atributos e métodos obrigatórios
- o banco precisa manter um histórico das transações, com dados da conta origem, conta destino, valor e data
- o sistema também deverá apresentar relatórios (listar contas por tipo, listar contas com saldo negativo, total do valor investido no banco, todas as transações de um determinado cliente)

## Modelagem do sistema

Ao identificar os principais requisitos do sistema, pensei em dividir a estrutura do mesmo nas seguintes classes:
- Cliente: guardará as informações pessoais dos clientes e será responsável por validar o CPF 
- Conta: definida nos requisitos do projeto - gerencia informações da conta
- Conta corrente: classe filha de Conta, definida nos requisitos do projeto
- Conta poupança: classe filha de Conta, definida nos requisitos do projeto
- Conta investimento: classe filha de Conta, definida nos requisitos do projeto
- Transações: classe definida nos requisitos do projeto - armazena as informações de transações entre contas
- Relatórios: classe que irá gerar os relatórios e apresentar para o usuário
- Interface: classe que irá gerenciar a interface com o usuário
- Banco: aplicação principal.


   