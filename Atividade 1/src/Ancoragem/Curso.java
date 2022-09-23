package Ancoragem;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nome;
    private String nivel;
    private int ch;
    private Professor professor;
    private List<Estudante> Estudante;

    public Curso(String nome8, String nivel, int ch, Professor p) {
        this.nome = nome8;
        this.nivel = nivel;
        this.ch = ch;
        this.professor = p;
        this.Estudante = new ArrayList<>();
    }

    public int getAlunosMatriculados() {
        return this.Estudante.size();
    }

    public void realizarMatricula(Estudante Estudante) {
        this.Estudante.add(Estudante);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCh(int ch) {
        this.ch = ch;
    }

    public String getNome() {
        return this.nome;
    }

    public String getNivel() {
        return nivel;
    }

    public int getCh() {
        return ch;
    }

    public Professor getProfessor() {
        return professor;
    }

    public String getNomeProfessor() {
        return this.professor.getNome();
    }

    public List<Estudante> getEstudante() {
        return Estudante;
    }

}
