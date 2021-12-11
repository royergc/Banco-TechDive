package com.techdive.Banco.Operacional;

public class ContaPoupanca extends Conta {

    protected ContaPoupanca(String nome, String cpf, double rendaMensal, String agencia) {
        super(nome, cpf, rendaMensal, agencia);
    }

    public double simularRendimento(int periodoMeses, double rentabilidade) {
        return 0;
    }
}
