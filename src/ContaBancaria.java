// Importa a classe Scanner do pacote java.util, que permite a leitura de entrada do usuário
import java.util.ArrayList;
import java.util.Scanner;

// Define a classe ContaBancaria
public class ContaBancaria {
    // Declaração dos atributos privados nomeCliente, tipoConta e saldo
    private String nomeCliente;
    private String tipoConta;
    private double saldo;
    private double limiteTransferencia;
    // Novo atributo para armazenar transferências programadas
    private double transferenciaProgramada;
    // Adicionando um registro de histórico de transações como um ArrayList
    private ArrayList<String> historicoTransacoes;

    // Construtor da classe ContaBancaria, que inicializa os atributos da classe com os valores fornecidos
    public ContaBancaria(String nomeCliente, String tipoConta, double saldo, double limiteTransferencia,double transferenciaProgramada) {
        this.nomeCliente = nomeCliente; // Inicializa o atributo nomeCliente
        this.tipoConta = tipoConta; // Inicializa o atributo tipoConta
        this.saldo = saldo; // Inicializa o atributo saldo
        this.limiteTransferencia = limiteTransferencia;
        this.historicoTransacoes = new ArrayList<>();
        // Inicialização dos atributos existentes
        this.transferenciaProgramada = transferenciaProgramada;
    }

    // Método para definir o limite de transferência
    public void definirLimiteTransferencia(double limite) {
        this.limiteTransferencia = limite;
        System.out.println("Limite de transferência definido para R$" + limite);
    }


    // Método para receber um valor na conta
    public void receberValor(double valor) {
        this.saldo += valor; // Adiciona o valor recebido ao saldo da conta
        System.out.println("Valor recebido. Saldo atualizado: R$ " + this.saldo); // Imprime o saldo atualizado da conta
    }

    // Método para transferir um valor para outra conta
    public void transferirValor(double valor) {
        if (valor > this.limiteTransferencia) {
            System.out.println("Limite de transferência excedido. Por favor, escolha um valor dentro do limite de transferência de R$" + this.limiteTransferencia);
            // Verifica se o valor da transferência é maior que o saldo da conta
        } else if (valor > this.saldo) {
            // Se o saldo não for suficiente, imprime uma mensagem informando que a transferência não pode ser realizada
            System.out.println("Não há saldo suficiente para fazer essa transferência.");
        } else {
            // Se o saldo for suficiente, subtrai o valor da transferência do saldo da conta
            this.saldo -= valor;
            registrarTransacao("Transferência realizada: -R$" + valor);
            // Imprime uma mensagem informando que a transferência foi realizada com sucesso e o saldo atualizado da conta
            System.out.println("Transferência realizada com sucesso. Saldo atualizado: R$ " + this.saldo);
        }
    }
    public void depositarValor(double valor) {
        this.saldo += valor;
        registrarTransacao("Depósito realizado: +R$" + valor);
        System.out.println("Depósito realizado com sucesso. Saldo atualizado: R$ " + this.saldo);
    }

    public void retirarValor(double valor) {
        if (valor > this.saldo) {
            System.out.println("Não há saldo suficiente para fazer esta retirada.");
        } else {
            this.saldo -= valor;
            registrarTransacao("Retirada realizada: -R$" + valor);
            System.out.println("Retirada realizada com sucesso. Saldo atualizado: R$ " + this.saldo);
        }
    }
    public void agendarTransferencia(double valor, String data) {
        this.transferenciaProgramada += valor;
        System.out.println("Transferência agendada para " + data + " no valor de R$" + valor);
    }

    // Método para registrar as transações no histórico
    private void registrarTransacao(String transacao) {
        this.historicoTransacoes.add(transacao);
    }

    // Método para consultar o saldo da conta
    public void consultarSaldo() {
        System.out.println("Saldo atual: R$ " + this.saldo); // Imprime o saldo atual da conta
    }

    // Método para exibir o histórico de transações
    public void exibirHistoricoTransacoes() {
        System.out.println("Histórico de transações:");
        for (String transacao : historicoTransacoes) {
            System.out.println(transacao);
        }
    }
}
