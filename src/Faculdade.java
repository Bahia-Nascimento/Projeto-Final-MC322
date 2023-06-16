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

    public Boolean addProfessor(Professor p) {
        if (listaProfessores.contains(p)) {
            return false;
        }
        listaProfessores.add(p);
        return true;
    }

    public Boolean remProfessor(String cadastro) {
        for (Professor p : listaProfessores) {
            if (p.getCadastro().equals(cadastro)) {
                listaProfessores.remove(p);
                return true;
            }
        }
        return false;
    }

    public Boolean addMateria(Materia m) {
        return materiaOferecidas.add(m);
    }

    @Override
    public String toString() {
        return "nome: " + getNome() +
            ", cnpj: " + getCpnj() ;
    }
}
