import java.sql.*;
import java.util.Scanner;

public class Main {
    private Connection connection;

    public static void main(String[] args) {

        Opcoes opcoes = new Opcoes();
        boolean executar = true;
        Scanner scanner = new Scanner(System.in);

        while (executar) {
            opcoes.imprimirMenu();
            String opcao = scanner.nextLine();
            switch (opcao) {
                case "1":
                    opcoes.alunos(true);
                    break;
                case "2":
                    opcoes.professores(true);
                    break;
                case "3":
                    opcoes.aulas(true);
                    break;
                case "4":
                    scanner.close();
                    executar = false;
                    break;
                default:
                    System.out.println("Opcao invalida, escolha outra opcao.");
                    break;
            }
        }

    }
}