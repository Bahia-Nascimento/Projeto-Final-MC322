package app.controllers;

import app.views.MenuPrincipal;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuPrincipalController extends Controller<MenuPrincipal> {
	public MenuPrincipalController(MenuPrincipal view) {
		super(view);
	}

	public void atualizarAluno(ActionEvent _e) {
		Stage janelaRA = new Stage();

		BorderPane painel = new BorderPane();

		HBox hb = new HBox(10);
		Label l = new Label("Insira o RA: ");
		TextField tf = new TextField();
		tf.textProperty().addListener((o, textoAntigo, textoNovo) -> {
			if (!textoNovo.chars().allMatch(Character::isDigit) || textoNovo.isEmpty()) {
				tf.setText(textoAntigo);
			}
		});
		l.setLabelFor(tf);

		hb.getChildren().addAll(l, tf);

		HBox botoes = new HBox(10);
		Button botaoConfirmar = new Button("Confirmar");
		botaoConfirmar.setOnAction(e -> {
			
		});
		Button botaoVoltar = new Button("Voltar");
		botoes.getChildren().addAll(botaoVoltar, botaoConfirmar);

		botaoVoltar.setOnAction(this::navigateHome);
		painel.setCenter(hb);
		Scene cena = new Scene(hb, 200, 200);
		janelaRA.setScene(cena);
		janelaRA.show();
	}
}
