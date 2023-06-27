package app.views;

import app.controllers.AtualizarTurmaController;
import app.model.Turma;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AtualizarTurma extends View<BorderPane> {
	BorderPane principal;
	AtualizarTurmaController controller;

	public AtualizarTurma(Stage stage, Turma turma) {
		super(stage);
		controller = new AtualizarTurmaController(this);
		stage.getIcons().add(new Image("resources/img/iComp_logo.png"));

		GridPane centro = new GridPane();

		centro.addColumn(0,
				new Label("Código:"),
				new Label("Horário"),
				new Label("Professor:"),
				new Label("Lista de Alunos:"));
		centro.addColumn(1, 
				new Text(turma.getMateria().getCodigo()),
				new Text(turma.getHorario()),
				new Text(turma.getProfessor().getNome()));
				//new Text(toString(turma.getListaAlunos())));

				Button botaoVoltar = new Button("Voltar");
				botaoVoltar.setMinHeight(20);
				botaoVoltar.setOnAction(controller::navigateHome);
				HBox base = new HBox(10);
				base.getChildren().addAll(botaoVoltar);
				base.setMinHeight(15);
				botaoVoltar.setPrefWidth(100);
				HBox.setMargin(botaoVoltar, new Insets(10, 0, 50, 0));
		
				principal = new BorderPane(centro);
				principal.setBottom(base);
				base.setAlignment(Pos.TOP_CENTER);
	}

	@Override
	public BorderPane getNode() {
		return principal;
	}

	@Override
	public AtualizarTurmaController getController() {
		return controller;
	}
}