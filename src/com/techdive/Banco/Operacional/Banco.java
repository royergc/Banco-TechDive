package com.techdive.Banco.Operacional;

import com.techdive.Banco.Cliente;

import java.util.ArrayList;
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
        if(cliente != null && ( agencia.equals("Florianopolis") || agencia.equals("Sao Jose"))) {
            switch(tipoConta) {
                case 2:
                    ContaPoupanca contaPoupanca = new ContaPoupanca(cliente.getNome(), cliente.getCpf(), cliente.getRendaMensal(),agencia);
                    registraConta(contaPoupanca);
                    break;
                case 3:
                    ContaInvestimento contaInvestimento = new ContaInvestimento(cliente.getNome(), cliente.getCpf(), cliente.getRendaMensal(),agencia);
                    registraConta(contaInvestimento);
                    break;
                case 1:
                default:
                    ContaCorrente contaCorrente = new ContaCorrente(cliente.getNome(), cliente.getCpf(), cliente.getRendaMensal(),agencia);
                    registraConta(contaCorrente);
                    break;
            }
            return true;
        }
        return false;
    }

    public static boolean alteraCadastro(Conta conta,String nome, double rendaMensal, String agencia){
        if(conta != null && ( agencia.equals("Florianopolis") || agencia.equals("Sao Jose"))) {
        conta.alteraCadastro(nome,rendaMensal,agencia);
        return true;
        }
        return false;
    }

    public static int getNumContaCliente(String cpf) {
        return mapaClienteConta.get(cpf);
    }

    public static Conta getConta(int numeroConta){
        return contas.get(numeroConta);
    }

    public static ArrayList<Conta> getListaContas() {
        ArrayList<Conta> contasDoBanco = new ArrayList<>();
        for(int idConta : contas.keySet()) {
            contasDoBanco.add(contas.get(idConta));
        }
        return contasDoBanco;
    }

    public static ArrayList<Cliente> getListaClientes() {
        ArrayList<Cliente> clientesDoBanco = new ArrayList<>();
        for(String cpf : clientes.keySet()) {
            clientesDoBanco.add(clientes.get(cpf));
        }
        return clientesDoBanco;
    }

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

    private static void registraConta(Conta conta){
        contas.put(conta.getIdConta(), conta);
        mapaClienteConta.put(conta.getCpf(),conta.getIdConta());
    }
}