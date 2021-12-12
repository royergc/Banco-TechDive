package com.techdive.InterfaceUsuario;

import com.techdive.Banco.Cliente;
import com.techdive.Banco.Operacional.Banco;
import com.techdive.Banco.Operacional.Conta;
import com.techdive.Banco.Operacional.ContaCorrente;
import com.techdive.Banco.Operacional.Transacoes;
import com.techdive.Banco.Relatorios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterfaceUsuario {

    public static void main(String[] args) {
        chamaMenuPrincipal();
    }

    public static void chamaMenuPrincipal() {
        int opcao;
        Scanner entrada = new Scanner(System.in);

        do{
            menuPrincipal();
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch(opcao){
                case 1:
                    chamaMenuCadastros();
                    break;

                case 2:
                    chamaMenuOperacoes();
                    break;

                case 3:
                    chamaMenuRelatorios();
                    break;
                case 0 :
                    sairSistema();
                    break;
                default:
                    limpaTela();
                    System.out.println("Opção inválida! Tente novamente");
            }
        } while(opcao != 0);
    }

    public static void chamaMenuCadastros() {
        int opcao;
        Scanner entrada = new Scanner(System.in);

        do{
            menuCadastros();
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch(opcao){
                case 1:
                    limpaTela();
                    quebraLinha();
                    System.out.println("Cadastro de cliente");
                    quebraLinha();
                    System.out.println("");
                    System.out.println("Por favor, digite o CPF do cliente (apenas numeros, sem pontos ou tracos): ");
                    String cpf = entrada.nextLine();
                    while(!Cliente.validaCPF(cpf)) {
                        limpaTela();
                        quebraLinha();
                        System.out.println("Cadastro de cliente");
                        quebraLinha();
                        System.out.println("");
                        System.out.println("Cpf digitado eh invalido!");
                        System.out.println("Por favor, digite o CPF do cliente (apenas numeros, sem pontos ou tracos): ");
                        cpf = entrada.nextLine();
                    }
                    if(Banco.getCliente(cpf) != null) {
                        limpaTela();
                        quebraLinha();
                        System.out.println("Cliente ja cadastrado no banco");
                        quebraLinha();
                        System.out.println("");
                        System.out.println("Pressione qualquer tecla para prosseguir");
                        entrada.nextLine();
                        break;
                    }
                    System.out.println("");
                    System.out.println("Por favor, digite o nome completo do cliente: ");
                    String nome = entrada.nextLine();
                    System.out.println("");
                    System.out.println("Por favor, digite a renda mensal do cliente (apenas numeros): ");
                    double rendaMensal = Double.parseDouble(entrada.nextLine());

                    limpaTela();
                    quebraLinha();
                    System.out.println("Cadastrando novo cliente");
                    quebraLinha();
                    Cliente cliente = new Cliente(nome, cpf, rendaMensal);
                    Banco.cadastraCliente(cliente);

                    System.out.println("Cliente cadastrado corretamente");
                    System.out.println(cliente);
                    quebraLinha();
                    System.out.println("");
                    System.out.println("Pressione qualquer tecla para prosseguir");
                    entrada.nextLine();

                    break;

                case 2:
                    limpaTela();
                    quebraLinha();
                    System.out.println("Cadastro de Conta Corrente");
                    quebraLinha();
                    System.out.println("");
                    System.out.println("Por favor, digite o CPF do cliente (apenas numeros, sem pontos ou tracos): ");
                    cpf = entrada.nextLine();
                    while(!Cliente.validaCPF(cpf)) {
                        limpaTela();
                        quebraLinha();
                        System.out.println("Cadastro de Conta Corrente");
                        quebraLinha();
                        System.out.println("");
                        System.out.println("Cpf digitado eh invalido!");
                        System.out.println("Por favor, digite o CPF do cliente (apenas numeros, sem pontos ou tracos): ");
                        cpf = entrada.nextLine();
                    }
                    cliente = Banco.getCliente(cpf);
                    if(cliente == null) {
                        limpaTela();
                        quebraLinha();
                        System.out.println("Cliente nao tem cadastro no banco");
                        System.out.println("Faca o cadastro do cliente para poder criar a conta");
                        quebraLinha();
                        System.out.println("");
                        System.out.println("Pressione qualquer tecla para prosseguir");
                        entrada.nextLine();
                        break;
                    }
                    else {
                        quebraLinha();
                        System.out.println("O cliente selecionado foi: ");
                        System.out.println(cliente);
                        quebraLinha();
                        System.out.println("Por favor digite a agencia em que a conta devera ser criada: ");
                        String agencia = entrada.nextLine();
                        Banco.cadastraConta(cliente,agencia,1);
                        int numConta = Banco.getNumContaCliente(cpf);
                        ContaCorrente conta = (ContaCorrente) Banco.getConta(numConta);
                        limpaTela();
                        quebraLinha();
                        System.out.println("Conta Corrente cadastrada corretamente");
                        System.out.println(conta);
                        quebraLinha();
                        System.out.println("");
                        System.out.println("Pressione qualquer tecla para prosseguir");
                        entrada.nextLine();
                    }
                    break;

                case 3:
                    // cadastrar conta poupanca
                    break;
                case 4:
                    // cadastrar conta investimento
                    break;
                case 5:
                    // cadastrar agencia
                    break;
                case 0 :
                    // voltar menuPrincipal
                    break;
                default:
                    limpaTela();
                    System.out.println("Opção inválida! Tente novamente");
            }
        } while(opcao != 0);

    }

    public static void chamaMenuOperacoes() {
        int opcao;
        Transacoes transacoes = Transacoes.iniciaTransacoes();
        Scanner entrada = new Scanner(System.in);

        do{
            menuOperacoes();
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch(opcao){
                case 1:
                    System.out.println("Por favor, digite o numero da conta que deseja tirar o extrato0" +
                            ": ");
                    int numConta = entrada.nextInt();
                    entrada.nextLine();
                    Conta conta = Banco.getConta(numConta);
                    quebraLinha();
                    System.out.println("A Conta selecionada foi: ");
                    System.out.println(conta);
                    quebraLinha();
                    List<String> extratoConta;
                    extratoConta = conta.getExtrato(1);
                    for(String linhaExtrato : extratoConta) {
                        System.out.println(linhaExtrato);
                    }
                    quebraLinha();
                    System.out.println("");
                    System.out.println("Por favor, digite qualquer tecla para continuar");
                    entrada.nextLine();
                    break;

                case 2:
                    System.out.println("Por favor, digite o numero da conta a ser depositada: ");
                    numConta = entrada.nextInt();
                    entrada.nextLine();
                    conta = Banco.getConta(numConta);
                    quebraLinha();
                    System.out.println("A Conta selecionada foi: ");
                    System.out.println(conta);
                    quebraLinha();
                    System.out.println("Por favor, digite o valor a ser depositado: ");
                    double valor = entrada.nextDouble();
                    entrada.nextLine();
                    transacoes.processaDeposito(conta,valor);
                    quebraLinha();
                    System.out.println("Deposito realizado");
                    System.out.println("Novo saldo da conta: " + conta.getSaldo());
                    quebraLinha();
                    System.out.println("");
                    System.out.println("Por favor, digite qualquer tecla para continuar");
                    entrada.nextLine();
                    break;

                case 3:
                    System.out.println("Por favor, digite o numero da conta a ser feito o saque: ");
                    numConta = entrada.nextInt();
                    entrada.nextLine();
                    conta = Banco.getConta(numConta);
                    quebraLinha();
                    System.out.println("A Conta selecionada foi: ");
                    System.out.println(conta);
                    quebraLinha();
                    System.out.println("Por favor, digite o valor do saque: ");
                    valor = entrada.nextDouble();
                    entrada.nextLine();
                    transacoes.processaSaque(conta,valor);
                    quebraLinha();
                    System.out.println("Saque realizado");
                    System.out.println("Novo saldo da conta: " + conta.getSaldo());
                    quebraLinha();
                    System.out.println("");
                    System.out.println("Por favor, digite qualquer tecla para continuar");
                    entrada.nextLine();
                    break;
                case 4:
                    // transferencia
                    System.out.println("Por favor, digite o numero da conta de origem para a transferencia: ");
                    numConta = entrada.nextInt();
                    entrada.nextLine();
                    conta = Banco.getConta(numConta);
                    quebraLinha();
                    System.out.println("A Conta de origem selecionada foi: ");
                    System.out.println(conta);
                    quebraLinha();
                    System.out.println("Por favor, digite o numero da conta de destindo para a trasnferencia: ");
                    numConta = entrada.nextInt();
                    entrada.nextLine();
                    Conta contaDestino = Banco.getConta(numConta);
                    quebraLinha();
                    System.out.println("A Conta destino selecionada foi: ");
                    System.out.println(contaDestino);
                    quebraLinha();
                    System.out.println("Por favor, digite o valor a ser transferido: ");
                    valor = entrada.nextDouble();
                    entrada.nextLine();
                    transacoes.processaTransferencia(conta,contaDestino,valor);
                    quebraLinha();
                    System.out.println("Transferencia realizada");
                    System.out.println("Novo saldo da conta de origem: " + conta.getSaldo());
                    System.out.println("Novo saldo da conta de destino: " + contaDestino.getSaldo());
                    quebraLinha();
                    System.out.println("");
                    System.out.println("Por favor, digite qualquer tecla para continuar");
                    entrada.nextLine();
                    break;
                case 5:
                    // simular rendimento poupanca
                    break;
                case 6:
                    // escolher investimento conta investimento
                    break;
                case 7:
                    // alterar dados cadastrais
                    break;
                case 0 :
                    // voltar menuPrincipal
                    break;
                default:
                    limpaTela();
                    System.out.println("Opção inválida! Tente novamente");
            }
        } while(opcao != 0);
    }

    public static void chamaMenuRelatorios() {
        int opcao;
        Relatorios relatorios = new Relatorios();
        Scanner entrada = new Scanner(System.in);

        do{
            menuRelatorios();
            opcao = entrada.nextInt();
            entrada.nextLine();


            switch(opcao){
                case 1:
                    ArrayList<Conta> relatorioContas = relatorios.getTodasContasDoBanco();
                    quebraLinha();
                    System.out.println("Lista das contas do banco");
                    quebraLinha();
                    for (Conta conta : relatorioContas) {
                        System.out.println(conta);
                    }
                    quebraLinha();
                    System.out.println("");
                    System.out.println("Por favor pressione qualquer tecla para continuar");
                    entrada.nextLine();
                    break;

                case 2:
                    ArrayList<ContaCorrente> relatorioContasCorrente = relatorios.getContasCorrente();quebraLinha();
                    System.out.println("Lista das contas correntes do banco");
                    quebraLinha();
                    for(ContaCorrente conta : relatorioContasCorrente) {
                        System.out.println(conta);
                    }
                    quebraLinha();
                    System.out.println("");
                    System.out.println("Por favor pressione qualquer tecla para continuar");
                    entrada.nextLine();
                    break;

                case 3:
                    // listar contas poupanca
                    break;
                case 4:
                    // listar contas investimento
                    break;
                case 5:
                    ArrayList<ContaCorrente> relatorioContasNegativas = relatorios.getContasSaldoInferior(0);
                    System.out.println("Lista das contas com saldo negativo no banco");
                    quebraLinha();
                    for (ContaCorrente conta : relatorioContasNegativas) {
                        System.out.println(conta);
                    }
                    quebraLinha();
                    System.out.println("");
                    System.out.println("Por favor pressione qualquer tecla para continuar");
                    entrada.nextLine();
                    break;
                case 6:
                    double valortotaldobanco = relatorios.getTotalSaldos();
                    quebraLinha();
                    System.out.println("Saldo total disponivel no banco : " + valortotaldobanco);
                    quebraLinha();
                    System.out.println("");
                    System.out.println("Por favor pressione qualquer tecla para continuar");
                    entrada.nextLine();
                    break;
                case 7:
                    ArrayList<String> historicoSaques = relatorios.getHistoricoOperacao("[");
                    limpaTela();
                    quebraLinha();
                    System.out.println("O sistema ira imprimir o historico de todas as transacoes realizadas no banco");
                    quebraLinha();
                    System.out.println("");
                    System.out.println("Pressione qualquer tecla para prosseguir");
                    entrada.nextLine();
                    for(int i = 0; i < historicoSaques.size(); i++) {
                        System.out.println(historicoSaques.get(i));
                    }
                    quebraLinha();
                    System.out.println("");
                    System.out.println("Pressione qualquer tecla para prosseguir");
                    entrada.nextLine();
                    break;
                case 0 :
                    // voltar menuPrincipal
                    break;
                default:
                    limpaTela();
                    System.out.println("Opção inválida! Tente novamente");
            }
        } while(opcao != 0);
    }

    public static void menuPrincipal(){
        limpaTela();
        quebraLinha();
        System.out.println("Bem vindo ao Banco TechDive");
        quebraLinha();
        System.out.println("Escolha a opção desejada: ");
        System.out.println("1 - Cadastros");
        System.out.println("2 - Operacoes bancarias");
        System.out.println("3 - Relatorios");
        System.out.println("0 - Sair do sistema");
        System.out.println("");
        System.out.println("Opcao: ");
    }
    public static void menuCadastros(){
        limpaTela();
        quebraLinha();
        System.out.println("Menu Cadastros ");
        quebraLinha();
        System.out.println("Escolha a opção desejada: ");
        System.out.println("1 - Cadastrar novo cliente");
        System.out.println("2 - Cadastrar nova conta corrente");
        System.out.println("3 - Cadastrar nova conta poupanca");
        System.out.println("4 - Cadastrar nova conta investimento");
        System.out.println("5 - Cadastrar nova agencia bancaria");
        System.out.println("0 - Retornar ao menu principal");
        System.out.println("");
        System.out.println("Opcao: ");
    }

    public static void menuOperacoes(){
        limpaTela();
        quebraLinha();
        System.out.println("Menu Operacoes");
        quebraLinha();
        System.out.println("Escolha a opção desejada: ");
        System.out.println("1 - Extrato");
        System.out.println("2 - Deposito");
        System.out.println("3 - Saque");
        System.out.println("4 - Transferencia entre contas");
        System.out.println("5 - Simular rendimento da poupanca");
        System.out.println("6 - Escolher investimento da conta investimento");
        System.out.println("7 - Alterar dados cadastrais");
        System.out.println("0 - Retornar ao menu principal");
        System.out.println("");
        System.out.println("Opcao: ");
    }

    public static void menuRelatorios(){
        limpaTela();
        quebraLinha();
        System.out.println("Menu Relatorios");
        quebraLinha();
        System.out.println("Escolha a opção desejada: ");
        System.out.println("1 - Listar todas as contas");
        System.out.println("2 - Listar contas correntes");
        System.out.println("3 - Listar contas poupanca");
        System.out.println("4 - Listar contas investimento");
        System.out.println("5 - Listar contas com saldo negativo");
        System.out.println("6 - Mostrar total investido");
        System.out.println("7 - Mostrar transacoes");
        System.out.println("0 - Retornar ao menu principal");
        System.out.println("");
        System.out.println("Opcao: ");
    }


    public static void limpaTela() {
        System.out.printf("%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n");
    }

    public static void quebraLinha() {
        System.out.printf("%n==========================================================================%n%n");
    }

    public static void sairSistema() {
        limpaTela();
        quebraLinha();
        System.out.println("Obrigado por usar o aplicativo do Banco Tech Dive! Até breve!");
        quebraLinha();
    }



}
