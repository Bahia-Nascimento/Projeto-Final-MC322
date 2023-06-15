import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

public class Aluno extends Pessoa {
    private String curso;
    private final String ra;
    private HashSet<Materia> grade;
    private ArrayList<Turma> turmas;
    

    public Aluno(String cpf, String nome, LocalDate dataNascimento, LocalDate dataCadastro, String curso, String ra) {
        super(cpf, nome, dataNascimento, dataCadastro);
        this.curso = curso;
        this.ra = ra;
        this.grade = new HashSet<Materia>();
        this.turmas = new ArrayList<Turma>();
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

    public HashSet<Materia> getGrade() {
        return this.grade;
    }

    public void eliminarMateria(Materia m, int nota) {

    }

    public ArrayList<Turma> getTurmas() {
        return this.turmas;
    }

    public void addTurma() {

    }
    
    public void remTurma() {
        
    }

    public String getCadastro() {
        return this.ra;
    }
}