import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

public class Aluno extends Pessoa {
    private final String curso;
    private final String ra;
    private HashSet<Materia> grade;
    private ArrayList<Turma> listaTurmas;
    

    public Aluno(String cpf, String nome, LocalDate dataNascimento, LocalDate dataCadastro, String curso, String ra) {
        super(cpf, nome, dataNascimento, dataCadastro);
        this.curso = curso;
        this.ra = ra;
        this.grade = new HashSet<Materia>();
        this.listaTurmas = new ArrayList<Turma>();
    }

    public String getCurso() {
        return this.curso;
    }

    public String getRa() {
        return this.ra;
    }

    public HashSet<Materia> getGrade() {
        return this.grade;
    }

    public Boolean eliminarMateria(Materia m, int nota) {
        // Remove materia da grade do aluno se sua nota for maior ou igual a nota minima da materia

        if (nota >= m.getNotaMin()) {
            grade.remove(m);
            return true;
        }
        return false;

    }

    public ArrayList<Turma> getListaTurmas() {
        return this.listaTurmas;
    }

    public Boolean addTurma(Turma t) {
        if (listaTurmas.contains(t)) {
            return false;
        }
        listaTurmas.add(t);
        return true;
    }
    
    public Boolean remTurma(String codigo) {
        for (Turma t : listaTurmas) {
            if (t.getCodigo().equals(codigo)) {
                listaTurmas.remove(t);
                return true;
            }
        }
        return false;
    }

    public String getCadastro() {
        return this.ra;
    }
}