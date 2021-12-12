package com.techdive.Banco;

import com.techdive.Banco.Operacional.*;

import java.util.ArrayList;

public class Relatorios {

    private Transacoes transacoes;

    public ArrayList<Cliente> getClientesDoBanco() {
        return Banco.getListaClientes();
    }

    public ArrayList<String> getHistoricoCliente(Cliente cliente) {
        transacoes = Transacoes.iniciaTransacoes();
        ArrayList<String> historico = transacoes.getHistoricoTransacoes();
        ArrayList<String> historicoCliente = new ArrayList<>();
        for (String transacao : historico) {
            if (transacao.contains(cliente.getCpf())) {
                historicoCliente.add(transacao);
            }
        }
        return historicoCliente;
    }

    public ArrayList<String> getHistoricoOperacao(String operacao) {
        transacoes = Transacoes.iniciaTransacoes();
        ArrayList<String> historico = transacoes.getHistoricoTransacoes();
        ArrayList<String> historicoOperacoes = new ArrayList<>();
        for (String transacao : historico) {
            if (transacao.contains(operacao)) {
                historicoOperacoes.add(transacao);
            }
        }
        return historicoOperacoes;
    }

    public ArrayList<Conta> getTodasContasDoBanco() {
        return Banco.getListaContas();
    }

    public ArrayList<ContaCorrente> getContasCorrente() {
        ArrayList<ContaCorrente> contas = new ArrayList<>();
        for(Conta conta : getTodasContasDoBanco()) {
            if(conta instanceof ContaCorrente){
                contas.add((ContaCorrente) conta);
            }
        }
        return contas;
    }

    public ArrayList<ContaInvestimento> getContasInvestimento() {
        ArrayList<ContaInvestimento> contas = new ArrayList<>();
        for(Conta conta : getTodasContasDoBanco()) {
            if(conta instanceof ContaInvestimento){
                contas.add((ContaInvestimento) conta);
            }
        }
        return contas;
    }

    public ArrayList<ContaPoupanca> getContasPoupanca() {
        ArrayList<ContaPoupanca> contas = new ArrayList<>();
        for(Conta conta : getTodasContasDoBanco() ) {
            if(conta instanceof ContaPoupanca) {
                contas.add((ContaPoupanca) conta);
            }
        }
        return contas;
    }

    public ArrayList<ContaCorrente> getContasSaldoInferior(double valor) {
        ArrayList<ContaCorrente> contasCorrentes = getContasCorrente();
        ArrayList<ContaCorrente> contasInferiores = new ArrayList<>();
        for(ContaCorrente conta : contasCorrentes) {
            if(conta.getSaldo() < valor){
                contasInferiores.add(conta);
            }
        }
        return contasInferiores;
    }

    public ArrayList<Conta> getContasSaldoSuperior(int valor) {
        ArrayList<Conta> contas = getTodasContasDoBanco();
        for(Conta conta : contas) {
            if(conta.getSaldo() <= valor) {
                contas.remove(conta);
            }
        }
        return contas;
    }

    public double getTotalSaldos() {
        double valorSaldos = 0;
        ArrayList<Conta> contas = getTodasContasDoBanco();
        for (Conta conta : contas) {
            valorSaldos += conta.getSaldo();
        }
        return valorSaldos;
    }

    public double getValorInvestimentos() {
        double valorInvestimentos = 0;
        ArrayList<ContaInvestimento> contas = getContasInvestimento();
        for(ContaInvestimento conta : contas) {
            valorInvestimentos += conta.getSaldo();
        }
        return valorInvestimentos;
    }

    public double getValorPoupancas() {
        double valorPoupancas = 0;
        ArrayList<ContaPoupanca> contas = getContasPoupanca();
        for(ContaPoupanca conta : contas) {
            valorPoupancas += conta.getSaldo();
        }
        return valorPoupancas;
    }
}
