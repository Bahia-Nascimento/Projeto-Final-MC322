package app.model;
import java.util.HashSet;

public class Materia {
    private final String codigo;
    private final double notaMin;
    private final HashSet<Materia> requisitos;

    public Materia(String codigo, double notaMin, HashSet<Materia> requisitos) {
        this.codigo = codigo;
        this.notaMin = notaMin;
        this.requisitos = requisitos;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public double getNotaMin() {
        return this.notaMin;
    }

    public HashSet<Materia> getRequisitos() {
        return this.requisitos;
    }
    
    @Override
    public String toString() {
        return "código: " + getCodigo() +
            ", nota minima: " + getNotaMin()+
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
