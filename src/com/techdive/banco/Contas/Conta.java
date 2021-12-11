package com.techdive.banco.Contas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public abstract class Conta {
    private static int numConta = 0;        // valor estatico = contagem dos objetos conta criados e id da conta

    private String nome;
    private String cpf;
    private double rendaMensal;

    private String agencia;
    private double saldo;

    protected List<String> extrato;

    public Conta(String nome, String cpf, double rendaMensal, String agencia) {
        numConta++;
        this.nome = nome;
        this.cpf = cpf;
        this.rendaMensal = rendaMensal;
        this.agencia = agencia;
        this.saldo = 0;
        this.extrato = new ArrayList<>();
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean deposito(double valorDepositar) {
        if(creditaConta(valorDepositar)) {
            extrato.add(LocalDate.now() + " - " +  LocalTime.now()+ " [Deposito]: R$ " + valorDepositar);
            return true;
        }
        return false;
    }

    public boolean saque(double valorSacar) {
        if(debitaConta(valorSacar)) {
            extrato.add(LocalDate.now() + " - " + LocalTime.now() + " [Saque]: R$ " + valorSacar);
            return true;
        }
        return false;
    }

    public boolean transfere(Conta contaDestino, double valorTransferir) {
        if(debitaConta(valorTransferir)) {
            if(contaDestino.creditaConta(valorTransferir)) {
                extrato.add(LocalDate.now() + " - " + LocalTime.now() + "[Transferencia realizada]: R$ " + valorTransferir + " para " + contaDestino.getNome());
                contaDestino.extrato.add(LocalDate.now() + " - " + LocalTime.now() + "[Transferencia recebida]: R$ " + valorTransferir + " de " + getNome());
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean alteraCadastro(String nome, double rendaMensal, String agencia) {
        if(!agencia.equals("Florianopolis") || !agencia.equals("Sao Jose")) {
            return false;
        }

        if(rendaMensal < 0 ) {
            return false;
        }

        this.nome = nome;
        this.rendaMensal = rendaMensal;
        this.agencia = agencia;
        return true;
    }

    public double getRendaMensal() {
        return this.rendaMensal;
    }

    public int getNumConta() {
        return this.numConta;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getAgencia() {
        return this.agencia;
    }

    public List<String> getExtrato(int periodo) {
        extrato.add("Saldo atual: R$ " + getSaldo());
        return extrato;
    }

    protected boolean creditaConta(double valorCreditar) {
        if(valorCreditar > 0) {
            saldo += valorCreditar;
            return true;
        }
        return false;
    }

    protected boolean debitaConta(double valorDebitar) {
        if (valorDebitar <= saldo) {
            saldo -= valorDebitar;
            return true;
        }
        return false;
    }
}
