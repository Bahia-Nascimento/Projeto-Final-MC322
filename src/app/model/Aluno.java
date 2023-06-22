package app.model;




import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Aluno extends Pessoa {
    private String curso;
    private final String ra;
    private Set<Materia> grade;
    private Set<Turma> turmas;
    

    public Aluno(CPF cpf, String nome, LocalDate dataNascimento, LocalDate dataCadastro, String curso, String ra, Collection<Materia> grade, Collection<Turma> turmas) {
        super(cpf, nome, dataNascimento, dataCadastro);
        this.curso = curso;
        this.ra = ra;
        this.grade = new HashSet<Materia>(grade);
        this.turmas = new HashSet<Turma>(turmas);
    }
    public String getCadastro() {
            return this.ra;
        }

    public String getCurso() {
        return this.curso;
    }
    
    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getRa() {
        return this.ra;
    }

    public Set<Materia> getGrade() {
        return this.grade;
    }
    
    public void setGrade(Set<Materia> grade) {
        this.grade = grade;
    }

    public Set<Turma> getTurmas() {
        return this.turmas;
    }
    
    public void setTurmas(Set<Turma> turmas) {
        this.turmas = turmas;
    }
    
    public Boolean eliminarMateria(Materia m, int nota) {
        // Remove materia da grade do aluno se sua nota for maior ou igual a nota minima da materia

        if (nota >= m.getNotaMin()) {
            grade.remove(m);
            return true;
        }
        return false;

    }



    public Boolean addTurma(Turma t) {
        if (turmas.contains(t)) {
            return false;
        }
        turmas.add(t);
        return true;
    }
    
    public Boolean remTurma(String codigo) {
        for (Turma t : turmas) {
            if (t.getCodigo().equals(codigo)) {
                turmas.remove(t);
                return true;
            }
        }
        return false;
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