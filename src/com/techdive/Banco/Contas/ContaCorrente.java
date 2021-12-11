package com.techdive.Banco.Contas;

public class ContaCorrente extends Conta {

    private double limiteChequeEspecial;
    private double usoLimiteChequeEspecial;
    private static final double fatorLimite = 0.50;

    public ContaCorrente(String nome, String cpf, double rendaMensal, String agencia) {
        super(nome, cpf, rendaMensal, agencia);
        this.limiteChequeEspecial = super.getRendaMensal() * fatorLimite;
        this.usoLimiteChequeEspecial = 0;
    }

    @Override
    public double getSaldo() {
         return super.getSaldo() - usoLimiteChequeEspecial;
    }

    @Override
    public boolean alteraCadastro(String nome, double rendaMensal, String agencia) {
        if(rendaMensal < 0) {
            return false;
        }
        else {
            this.limiteChequeEspecial = rendaMensal * this.fatorLimite;
            return super.alteraCadastro(nome, rendaMensal, agencia);
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                " [LimiteChequeEspecial] = " + limiteChequeEspecial + " - " +
                "[UsoLimiteChequeEspecial] = " + usoLimiteChequeEspecial;
    }

    public double getUsoLimiteChequeEspecial() {
        return this.usoLimiteChequeEspecial;
    }

    public double getLimiteChequeEspecial() {
        return this.limiteChequeEspecial;
    }

   @Override
    protected boolean debitaConta(double valorDebitar) {
        if(!podeDebitar(valorDebitar)) return false;

        if(usoLimiteChequeEspecial > 0 ) {
            usoLimiteChequeEspecial += valorDebitar;
            return true;
        }
        else {
            calculaUsoChequeEspecial(valorDebitar);
            valorDebitar -= usoLimiteChequeEspecial;
            return super.debitaConta(valorDebitar);
        }
    }

    @Override
    protected boolean creditaConta(double valorCreditar) {
        if (valorCreditar < 0) return false;
        if (valorCreditar > usoLimiteChequeEspecial) {
            super.creditaConta(valorCreditar - usoLimiteChequeEspecial);
            usoLimiteChequeEspecial = 0;
        } else {
            usoLimiteChequeEspecial -= valorCreditar;
        }
        return true;
    }

    private boolean podeDebitar(double valorDebitar) {
        if(valorDebitar - getSaldo() > limiteChequeEspecial) {
            return false;
        }
        return true;
    }

    private void calculaUsoChequeEspecial(double valorSacar) {
        if(valorSacar > getSaldo()) {
            usoLimiteChequeEspecial = valorSacar - getSaldo();
        }
    }
}
