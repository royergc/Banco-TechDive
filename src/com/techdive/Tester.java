package com.techdive;

import com.techdive.Banco.Clientes.Cliente;
import com.techdive.Banco.Contas.Banco;
import com.techdive.Banco.Contas.ContaCorrente;

import java.util.ArrayList;
import java.util.List;

public class Tester {

    public static Cliente criaCliente(String nome, String cpf, double rendaMensal) {
        System.out.println("Tentando criar cliente");
        Cliente cliente = new Cliente(nome, cpf, rendaMensal);
        if (cliente.getCpf().equals("CPF invalido")) {
            System.out.println("Cliente não foi aceito - CPF inválido - tente novamente");
            return null;
        }
        System.out.println("Cliente criado corretamente");
        System.out.println(cliente);
        return cliente;
    }

    public static ContaCorrente criaContaCorrente(Cliente cliente, String agencia) {
        System.out.println("Criando conta corrente");

        Banco.cadastraConta(cliente,agencia,1);
        System.out.println("Conta criada");
        System.out.println(Banco.getNumContaCliente(cliente.getCpf()));
        ContaCorrente conta = (ContaCorrente) Banco.getConta(Banco.getNumContaCliente(cliente.getCpf()));
        System.out.println(conta);
        return conta;
    }

    public static void main(String[] args) {

        Cliente guilherme = criaCliente("Guilherme", "03596463955", 1500);
        ContaCorrente ccGuilherme = criaContaCorrente(guilherme,"Florianopolis");

        Cliente joao = criaCliente("Joao", "06706746991", 20000);
        ContaCorrente ccJoao = criaContaCorrente(joao,"Sao Jose");

        Cliente marilene = criaCliente("Marilene", "00249313901", 12000 );
        ContaCorrente ccMarilene = criaContaCorrente(marilene,"Florianopolis");

        System.out.println("Deposita 10.000 na conta do Guilherme");
        ccGuilherme.deposito(10000);
        System.out.println("Saldo da conta do Guilherme: " + ccGuilherme.getSaldo());

        System.out.println("Deposita 50.000 na conta do Joao");
        ccJoao.deposito(50000);
        System.out.println("Saldo na conta do Joao: " + ccJoao.getSaldo());

        System.out.println("Saca 25.000 da conta do Joao");
        ccJoao.saque(25000);
        System.out.println("Saldo na conta do Joao: " + ccJoao.getSaldo());

        System.out.println("Deposita 10.000 na conta da Marilene");
        ccMarilene.deposito(10000);
        System.out.println("Saldo na conta da Marilene: " + ccMarilene.getSaldo());

        System.out.println("Transfere 5.000 do Guilherme pra Marilene");
        ccGuilherme.transfere(ccMarilene,5000);
        System.out.println("Saldo Guilherme: " + ccGuilherme.getSaldo() + " Saldo Marilene : " + ccMarilene.getSaldo());

        System.out.println("Transfere 5.150 do Guilherme pro Joao");
        ccGuilherme.transfere(ccJoao, 5150);
        System.out.println("Saldo Guilherme: " + ccGuilherme.getSaldo() + " Saldo Joao : " + ccJoao.getSaldo());

        System.out.println("Tenta sacar 700 reais da conta do Guilherme");
        ccGuilherme.saque(700);
        System.out.println("Limite Guilherme " + ccGuilherme.getLimiteChequeEspecial());
        System.out.println("Uso Limite Guilherme " + ccGuilherme.getUsoLimiteChequeEspecial());
        System.out.println("Saldo Guilherme :" + ccGuilherme.getSaldo());

        System.out.println("Deposita 10.000 na conta do Guilherme");
        ccGuilherme.deposito(10000);
        System.out.println("Saldo Guilherme " + ccGuilherme.getSaldo());
        System.out.println("Limite Guilherme " + ccGuilherme.getLimiteChequeEspecial());
        System.out.println("Uso Limite Guilherme " + ccGuilherme.getUsoLimiteChequeEspecial());

        System.out.println("Transfere 32000 do Joao pra Marilene");
        ccJoao.transfere(ccMarilene, 32000);
        System.out.println("Saldo Joao: " + ccJoao.getSaldo());
        System.out.println("Limite Joao: " + ccJoao.getLimiteChequeEspecial());
        System.out.println("Uso do limite do Joao: " + ccJoao.getUsoLimiteChequeEspecial());
        System.out.println("Saldo MArilene : " + ccMarilene.getSaldo());

        System.out.println("Imprimindo extrato Guilherme");
        List<String> extratoGui = new ArrayList<>();
        extratoGui = ccGuilherme.getExtrato(1);
        for(int i = 0; i < extratoGui.size(); i++) {
            System.out.println(extratoGui.get(i));
        }

        System.out.println("Imprimindo extrato Joao");
        List<String> extratoJoao = new ArrayList<>();
        extratoJoao = ccJoao.getExtrato(1);
        for(int i = 0; i < extratoJoao.size(); i++) {
            System.out.println(extratoJoao.get(i));
        }

        System.out.println("Imprimindo extrato Marilene");
        List<String> extratoMarilene = new ArrayList<>();
        extratoMarilene = ccMarilene.getExtrato(1);
        for(int i = 0; i < extratoMarilene.size(); i++) {
            System.out.println(extratoMarilene.get(i));
        }

        Banco.cadastraCliente(guilherme);
        Banco.cadastraCliente(joao);
        Banco.cadastraCliente(marilene);

        System.out.println(Banco.getCliente(guilherme.getCpf()));
        System.out.println(Banco.getConta(1));
        System.out.println(Banco.getConta(2));
        System.out.println(Banco.getConta(3));



        //Menu tela = new Menu();
    }
}
