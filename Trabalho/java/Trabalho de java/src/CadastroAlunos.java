import java.util.Scanner;

public class CadastroAlunos {
    Scanner scanner = new Scanner(System.in);
    Clientes clientes = new Clientes();
    String nome, senha, cpf, aula;


    void adcionarAlunos() {
        clientes.connect();
        clientes.createTableAlunos();
        System.out.println("cadatrar alunos");
        clientes.connect();
        System.out.println("Escreva o nome completo do aluno");
        this.nome = scanner.nextLine();
        System.out.println("Escreva o CPF do aluno");
        this.cpf = scanner.nextLine();
        if (cpf.length() != 11) {
            System.out.println("Cpf invalido");
            return;
        }
        System.out.println("Escreva as aulas do aluno");
        this.aula = scanner.nextLine();
        clientes.addAlunos(nome, cpf, aula);
        clientes.close();
    }


    void VisualizarDadosDoAluno() {
        clientes.connect();
        System.out.println("Encira O CPF ou o nome do aluno");
        String dadoDeBusca = scanner.nextLine();
        clientes.queryAlunos(dadoDeBusca);
        clientes.close();
    }

    void ApagarAluno() {
        clientes.connect();
        System.out.println("Encira O CPF do aluno que desja excluir:");
        String dadoDeBusca = scanner.nextLine();
        System.out.println("voce confima esse dados:");
        System.out.println("1- sim");
        System.out.println("2- não");
        String certesa = scanner.nextLine();
        if (certesa.equals("1")) {
            clientes.apagarAluno(dadoDeBusca);
        }
        clientes.close();
    }

    void editarNome() {
        clientes.connect();
        int id = clientes.searchClients(nome);
        System.out.println("Digite o nome ou sobrenome que será alterado: ");
        String nomeOriginal = scanner.nextLine();
        System.out.println("Digite o novo valor: ");
        String nomeAtualizado = scanner.nextLine();
        this.nome = nome.replace(nomeOriginal, nomeAtualizado);
        clientes.updateClient(id, nome, senha);
        clientes.close();
        System.out.println("O nome " + nomeOriginal + " foi atualizado para " + nomeAtualizado);
        System.out.println("Novo nome completo: " + nome);
    }

}