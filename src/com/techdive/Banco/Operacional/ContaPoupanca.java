package com.techdive.Banco.Operacional;

public class ContaPoupanca extends Conta {

    protected ContaPoupanca(String nome, String cpf, double rendaMensal, String agencia) {
        super(nome, cpf, rendaMensal, agencia);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "[Tipo] = Conta Poupanca";
    }

    protected double simularRendimento(int periodoMeses, double taxaAnual) {
        double taxaMensal = 0;
        taxaAnual /= 100;
        taxaAnual += 1;
        taxaMensal = Math.pow(taxaAnual, 1.0 / 12.0);
        taxaMensal -= 1;
        taxaMensal *= 100;

        return taxaMensal * periodoMeses;
    }
}
