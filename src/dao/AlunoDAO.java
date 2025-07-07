package dao;

import factory.ConnectionFactory;
import factory.Conexao;
import modelo.Aluno;
import modelo.Curso;

import java.sql.*;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    public void inserir(Aluno aluno) throws SQLException {
        String sql = "INSERT INTO aluno (nome, cpf, email, data_nascimento, ativo, idCurso) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getEmail());
            stmt.setDate(4, Date.valueOf(aluno.getDataNascimento()));
            stmt.setBoolean(5, aluno.isAtivo());
            stmt.setInt(6, aluno.getCurso().getId());

            stmt.executeUpdate();
        }
    }

    public List<Aluno> listarTodos() throws SQLException {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT a.id, a.nome, a.cpf, a.email, a.data_nascimento, a.ativo, a.idCurso, " +
                     "c.nome AS nomeCurso, c.carga_horaria, c.limite_alunos " +
                     "FROM aluno a JOIN curso c ON a.idCurso = c.id ORDER BY a.nome";




        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Aluno aluno = new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getDate("data_nascimento").toLocalDate(),
                        rs.getBoolean("ativo"),
                        new Curso(
                            rs.getInt("idCurso"),
                            rs.getString("nomeCurso"),
                            rs.getInt("carga_horaria"),
                            rs.getInt("limite_alunos")
)

                );
                aluno.setAtivo(rs.getBoolean("ativo"));
                alunos.add(aluno);
            }
        }

        return alunos;
    }

    public void atualizar(Aluno aluno) throws Exception {
        String sql = "UPDATE aluno SET nome=?, cpf=?, email=?, data_nascimento=?, ativo=?, idCurso=? WHERE id=?";

        try (Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getEmail());
            stmt.setDate(4, java.sql.Date.valueOf(aluno.getDataNascimento()));
            stmt.setBoolean(5, aluno.isAtivo());
            stmt.setInt(6, aluno.getCurso().getId());  // importante!
            stmt.setInt(7, aluno.getId());             // WHERE id = ?

            stmt.executeUpdate();
    }
 }


    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM aluno WHERE id=?";

        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
    
    public void excluirPorCurso(int cursoId) throws Exception {
    String sql = "DELETE FROM alunos WHERE curso_id = ?";
    try (Connection conn = new ConnectionFactory().getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, cursoId);
        stmt.executeUpdate();
    }
}
    public void atualizarStatus(Aluno aluno) throws SQLException {
    String sql = "UPDATE aluno SET ativo = ? WHERE id = ?";

    try (Connection conn = new ConnectionFactory().getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setBoolean(1, aluno.isAtivo());
        stmt.setInt(2, aluno.getId());

        stmt.executeUpdate();
    }
}
    
   public List<Aluno> listarPorCurso(int cursoId) throws Exception {
    List<Aluno> alunos = new ArrayList<>();
    String sql = "SELECT * FROM aluno WHERE idCurso = ?";

    try (Connection conn = new ConnectionFactory().getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, cursoId);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Aluno aluno = new Aluno();
            aluno.setId(rs.getInt("id"));
            aluno.setNome(rs.getString("nome"));
            aluno.setCpf(rs.getString("cpf"));
            aluno.setEmail(rs.getString("email"));
            aluno.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
            aluno.setAtivo(rs.getBoolean("ativo"));

            alunos.add(aluno);
        }
    }

    return alunos;
   }

}
