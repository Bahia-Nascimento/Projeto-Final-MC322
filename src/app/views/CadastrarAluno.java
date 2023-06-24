package app.views;

import app.controllers.Controller;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CadastrarAluno extends View<BorderPane> {

	private MenuSuperior ms = new MenuSuperior(stage);

	CadastrarAluno(Stage stage) {
		super(stage);
		MenuBar barra = ms.getNode();

		BorderPane principal = new BorderPane();
	}

	@Override
	public BorderPane getNode() {
		throw new UnsupportedOperationException("Unimplemented method 'getNode'");
	}

	@Override
	public Controller<? extends View<BorderPane>> getController() {
		throw new UnsupportedOperationException("Unimplemented method 'getController'");
	}
	
}
