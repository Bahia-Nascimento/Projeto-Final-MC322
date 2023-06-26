package app.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Aluno extends Pessoa {
    private Curso curso;
    private final String ra;
    private HashSet<Materia> grade;
    private HashSet<Turma> turmas;
    private HashSet<Materia> completas;

    public Aluno(CPF cpf, String nome, LocalDate dataNascimento, LocalDate dataCadastro, Curso curso, String ra,
            Collection<Materia> grade, Collection<Turma> turmas) {
        super(cpf, nome, dataNascimento, dataCadastro);
        this.curso = curso;
        this.ra = ra;
        this.grade = new HashSet<Materia>(grade);
        this.turmas = new HashSet<Turma>(turmas);
        this.completas = new HashSet<Materia>(); 
    }

    public String getCadastro() {
        return this.ra;
    }

    public Curso getCurso() {
        return this.curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getRa() {
        return this.ra;
    }

    public Set<Materia> getGrade() {
        return this.grade;
    }

    public void setGrade(HashSet<Materia> grade) {
        this.grade = grade;
    }

    public Set<Materia> getCompletas() {
        return this.completas;
    }

    public void seCompletas(HashSet<Materia> completas) {
        this.completas = completas;
    }

    public Set<Turma> getTurmas() {
        return this.turmas;
    }

    public void setTurmas(HashSet<Turma> turmas) {
        this.turmas = turmas;
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