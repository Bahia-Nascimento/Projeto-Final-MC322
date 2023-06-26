package app.model;
import java.time.LocalDate;

import javafx.beans.property.SimpleObjectProperty;

public abstract class Pessoa {
    private final CPF cpf;
    private String nome;

    private final SimpleObjectProperty<LocalDate> dataNascimento;
    private final SimpleObjectProperty<LocalDate> dataCadastro;


    public Pessoa(CPF cpf, String nome, LocalDate dataNascimento, LocalDate dataCadastro) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = new SimpleObjectProperty<>(dataNascimento);
        this.dataCadastro = new SimpleObjectProperty<LocalDate>(dataCadastro);
    }

    public CPF getCpf() {
        return cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public SimpleObjectProperty<LocalDate> dataNascimentoProperty() {
        return dataNascimento;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento.getValue();
    }

    public SimpleObjectProperty<LocalDate> dataCadastroProperty() {
        return dataNascimento;
    }

    public LocalDate getDataCadastro() {
        return this.dataCadastro.getValue();
    }
    
    public abstract String getCadastro();
    
    public String toString() {
        return "cpf: " + getCpf() +
            ", nome: " + getNome() +
            ", dataNascimento: " + getDataNascimento() +
            ", dataCadastro: " + getDataCadastro();
    }
    
    

    @Override
    public int hashCode() {
        return cpf.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }
}
