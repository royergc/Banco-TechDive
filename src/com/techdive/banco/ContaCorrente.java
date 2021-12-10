package com.techdive.banco;

import java.util.ArrayList;

public class ContaCorrente extends Conta {

    private double usoLimiteChequeEspecial;
    private double limiteChequeEspecial;
    private static final double fatorLimite = 0.30;

    private ArrayList<String> extrato;

    public ContaCorrente(String nome, String cpf, double rendaMensal, String agencia) {
        super(nome, cpf, rendaMensal, agencia);
        this.limiteChequeEspecial = super.getRendaMensal() * fatorLimite;
        this.usoLimiteChequeEspecial = 0;
        extrato = new ArrayList<>();
    }

    @Override
    public boolean deposito(double valorDepositar) {
        if(valorDepositar < 0 ) return false;
        if(valorDepositar > usoLimiteChequeEspecial) {
            super.deposito(valorDepositar - usoLimiteChequeEspecial);
            usoLimiteChequeEspecial = 0;
        } else {
            usoLimiteChequeEspecial -= valorDepositar;
        }
        return true;
    }

    @Override
    public boolean saque(double valorSacar) {
        if(!podeSacar(valorSacar)) return false;

        if(usoLimiteChequeEspecial > 0 ) {
            usoLimiteChequeEspecial += valorSacar;
            return true;
        }
        else {
                calculaUsoChequeEspecial(valorSacar);
                valorSacar -= usoLimiteChequeEspecial;
                return super.saque(valorSacar);
        }
    }

    @Override
    public double getSaldo() {
         return super.getSaldo() - usoLimiteChequeEspecial;
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

    public double getUsoLimiteChequeEspecial() {
        return this.usoLimiteChequeEspecial;
    }

    private boolean podeSacar(double valorSacar) {
        if(valorSacar - getSaldo() > limiteChequeEspecial) {
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
