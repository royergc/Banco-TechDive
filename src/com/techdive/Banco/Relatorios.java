package com.techdive.Banco;

import com.techdive.Banco.Contas.Banco;
import com.techdive.Banco.Contas.Conta;
import com.techdive.Banco.Contas.Transacoes;
import java.util.ArrayList;

public class Relatorios {

    private Transacoes transacoes;

    public ArrayList<String> getHistoricoCliente(Cliente cliente) {
        transacoes = Transacoes.iniciaTransacoes();
        ArrayList<String> historico = transacoes.getHistoricoTransacoes();
        for (int i = 0; i < historico.size(); i++) {
            if (!(historico.get(i).contains(cliente.getCpf()))) {
                historico.remove(i);
            }
        }
        return historico;
    }

    public ArrayList<String> getHistoricoOperacao(String operacao) {
        transacoes = Transacoes.iniciaTransacoes();
        ArrayList<String> historico = transacoes.getHistoricoTransacoes();
        for(int i = 0; i < historico.size(); i++) {
            if(!(historico.get(i).contains(operacao))) {
                historico.remove(i);
            }
        }
        return historico;
    }
    public ArrayList<Conta> getTodasContasDoBanco() {
        return Banco.getContas();
    }

}
