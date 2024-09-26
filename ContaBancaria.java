public class ContaBancaria {
	
    private double saldocont; // Saldo da conta
    private int contadorConsultasald; // Contador de consultas ao saldo

    public ContaBancaria(double saldoInicial) { // CONSTRUTOR CONTA BANCÁRIA
        if (saldoInicial >= 0) {
            this.saldocont = saldoInicial; // Define o saldo inicial
        } else {
            this.saldocont = 0; // Se o saldo inicial for negativo, define como 0
            System.out.println("Saldo inicial não pode ser negativo. Definindo como 0.");
        }
        this.contadorConsultasald = 0; // Inicializa o contador de consultas
    }

    public void deposito(double valor) {// MÉTODO PARA REALIZAR UM DEPÓSITO
        if (valor > 0) { // Verifica se o valor do depósito é positivo
            double taxa = valor * 0.01; // Aplica taxa de 1%
            saldocont += (valor - taxa); // Atualiza o saldo com o valor do depósito menos a taxa
            System.out.println("Depósito de R$" + valor + " realizado com sucesso! Taxa de R$" + taxa + " aplicada.");
        } else {
            System.out.println("O valor do depósito precisa ser positivo."); // Mensagem de erro para valor inválido
        }
    }

    public void saque(double valor) {// MÉTODO PARA REALIZAR UM SAQUE
        if (valor > 0) { // Verifica se o valor do saque é positivo
            double taxa = valor * 0.005; // Aplica taxa de 0,5%
            if (saldocont >= (valor + taxa)) { // Verifica se há saldo suficiente
                saldocont -= (valor + taxa); // Deduz o valor do saque e a taxa do saldo
                System.out.println("Saque de R$" + valor + " realizado com sucesso! Taxa de R$" + taxa + " aplicada.");
            } else {
                System.out.println("Saldo insuficiente para realizar o saque."); // Mensagem de erro se não houver saldo suficiente
            }
        } else {
            System.out.println("O valor do saque precisa ser positivo."); // Mensagem de erro para valor inválido
        }
    }

    public double consultaSaldo() {    // MÉTODO PARA CONSULTAR O SAQUE
        contadorConsultasald++; // Incrementa o contador de consultas
        if (contadorConsultasald % 5 == 0) { // A cada 5 consultas, cobra uma taxa
            saldocont -= 0.10; // Deduz 10 centavos do saldo
            System.out.println("Cobrança de R$0.10 pela consulta de saldo.");
        }
        return saldocont; // Retorna o saldo atual
    }

    public double getSaldo() {    // MÉTODO PARA AVERIGUAR O SALDO ATUAL
        return saldocont; // Retorna o saldo atual
    }

    public static void main(String[] args) { // MÉTODO PARA TESTAR A CLASSE
        ContaBancaria conta = new ContaBancaria(2000); // Cria uma conta com R$2000
        conta.deposito(700); // Realiza um depósito de R$500
        conta.saque(400); // Realiza um saque de R$200
        System.out.println("Saldo atual: R$" + conta.consultaSaldo()); // Consulta o saldo
        conta.consultaSaldo(); // Realiza outra consulta
        conta.consultaSaldo(); // Realiza mais uma consulta
        conta.consultaSaldo(); // Realiza outra consulta
        conta.consultaSaldo(); // Última consulta (cobrança de taxa aqui)
        System.out.println("Saldo final: R$" + conta.getSaldo()); // Mostra o saldo final
    }
}
