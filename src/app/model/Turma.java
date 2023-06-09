package app.model;

import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Turma {
    private final Materia materia;
    private final String codigo;
    private String horario;
    private ReadOnlyListProperty<Aluno> listaAlunos;
    private Professor professor;


    public Turma(Materia materia, String horario, Professor professor) {
        this.materia = materia;
        this.codigo = materia.getCodigo() + " " + (char)('A' + materia.getCount());
        materia.countUp();
        this.horario = horario;
        this.listaAlunos = new SimpleListProperty<>(FXCollections.observableArrayList());
        this.professor = professor;
        this.professor.addTurma(this);
        this.materia.addTurma(this);
    }


    public Materia getMateria() {
        return this.materia;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setHorario(String horario){
        this.horario = horario;
    }

    public String getHorario() {
        return this.horario;
    }

    public ReadOnlyListProperty<Aluno> listaAlunosProperty() {
        return listaAlunos;
    }

    public ObservableList<Aluno> getListaAlunos() {
        return this.listaAlunos.getValue();
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
            return this.materia.getCodigo().equals(t.getHorario());
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "matéria: " + getMateria() +
            ", horario: " + getHorario() +
            ", professor: " + getProfessor().getNome() ;
    }
}
