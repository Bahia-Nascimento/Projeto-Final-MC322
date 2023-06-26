package app.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javafx.beans.property.ReadOnlySetProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.collections.FXCollections;

public class Aluno extends Pessoa {
    private SimpleObjectProperty<Curso> curso;
    private final String ra;
    private ReadOnlySetProperty<Materia> grade;
    private ReadOnlySetProperty<Turma> turmas;
    private ReadOnlySetProperty<Materia> completas;

    public Aluno(CPF cpf, String nome, LocalDate dataNascimento, LocalDate dataCadastro, Curso curso, String ra,
            Collection<Materia> grade, Collection<Turma> turmas) {
        super(cpf, nome, dataNascimento, dataCadastro);
        this.curso = new SimpleObjectProperty<>(curso);
        this.ra = ra;
        this.grade = new SimpleSetProperty<>(
                FXCollections.observableSet(new HashSet<>(grade)));
        this.turmas = new SimpleSetProperty<>(
                FXCollections.observableSet(new HashSet<>(turmas)));
        this.completas = new SimpleSetProperty<>(FXCollections.observableSet(new HashSet<>()));
        this.curso.addListener((observable, oldCurso, newCurso) -> {
            if (oldCurso != newCurso) {
                this.grade.clear();
                for (Materia materia : newCurso.grade()) {
                    if (!completas.contains(materia)) {
                        this.grade.add(materia);
                    }
                }
            }
        });


    }

    public String getCadastro() {
        return this.ra;
    }

    public SimpleObjectProperty<Curso> cursoProperty() {
        return curso;
    }

    public Curso getCurso() {
        return this.curso.getValue();
    }

    public void setCurso(Curso curso) {
        this.curso.setValue(curso);
    }

    public String getRa() {
        return this.ra;
    }

    public ReadOnlySetProperty<Materia> gradeProperty() {
        return grade;        
    }

    public Set<Materia> getGrade() {
        return this.grade.getValue();
    }

    public ReadOnlySetProperty<Materia> completasProperty() {
        return completas;        
    }

    public Set<Materia> getCompletas() {
        return this.completas.getValue();
    }

    public ReadOnlySetProperty<Turma> turmasProperty() {
        return turmas;        
    }

    public Set<Turma> getTurmas() {
        return this.turmas.getValue();
    }

    public boolean addTurma(Turma t) {
        if (turmas.contains(t)) {
            return false;
        }
        turmas.add(t);
        return true;
    }

    public boolean remTurma(String codigo) {
        for (Turma t : turmas) {
            if (t.getMateria().getCodigo().equals(codigo)) {
                turmas.remove(t);
                return true;
            }
        }
        return false;
    }

    public void eliminarMateria(String codigo) {
        for (Materia m : grade) {
            if (m.getCodigo().equals(codigo)) {
                grade.remove(m);
                completas.add(m);
                break;
            }
        }
    }

    public boolean solicitarDiploma() {
        return grade.isEmpty();
    }

    @Override
    public String toString() {
        return "cpf: " + getCpf() +
                ", nome: " + getNome() +
                ", dataNascimento: " + getDataNascimento() +
                ", dataCadastro: " + getDataCadastro() +
                ", ra: " + getRa() +
                ", curso: " + getCurso();
    }

}