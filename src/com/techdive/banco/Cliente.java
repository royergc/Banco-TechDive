package com.techdive.banco;

public class Cliente {
    private String nome;
    private String cpf;
    private double rendaMensal;

    Cliente(String nome, String cpf, double rendaMensal) {
       if(validaCPF(cpf)) {
           this.nome = nome;
           this.cpf = cpf;
           this.rendaMensal = rendaMensal;
           System.out.println("Cliente criado");
       }
       else {
           this.nome = "Cliente com CPF invalido";
           this.cpf = "CPF invalido";
           this.rendaMensal = 0;
           System.out.println("Cliente invalido");
       }
    }


    private boolean validaCPF(String cpf) {
        return true;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public double getRendaMensal() {
        return rendaMensal;
    }
}
