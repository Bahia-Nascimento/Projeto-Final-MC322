import java.util.ArrayList;

public class Turma {
    private final Materia materia;
    private final String codigo;
    private ArrayList<Aluno> listaAlunos;
    private Professor professor;


    public Turma(Materia materia, String codigo, Professor professor) {
        this.materia = materia;
        this.codigo = codigo;
        this.listaAlunos = new ArrayList<Aluno>();
        this.professor = professor;
    }


    public Materia getMateria() {
        return this.materia;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public ArrayList<Aluno> getListaAlunos() {
        return this.listaAlunos;
    }

    public void addAluno() {

    }

    public void remAluno() {

    }

    public Professor getProfessor() {
        return this.professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
}
