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
        for (int i = 0; i < historico.size(); i++) {
            if (!(historico.get(i).contains(cliente.getCpf()))) {
                historico.remove(i);
            }
        }
        return historico;
    }

    public ArrayList<String> getHistoricoOperacao(String operacao) {
        transacoes = Transacoes.iniciaTransacoes();
        ArrayList<String> historico = transacoes.getHistoricoTransacoes();
        for(int i = 0; i < historico.size(); i++) {
            if(!(historico.get(i).contains(operacao))) {
                historico.remove(i);
            }
        }
        return historico;
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

    public ArrayList<Conta> getContasInvestimento() {
        ArrayList<Conta> contas = getTodasContasDoBanco();
        for(Conta conta : contas) {
            if(!(conta instanceof ContaInvestimento)){
                contas.remove(conta);
            }
        }
        return contas;
    }

    public ArrayList<Conta> getContasPoupanca() {
        ArrayList<Conta> contas = getTodasContasDoBanco();
        for(Conta conta : contas) {
            if(!(conta instanceof ContaPoupanca)){
                contas.remove(conta);
            }
        }
        return contas;
    }

    public ArrayList<ContaCorrente> getContasSaldoInferior(double valor) {
        ArrayList<ContaCorrente> contasCorrentes = getContasCorrente();
        ArrayList<ContaCorrente> contasInferiores = new ArrayList<>();
        for(ContaCorrente conta : contasCorrentes) {
            if(conta.getSaldo() <= valor){
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

    public double getValorInvestidoTotal() {
        double valorInvestido = 0;
        ArrayList<Conta> contas = getTodasContasDoBanco();
        for (Conta conta : contas) {
            valorInvestido += conta.getSaldo();
        }
        return valorInvestido;
    }

}
