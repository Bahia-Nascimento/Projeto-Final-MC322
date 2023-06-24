package app.views;

import app.controllers.Controller;
import app.model.Aluno;
import app.model.Curso;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AtualizarAluno extends View<BorderPane> {
	BorderPane principal;

	public AtualizarAluno(Stage stage, Aluno aluno) {
		super(stage);

		GridPane centro = new GridPane();

		ChoiceBox<Curso> cb = new ChoiceBox<>();
		cb.getItems().addAll(Curso.CIENCIA, Curso.ENGENHARIA);
		cb.setValue(aluno.getCurso());

		centro.addColumn(0, 
				new Label("RA:"),
				new Label("Nome:"),
				new Label("CPF:"),
				new Label("Data de Nascimento:"),
				new Label("Data de Cadastro:"),
				new Label("Curso:"));
		centro.addColumn(1, 
				new Text(aluno.getRa()),
				new Text(aluno.getNome()),
				new Text(aluno.getCpf().valor()),
				new Text(aluno.getDataNascimento().format(Utils.formatadorPadrao)),
				new Text(aluno.getDataCadastro().format(Utils.formatadorPadrao)),
				cb);

		principal = new BorderPane(centro);
	}

	@Override
	public BorderPane getNode() {
		return principal;
	}

	@Override
	public Controller<? extends View<BorderPane>> getController() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getController'");
	}
}
