package com.techdive.Banco.Operacional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public abstract class Conta {
    private static int numConta = 0;        // valor estatico = contagem dos objetos conta criados e id da conta

    private int idConta;
    private String nome;
    private String cpf;
    private double rendaMensal;

    private String agencia;
    private double saldo;

    private List<String> extrato;
    private DateTimeFormatter formatadorData;
    private DateTimeFormatter formatadorHora;


    protected Conta(String nome, String cpf, double rendaMensal, String agencia) {
        numConta++;
        this.idConta = numConta;
        this.nome = nome;
        this.cpf = cpf;
        this.rendaMensal = rendaMensal;
        this.agencia = agencia;
        this.saldo = 0;
        this.extrato = new ArrayList<>();
        formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        formatadorHora = DateTimeFormatter.ofPattern("HH:mm:ss");
    }

    protected boolean deposito(double valorDepositar) {
        if(creditaConta(valorDepositar)) {
            extrato.add(LocalDate.now().format(formatadorData) + " - " +  LocalTime.now().format(formatadorHora) + " -> [Deposito]: R$ " + valorDepositar);
            return true;
        }
        return false;
    }

    protected boolean saque(double valorSacar) {
        if(debitaConta(valorSacar)) {
            extrato.add(LocalDate.now().format(formatadorData) + " - " + LocalTime.now().format(formatadorHora) + " -> [Saque]: R$ " + valorSacar);
            return true;
        }
        return false;
    }

    protected boolean transfere(Conta contaDestino, double valorTransferir) {
        if(debitaConta(valorTransferir)) {
            if(contaDestino.creditaConta(valorTransferir)) {
                extrato.add(LocalDate.now().format(formatadorData) + " - " + LocalTime.now().format(formatadorHora) + " -> [Transferencia realizada]: R$ " + valorTransferir + " para " + contaDestino.getNome());
                contaDestino.extrato.add(LocalDate.now().format(formatadorData) + " - " + LocalTime.now().format(formatadorHora) + " -> [Transferencia recebida]: R$ " + valorTransferir + " de " + getNome());
                return true;
            }
            return false;
        }
        return false;
    }

    protected boolean alteraCadastro(String nome, double rendaMensal, String agencia) {
        if(rendaMensal < 0 ) {
            return false;
        }
        this.nome = nome;
        this.rendaMensal = rendaMensal;
        this.agencia = agencia;
        return true;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<String> getExtrato(int periodo) {
        extrato.add("Saldo atual: R$ " + getSaldo());
        return extrato;
    }

    public double getRendaMensal() { return this.rendaMensal; }

    public int getIdConta() {
        return this.idConta;
    }

    public String getNome() { return this.nome; }

    public String getCpf() { return this.cpf; }

    public String getAgencia() { return this.agencia; }

    @Override
    public String toString() {
        return "[Conta] = " + idConta + " - " +
                "[Nome cliente] = " + nome + " - " +
                "[CPF] = " + cpf + " - " +
                "[RendaMensal] = " + rendaMensal + " - " +
                "[Agencia] = " + agencia + " - " +
                "[Saldo] = " + saldo;
    }

    protected boolean creditaConta(double valorCreditar) {
        if(valorCreditar > 0) {
            saldo += valorCreditar;
            return true;
        }
        return false;
    }

    protected boolean debitaConta(double valorDebitar) {
        if (valorDebitar <= saldo) {
            saldo -= valorDebitar;
            return true;
        }
        return false;
    }
}
