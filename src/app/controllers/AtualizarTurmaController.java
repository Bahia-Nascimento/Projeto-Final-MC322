package app.controllers;

import app.model.Aluno;
import app.model.Faculdade;
import app.model.Professor;
import app.model.TurmaModel;
import app.model.Validacao;
import app.views.AtualizarTurma;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AtualizarTurmaController extends Controller<AtualizarTurma> {

	private TurmaModel model;

	public AtualizarTurmaController(AtualizarTurma view) {
		super(view);
		model = TurmaModel.getInstance();
		model.hashCode();
	}
	
	public void professorTf(String cadastroProfessor, String horario, Aluno alunoARemover) {
		boolean horarioValido = Validacao.validarHorario(horario);
		Professor prof = Faculdade.getIC().getProfessores().get(cadastroProfessor);
		if (horarioValido && prof != null) {
			view.getTurma().setHorario(horario);
			view.getTurma().setProfessor(prof);
		} else {
			String texto = "";
			if (!horarioValido) {
				texto += "Horário " + horario + " inválido.\n";
			}
			if (prof == null) {
				texto += "Professor com cadastro " + cadastroProfessor + " não existe.";
			}
			Stage janelaErro = new Stage();
			Label textoErro = new Label(texto);
			textoErro.setWrapText(true);
			textoErro.setAlignment(Pos.TOP_LEFT);
			Button botaoOk = new Button("ok");
			botaoOk.setAlignment(Pos.BASELINE_CENTER);
			botaoOk.setOnAction(e -> janelaErro.close());
			VBox root = new VBox(5, textoErro, botaoOk);
			Scene cenaErro = new Scene(root, 200, 100);
			janelaErro.setScene(cenaErro);
			janelaErro.setTitle("iComp - Erro ao atualizar turma " + view.getTurma().getCodigo());
			janelaErro.show();
		}
		if (alunoARemover != null) {
			view.getTurma().remAluno(alunoARemover.getRa());
		}
	}
}
