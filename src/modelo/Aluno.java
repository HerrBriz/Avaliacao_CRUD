package modelo;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

public class Aluno {
    private int id;
    private String nome;
    private String cpf;
    private String email;
    private LocalDate dataNascimento;
    private boolean ativo;
    private Curso curso;

    public Aluno(int id, String nome, String cpf, String email, LocalDate dataNascimento, boolean ativo, Curso curso) {
        if (nome == null || nome.length() < 3) {
            throw new IllegalArgumentException("Nome deve ter no mínimo 3 caracteres.");
        }
        if (!isCpfValido(cpf)) {
            throw new IllegalArgumentException("CPF inválido. Deve conter 11 dígitos.");
        }
        if (!isEmailValido(email)) {
            throw new IllegalArgumentException("Email inválido.");
        }
        if (!temIdadeMinima(dataNascimento)) {
            throw new IllegalArgumentException("O aluno deve ter no mínimo 16 anos.");
        }
        if (curso == null) {
            throw new IllegalArgumentException("O aluno deve estar vinculado a um curso.");
        }

        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.ativo = true;
        this.curso = curso;
    }

    public Aluno() {
        
    }

    
    public int getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public String getCpf(){
        return cpf;
    }
    public String getEmail(){
        return email;
    }
    public LocalDate getDataNascimento(){
        return dataNascimento;
    }
    public boolean isAtivo(){
        return ativo;
    }
    public Curso getCurso(){
        return curso;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setAtivo(boolean ativo){
        this.ativo = ativo;
    }
    public void setCurso(Curso curso){
        this.curso = curso;
    }

    
    private boolean isCpfValido(String cpf) {
        return cpf != null && cpf.matches("\\d{11}");
    }

    private boolean isEmailValido(String email) {
        return email != null && Pattern.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$", email);
    }

    private boolean temIdadeMinima(LocalDate nascimento) {
        return nascimento != null && Period.between(nascimento, LocalDate.now()).getYears() >= 16;
    }
    
    public String getStatusTexto() {
    return ativo ? "Habilitado" : "Desabilitado";
    }

    
    @Override
    public String toString() {
    return getNome();
}

    public void setCpf(String cpf) {
    if (!isCpfValido(cpf)) {
        throw new IllegalArgumentException("CPF inválido. Deve conter 11 dígitos.");
    }
    this.cpf = cpf;
}

    public void setDataNascimento(LocalDate dataNascimento) {
        if (!temIdadeMinima(dataNascimento)) {
            throw new IllegalArgumentException("O aluno deve ter no mínimo 16 anos.");
        }
        this.dataNascimento = dataNascimento;
    }

    public void setId(int id) {
        this.id = id;
    }

}