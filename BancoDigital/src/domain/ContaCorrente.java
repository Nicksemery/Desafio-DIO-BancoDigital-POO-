package domain;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirConta() {
        System.out.println("=== domain.Conta Corrente ===");
        super.imprimirConta();
    }

    @Override
    public String toString() {
        return "domain.ContaCorrente{" +
                ", agencia=" + agencia +
                ", numero=" + numero +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
