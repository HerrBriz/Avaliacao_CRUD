package modelo;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private int id;
    private String nome;
    private int cargaHoraria;
    private int limiteAlunos;
    private boolean ativo;
    private List<Aluno> alunos;

    public Curso(int id, String nome, int cargaHoraria, int limiteAlunos, boolean ativo) {
        if (nome == null || nome.length() < 3) {
            throw new IllegalArgumentException("Nome do curso deve ter no mínimo 3 caracteres.");
        }
        if (cargaHoraria < 20) {
            throw new IllegalArgumentException("Carga horária mínima é de 20 horas.");
        }
        if (limiteAlunos < 1) {
            throw new IllegalArgumentException("O limite de alunos deve ser no mínimo 1.");
        }

        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.limiteAlunos = limiteAlunos;
        this.ativo = true;
        this.alunos = new ArrayList<>();
    }

    public Curso(int id, String nome, int cargaHoraria, int limite) {
        this(id, nome, cargaHoraria, limite, true); // assume ativo = true por padrão
    }

    public Curso() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    public int getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public int getCargaHoraria(){
        return cargaHoraria;
    }
    public int getLimiteAlunos(){
        return limiteAlunos;
    }
    public boolean isAtivo(){
        return ativo;
    }
    public List<Aluno> getAlunos(){
        return alunos;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setCargaHoraria(int cargaHoraria){
        this.cargaHoraria = cargaHoraria;
    }
    public void setLimiteAlunos(int limiteAlunos){
        this.limiteAlunos = limiteAlunos;
    }
    public void setAtivo(boolean ativo){
        this.ativo = ativo;
    }

    public boolean adicionarAluno(Aluno aluno) {
        if (!ativo) return false;
        if (alunos.size() >= limiteAlunos) return false;
        return alunos.add(aluno);
    }

    public boolean removerAluno(Aluno aluno) {
        return alunos.remove(aluno);
    }
    
    @Override
    public String toString() {
        return getNome();
    }

    public void setId(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
