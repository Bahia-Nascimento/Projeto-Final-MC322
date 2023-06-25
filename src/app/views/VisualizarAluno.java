package app.views;

import app.controllers.Controller;
import app.model.Aluno;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class VisualizarAluno extends View<BorderPane> {
	private BorderPane principal;

	VisualizarAluno(Stage stage, ObservableList<Aluno> alunos) {
		super(stage);
		
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
