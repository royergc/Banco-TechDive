package com.techdive.InterfaceLinhaComando;

import java.util.Scanner;

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

    public static void pressioneParaContinuar() {
        Scanner entrada = new Scanner(System.in);
        quebraLinha();
        System.out.println(" ");
        System.out.println("Por favor, pressione qualquer tecla para continuar");
        entrada.nextLine();
    }

    public static int perguntaNumConta() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Por favor, digite o numero da conta: ");
        return entrada.nextInt();
    }
}


