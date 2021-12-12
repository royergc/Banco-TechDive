package com.techdive.InterfaceLinhaComando;

import com.techdive.Banco.Cliente;
import com.techdive.Banco.Operacional.*;

import java.util.Scanner;

import static com.techdive.InterfaceLinhaComando.InterfaceUsuario.*;

public class MenuCadastros {

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
        System.out.println("5 - Alterar dados cadastrais");
        System.out.println("0 - Retornar ao menu principal");
        System.out.println("");
        System.out.println("Opcao: ");
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
                    pedeCadastrarCliente();
                    break;

                case 2:
                    pedeCadastrarContaCorrente();
                    break;

                case 3:
                    pedeCadastrarContaPoupanca();
                    break;
                case 4:
                    pedeCadastrarContaInvestimento();
                 break;
                case 5:
                    pedeAlterarDadosCadastrais();
                    // alterar dados cadastrais
                    break;
                default:
                    limpaTela();
                    System.out.println("Opção inválida! Tente novamente");
            }
        } while(opcao != 0);
    }

    public static void pedeCadastrarCliente() {
        Scanner entrada = new Scanner(System.in);
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
           return;
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
        if (Banco.cadastraCliente(cliente)) {

            System.out.println("Cliente cadastrado corretamente");
            System.out.println(cliente);
        } else {
            System.out.println(" ERRO: cliente nao cadastrado");
        }
        pressioneParaContinuar();
    }

    public static void pedeCadastrarContaCorrente() {
        Scanner entrada = new Scanner(System.in);
        limpaTela();
        quebraLinha();
        System.out.println("Cadastro de Conta Corrente");
        quebraLinha();
        System.out.println("");
        System.out.println("Por favor, digite o CPF do cliente (apenas numeros, sem pontos ou tracos): ");
        String cpf = entrada.nextLine();
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
        Cliente cliente = Banco.getCliente(cpf);
        if(cliente == null) {
            limpaTela();
            quebraLinha();
            System.out.println("Cliente nao tem cadastro no banco");
            System.out.println("Faca o cadastro do cliente para poder criar a conta");
            quebraLinha();
            System.out.println("");
            System.out.println("Pressione qualquer tecla para prosseguir");
            entrada.nextLine();
            return;
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
            if(conta == null)
            {
                quebraLinha();
                System.out.println("ERRO: Conta inexistente");
            }
            else {
                limpaTela();
                quebraLinha();
                System.out.println("Conta Corrente cadastrada corretamente");
                System.out.println(conta);
            }
            pressioneParaContinuar();
        }
    }

    public static void pedeCadastrarContaPoupanca() {
        // cadastrar conta poupanca
        Scanner entrada = new Scanner(System.in);
        limpaTela();
        quebraLinha();
        System.out.println("Cadastro de Conta Poupanca");
        quebraLinha();
        System.out.println("");
        System.out.println("Por favor, digite o CPF do cliente (apenas numeros, sem pontos ou tracos): ");
        String cpf = entrada.nextLine();
        while (!Cliente.validaCPF(cpf)) {
            limpaTela();
            quebraLinha();
            System.out.println("Cadastro de Conta Poupanca");
            quebraLinha();
            System.out.println("");
            System.out.println("Cpf digitado eh invalido!");
            System.out.println("Por favor, digite o CPF do cliente (apenas numeros, sem pontos ou tracos): ");
            cpf = entrada.nextLine();
        }
        Cliente cliente = Banco.getCliente(cpf);
        if (cliente == null) {
            limpaTela();
            quebraLinha();
            System.out.println("Cliente nao tem cadastro no banco");
            System.out.println("Faca o cadastro do cliente para poder criar a conta");
            quebraLinha();
            System.out.println("");
            System.out.println("Pressione qualquer tecla para prosseguir");
            entrada.nextLine();
            return;
        } else {
            quebraLinha();
            System.out.println("O cliente selecionado foi: ");
            System.out.println(cliente);
            quebraLinha();
            System.out.println("Por favor digite a agencia em que a conta devera ser criada: ");
            String agencia = entrada.nextLine();
            Banco.cadastraConta(cliente, agencia, 2);
            int numConta = Banco.getNumContaCliente(cpf);
            ContaPoupanca conta = (ContaPoupanca) Banco.getConta(numConta);
            if (conta == null) {
                quebraLinha();
                System.out.println("ERRO: Conta inexistente");
            } else {
                limpaTela();
                quebraLinha();
                System.out.println("Conta Poupanca cadastrada corretamente");
                System.out.println(conta);
            }
            pressioneParaContinuar();
        }
    }

    public static void pedeCadastrarContaInvestimento() {
        Scanner entrada = new Scanner(System.in);
        // cadastrar conta investimento
        limpaTela();
        quebraLinha();
        System.out.println("Cadastro de Conta Investimento");
        quebraLinha();
        System.out.println("");
        System.out.println("Por favor, digite o CPF do cliente (apenas numeros, sem pontos ou tracos): ");
        String cpf = entrada.nextLine();
        while(!Cliente.validaCPF(cpf)) {
            limpaTela();
            quebraLinha();
            System.out.println("Cadastro de Conta Investimento");
            quebraLinha();
            System.out.println("");
            System.out.println("Cpf digitado eh invalido!");
            System.out.println("Por favor, digite o CPF do cliente (apenas numeros, sem pontos ou tracos): ");
            cpf = entrada.nextLine();
        }
        Cliente cliente = Banco.getCliente(cpf);
        if(cliente == null) {
            limpaTela();
            quebraLinha();
            System.out.println("Cliente nao tem cadastro no banco");
            System.out.println("Faca o cadastro do cliente para poder criar a conta");
            quebraLinha();
            System.out.println("");
            System.out.println("Pressione qualquer tecla para prosseguir");
            entrada.nextLine();
            return;
        }
        else {
            quebraLinha();
            System.out.println("O cliente selecionado foi: ");
            System.out.println(cliente);
            quebraLinha();
            System.out.println("Por favor digite a agencia em que a conta devera ser criada: ");
            String agencia = entrada.nextLine();
            Banco.cadastraConta(cliente,agencia,3);
            int numConta = Banco.getNumContaCliente(cpf);
            ContaInvestimento conta = (ContaInvestimento) Banco.getConta(numConta);
            if(conta == null)
            {
                quebraLinha();
                System.out.println("ERRO: Conta inexistente");
            }
            else {
                limpaTela();
                quebraLinha();
                System.out.println("Conta Investimento cadastrada corretamente");
                System.out.println(conta);
            }
            pressioneParaContinuar();
        }
    }

    public static void pedeAlterarDadosCadastrais() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Por favor, digite o numero da conta cujos dados deseja alterar: ");
        int numConta = entrada.nextInt();
        entrada.nextLine();
        Conta conta = Banco.getConta(numConta);
        if(conta == null)
        {
            quebraLinha();
            System.out.println("ERRO: Conta inexistente");
            System.out.println(" ");
            System.out.println("Por favor, digite qualquer tecla para continuar");
            entrada.nextLine();
            return;
        }
        else {
            quebraLinha();
            System.out.println("A Conta de origem selecionada foi: ");
            System.out.println(conta);
            quebraLinha();
        }
        System.out.println("Digite os novos dados para a conta: ");
        System.out.println("Digite o nome do titular da conta: ");
        String nome = entrada.nextLine();
        System.out.println("Digite a renda mensal do titular da conta: ");
        double rendaMensal = entrada.nextDouble();
        entrada.nextLine();
        System.out.println("Digite a agencia da conta: ");
        String agencia = entrada.nextLine();
        if(Banco.alteraCadastro(conta,nome,rendaMensal,agencia)) {
            quebraLinha();
            System.out.println("Alteracoes implementadas com sucesso");
            System.out.println("Os dados da conta foram alterados");
            System.out.printf(conta);
        } else {
            System.out.println("ERRO: dados nao alterados. Por favor verifique novamente os dados que deseja alterar");
        }
        pressioneParaContinuar();
    }
}
