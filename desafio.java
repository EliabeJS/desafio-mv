import java.util.ArrayList;
import java.util.List;

// Classe base para Cliente
abstract class Cliente {
    private String nome;
    private String endereco;
    private String telefone;
    private List<Conta> contas;

    // Construtor
    public Cliente(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.contas = new ArrayList<>();
    }

    // Métodos getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Conta> getContas() {
        return contas;
    }

    // Métodos para adicionar, remover e listar contas
    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void removerConta(Conta conta) {
        contas.remove(conta);
    }

    public void listarContas() {
        for (Conta conta : contas) {
            System.out.println(conta);
        }
    }

    // Método abstrato para obter o tipo de cliente
    public abstract String getTipo();
}

// Classe para Cliente Pessoa Física
class ClientePF extends Cliente {
    private String cpf;

    // Construtor
    public ClientePF(String nome, String endereco, String telefone, String cpf) {
        super(nome, endereco, telefone);
        this.cpf = cpf;
    }

    // Métodos getters e setters específicos para CPF

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Implementação do método abstrato
    @Override
    public String getTipo() {
        return "Pessoa Física";
    }
}

// Classe para Cliente Pessoa Jurídica
class ClientePJ extends Cliente {
    private String cnpj;

    // Construtor
    public ClientePJ(String nome, String endereco, String telefone, String cnpj) {
        super(nome, endereco, telefone);
        this.cnpj = cnpj;
    }

    // Métodos getters e setters específicos para CNPJ

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    // Implementação do método abstrato
    @Override
    public String getTipo() {
        return "Pessoa Jurídica";
    }
}

// Classe para Conta
class Conta {
    private double saldo;

    // Construtor
    public Conta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    // Métodos getters e setters

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Método para realizar depósito
    public void depositar(double valor) {
        saldo += valor;
    }

    // Método para realizar saque
    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    // Representação textual da conta
    @Override
    public String toString() {
        return "Saldo: " + saldo;
    }
}

// Exemplo de utilização
public class Main {
    public static void main(String[] args) {
        // Criando clientes
        ClientePF clientePF = new ClientePF("Fulano", "Rua A", "123456789", "123.456.789-00");
        ClientePJ clientePJ = new ClientePJ("Empresa XYZ", "Rua B", "987654321", "12.345.678/0001-00");

        // Adicionando contas aos clientes
        clientePF.adicionarConta(new Conta(1000));
        clientePJ.adicionarConta(new Conta(5000));

        // Realizando operações bancárias
        clientePF.getContas().get(0).depositar(500);
        clientePJ.getContas().get(0).sacar(2000);

        // Exibindo informações dos clientes e suas contas
        System.out.println(clientePF.getNome() + " - " + clientePF.getTipo());
        clientePF.listarContas();

        System.out.println();

        System.out.println(clientePJ.getNome() + " - " + clientePJ.getTipo());
        clientePJ.listarContas();
    }
}