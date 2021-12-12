package com.techdive.InterfaceUsuario;

import com.techdive.Banco.Cliente;
import com.techdive.Banco.Operacional.Banco;
import com.techdive.Banco.Operacional.Conta;
import com.techdive.Banco.Operacional.ContaCorrente;
import com.techdive.Banco.Operacional.Transacoes;
import com.techdive.Banco.Relatorios;

import java.util.ArrayList;
import java.util.List;
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



}
