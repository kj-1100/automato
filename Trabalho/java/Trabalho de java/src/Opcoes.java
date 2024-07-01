import java.util.Scanner;

public class Opcoes {
    boolean executar = false;
    CadastroAlunos cadastro = new CadastroAlunos();
    Scanner scanner = new Scanner(System.in);
    CadastroProfessores prof = new CadastroProfessores();

    void imprimirMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("1- Alunos");
        System.out.println("2- Professores");
        System.out.println("3- Gerenciar Aulas");
        System.out.println("4- Sair");
    }

    void alunos(boolean b) {
        executar = b;
        while (executar) {
            CadastroAlunos cadastro = new CadastroAlunos();
            System.out.println("Escolha uma opção:");
            System.out.println("1- Adicionar Alunos");
            System.out.println("2- Ver dados de Alunos");
            System.out.println("3- Excluir Alunos");
            System.out.println("4- Sair");

            String opcao = cadastro.scanner.nextLine();
            switch (opcao) {
                case "1":
                    cadastro.adcionarAlunos();
                    break;
                case "2":
                    cadastro.VisualizarDadosDoAluno();
                    break;
                case "3":
                    cadastro.ApagarAluno();
                    break;
                case "4":
                    cadastro.scanner.close();
                    executar = false;
                    break;
                default:
                    System.out.println("Opcao invalida, escolha outra opcao.");
                    break;
            }
        }
    }


    void professores(boolean b) {
        executar = b;
        while (executar) {
            CadastroAlunos cadastro = new CadastroAlunos();

            System.out.println("Escolha uma opção:");
            System.out.println("1- Adicionar Professores");
            System.out.println("2- Ver dados de Professores");
            System.out.println("3- Excluir Professores");
            System.out.println("4- Sair");

            String opcao = cadastro.scanner.nextLine();
            switch (opcao) {
                case "1":
                    prof.adcionarProfessores();
                    break;
                case "2":
                    prof.VisualizarDadosDoProfessores();
                    break;
                case "3":
                    prof.ApagarProfessores();
                    break;
                case "4":
                    cadastro.scanner.close();
                    executar = false;
                    break;
                default:
                    System.out.println("Opcao invalida, escolha outra opcao.");
                    break;
            }
        }
    }


    void aulas(boolean b) {
        executar = b;
        while (executar) {
            CadastroAulas cadastro = new CadastroAulas();
            System.out.println("Escolha uma opção:");
            System.out.println("1- PORT");
            System.out.println("2- GEO");
            System.out.println("3- MAT");
            System.out.println("4- MAT");
            System.out.println("5- Sair");

            String opcao = scanner.nextLine();
            switch (opcao) {
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":


                    break;
                case "5":

                    executar = false;
                    break;
                default:
                    System.out.println("Opcao invalida, escolha outra opcao.");
                    break;
            }
        }
    }


}