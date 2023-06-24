package app.model;
import java.util.HashSet;

public class Materia {
    private final String codigo;
    private int creditos;
    private HashSet<Materia> requisitos;

    public Materia(String codigo, int creditos,  HashSet<Materia> requisitos) {
        this.codigo = codigo;
        this.creditos = creditos;
        this.requisitos = requisitos;
    }

    public String getCodigo() {
        return this.codigo;
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
    
    public Boolean remRequisito(String codigo) {
        for (Materia m : requisitos) {
            if (m.getCodigo().equals(codigo)) {
                requisitos.remove(m);
                return true;
            }
        }
        return false;
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
