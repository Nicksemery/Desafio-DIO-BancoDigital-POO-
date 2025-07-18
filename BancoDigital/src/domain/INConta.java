package domain;

public interface INConta {

    void deposito(double valor);
    void sacar(double valor);
    void transferir(double valor, Conta contaDestino);
}
