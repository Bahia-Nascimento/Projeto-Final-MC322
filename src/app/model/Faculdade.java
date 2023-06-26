package app.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import app.Utils;
import javafx.beans.property.SimpleMapProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

public class Faculdade {
    private String nome;
    private final CNPJ cnpj;
    private final SimpleMapProperty<String, Aluno> alunos;
    private static Faculdade ic;

    public static Faculdade getIC() {
        if (ic == null) {
            ic = new Faculdade("Instituto de Computação", new CNPJ("46.068.425/0001-33"));
            Curso.CIENCIA.grade().addAll(ic.gradeCC);
            Curso.ENGENHARIA.grade().addAll(ic.gradeEC);
        }
        return ic;
    }

    private final SimpleMapProperty<String, Professor> professores;
    private final SimpleMapProperty<String, Materia> materias;
    private final SimpleMapProperty<String, Turma> turmas;
    protected final HashSet<Materia> gradeCC;
    protected final HashSet<Materia> gradeEC;

    public Faculdade(String nome, CNPJ cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.alunos = new SimpleMapProperty<String, Aluno>(FXCollections.observableHashMap());
        this.professores = new SimpleMapProperty<String, Professor>(FXCollections.observableHashMap());
        this.materias = new SimpleMapProperty<String, Materia>(FXCollections.observableHashMap());
        this.turmas = new SimpleMapProperty<String, Turma>(FXCollections.observableHashMap());
        this.gradeCC = new HashSet<Materia>();
        this.gradeEC = new HashSet<Materia>();
        lerDados();
    }

    public void lerDados() {
        ArrayList<String[]> temp = CSV.lerProfessores();
        for (String[] array : temp) {
            Professor p = new Professor(
                    array[4],
                    new CPF(array[1]),
                    array[0],
                    LocalDate.parse(array[2], Utils.formatadorPadrao),
                    LocalDate.parse(array[3], Utils.formatadorPadrao));
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
                    if (materias.containsKey(array[i])) {
                        requisitos.add(materias.get(array[i]));
                    }
                }
                m = new Materia(array[0], Integer.parseInt(array[1]), requisitos);
            }
            addMateria(m);
        }

        temp = CSV.lerGrade();
        System.out.println(temp.size());
        for (int i = 1; i < temp.get(0).length; i++) {
            String cod = temp.get(0)[i].replaceAll("\"", "");
            if (materias.containsKey(cod)) {
                gradeCC.add(materias.get(cod));
            }
        }
        for (int i = 1; i < temp.get(1).length; i++) {
            String cod = temp.get(1)[i].replaceAll("\"", "");
            if (materias.containsKey(cod)) {
                gradeEC.add(materias.get(cod));
            }
        }

        temp = CSV.lerAlunos();
        for (String[] array : temp) {
            HashSet<Materia> gradeAluno;
            if (Curso.fromString(array[4]) == Curso.CIENCIA) {
                gradeAluno = gradeCC;
            } else {
                gradeAluno = gradeEC;
            }
            Aluno a = new Aluno(new CPF(array[1]), array[0], LocalDate.parse(array[2], Utils.formatadorPadrao), LocalDate.parse(array[3], Utils.formatadorPadrao), Curso.fromString(array[4]), array[5], gradeAluno, Collections.emptyList());
            addAluno(a);
        }

        temp = CSV.lerCompletas();
        for (String[] array : temp) {
            for (int i = 2; i < array.length; i++) {
                alunos.get(array[0]).eliminarMateria(array[i].replaceAll("\"", ""));
            }
        }
        
        temp = CSV.lerTurmas();
        for (String[] array : temp) {
            Turma t = new Turma(materias.get(array[0]), array[1], professores.get(array[2]));
            addTurma(t);
        }
    }

    public void gravarDados() {

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

    public SimpleMapProperty<String, Aluno> alunosProperty() {
        return alunos;
    }

    public ObservableMap<String, Aluno> getAlunos() {
        return alunos.getValue();
    }

    public SimpleMapProperty<String, Professor> professoresProperty() {
        return professores;
    }

    public ObservableMap<String, Professor> getProfessores() {
        return this.professores.getValue();
    }

    public SimpleMapProperty<String, Materia> materiasProperty() {
        return materias;
    }

    public ObservableMap<String, Materia> getmaterias() {
        return this.materias.getValue();
    }

    public SimpleMapProperty<String, Turma> turmasProperty() {
        return turmas;
    }

    public ObservableMap<String, Turma> getTurmas() {
        return turmas.getValue();
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
        if (professores.containsKey(p.getCadastro())) {
            return false;
        }
        professores.put(p.getCadastro(), p);
        return true;
    }

    public boolean remProfessor(String cadastro) {
        if (professores.containsKey(cadastro)) {
            professores.remove(cadastro);
            return true;
        }
        return false;
    }

    public void addMateria(Materia m) {
        materias.put(m.getCodigo(), m);
    }

    public boolean addTurma(Turma t) {
        if (turmas.containsKey(t.getCodigo())) {
            return false;
        }
        turmas.put(t.getCodigo(), t);
        return true;
    }

    @Override
    public String toString() {
        return "nome: " + getNome() +
                ", cnpj: " + getCnpj();
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
