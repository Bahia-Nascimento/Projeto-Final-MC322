package app.views;

import app.Utils;
import app.controllers.Controller;
import app.model.Professor;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AtualizarProfessor extends View<BorderPane> {
	BorderPane principal;

	public AtualizarProfessor(Stage stage, Professor professor) {
		super(stage);

		GridPane centro = new GridPane();

		centro.addColumn(0, 
				new Label("Cadastro:"),
				new Label("Nome:"),
				new Label("CPF:"),
				new Label("Data de Nascimento:"),
				new Label("Data de Cadastro:"));
		centro.addColumn(1, 
				new Text(professor.getCadastro()),
				new Text(professor.getNome()),
				new Text(professor.getCpf().valor()),
				new Text(professor.getDataNascimento().format(Utils.formatadorPadrao)),
				new Text(professor.getDataCadastro().format(Utils.formatadorPadrao)));

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
