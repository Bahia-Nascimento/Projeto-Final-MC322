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
    
}
