package domain;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private static final String nome = "domain.Banco Digital";
    private List<Conta> contas;

    public Banco() {
        this.contas = new ArrayList<>();
    }

    public void adicionaConta(Conta conta) {
        this.contas.add(conta);
    }

    public void inforContas(){
        System.out.println(nome);
        System.out.println("\n=== Contas ===");
        for (Conta conta : contas) {
            System.out.println(conta);
        }
    }

    public Conta buscarContaPorNumero(int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numeroConta) {
                return conta;
            }
        }
        return null;
    }
}
