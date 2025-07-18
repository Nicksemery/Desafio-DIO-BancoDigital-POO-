package domain;

public abstract class Conta implements INConta{

    private static final int agencia_padrao = 1;
    private static int sequencial = 1;

    protected Cliente cliente;
    protected int agencia;
    protected int numero;
    protected String titular;
    protected double saldo = 0;

    public Conta(Cliente cliente) {
        this.agencia = Conta.agencia_padrao;
        this.numero = sequencial++;
        this.cliente = cliente;
        titular = cliente.getNome();
    }

    @Override
    public void deposito(double valor) {
        saldo += valor;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.deposito(valor);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }



    public void imprimirConta(){
        System.out.printf("Titular: %s%n", cliente.getNome());
        System.out.printf("CPF: %s%n", cliente.getCpf());
        System.out.printf("Agencia: %d%n", this.agencia);
        System.out.printf("Numero: %d%n", this.numero);
        System.out.printf("Saldo: %.2f%n", this.saldo);
    }
}