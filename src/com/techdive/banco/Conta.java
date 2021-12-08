package com.techdive.banco;

// falta implementar extrato, transferir

public class Conta {
    private static int numConta;        // valor estatico = contagem dos objetos conta criados e id da conta

    private String nome;
    private String cpf;
    private String rendaMensal;

    private String agencia;
    private double saldo;

//    private ArrayList<String> extrato;

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
        if( valorSacar < saldo) {
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
}
