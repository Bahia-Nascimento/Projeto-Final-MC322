package app.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Professor extends Pessoa{
    private final String cadastro;
    private Set<Turma> turmas;


    public Professor(String cadastro, Collection<Turma> turmas, CPF cpf, String nome, LocalDate dataNascimento, LocalDate dataCadastro) {
        super(cpf, nome, dataNascimento, dataCadastro);
        this.cadastro = cadastro;
        this.turmas = new HashSet<Turma>(turmas);
    }

    public String getCadastro() {
        return this.cadastro;
    }

    public Set<Turma> getTurmas() {
        return this.turmas;
    }

    public boolean addTurma(Turma t) {
        return turmas.add(t);
    }
    
    public boolean remTurma(String codigo) {
        for (Turma t : turmas) {
            if (t.getCodigo().equals(codigo)) {
                turmas.remove(t);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "Professor(cpf: " + getCpf() +
            ", nome: " + getNome() +
            ", dataNascimento: " + getDataNascimento() +
            ", dataCadastro: " + getDataCadastro() +
            ", cadastro: " + getCadastro() + ")";
    }
}
