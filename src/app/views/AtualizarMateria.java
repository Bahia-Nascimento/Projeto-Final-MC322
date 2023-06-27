package app.views;

import app.controllers.Controller;
import app.model.Materia;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AtualizarMateria extends View<BorderPane> {
	BorderPane principal;

	public AtualizarMateria(Stage stage, Materia materia) {
		super(stage);
		stage.getIcons().add(new Image("resources/img/iComp_logo.png"));
		
		GridPane centro = new GridPane();

		centro.addColumn(0, 
				new Label("Codigo:"),
				new Label("Créditos:"),
				new Label("Requisitos:"));
		centro.addColumn(1, 
				new Text(materia.getCodigo()),
				new Text(Integer.toString(materia.getCreditos())));
				//new Text(materia.getRequisitos()));

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
