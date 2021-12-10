package com.techdive.banco;

// falta implementar extrato, transferir

import java.util.ArrayList;

public class Conta {
    private static int numConta = 0;        // valor estatico = contagem dos objetos conta criados e id da conta

    private String nome;
    private String cpf;
    private double rendaMensal;

    private String agencia;
    private double saldo;

    public Conta(String nome, String cpf, double rendaMensal, String agencia) {
        numConta++;
        this.nome = nome;
        this.cpf = cpf;
        this.rendaMensal = rendaMensal;
        this.agencia = agencia;
        this.saldo = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean deposito(double valorDepositar) {
        if(valorDepositar > 0) {
            saldo += valorDepositar;
            return true;
        }
        return false;
    }

    public boolean saque(double valorSacar) {
        if( valorSacar <= saldo) {
            saldo -= valorSacar;
            return true;
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

    protected double getRendaMensal() {
        return this.rendaMensal;
    }

    protected String getNome(){
        return this.nome;
    }

    protected String getCpf(){
        return this.cpf;
    }

    protected String getAgencia() {
        return this.agencia;
    }
}
