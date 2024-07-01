import java.sql.*;

public class Clientes {
    private static final String URL = "jdbc:sqlite:C:\\Users\\LabInfo\\Desktop\\paradas_dokayky\\Trabalho\\banco.db";
    private Connection connection;

    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection(URL);
            connection.setAutoCommit(false);
            System.out.println("Conexão realizada! Banco de dados: " + URL);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC do SQLite não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexão fechada.");
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }


    /////////////////////////////////////////////////Alunos/////////////////////////////////
    public void createTableAlunos() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS Alunos (ID INTEGER PRIMARY KEY, Nome VARCHAR, CPF VARCHAR, Aula VARCHAR)");
            connection.commit();
            System.out.println("Tabela criada ou já existe.");
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }


    public void addAlunos(String nome, String cpf, String aula) {
        try (PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO Alunos (Nome,CPF,Aula) VALUES (?,?,?)")) {
            insertStatement.setString(1, nome);
            System.out.println("Erro ao criar tabela: " + nome);
            insertStatement.setString(2, cpf);
            System.out.println("Erro ao criar tabela: " + cpf);
            insertStatement.setString(3, aula);
            System.out.println("Erro ao criar tabela: " + aula);
            insertStatement.executeUpdate();
            connection.commit();
            System.out.println("Cliente inserido.");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir cliente: " + e.getMessage());
        }
    }

    public void queryAlunos(String dadoDeBusca) {
        try (PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM Alunos")) {
            ResultSet resultSet = selectStatement.executeQuery();
            System.out.println("Alunos:");
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String nome = resultSet.getString("Nome");
                String CPF = resultSet.getString("CPF");
                String Aula = resultSet.getString("Aula");

                if (dadoDeBusca.equalsIgnoreCase(nome) || dadoDeBusca.equals(CPF)) {
                    System.out.println("AlUNO ID: " + id);
                    System.out.println("Nome: " + nome);
                    System.out.println("CPF: " + CPF);
                    System.out.println("Aulas: " + Aula);
                }

            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar clientes: " + e.getMessage());
        }
    }

    public void apagarAluno(String cpf) {
        try (PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM Alunos WHERE CPF = ?")) {
            deleteStatement.setString(1, cpf);
            deleteStatement.executeUpdate();
            connection.commit();
            System.out.println("Cliente deletado.");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar cliente: " + e.getMessage());
        }
    }

    //////////////////////////////////////////////////professor///////////////////////////
    public void createTablePROF() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS Professores (ID INTEGER PRIMARY KEY, Nome VARCHAR, CPF VARCHAR, Aula VARCHAR)");
            connection.commit();
            System.out.println("Tabela criada ou já existe.");
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    public void addPROF(String nome, String cpf, String aula) {
        try (PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO Professores (Nome,CPF,Aula) VALUES (?,?,?)")) {
            insertStatement.setString(1, nome);
            System.out.println("Erro ao criar tabela: " + nome);
            insertStatement.setString(2, cpf);
            System.out.println("Erro ao criar tabela: " + cpf);
            insertStatement.setString(3, aula);
            System.out.println("Erro ao criar tabela: " + aula);
            insertStatement.executeUpdate();
            connection.commit();
            System.out.println("Cliente inserido.");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir cliente: " + e.getMessage());
        }
    }

    public void queryPROF(String dadoDeBusca) {
        try (PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM Professores")) {
            ResultSet resultSet = selectStatement.executeQuery();
            System.out.println("Professores:");
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String nome = resultSet.getString("Nome");
                String CPF = resultSet.getString("CPF");
                String Aula = resultSet.getString("Aula");

                if (dadoDeBusca.equalsIgnoreCase(nome) || dadoDeBusca.equals(CPF)) {
                    System.out.println("Professores ID: " + id);
                    System.out.println("Nome: " + nome);
                    System.out.println("CPF: " + CPF);
                    System.out.println("Aulas: " + Aula);
                }

            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar clientes: " + e.getMessage());
        }
    }

    public void apagarPROF(String cpf) {
        try (PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM Professores WHERE CPF = ?")) {
            deleteStatement.setString(1, cpf);
            deleteStatement.executeUpdate();
            connection.commit();
            System.out.println("deletado.");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar cliente: " + e.getMessage());
        }
    }


    /////////////////////////////////////////////////aula/////////////////////////////////










}