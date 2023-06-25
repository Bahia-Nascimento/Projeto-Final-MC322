package app.model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.beans.property.SimpleMapProperty;
import javafx.collections.FXCollections;

public class Faculdade {
    private String nome;
    private final CNPJ cnpj;
    private final SimpleMapProperty<String, Aluno> alunos;
    private final List<Professor> listaProfessores;
    private final Set<Materia> materiaOferecidas;
    private final Set<Turma> turmas;
    private final HashSet<Materia> gradeCC;
    private final HashSet<Materia> gradeEC;
    

    public Faculdade(String nome, CNPJ cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.alunos = new SimpleMapProperty<String, Aluno>(FXCollections.observableHashMap());
        this.listaProfessores = new ArrayList<Professor>();
        this.materiaOferecidas = new HashSet<Materia>();
        this.gradeCC = new HashSet<Materia>();
        this.gradeEC = new HashSet<Materia>();
        this.turmas = new HashSet<>();
        lerDados();
    }

    public void lerDados() {
        ArrayList<String[]> temp = CSV.lerProfessores();
        for (String[] array : temp) {
            Professor p = new Professor(array[4], new CPF(array[1]), array[0], LocalDate.parse(array[3]), LocalDate.parse(array[4]));
            addProfessor(p);
        }

        temp = CSV.lerMateria();
        for (String[] array : temp) {
            Materia m;
            if (array[2].equals("\"\"")) {
                m = new Materia(array[0], Integer.parseInt(array[1]), new HashSet<Materia>());
            } else {
                HashSet<Materia> requisitos = new HashSet<Materia>();
                for (int i = 2; i < array.length; i++) {
                    array[i] = array[i].replaceAll("\"", "");
                    for (Materia mat : materiaOferecidas) {
                        if (mat.getCodigo().equals(array[i])) {
                            requisitos.add(mat);
                            break;
                        }
                    }
                }
                m = new Materia(array[0], Integer.parseInt(array[1]), requisitos);
            }
            addMateria(m);
        }

        temp = CSV.lerGrade();
        for (int i = 1; i < temp.get(0).length; i++) {
            String cod = temp.get(0)[i].replaceAll("\"", "");
            for (Materia m : materiaOferecidas) {
                if (cod.equals(m.getCodigo())) {
                    gradeCC.add(m);
                    break;
                }
            }
        }
        for (int i = 1; i < temp.get(1).length; i++) {
            String cod = temp.get(1)[i].replaceAll("\"", "");
            for (Materia m : materiaOferecidas) {
                if (cod.equals(m.getCodigo())) {
                    gradeEC.add(m);
                    break;
                }
            }
        }
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CNPJ getCnpj() {
        return this.cnpj;
    }

    public SimpleMapProperty<String, Aluno> getAlunos() {
        return alunos;
    }

    public List<Professor> getListaProfessores() {
        return this.listaProfessores;
    }

    public Set<Materia> getMateriaOferecidas() {
        return this.materiaOferecidas;
    }

    public Set<Turma> getTurmas() {
        return turmas;
    }

    public boolean addAluno(Aluno a) {
        Aluno b = alunos.putIfAbsent(a.getRa(), a);
        return a.equals(b);

    }

    public boolean remAluno(String ra) {
        Aluno a = alunos.remove(ra);
        return a != null;
    }

    public boolean addProfessor(Professor p) {
        if (listaProfessores.contains(p)) {
            return false;
        }
        listaProfessores.add(p);
        return true;
    }

    public boolean remProfessor(String cadastro) {
        for (Professor p : listaProfessores) {
            if (p.getCadastro().equals(cadastro)) {
                listaProfessores.remove(p);
                return true;
            }
        }
        return false;
    }

    public boolean addMateria(Materia m) {
        return materiaOferecidas.add(m);
    }

    @Override
    public String toString() {
        return "nome: " + getNome() +
            ", cnpj: " + getCnpj() ;
    }

    @Override
    public int hashCode() {
        return cnpj.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Faculdade other = (Faculdade) obj;
        if (cnpj == null) {
            if (other.cnpj != null)
                return false;
        } else if (!cnpj.equals(other.cnpj))
            return false;
        return true;
    }
}
