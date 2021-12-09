package com.techdive.banco;

public class ContaCorrente extends Conta {

    private double usoChequeEspecial;
    private double limiteChequeEspecial;
    private final double fatorLimite = 0.30;

    public ContaCorrente(String nome, String cpf, double rendaMensal, String agencia) {
        super(nome, cpf, rendaMensal, agencia);
        this.limiteChequeEspecial = super.getRendaMensal() * fatorLimite;
        this.usoChequeEspecial = 0;
    }

    @Override
    public void deposito(double valorDepositar) {
        if(valorDepositar > usoChequeEspecial) {
            super.deposito(valorDepositar - usoChequeEspecial);
            usoChequeEspecial = 0;
        } else {
            usoChequeEspecial -= valorDepositar;
        }
    }

    @Override
    public boolean saque(double valorSacar) {
        if(valorSacar - getSaldo() > limiteChequeEspecial) {
            return false;
        }

        if(usoChequeEspecial > 0 ) {
            usoChequeEspecial += valorSacar;
        }
        else {
            double precisaChequeEspecial = valorSacar - getSaldo();
            if(precisaChequeEspecial > 0) {
                usoChequeEspecial += precisaChequeEspecial;
                valorSacar -= usoChequeEspecial;
                super.saque(valorSacar);
            } else {
                super.saque(valorSacar);
            }
        }
        return true;
    }

    @Override
    public double getSaldo() {
         return super.getSaldo() - usoChequeEspecial;
    }

    public double getLimiteChequeEspecial() {
        return this.limiteChequeEspecial;
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

    public double getUsoChequeEspecial() {
        return this.usoChequeEspecial;
    }
}
