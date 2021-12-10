package com.techdive.banco;

public class Tester {
    public static void main(String[] args) {

        System.out.println("Tentando criar cliente");
        Cliente clienteTeste = new Cliente("Guilherme Teste", "0323252352", 1500);
        if(clienteTeste.getCpf().equals("CPF invalido")) {
            System.out.println("Cliente não foi aceito - CPF inválido - tente novamente");
        }
        else {
            System.out.println("Cliente criado corretamente");
            Conta contaTeste = new Conta(clienteTeste.getNome(), clienteTeste.getCpf(), clienteTeste.getRendaMensal(), "Florianopolis");
            System.out.println("Conta criada!");
            System.out.println("Nome: " + contaTeste.getNome()
                    + "CPF: " + contaTeste.getCpf()
                    + "Renda mensal: " + contaTeste.getRendaMensal()
                    + "Agencia: " + contaTeste.getAgencia()
                    + "Saldo: " + contaTeste.getSaldo());

            contaTeste.deposito(1000);
            System.out.println("Saldo: " + contaTeste.getSaldo());

            System.out.println("Tentando saque ivalido: 1500");
            if(contaTeste.saque(1500)) {
                System.out.println("Saldo após saque: " + contaTeste.getSaldo());
            }
            else
            {
                System.out.println("Saque inválido - valor excede o limite");
                System.out.println("Saldo: " + contaTeste.getSaldo());
            }

            System.out.println("Criando conta corrente e testando limite");
            ContaCorrente contaTeste2 = new ContaCorrente("Guilherme Teste", "123456789-99",18500,"Sao Jose");
            System.out.println("Conta criada!");
            System.out.println("Nome: " + contaTeste2.getNome()
                    + "CPF: " + contaTeste2.getCpf()
                    + "Renda mensal: " + contaTeste2.getRendaMensal()
                    + "Agencia: " + contaTeste2.getAgencia()
                    + "Saldo: " + contaTeste2.getSaldo()
                    + "Limite: " + contaTeste2.getLimiteChequeEspecial()
                    + "Saldo Chegue Especial: " + contaTeste2.getUsoLimiteChequeEspecial());

            System.out.println("Fazendo depósito");
            contaTeste2.deposito(25000);
            System.out.println("Deposito feito, saldo: " + contaTeste2.getSaldo());

            System.out.println("Testando saque sem uso do limite - fazendo saque de 20000");
            if(contaTeste2.saque(20000)) {
                System.out.println("Saque realizado, novo saldo: " + contaTeste2.getSaldo());
            }
            else {
                System.out.println("Saque não realizado, saldo: " + contaTeste2.getSaldo());
            }
            System.out.println("Saldo cheque especial: " + contaTeste2.getUsoLimiteChequeEspecial());

            System.out.println("Testando saque sem uso do limite - fazendo saque de 4000");
            if(contaTeste2.saque(4000)) {
                System.out.println("Saque realizado, novo saldo: " + contaTeste2.getSaldo());
            }
            else {
                System.out.println("Saque não realizado, saldo: " + contaTeste2.getSaldo());
            }
            System.out.println("Saldo cheque especial: " + contaTeste2.getUsoLimiteChequeEspecial());


            System.out.println("Testando uso do limite - fazendo saque de 6000");
            if(contaTeste2.saque(6000)) {
                System.out.println("Saque realizado, novo saldo: " + contaTeste2.getSaldo());
            }
            else {
                System.out.println("Saque não realizado, saldo: " + contaTeste2.getSaldo());
            }
            System.out.println("Saldo cheque especial: " + contaTeste2.getUsoLimiteChequeEspecial());

            System.out.println("Novo saque, usando todo limite");
            if(contaTeste2.saque(550)) {
                System.out.println("Saque realizado, novo saldo: " + contaTeste2.getSaldo());
            }
            else {
                System.out.println("Saque nao realizado, saldo: " + contaTeste2.getSaldo());
            }
            System.out.println("Saldo cheque especial: " + contaTeste2.getUsoLimiteChequeEspecial());
            System.out.println("Limite cheque especial: " + contaTeste2.getLimiteChequeEspecial());

            contaTeste2.deposito(3550);
            System.out.println("Deposito de 3550 feito");
            System.out.println("Novo saldo: " + contaTeste2.getSaldo());
            System.out.println("Saldo cheque especial: " + contaTeste2.getUsoLimiteChequeEspecial());
            System.out.println("Limite cheque especial: " + contaTeste2.getLimiteChequeEspecial());


            contaTeste2.saque(1500);
            System.out.println("Saque de 1500 feito, saldo: " + contaTeste2.getSaldo());
            System.out.println("Saldo cheque especial: " + contaTeste2.getUsoLimiteChequeEspecial());
            System.out.println("Limite cheque especial: " + contaTeste2.getLimiteChequeEspecial());

            System.out.println("Deposito de 33500 feito");
            contaTeste2.deposito(33500);
            System.out.println("Novo saldo: " + contaTeste2.getSaldo());
            System.out.println("Saldo cheque especial: " + contaTeste2.getUsoLimiteChequeEspecial());
            System.out.println("Limite cheque especial: " + contaTeste2.getLimiteChequeEspecial());

            System.out.println("Novo saque,  estourando limite - tentando sacar 50000");
            if(contaTeste2.saque(50000)) {
                System.out.println("Saque realizado, novo saldo: " + contaTeste2.getSaldo());
            }
            else {
                System.out.println("Saque nao realizado, saldo: " + contaTeste2.getSaldo());
            }
            System.out.println("Saldo cheque especial: " + contaTeste2.getUsoLimiteChequeEspecial());
            System.out.println("Limite cheque especial: " + contaTeste2.getLimiteChequeEspecial());

            System.out.println("Novo saque,  zerando a conta - tentando sacar 30000");
            if(contaTeste2.saque(30000)) {
                System.out.println("Saque realizado, novo saldo: " + contaTeste2.getSaldo());
            }
            else {
                System.out.println("Saque nao realizado, saldo: " + contaTeste2.getSaldo());
            }
            System.out.println("Saldo cheque especial: " + contaTeste2.getUsoLimiteChequeEspecial());
            System.out.println("Limite cheque especial: " + contaTeste2.getLimiteChequeEspecial());








        }
    }
}
