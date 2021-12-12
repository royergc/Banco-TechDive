package com.techdive.InterfaceUsuario;

public class InterfaceUsuario {

    public static void main(String[] args) {
        MenuPrincipal.chamaMenuPrincipal();
    }

    public static void limpaTela() {
        System.out.printf("%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n");
    }

    public static void quebraLinha() {
        System.out.printf("%n==========================================================================%n%n");
    }

    public static void sairSistema() {
        limpaTela();
        quebraLinha();
        System.out.println("Obrigado por usar o aplicativo do Banco Tech Dive! Até breve!");
        quebraLinha();
    }
}
