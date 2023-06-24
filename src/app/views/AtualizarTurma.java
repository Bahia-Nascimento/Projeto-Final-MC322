package app.views;

import app.controllers.Controller;
import app.model.Turma;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AtualizarTurma extends View<BorderPane> {
	BorderPane principal;

	public AtualizarTurma(Stage stage, Turma turma) {
		super(stage);

		GridPane centro = new GridPane();

		centro.addColumn(0,
				new Label("Código:"),
				new Label("Professor:"),
				new Label("Lista de Alunos:"));
		centro.addColumn(1, 
				new Text(turma.getMateria().getCodigo()),
				new Text(turma.getProfessor().getNome()));
				//new Text(toString(turma.getListaAlunos())));

		principal = new BorderPane(centro);
	}

	@Override
	public BorderPane getNode() {
		return principal;
	}

	@Override
	public Controller<? extends View<BorderPane>> getController() {
		throw new UnsupportedOperationException("Unimplemented method 'getController'");
	}
}