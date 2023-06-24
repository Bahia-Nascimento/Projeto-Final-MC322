package app.views;

import app.controllers.Controller;
import javafx.scene.Node;
import javafx.stage.Stage;

public abstract class View<T extends Node> {
	protected Stage stage;
	View(Stage stage) {
		this.stage = stage;
	}

	public abstract T getNode();

	public abstract Controller<? extends View<T>> getController();
	
	public Stage getStage() {
		return stage;
	}

}
