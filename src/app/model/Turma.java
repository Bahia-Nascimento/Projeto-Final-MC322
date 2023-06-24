package app.model;

import java.util.ArrayList;

public class Turma {
    private final Materia materia;
    private ArrayList<Aluno> listaAlunos;
    private Professor professor;


    public Turma(Materia materia, Professor professor) {
        this.materia = materia;
        this.listaAlunos = new ArrayList<Aluno>();
        this.professor = professor;
    }


    public Materia getMateria() {
        return this.materia;
    }

    public String getCodigo() {
        return this.materia.getCodigo();
    }

    public ArrayList<Aluno> getListaAlunos() {
        return this.listaAlunos;
    }

    public Boolean addAluno(Aluno a) {
        if (listaAlunos.contains(a)) {
            return false;
        }
        listaAlunos.add(a);
        return true;
    }

    public Boolean remAluno(String ra) {
        for (Aluno a : listaAlunos) {
            if (a.getCadastro().equals(ra)) {
                listaAlunos.remove(a);
                return true;
            }
        }
        return false;
    }

    public Professor getProfessor() {
        return this.professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public int hashCode() {
        return this.materia.getCodigo().hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Turma t) {
            return this.materia.getCodigo().equals(t.getCodigo());
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "matéria: " + getMateria() +
            ", código: " + getCodigo() +
            ", professor: " + getProfessor().getNome() ;
    }
}
