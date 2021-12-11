package com.techdive.Banco.Operacional;

public class ContaInvestimento extends Conta {

    protected ContaInvestimento(String nome, String cpf, double rendaMensal, String agencia) {
        super(nome, cpf, rendaMensal, agencia);
    }

    public double escolheInvestimento(int escolha) {
        return 0;
    }

    public double simularRendimento(int periodoMeses, double rentabilidade) {
        return 0;
    }
}
