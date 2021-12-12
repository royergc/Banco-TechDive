package com.techdive.InterfaceUsuario;

import com.techdive.Banco.Operacional.Banco;
import com.techdive.Banco.Operacional.Conta;
import com.techdive.Banco.Operacional.Transacoes;

import java.util.List;
import java.util.Scanner;

import static com.techdive.InterfaceUsuario.InterfaceUsuario.limpaTela;
import static com.techdive.InterfaceUsuario.InterfaceUsuario.quebraLinha;

public class MenuOperacoes {

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
}
