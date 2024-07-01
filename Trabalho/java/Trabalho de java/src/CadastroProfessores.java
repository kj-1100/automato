import java.util.Scanner;

public class CadastroProfessores {
    Scanner scanner = new Scanner(System.in);
    Clientes clientes = new Clientes();
    String nome, senha, cpf, aula;


    void adcionarProfessores() {
        clientes.connect();
        clientes.createTableAlunos();
        System.out.println("cadatrar professores");
        clientes.connect();
        System.out.println("Escreva o nome completo do professores");
        this.nome = scanner.nextLine();
        System.out.println("Escreva o CPF do aluno");
        this.cpf = scanner.nextLine();
        if (cpf.length() != 11) {
            System.out.println("Cpf invalido");
            return;
        }
        System.out.println("Escreva as aulas do professores");
        this.aula = scanner.nextLine();
        clientes.addAlunos(nome, cpf, aula);
        clientes.close();
    }


    void VisualizarDadosDoProfessores() {
        clientes.connect();
        System.out.println("Encira O CPF ou o nome do professores");
        String dadoDeBusca = scanner.nextLine();
        clientes.queryAlunos(dadoDeBusca);
        clientes.close();
    }

    void ApagarProfessores() {
        clientes.connect();
        System.out.println("Encira O CPF do professores que desja excluir:");
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
}
