import java.time.LocalDate;
import java.util.ArrayList;

public class Professor extends Pessoa{
    private final String cadastro;
    private ArrayList<Turma> listaTurmas;


    public Professor(String cadastro, ArrayList<Turma> listaTurmas, String cpf, String nome, LocalDate dataNascimento, LocalDate dataCadastro) {
        super(cpf, nome, dataNascimento, dataCadastro);
        this.cadastro = cadastro;
        this.listaTurmas = new ArrayList<Turma>();
    }

    public String getCadastro() {
        return this.cadastro;
    }

    public ArrayList<Turma> getListaTurmas() {
        return this.listaTurmas;
    }

    public void addTurma() {

    }

    public void remTurma() {
        
    }
    
}
