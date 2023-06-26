package app.model;
import java.util.HashSet;
import java.util.Set;

import javafx.beans.property.SimpleStringProperty;

public class Materia {
    private final String codigo;
    private int count;
    private int creditos;
    private HashSet<Materia> requisitos;
    private Set<Turma> turmas;

    public Materia(String codigo, int creditos,  HashSet<Materia> requisitos) {
        this.codigo = codigo;
        this.creditos = creditos;
        this.requisitos = requisitos;
        this.count = 0;
        this.turmas = new HashSet<Turma>();
    }

    public String getCodigo() {
        return this.codigo;
    }

    public Set<Turma> getTurmas() {
        return this.turmas;
    }

    public int getCount() {
        return count;
    }

    public void countUp() {
        this.count = this.count++;
    }

    public void setCreditos(int creditos){
        this.creditos = creditos;
    }

    public int getCreditos(){
        return creditos;
    }

    public HashSet<Materia> getRequisitos() {
        return this.requisitos;
    }

    public void setRequisitos(HashSet<Materia> requisitos) {
        this.requisitos = requisitos;
    }

    public boolean addRequisito(Materia m){
        if (requisitos.contains(m)) {
            return false;
        }
        requisitos.add(m);
        return true;
    }
    
    public boolean remRequisito(String codigo) {
        for (Materia m : requisitos) {
            if (m.getCodigo().equals(codigo)) {
                requisitos.remove(m);
                return true;
            }
        }
        return false;
    }

    public SimpleStringProperty reqToString() {
        String s = "";
        for (Materia m : requisitos) {
            s += " " + m.getCodigo();
        }
        if (s.equals("")) {
            s = " Sem requisitos";
        }
        return new SimpleStringProperty(s);
    }

    @Override
    public String toString() {
        return "código: " + getCodigo() +
            ", créditos: " + getCreditos()+
            ", requisitos: " + getRequisitos() ;
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Materia other = (Materia) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }
}
