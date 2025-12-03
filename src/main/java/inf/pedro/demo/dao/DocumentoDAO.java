package inf.pedro.demo.dao;

import inf.pedro.demo.db.Db;
import inf.pedro.demo.model.Documento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DocumentoDAO {

    public void inserir(Documento d) throws SQLException {
        final String sql = """
            INSERT INTO documentos (titulo, autor, dataPublicacao, descricao, tipo)
            VALUES (?, ?, ?, ?, ?)
        """;

        try (Connection conn = Db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, d.getTitulo());
            ps.setString(2, d.getAutor());
            ps.setDate(3, Date.valueOf(d.getDataPublicacao()));
            ps.setString(4, d.getDescricao());
            ps.setString(5, d.getTipo());

            ps.executeUpdate();

            // Capture generated ID
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    d.setId(rs.getInt(1));  // <-- Works now because you added setId()!
                }
            }
        }
    }

    public void atualizar(Documento d) throws SQLException {
        if (d.getId() == null)
            throw new SQLException("ID nulo para atualizar.");

        final String sql = """
            UPDATE documentos
            SET titulo=?, autor=?, dataPublicacao=?, descricao=?, tipo=?
            WHERE id=?
        """;

        try (Connection conn = Db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, d.getTitulo());
            ps.setString(2, d.getAutor());
            ps.setDate(3, Date.valueOf(d.getDataPublicacao()));
            ps.setString(4, d.getDescricao());
            ps.setString(5, d.getTipo());
            ps.setInt(6, d.getId());

            ps.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException {
        final String sql = "DELETE FROM documentos WHERE id=?";

        try (Connection conn = Db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public Documento buscarPorId(int id) throws SQLException {
        final String sql = """
            SELECT id, titulo, autor, dataPublicacao, descricao, tipo
            FROM documentos WHERE id=?
        """;

        try (Connection conn = Db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return map(rs);
                }
            }
        }
        return null;
    }

    public List<Documento> listar() throws SQLException {
        final String sql = """
            SELECT id, titulo, autor, dataPublicacao, descricao, tipo
            FROM documentos ORDER BY id DESC
        """;

        List<Documento> lista = new ArrayList<>();

        try (Connection conn = Db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(map(rs));
            }
        }
        return lista;
    }

    private Documento map(ResultSet rs) throws SQLException {
        return new Documento(
                rs.getInt("id"),
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getDate("dataPublicacao").toLocalDate(),
                rs.getString("descricao"),
                rs.getString("tipo")
        );
    }
}
