package com.techdive.InterfaceUsuario;

import com.techdive.Banco.Cliente;
import com.techdive.Banco.Operacional.Banco;
import com.techdive.Banco.Operacional.ContaCorrente;

import java.util.Scanner;

import static com.techdive.InterfaceUsuario.InterfaceUsuario.*;

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
        System.out.println("5 - Cadastrar nova agencia bancaria");
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
}
