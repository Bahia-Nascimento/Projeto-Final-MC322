package app.views;

import app.Utils;
import app.controllers.AtualizarProfessorController;
import app.model.Faculdade;
import app.model.Professor;
import app.model.Turma;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.SetChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AtualizarProfessor extends View<BorderPane> {
	BorderPane principal;
	AtualizarProfessorController controller;

	public AtualizarProfessor(Stage stage, Professor professor) {
		super(stage);
		controller = new AtualizarProfessorController(this);
		stage.getIcons().add(new Image("resources/img/iComp_logo.png"));

		GridPane centro = new GridPane();

		centro.addColumn(0,
				new Label("Cadastro:"),
				new Label("Nome:"),
				new Label("CPF:"),
				new Label("Data de Nascimento:"),
				new Label("Data de Cadastro:"));
		centro.addColumn(1,
				new Text(professor.getCadastro()),
				new Text(professor.getNome()),
				new Text(professor.getCpf().getValor()),
				new Text(professor.getDataNascimento().format(Utils.formatadorPadrao)),
				new Text(professor.getDataCadastro().format(Utils.formatadorPadrao)));

		ObservableList<Turma> turmasProf = FXCollections.observableArrayList(professor.turmasProperty());
		professor.turmasProperty().addListener(new SetChangeListener<Turma>() {
			@Override
			public void onChanged(Change<? extends Turma> change) {

			}

		});
		ListView<Turma> listaTurmasProf = new ListView<>(turmasProf);
		listaTurmasProf.setCellFactory(a -> new TurmaListCell());
		listaTurmasProf.selectionModelProperty();

		ObservableList<Turma> turmas = FXCollections.observableArrayList(Faculdade.getIC().getTurmas().values());
		

		Button botaoVoltar = new Button("Voltar");
		botaoVoltar.setMinHeight(20);
		botaoVoltar.setOnAction(controller::navigateHome);
		HBox base = new HBox(10);
		base.getChildren().addAll(botaoVoltar);
		base.setMinHeight(15);
		botaoVoltar.setPrefWidth(100);
		HBox.setMargin(botaoVoltar, new Insets(10, 0, 50, 0));

		centro.setAlignment(Pos.CENTER);
		principal = new BorderPane(centro);
		principal.setBottom(base);
		base.setAlignment(Pos.TOP_CENTER);
	}

	@Override
	public BorderPane getNode() {
		return principal;
	}

	@Override
	public AtualizarProfessorController getController() {
		return controller;
	}
}
