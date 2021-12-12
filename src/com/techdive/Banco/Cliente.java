package com.techdive.Banco;

public class Cliente {
    private String nome;
    private String cpf;
    private double rendaMensal;

    public Cliente(String nome, String cpf, double rendaMensal) {
        if(validaCPF(cpf)) {
           this.nome = nome;
           this.cpf = cpf;
           this.rendaMensal = rendaMensal;
       }
       else {
           this.nome = "";
           this.cpf = "CPF invalido";
           this.rendaMensal = 0;
       }
    }

    // Algoritmo retirado de : https://www.devmedia.com.br/validando-o-cpf-em-uma-aplicacao-java/22097
    public static boolean validaCPF(String cpf) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (cpf.equals("00000000000") ||
                cpf.equals("11111111111") ||
                cpf.equals("22222222222") || cpf.equals("33333333333") ||
                cpf.equals("44444444444") || cpf.equals("55555555555") ||
                cpf.equals("66666666666") || cpf.equals("77777777777") ||
                cpf.equals("88888888888") || cpf.equals("99999999999") ||
                (cpf.length() != 11))
            return false;

        char dig10, dig11;
        int sm, i, r, num, peso;

        // Calculo do 1o. Digito Verificador
        sm = 0;
        peso = 10;
        for (i=0; i<9; i++) {
            // converte o i-esimo caractere do CPF em um numero:
            // por exemplo, transforma o caractere '0' no inteiro 0
            // (48 eh a posicao de '0' na tabela ASCII)
            num = (int)(cpf.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        }

        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11))
            dig10 = '0';
        else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

        // Calculo do 2o. Digito Verificador
        sm = 0;
        peso = 11;
        for(i=0; i<10; i++) {
            num = (int)(cpf.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        }

        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11))
            dig11 = '0';
        else dig11 = (char)(r + 48);

        // Verifica se os digitos calculados conferem com os digitos informados.
        if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
            return true;
        else
            return false;
    }

    public String getNome() { return nome; }

    public String getCpf() {
        return cpf;
    }

    public double getRendaMensal() {
        return rendaMensal;
    }

    @Override
    public String toString() {
        return "[Cliente] = " + nome + " - " +
                "[CPF] = " + cpf + " - " +
                "[RendaMensal] = " + rendaMensal;
    }
}
