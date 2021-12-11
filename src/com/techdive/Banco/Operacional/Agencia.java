package com.techdive.Banco.Operacional;

public class Agencia {
    private int numAgencia;
    private String nomeAgencia;

    public Agencia(int numAgencia, String nomeAgencia) {
        this.numAgencia = numAgencia;
        this.nomeAgencia = nomeAgencia;
    }

    public int getNumAgencia() {
        return numAgencia;
    }

    public String getNomeAgencia() {
        return nomeAgencia;
    }
}
