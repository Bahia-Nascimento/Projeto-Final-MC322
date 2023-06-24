package app.controllers;

import app.model.Aluno;
import app.model.AlunosModel;
import app.views.AtualizarAluno;
import app.views.MenuPrincipal;
import app.views.View;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MenuPrincipalController extends Controller<MenuPrincipal> {
	private AlunosModel model;

	public MenuPrincipalController(MenuPrincipal view) {
		super(view);
		model = AlunosModel.getInstance();
	}

	public void atualizarAluno(ActionEvent _e, Stage stage) {
		Stage janelaRA = new Stage();

		Label l = new Label("Insira o RA: ");
		TextField tf = new TextField();
		tf.textProperty().addListener((o, textoAntigo, textoNovo) -> {
			if (!textoNovo.chars().allMatch(Character::isDigit) || textoNovo.isEmpty()) {
				tf.setText(textoAntigo);
			}
		});
		l.setLabelFor(tf);

		HBox centro = new HBox(10);
		centro.getChildren().addAll(l, tf);

		HBox botoes = new HBox(10);
		Button botaoConfirmar = new Button("Confirmar");
		botaoConfirmar.setOnAction(e -> {
			Aluno alunoSelecionado = model.alunosProperty().get(tf.getText());
			if (alunoSelecionado != null) {
				var aa = new AtualizarAluno(janelaRA, alunoSelecionado);
				Parent a = aa.getNode();
				Scene cena = new Scene(a, 500, 500);
				janelaRA.close();
				boolean maximize = stage.isMaximized();
				stage.setScene(cena);
				stage.setMaximized(maximize);
			}
		});
		Button botaoVoltar = new Button("Cancelar");
		botaoVoltar.setOnAction(e -> janelaRA.close());

		botoes.getChildren().addAll(botaoVoltar, botaoConfirmar);

		BorderPane painel = new BorderPane(centro);
		painel.setBottom(botoes);
		Scene cena = new Scene(painel, 200, 200);
		janelaRA.setScene(cena);
		janelaRA.show();
	}
}
