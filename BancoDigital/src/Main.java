import domain.Banco;
import domain.Cliente;
import domain.Conta;
import domain.ContaCorrente;
import domain.ContaPoupanca;

import java.util.Scanner;

public class Main {

    private final static Scanner sc = new Scanner(System.in);
    private final static Banco banco = new Banco();

    public static void main(String[] args) {

      /*  domain.Banco banco = new domain.Banco();
        domain.Cliente cliente = new domain.Cliente();
        cliente.setNome("Joao");

        domain.Conta cc = new domain.ContaCorrente(cliente);
        domain.Conta poup = new domain.ContaPoupanca(cliente);

        cc.deposito(1222);
        cc.transferir(200,poup);

        cc.imprimirConta();

        poup.imprimirConta();
        banco.adicionaConta(cc);
        banco.inforContas();
       */

        while (true) {
            System.out.println("\n=== Banco Digital ===");
            System.out.println("[1] Cadastrar nova conta");
            System.out.println("[2] Login");
            System.out.println("[?] contas"); //seria apenas para adm
            System.out.println("[4] Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1 -> cadastrarConta();
                case 2 -> {
                        System.out.print("\nDigite o número da conta: ");
                        int numeroConta = sc.nextInt();
                        sc.nextLine();

                        Conta contaLogada = banco.buscarContaPorNumero(numeroConta);

                        if (contaLogada == null) {
                            System.out.println("Conta não encontrada!");
                            break;
                        }
                        System.out.println("Bem-vindo, " + contaLogada.getTitular() + "!");
                        boolean continuar = true;

                        while (continuar) {
                            System.out.println("\n=== Operações ===");
                            System.out.println("[1] Consultar Saldo");
                            System.out.println("[2] Depositar");
                            System.out.println("[3] Sacar");
                            System.out.println("[4] Transferir");
                            System.out.println("[5] Voltar");
                            System.out.print("Escolha: ");
                            int opcao = sc.nextInt();
                            sc.nextLine();

                            switch (opcao) {
                                case 1 -> {
                                    contaLogada.imprimirConta();
                                }
                                case 2 -> {
                                    System.out.print("Valor para depósito: ");
                                    double valor = sc.nextDouble();
                                    contaLogada.deposito(valor);
                                    System.out.println("Depósito realizado.");
                                }
                                case 3 -> {
                                    System.out.print("Valor para saque: ");
                                    double valor = sc.nextDouble();
                                    if (valor > contaLogada.getSaldo()) {
                                        System.out.println("Saldo insuficiente.");
                                    } else {
                                        contaLogada.sacar(valor);
                                        System.out.println("Saque realizado.");
                                    }
                                }
                                case 4 -> {
                                    System.out.print("Número da conta destino: ");
                                    int numeroDestino = sc.nextInt();
                                    sc.nextLine();
                                    Conta contaDestino = banco.buscarContaPorNumero(numeroDestino);

                                    if (contaDestino == null) {
                                        System.out.println("Conta destino não encontrada.");
                                    } else {
                                        System.out.print("Valor para transferir: ");
                                        double valor = sc.nextDouble();
                                        if (valor > contaLogada.getSaldo()) {
                                            System.out.println("Saldo insuficiente.");
                                        } else {
                                            contaLogada.transferir(valor, contaDestino);
                                            System.out.println("Transferência realizada.");
                                        }
                                    }
                                }
                                case 5 -> continuar = false;
                                default -> System.out.println("Opção inválida.");
                            }
                        }
                    }
                case 3 -> banco.inforContas();
                case 4 -> {
                    System.out.println("Encerrando...");
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void cadastrarConta() {
        System.out.println("\n--- Cadastro de Conta ---");
        Cliente cliente = new Cliente();
        System.out.print("Nome do cliente: ");
        cliente.setNome(sc.nextLine());


        System.out.print("CPF do cliente (000.000.000-00): ");
        cliente.setCpf(sc.nextLine());



        System.out.println("[1] Conta Corrente");
        System.out.println("[2] Conta Poupança");
        System.out.print("Escolha o tipo de conta: ");
        int tipo = sc.nextInt();
        sc.nextLine();

        Conta conta;
        if (tipo == 1) {
            conta = new ContaCorrente(cliente);
        } else if (tipo == 2) {
            conta = new ContaPoupanca(cliente);
        } else {
            System.out.println("Tipo inválido!");
            return;
        }

        banco.adicionaConta(conta);
        System.out.println("Conta criada com sucesso!");
        conta.imprimirConta();
    }
}