package app.views;

import app.controllers.Controller;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MenuSuperior extends View<MenuBar> {
	private MenuBar barra;

	MenuSuperior(Stage stage) {
		super(stage);
		ImageView a = new ImageView(new Image("resources/img/logo.jpg"));
		Menu m = new Menu("Home");
		m.setOnAction(getController()::navigateHome);
		barra = new MenuBar(
				new Menu("", a),
				m);
		barra.getStylesheets().add("resources/css/menu-superior.css");
	}

	@Override
	public MenuBar getNode() {
		return barra;
	}

	@Override
	public Controller<? extends View<MenuBar>> getController() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getController'");
	}
}
