// Importa a classe Scanner do pacote java.util, que permite a leitura de entrada do usuário
import java.util.Scanner;

// Define a classe ContaBancaria
public class ContaBancaria {
    // Declaração dos atributos privados nomeCliente, tipoConta e saldo
    private String nomeCliente;
    private String tipoConta;
    private double saldo;

    // Construtor da classe ContaBancaria, que inicializa os atributos da classe com os valores fornecidos
    public ContaBancaria(String nomeCliente, String tipoConta, double saldo) {
        this.nomeCliente = nomeCliente; // Inicializa o atributo nomeCliente
        this.tipoConta = tipoConta; // Inicializa o atributo tipoConta
        this.saldo = saldo; // Inicializa o atributo saldo
    }

    // Método para consultar o saldo da conta
    public void consultarSaldo() {
        System.out.println("Saldo atual: R$ " + this.saldo); // Imprime o saldo atual da conta
    }

    // Método para receber um valor na conta
    public void receberValor(double valor) {
        this.saldo += valor; // Adiciona o valor recebido ao saldo da conta
        System.out.println("Valor recebido. Saldo atualizado: R$ " + this.saldo); // Imprime o saldo atualizado da conta
    }

    // Método para transferir um valor para outra conta
    public void transferirValor(double valor) {
        // Verifica se o valor da transferência é maior que o saldo da conta
        if (valor > this.saldo) {
            // Se o saldo não for suficiente, imprime uma mensagem informando que a transferência não pode ser realizada
            System.out.println("Não há saldo suficiente para fazer essa transferência.");
        } else {
            // Se o saldo for suficiente, subtrai o valor da transferência do saldo da conta
            this.saldo -= valor;
            // Imprime uma mensagem informando que a transferência foi realizada com sucesso e o saldo atualizado da conta
            System.out.println("Transferência realizada com sucesso. Saldo atualizado: R$ " + this.saldo);
        }
    }
}
