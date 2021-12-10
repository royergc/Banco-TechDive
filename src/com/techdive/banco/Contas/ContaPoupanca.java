package com.techdive.banco.Contas;

import com.techdive.banco.Contas.Conta;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(String nome, String cpf, double rendaMensal, String agencia) {
        super(nome, cpf, rendaMensal, agencia);
    }

    public double simularRendimento(int periodoMeses, double rentabilidade) {
        return 0;
    }
}