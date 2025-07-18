package domain;

public class ContaPoupanca extends Conta{


    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirConta() {
        System.out.println("=== domain.Conta Poupanca ===");
        super.imprimirConta();
    }

    @Override
    public String toString() {
        return "domain.ContaPoupanca{" +
                ", agencia=" + agencia +
                ", numero=" + numero +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
