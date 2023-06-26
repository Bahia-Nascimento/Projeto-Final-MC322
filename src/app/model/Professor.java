package app.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javafx.beans.property.ReadOnlySetProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;

public class Professor extends Pessoa{
    private final String cadastro;
    private ReadOnlySetProperty<Turma> turmas;


    public Professor(String cadastro, CPF cpf, String nome, LocalDate dataNascimento, LocalDate dataCadastro) {
        super(cpf, nome, dataNascimento, dataCadastro);
        this.cadastro = cadastro;
        this.turmas = new SimpleSetProperty<>(FXCollections.observableSet(new HashSet<>()));
    }

    public String getCadastro() {
        return this.cadastro;
    }

    public ReadOnlySetProperty<Turma> turmasProperty() {
        return turmas;
    }

    public ObservableSet<Turma> getTurmas() {
        return this.turmas.getValue();
    }

    public boolean addTurma(Turma t) {
        return turmas.add(t);
    }
    
    public boolean remTurma(String codigo) {
        for (Turma t : turmas) {
            if (t.getMateria().getCodigo().equals(codigo)) {
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
