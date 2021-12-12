package com.techdive.Banco.Operacional;

public class ContaInvestimento extends Conta {

    protected ContaInvestimento(String nome, String cpf, double rendaMensal, String agencia) {
        super(nome, cpf, rendaMensal, agencia);
    }

    protected double escolheInvestimento(int escolha) {
        double rendimentoEscolhido;
        switch(escolha) {
            case 1:
                rendimentoEscolhido = 10;
                break;
            case 2:
                rendimentoEscolhido = 20;
                break;
            case 3:
                rendimentoEscolhido = 7.5;
                break;
            case 4:
                rendimentoEscolhido = 12.6825;
                break;
            default:
                rendimentoEscolhido = 6;
        }
        return rendimentoEscolhido;
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

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "[Tipo] = Conta Investimento";
    }

}
