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
- Conta: definida nos requisitos do projeto - gerencia informações da conta (saldo, extrato). Deixei publicos apenas os metodos de fornecer informações (getSaldo, getNome, getExtrato, etc) pois as transações em si serão realizadas pela classe Transações. 
- Conta corrente: classe filha de Conta, definida nos requisitos do projeto
- Conta poupança: classe filha de Conta, definida nos requisitos do projeto
- Conta investimento: classe filha de Conta, definida nos requisitos do projeto
- Transações: classe definida nos requisitos do projeto - armazena as informações de transações entre contas (utilizei como uma centralizadora das transacoes, a aplicacao só executar transacoes atraves dela).
Os metodos das contas ficaram protected para dividir a responsabilidade: as contas cuidam apenas de controlar o saldo e gerar o extrato, enquanto a classe transacoes gera o historico de todas as transacoes do banco e 
tem seus metodos visiveis para o resto da aplicacao requisitar transacoes entre as contas.
- Banco: assim como a classe Transações controla as transações, a classe Banco controla e centraliza as informações de contas e clientes. Todas as requisições de informações gerais de contas e clientes são fornecidas por ela.
Para se cadastrar uma conta nova ou um cliente novo no sistema, é necessário passar por métodos dessa Classe, que faz o controle (os construtores dos objetos conta estão protected para o resto da aplicação nao conseguir criar contas).
- Relatórios: classe que irá gerar os relatórios e apresentar para o usuário
- Interface: classe que irá gerenciar a interface com o usuário

## Conclusões

De modo geral foi um grande aprendizado desenvolver esse projeto. A medida que ia avançando, pude perceber várias oportunidades de melhoria e aprofundar um pouco mais nos conceitos básicos de POO.
Por exemplo, os atributos da conta: nome, cpf, renda mensal são na verdade atributos do Cliente, então a Conta poderia ter um Cliente no lugar desses atributos repetidos.
Além disso, toda a interface com o usuário eu fiz no último dia, pois perdi bastante tempo tentando fazer funcionar o "backend" da aplicação.
A interface poderia estar muito mais bem estruturada utilizando conceitos de POO. Fica como oportunidade de melhoria para uma próxima versão desse projeto. 
Foi um desafio, meu primeiro projeto Orientado a Objetos, mas foi bem gratificante poder terminar no prazo com as funcionalidades funcionando.
Porém, o código poderia ser refatorado para ficar mais limpo e organizado, especialmente na parte da interface com o usuário.





   