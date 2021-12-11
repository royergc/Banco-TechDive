package com.techdive.Banco.Operacional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Transacoes {

    private static Transacoes objetoTransacoes;

    private ArrayList<String> transacoes;

    private DateTimeFormatter formatadorData;
    private DateTimeFormatter formatadorHora;

    private Transacoes() {
        transacoes = new ArrayList<>();
        formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        formatadorHora = DateTimeFormatter.ofPattern("HH:mm:ss");
    }

    static public Transacoes iniciaTransacoes(){
        if(objetoTransacoes == null) {
            objetoTransacoes = new Transacoes();
        }
        return objetoTransacoes;
    }

    public boolean processaSaque(Conta conta, double valor) {
        if(conta.saque(valor)) {

            transacoes.add(LocalDate.now().format(formatadorData) + " "
                    + LocalTime.now().format(formatadorHora)
                    + " [Saque realizado] - R$ " + valor
                    + " [Conta] - " + conta.getIdConta()
                    + " [Cliente] - " + conta.getNome()
                    + " [CPF] - " + conta.getCpf() );
            return true;
        }
        return false;
    }

    public boolean processaDeposito(Conta conta, double valor) {
        if(conta.deposito(valor)) {
            transacoes.add(LocalDate.now().format(formatadorData) + " "
                    + LocalTime.now().format(formatadorHora)
                    + " [Deposito realizado] - R$ " + valor
                    + " [Conta] - " + conta.getIdConta()
                    + " [Cliente] - " + conta.getNome()
                    + " [CPF] - " + conta.getCpf() );
            return true;
        }
        return false;
    }

    public boolean processaTransferencia(Conta contaOrigem, Conta contaDestino, double valor) {
        if(contaOrigem.transfere(contaDestino, valor)) {
            transacoes.add(LocalDate.now().format(formatadorData) + " "
                    + LocalTime.now().format(formatadorHora)
                    + " [Transferência realizada] - R$ " + valor
                    + " [Conta Origem] - " + contaOrigem.getIdConta()
                    + " [Cliente] - " + contaOrigem.getNome()
                    + " [CPF] - " + contaOrigem.getCpf()
                    + " -> [Conta Destino] - " + contaDestino.getIdConta()
                    + "[Cliente] -  " + contaDestino.getNome()
                    + " [CPF] - " + contaDestino.getCpf() );
            return true;
        }
        return false;
    }

    public ArrayList<String> getHistoricoTransacoes() {
        return transacoes;
    }


    /*
    registrarInvestimento
    */
}
