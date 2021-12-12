package com.techdive.InterfaceLinhaComando;

import com.techdive.Banco.Operacional.Conta;
import com.techdive.Banco.Operacional.ContaCorrente;
import com.techdive.Banco.Operacional.ContaInvestimento;
import com.techdive.Banco.Operacional.ContaPoupanca;
import com.techdive.Banco.Relatorios;

import java.util.ArrayList;
import java.util.Scanner;

import static com.techdive.InterfaceLinhaComando.InterfaceUsuario.*;

public class MenuRelatorios {

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
                    if(relatorioContas.size() > 0) {
                        quebraLinha();
                        System.out.println("Lista das contas do banco");
                        quebraLinha();
                        for (Conta conta : relatorioContas) {
                            System.out.println(conta);
                        }
                    }
                    else {
                        quebraLinha();
                        System.out.println("Nenhuma conta cadastrada");
                    }
                    pressioneParaContinuar();
                    break;

                case 2:
                    ArrayList<ContaCorrente> relatorioContasCorrente = relatorios.getContasCorrente();
                    if(relatorioContasCorrente.size() > 0 ) {
                        quebraLinha();
                        System.out.println("Lista das contas correntes do banco");
                        quebraLinha();
                        for(ContaCorrente conta : relatorioContasCorrente) {
                            System.out.println(conta);
                        }
                    }
                    else {
                        quebraLinha();
                        System.out.println("Nenhuma conta corrente cadastrada");
                    }
                    pressioneParaContinuar();
                    break;

                case 3:
                    ArrayList<ContaPoupanca> relatorioContasPoupanca = relatorios.getContasPoupanca();
                    if(relatorioContasPoupanca.size() > 0 ) {
                        quebraLinha();
                        System.out.println("Lista das contas poupanca do banco");
                        quebraLinha();
                        for (ContaPoupanca conta : relatorioContasPoupanca) {
                            System.out.println(conta);
                        }
                    }
                    else {
                        quebraLinha();
                        System.out.println("Nenhuma conta poupança cadastrada");
                    }
                    pressioneParaContinuar();
                    break;
                case 4:
                    ArrayList<ContaInvestimento> relatorioContasInvestimento = relatorios.getContasInvestimento();
                    if(relatorioContasInvestimento.size() > 0) {
                        quebraLinha();
                        System.out.println("Lista das contas investimento do banco");
                        quebraLinha();
                        for(ContaInvestimento conta : relatorioContasInvestimento) {
                            System.out.println(conta);
                        }
                    }
                    else {
                        quebraLinha();
                        System.out.println("Nenhuma conta investimento cadastrada");
                    }
                    pressioneParaContinuar();
                    break;
                case 5:
                    ArrayList<ContaCorrente> relatorioContasNegativas = relatorios.getContasSaldoInferior(0);
                    if(relatorioContasNegativas.size() > 0 ) {
                        System.out.println("Lista das contas com saldo negativo no banco");
                        quebraLinha();
                        for (ContaCorrente conta : relatorioContasNegativas) {
                            System.out.println(conta);
                        }
                    }
                    else {
                        quebraLinha();
                        System.out.println("Nao ha contas com saldo negativo no banco");
                    }
                    pressioneParaContinuar();
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
                    ArrayList<String> historicoOperacoes = relatorios.getHistoricoOperacao("[");
                    limpaTela();
                    quebraLinha();
                    System.out.println("O sistema ira imprimir o historico de todas as transacoes realizadas no banco");
                    quebraLinha();
                    System.out.println("Pressione qualquer tecla para prosseguir");
                    entrada.nextLine();
                    for(String operacao : historicoOperacoes) {
                        System.out.println(operacao);
                    }
                    quebraLinha();
                    System.out.println("");
                    System.out.println("Pressione qualquer tecla para prosseguir");
                    entrada.nextLine();
                    break;
                default:
                    limpaTela();
                    System.out.println("Opção inválida! Tente novamente");
            }
        } while(opcao != 0);
    }
}
