package com.techdive.InterfaceLinhaComando;

import com.techdive.Banco.Cliente;
import com.techdive.Banco.Operacional.*;

import java.util.List;
import java.util.Scanner;

import static com.techdive.InterfaceLinhaComando.InterfaceUsuario.limpaTela;
import static com.techdive.InterfaceLinhaComando.InterfaceUsuario.quebraLinha;

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
                    System.out.println("Por favor, digite o numero da conta: ");
                    int numConta = entrada.nextInt();
                    entrada.nextLine();
                    Conta conta = Banco.getConta(numConta);
                    if(conta == null)
                    {
                        quebraLinha();
                        System.out.println("ERRO: Conta inexistente");
                    }
                    else {
                        quebraLinha();
                        System.out.println("A Conta selecionada foi: ");
                        System.out.println(conta);
                        quebraLinha();
                        List<String> extratoConta;
                        extratoConta = conta.getExtrato();
                        for (String linhaExtrato : extratoConta) {
                            System.out.println(linhaExtrato);
                        }
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
                    if(conta == null)
                    {
                        quebraLinha();
                        System.out.println("ERRO: Conta inexistente");
                    }
                    else {
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
                    }
                    System.out.println("Por favor, digite qualquer tecla para continuar");
                    entrada.nextLine();
                    break;

                case 3:
                    System.out.println("Por favor, digite o numero da conta a ser feito o saque: ");
                    numConta = entrada.nextInt();
                    entrada.nextLine();
                    conta = Banco.getConta(numConta);
                    if(conta == null)
                    {
                        quebraLinha();
                        System.out.println("ERRO: Conta inexistente");
                    }
                    else {
                        quebraLinha();
                        System.out.println("A Conta selecionada foi: ");
                        System.out.println(conta);
                        quebraLinha();
                        System.out.println("Por favor, digite o valor do saque: ");
                        double valor = entrada.nextDouble();
                        entrada.nextLine();
                        transacoes.processaSaque(conta, valor);
                        quebraLinha();
                        System.out.println("Saque realizado");
                        System.out.println("Novo saldo da conta: " + conta.getSaldo());
                        quebraLinha();
                    }
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
                    if(conta == null)
                    {
                        quebraLinha();
                        System.out.println("ERRO: Conta inexistente");
                        System.out.println("");
                        System.out.println("Por favor, digite qualquer tecla para continuar");
                        entrada.nextLine();
                        break;
                    }
                    else {
                        quebraLinha();
                        System.out.println("A Conta de origem selecionada foi: ");
                        System.out.println(conta);
                        quebraLinha();
                    }
                    System.out.println("Por favor, digite o numero da conta de destino para a trasnferencia: ");
                    numConta = entrada.nextInt();
                    entrada.nextLine();
                    Conta contaDestino = Banco.getConta(numConta);
                    if(contaDestino == null)
                    {
                        quebraLinha();
                        System.out.println("ERRO: Conta inexistente");
                        System.out.println("");
                        System.out.println("Por favor, digite qualquer tecla para continuar");
                        entrada.nextLine();
                        break;
                    }
                    else {
                        quebraLinha();
                        System.out.println("A Conta destino selecionada foi: ");
                        System.out.println(contaDestino);
                        quebraLinha();
                    }
                    System.out.println("Por favor, digite o valor a ser transferido: ");
                    double valor = entrada.nextDouble();
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
                    System.out.println("Por favor, digite o numero da conta poupanca para a simulacao de rendimento: ");
                    numConta = entrada.nextInt();
                    entrada.nextLine();
                    conta = Banco.getConta(numConta);
                    if(conta == null)
                    {
                        quebraLinha();
                        System.out.println("ERRO: Conta inexistente");
                    }
                    else if(!(conta instanceof ContaPoupanca)) {
                        quebraLinha();
                        System.out.println("ERRO: Conta nao e do tipo poupanca");
                    }
                    else {
                        quebraLinha();
                        System.out.println("A Conta selecionada foi: ");
                        System.out.println(conta);
                        quebraLinha();

                        System.out.println("Por favor digite a quantidade de meses que deseja simular: ");
                        int periodoMeses = entrada.nextInt();
                        entrada.nextLine();
                        System.out.println("Por favor digite a taxa de rendimento anual da poupanca (em %): ");
                        double rendimentoAnual = entrada.nextDouble();
                        entrada.nextLine();
                        quebraLinha();
                        System.out.println("Simulando rendimento");
                        System.out.println("Voce selecionou uma taxa de rentabilidade anual de: " + rendimentoAnual + "%");
                        System.out.println("Voce selecionou um periodo de : " + periodoMeses + " meses");
                        quebraLinha();
                        double rendimentoMensal = transacoes.simularRendimento(conta, periodoMeses, rendimentoAnual);
                        System.out.printf("Para esses valores, seu rendimento sera de: %.2f %% %n", rendimentoMensal);
                        System.out.println("Com esse rendimento, seu saldo que hoje e de: " + conta.getSaldo()
                                + " ira se valorizar para: " + (conta.getSaldo() * (1 + (rendimentoMensal / 100))));
                    }
                    quebraLinha();
                    System.out.println("Pressione qualquer tecla para continuar");
                    entrada.nextLine();
                    break;
                case 6:
                    // escolher investimento conta investimento
                    System.out.println("Por favor, digite o numero da conta investimento para a selecionar opcoes de investimento: ");
                    numConta = entrada.nextInt();
                    entrada.nextLine();
                    conta = Banco.getConta(numConta);
                    if(conta == null)
                    {
                        quebraLinha();
                        System.out.println("ERRO: Conta inexistente");
                    }
                    else if(!(conta instanceof ContaInvestimento)) {
                        quebraLinha();
                        System.out.println("ERRO: Conta nao e do tipo investimento");
                    }
                    else {

                        quebraLinha();
                        System.out.println("A Conta selecionada foi: ");
                        System.out.println(conta);

                        quebraLinha();
                        System.out.println("Por favor digite o numero da opcao de investimento que deseja consultar: ");
                        int escolha = entrada.nextInt();
                        entrada.nextLine();
                        quebraLinha();
                        System.out.println("Voce selecionou a opcao " + escolha + " de investimento");
                        double rendimentoInvestimento = transacoes.selecionarInvestimento(conta, escolha);
                        System.out.printf("Para esse investimento, seu rendimento anual sera de: %.2f %% %n", rendimentoInvestimento);
                        quebraLinha();
                        System.out.println("Pressione qualquer tecla para simular o rendimento desse inestimento na sua conta");
                        entrada.nextLine();

                        quebraLinha();
                        System.out.println(" Simulando rendimento da opcao " + escolha + " de investimento");
                        System.out.println("Por favor digite a quantidade de meses que deseja simular: ");
                        int periodoMeses = entrada.nextInt();
                        entrada.nextLine();

                        quebraLinha();
                        System.out.println("Simulando rendimento");
                        System.out.println("O investimento selecionado tem uma taxa de rentabilidade anual de: " + rendimentoInvestimento + "%");
                        System.out.println("Voce selecionou um periodo de : " + periodoMeses + " meses");
                        quebraLinha();
                        double rendimentoMensal = transacoes.simularRendimento(conta, periodoMeses, rendimentoInvestimento);
                        System.out.printf("Para esse periodo e essa opcao de investimento, seu rendimento sera de: %.2f %% %n", rendimentoMensal);
                        System.out.println("Com esse rendimento, seu saldo que hoje e de: " + conta.getSaldo()
                                + " ira se valorizar para: " + (conta.getSaldo() * (1 + (rendimentoMensal / 100))));
                    }
                    quebraLinha();
                    System.out.println("Pressione qualquer tecla para continuar");
                    entrada.nextLine();
                    break;
                default:
                    limpaTela();
                    System.out.println("Opção inválida! Tente novamente");
            }
        } while(opcao != 0);
    }
}

