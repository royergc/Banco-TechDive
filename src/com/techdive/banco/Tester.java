package com.techdive.banco;

public class Tester {
    public static void main(String[] args) {

        Cliente clienteTeste = new Cliente("Guilherme Teste", "0323252352",1500);

        Conta contaTeste = new Conta(clienteTeste.getNome(), clienteTeste.getCpf(), clienteTeste.getRendaMensal(),"Florianopolis");

    }
}
