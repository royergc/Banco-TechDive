package com.techdive.InterfaceUsuario;

import java.util.Scanner;

import static com.techdive.InterfaceUsuario.InterfaceUsuario.*;
import static com.techdive.InterfaceUsuario.MenuCadastros.chamaMenuCadastros;
import static com.techdive.InterfaceUsuario.MenuOperacoes.chamaMenuOperacoes;
import static com.techdive.InterfaceUsuario.MenuRelatorios.chamaMenuRelatorios;


public class MenuPrincipal {

    public static void menuPrincipal(){
        limpaTela();
        quebraLinha();
        System.out.println("Bem vindo ao Banco TechDive");
        quebraLinha();
        System.out.println("Escolha a opção desejada: ");
        System.out.println("1 - Cadastros");
        System.out.println("2 - Operacoes bancarias");
        System.out.println("3 - Relatorios");
        System.out.println("0 - Sair do sistema");
        System.out.println("");
        System.out.println("Opcao: ");
    }


    public static void chamaMenuPrincipal() {
        int opcao;
        Scanner entrada = new Scanner(System.in);

        do{
            menuPrincipal();
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch(opcao){
                case 1:
                    chamaMenuCadastros();
                    break;

                case 2:
                    chamaMenuOperacoes();
                    break;

                case 3:
                    chamaMenuRelatorios();
                    break;
                case 0 :
                    sairSistema();1

                    break;
                default:
                    limpaTela();
                    System.out.println("Opção inválida! Tente novamente");
            }
        } while(opcao != 0);
    }

}
