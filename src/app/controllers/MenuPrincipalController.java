package app.controllers;

import app.App;
import app.views.AtualizarAluno;
import app.views.MenuPrincipal;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MenuPrincipalController extends Controller<MenuPrincipal> {
	public MenuPrincipalController(MenuPrincipal view) {
		super(view);
	}

	public void atualizarAluno(ActionEvent e) {
		Stage janelaRA = new Stage();
		VBox vb = new VBox(20);
		HBox hb = new HBox(10);
		Label l = new Label("Insira o RA: ");
		TextField tf = new TextField();
		l.setLabelFor(tf);
		hb.getChildren().addAll(l, tf);
		vb.getChildren().add(hb);
		Scene cena = new Scene(hb);
		view.getStage();
	}
}
