import java.util.ArrayList;
import java.util.HashSet;

public class Faculdade {
    private String nome;
    private final String cpnj;
    private ArrayList<Aluno> listaAlunos;
    private ArrayList<Professor> listaProfessores;
    private HashSet<Materia> materiaOferecidas;

    public Faculdade(String nome, String cpnj) {
        this.nome = nome;
        this.cpnj = cpnj;
        this.listaAlunos = new ArrayList<Aluno>();
        this.listaProfessores = new ArrayList<Professor>();
        this.materiaOferecidas = new HashSet<Materia>();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpnj() {
        return this.cpnj;
    }

    public ArrayList<Aluno> getListaAlunos() {
        return this.listaAlunos;
    }

    public ArrayList<Professor> getListaProfessores() {
        return this.listaProfessores;
    }

    public HashSet<Materia> getMateriaOferecidas() {
        return this.materiaOferecidas;
    }

    public void addAluno() {

    }

    public void remAluno() {

    }

    public void addProfessor() {

    }

    public void remProfessor() {

    }

    public void addMateria() {

    }

    public void remMateria() {

    }

}
