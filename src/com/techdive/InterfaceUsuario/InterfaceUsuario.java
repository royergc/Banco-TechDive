package com.techdive.InterfaceUsuario;

import java.util.Scanner;

public class InterfaceUsuario {

    public static void sairSistema() {
        limpaTela();
        System.out.println("Obrigado por usar o aplicativo do Banco Tech Dive! Até breve!");
    }

    public static void menuRelatorios(){
        System.out.println("Você entrou no menu Relatorios");
    }

    public static void main(String[] args) {
        chamaMenuPrincipal();
    }

    public static void chamaMenuPrincipal() {
        int opcao;
        Scanner entrada = new Scanner(System.in);

        do{
            menuPrincipal();
            opcao = entrada.nextInt();

            switch(opcao){
                case 1:
                    opcaoCadastros();
                    break;

                case 2:
                    menuOperacoes();
                    break;

                case 3:
                    menuRelatorios();
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

        System.out.printf("%n");
        System.out.println("Opcao: ");
    }

    public static void opcaoCadastros() {
        int opcao;
        Scanner entrada = new Scanner(System.in);

        do{
            menuCadastros();
            opcao = entrada.nextInt();

            switch(opcao){
                case 1:
                    // cadastrar cliente
                    break;

                case 2:
                    // cadastrar conta corrente
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

    public static void menuCadastros(){
        limpaTela();
        quebraLinha();
        System.out.println("Você entrou no menu Cadastros ");
        quebraLinha();
        System.out.println("Escolha a opção desejada: ");
        System.out.println("1 - Cadastrar novo cliente");
        System.out.println("2 - Cadastrar nova conta corrente");
        System.out.println("3 - Cadastrar nova conta poupanca");
        System.out.println("4 - Cadastrar nova conta investimento");
        System.out.println("5 - Cadastrar nova agencia bancaria");
        System.out.println("");
        System.out.println("0 - Retornar ao menu principal");
    }

    public static void opcaoOperacoes() {

    }

    public static void menuOperacoes(){
        limpaTela();
        quebraLinha();
        System.out.println("Você entrou no menu Operacoes");
        quebraLinha();
        System.out.println("Escolha a opção desejada: ");
        System.out.println("1 - Extrato");
        System.out.println("2 - Deposito");
        System.out.println("3 - Saque");
        System.out.println("4 - Transferencia entre contas");
        System.out.println("5 - Simular rendimento da poupanca");
        System.out.println("6 - Escolher investimento da conta investimento");
        System.out.println("7 - Alterar dados cadastrais");
        System.out.println("");
        System.out.println("0 - Retornar ao menu principal");
    }

    public static void limpaTela() {
        System.out.printf("%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n");
    }

    public static void quebraLinha() {
        System.out.printf("%n-------------------------------------------------------------%n%n");
    }



}
