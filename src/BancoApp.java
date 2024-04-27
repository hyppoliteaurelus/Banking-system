import java.util.Scanner;

// Define a classe BancoApp
public class BancoApp {
    // Método main, ponto de entrada do programa
    public static void main(String[] args) {
        // Cria uma instância da classe ContaBancaria com os dados iniciais do cliente
        ContaBancaria conta = new ContaBancaria("Jacqueline Oliveira", "Corrente", 2500.00);
        // Chama o método exibirMenu passando a conta criada como parâmetro
        exibirMenu(conta);
    }

    // Método para exibir o menu de operações e interagir com o usuário
    public static void exibirMenu(ContaBancaria conta) {
        // Cria um objeto Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);
        int opcao; // Declara uma variável para armazenar a opção escolhida pelo usuário

        // Inicia um loop do-while para exibir o menu e realizar operações enquanto o usuário não escolher a opção "4" (Sair)
        do {
            // Imprime o menu de operações na tela
            System.out.println("\n***********************");
            System.out.println("Operações\n");
            System.out.println("1- Consultar saldos");
            System.out.println("2- Receber valor");
            System.out.println("3- Transferir valor");
            System.out.println("4- Sair");
            System.out.print("\nDigite a opção desejada: ");
            // Lê a opção escolhida pelo usuário
            opcao = scanner.nextInt();

            // Estrutura switch-case para executar a operação correspondente à opção escolhida pelo usuário
            switch (opcao) {
                case 1:
                    conta.consultarSaldo(); // Chama o método consultarSaldo da conta
                    break;
                case 2:
                    // Solicita ao usuário o valor a receber e chama o método receberValor da conta
                    System.out.print("Informe o valor a receber: ");
                    double valorRecebido = scanner.nextDouble();
                    conta.receberValor(valorRecebido);
                    break;
                case 3:
                    // Solicita ao usuário o valor a transferir e chama o método transferirValor da conta
                    System.out.print("Informe o valor que deseja transferir: ");
                    double valorTransferencia = scanner.nextDouble();
                    conta.transferirValor(valorTransferencia);
                    break;
                case 4:
                    System.out.println("Encerrando o aplicativo."); // Imprime uma mensagem informando que o aplicativo está sendo encerrado
                    break; // Sai do loop do-while, encerrando o programa
                default:
                    System.out.println("Opção inválida."); // Se o usuário escolher uma opção inválida, imprime uma mensagem informando isso
                    break; // Reinicia o loop do-while para que o usuário escolha uma opção válida
            }
        } while (opcao != 4); // O loop continua enquanto o usuário não escolher a opção "4" (Sair)
    }
}
