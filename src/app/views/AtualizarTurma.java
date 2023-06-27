package app.views;

import app.controllers.AtualizarTurmaController;
import app.model.Turma;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AtualizarTurma extends View<BorderPane> {
	BorderPane principal;
	AtualizarTurmaController controller;
	private Turma turma;

	public AtualizarTurma(Stage stage, Turma turma) {
		super(stage);
		controller = new AtualizarTurmaController(this);
		this.turma = turma;
		GridPane centro = new GridPane();

		TextField tfProfessor = new TextField(turma.getProfessor().getCadastro());
		TextField tHorario = new TextField(turma.getHorario());
		centro.addColumn(0,
				new Label("Código:"),
				new Label("Horário"),
				new Label("Professor:"));
		centro.addColumn(1,
				new Text(turma.getMateria().getCodigo()),
				tHorario,
				tfProfessor);

		Button botaoConfirmar = new Button("Confirmar mudanças.");
		botaoConfirmar.setMinHeight(20);
		botaoConfirmar.setOnAction(e -> controller.professorTf(tfProfessor.getText(), tHorario.getText()));

		Button botaoVoltar = new Button("Voltar");
		botaoVoltar.setMinHeight(20);
		botaoVoltar.setOnAction(controller::navigateHome);
		HBox base = new HBox(10);
		base.getChildren().addAll(botaoVoltar, botaoConfirmar);
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

	public Turma getTurma() {
		return turma;
	}
}