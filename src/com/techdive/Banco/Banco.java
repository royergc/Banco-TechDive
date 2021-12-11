package com.techdive.Banco;

import com.techdive.Banco.Clientes.Cliente;
import com.techdive.Banco.Contas.Conta;
import com.techdive.Banco.Contas.ContaCorrente;

import java.util.HashMap;
import java.util.Map;

public class Banco {
    private static Map<Integer, Conta> contas = new HashMap<>();
    private static Map<Integer, Agencia> agencias = new HashMap<>();
    private static Map<String,Cliente> clientes = new HashMap<>();
    private static Map<String,Integer> mapaClienteConta = new HashMap<>();

    private Banco() {}

    public static boolean cadastraCliente(Cliente cliente) {
        if(cliente != null) {
            clientes.put(cliente.getCpf(), cliente);
            return true;
        }
        return false;
    }

    public static Cliente getCliente(String cpf) {
        return clientes.get(cpf);
    }

    public static boolean cadastraConta(Cliente cliente, String agencia, int tipoConta) {
        if(cliente != null) {
            switch(tipoConta) {
                case 1:
                default:
                    ContaCorrente conta = new ContaCorrente(cliente.getNome(), cliente.getCpf(), cliente.getRendaMensal(),agencia);
                    contas.put(conta.getIdConta(), conta);
                    mapaClienteConta.put(conta.getCpf(),conta.getIdConta());
                    System.out.println("Adicionada conta " + conta + " no Banco");
                    break;
                case 2:
//                    ContaPoupanca conta
                    break;
                case 3:
//                    ContaInvestimento conta
                    break;
            }
            return true;
        }
        return false;
    }

    public static int getContaCliente(String cpf) {
        return mapaClienteConta.get(cpf);
    }

    public static Conta getConta(int numeroConta){
        return contas.get(numeroConta);
    }


/*
    public static boolean cadastraConta(Conta conta) {
        if(conta != null) {
            contas.put(conta.getIdConta(), conta);
            return true;
        }
        return false;
    }
*/

    public static Agencia getAgencia(int numeroAgencia) {
        return agencias.get(numeroAgencia);
    }

    public static boolean cadastraAgencia(Agencia agencia) {
        if(agencia != null) {
            agencias.put(agencia.getNumAgencia(), agencia);
            return true;
        }
        return false;
    }

}