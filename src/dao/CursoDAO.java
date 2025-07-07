package dao;

import factory.ConnectionFactory;
import factory.Conexao;
import modelo.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    public void inserir(Curso curso) throws SQLException {
        String sql = "INSERT INTO curso (nome, carga_horaria, limite_alunos, ativo) VALUES (?, ?, ?, ?)";

        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, curso.getNome());
            stmt.setInt(2, curso.getCargaHoraria());
            stmt.setInt(3, curso.getLimiteAlunos());
            stmt.setBoolean(4, curso.isAtivo());

            stmt.executeUpdate();
        }
    }

    public List<Curso> listarTodos() throws SQLException {
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT * FROM curso";

        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Curso curso = new Curso(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("carga_horaria"),
                        rs.getInt("limite_alunos")
                );
                curso.setAtivo(rs.getBoolean("ativo"));
                cursos.add(curso);
            }
        }

        return cursos;
    }

    public void atualizar(Curso curso) throws SQLException {
        String sql = "UPDATE curso SET nome=?, carga_horaria=?, limite_alunos=?, ativo=? WHERE id=?";

        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, curso.getNome());
            stmt.setInt(2, curso.getCargaHoraria());
            stmt.setInt(3, curso.getLimiteAlunos());
            stmt.setBoolean(4, curso.isAtivo());
            stmt.setInt(5, curso.getId());

            stmt.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM curso WHERE id=?";

        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
    
    public void excluirPorId(int id) throws SQLException {
    String sqlExcluirAlunos = "DELETE FROM aluno WHERE idCurso = ?";
    String sqlExcluirCurso = "DELETE FROM curso WHERE id = ?";

    try (Connection conn = new ConnectionFactory().getConnection()) {
        conn.setAutoCommit(false); // começa transação

        try (PreparedStatement stmtAlunos = conn.prepareStatement(sqlExcluirAlunos);
             PreparedStatement stmtCurso = conn.prepareStatement(sqlExcluirCurso)) {

            stmtAlunos.setInt(1, id);
            stmtAlunos.executeUpdate();

            stmtCurso.setInt(1, id);
            stmtCurso.executeUpdate();

            conn.commit(); // tudo certo
        } catch (SQLException e) {
            conn.rollback(); // reverte se der erro
            throw e;
        }
    }
    }
    
    public void atualizarStatus(Curso curso) throws SQLException {
    String sql = "UPDATE curso SET ativo = ? WHERE id = ?";
    try (Connection conn = new ConnectionFactory().getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setBoolean(1, curso.isAtivo());
        stmt.setInt(2, curso.getId());

        stmt.executeUpdate();
    }
 }
    
    public int contarAlunosPorCurso(int idCurso) throws SQLException {
    String sql = "SELECT COUNT(*) FROM aluno WHERE idCurso = ?";
    try (Connection conn = new ConnectionFactory().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, idCurso);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
    }
    return 0;
 }
    
}