import java.time.LocalDate;

public abstract class Pessoa {
    private String cpf;
    private String nome;
    private final LocalDate dataNascimento;
    private final LocalDate dataCadastro;


    public Pessoa(String cpf, String nome, LocalDate dataNascimento, LocalDate dataCadastro) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = dataCadastro;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public LocalDate getDataCadastro() {
        return this.dataCadastro;
    }

    public String toString() {
        return "cpf: " + getCpf() +
            ", nome: " + getNome() +
            ", dataNascimento: " + getDataNascimento() +
            ", dataCadastro: " + getDataCadastro();
    }
    
    public abstract String getCadastro();

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
