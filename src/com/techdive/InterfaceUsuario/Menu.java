package com.techdive.InterfaceUsuario;

import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private int opcaoEscolhida;

    public Menu() {
        scanner = new Scanner(System.in);
        mostraMenuInicial();
    }

    public void mostraMenuInicial() {
        quebraLinha();
        System.out.println("Bem vindo ao Banco TechDive");
        quebraLinha();
        System.out.println("Escolha a opção desejada: ");
        System.out.println("1 - Cadastro");
        System.out.println("2 - Operacoes");
        System.out.println("3 - Relatorios");
        System.out.printf("%n%n");
        opcaoEscolhida = Integer.parseInt(scanner.nextLine());
        limpaTela();

        switch(opcaoEscolhida) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:

                break;

        }
    }

    public static void limpaTela() {
        System.out.printf("%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n");
    }

    public static void quebraLinha() {
        System.out.printf("%n-------------------------------------------------------------%n%n");
    }




}
