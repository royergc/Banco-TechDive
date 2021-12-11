package com.techdive.Banco.Relatorios;

import com.techdive.Banco.Contas.Conta;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Transacoes {

    private List<String> transacoes;
    private static Transacoes objetoTransacoes;
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
            return objetoTransacoes;
        }
        return null;
    }

    public boolean registraSaque(Conta conta, double valor) {
        if(conta.saque(valor)) {

            transacoes.add(LocalDate.now().format(formatadorData) + " "
                    + LocalTime.now().format(formatadorHora)
                    + " [Saque realizado] - R$ " + valor
                    + " [Conta] - " + conta.getIdConta()
                    + " [Cliente] - " + conta.getNome() );
            return true;
        }
        return false;
    }

    public boolean registraDeposito(Conta conta, double valor) {
        if(conta.deposito(valor)) {
            transacoes.add(LocalDate.now().format(formatadorData) + " "
                    + LocalTime.now().format(formatadorHora)
                    + " [Deposito realizado] - R$ " + valor
                    + " [Conta] - " + conta.getIdConta()
                    + " [Cliente] - " + conta.getNome() );
            return true;
        }
        return false;
    }

    public boolean registraTransferencia(Conta contaOrigem, Conta contaDestino, double valor) {
        if(contaOrigem.transfere(contaDestino, valor)) {
            transacoes.add(LocalDate.now().format(formatadorData) + " "
                    + LocalTime.now().format(formatadorHora)
                    + " [Transferência realizada] - R$ " + valor
                    + " [Conta Origem] - " + contaOrigem.getIdConta()
                    + " [Cliente] - " + contaOrigem.getNome()
                    + " -> [Conta Destino] - " + contaDestino.getIdConta()
                    + "[Cliente] -  " + contaDestino.getNome() );
            return true;
        }
        return false;
    }
    /*
    registrarInvestimento
    */
}
