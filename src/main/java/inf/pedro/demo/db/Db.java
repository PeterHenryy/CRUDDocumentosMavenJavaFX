package inf.pedro.demo.db;

import java.sql.*;

public class Db {

    private static final String DB_NAME = "bancodocumentos";  // ensures lowercase
    private static final String USER = "root";
    private static final String PASS = "kalling555";

    private static final String URL_NO_DB =
            "jdbc:mysql://localhost:3306/?useSSL=false&serverTimezone=America/Sao_Paulo&allowPublicKeyRetrieval=true";

    private static final String URL_WITH_DB =
            "jdbc:mysql://localhost:3306/" + DB_NAME +
                    "?useSSL=false&serverTimezone=America/Sao_Paulo&allowPublicKeyRetrieval=true";

    static {
        try {
            criarBancoSeNecessario();
            criarTabelaSeNecessario();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inicializar banco: " + e.getMessage(), e);
        }
    }

    private static void criarBancoSeNecessario() throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL_NO_DB, USER, PASS);
             Statement st = conn.createStatement()) {

            st.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME);
        }
    }

    private static void criarTabelaSeNecessario() throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL_WITH_DB, USER, PASS);
             Statement st = conn.createStatement()) {

            st.execute("""
            CREATE TABLE IF NOT EXISTS documentos (
                id INT AUTO_INCREMENT PRIMARY KEY,
                titulo VARCHAR(255) NOT NULL,
                autor VARCHAR(255) NOT NULL,
                dataPublicacao DATE NOT NULL,
                descricao VARCHAR(500),
                tipo VARCHAR(50) NOT NULL
            )
        """);
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL_WITH_DB, USER, PASS);
    }
}
