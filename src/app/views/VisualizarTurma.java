package app.views;


import app.controllers.VisualizarTurmaController;
import app.model.Aluno;
import app.model.Professor;
import app.model.Turma;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VisualizarTurma extends View<BorderPane> {
	

	private BorderPane principal;
	private VisualizarTurmaController controller;


	private ObservableList<Turma> turmas;

	public VisualizarTurma(Stage stage, ObservableList<Turma> turmas) {
		super(stage);
		this.turmas = turmas;
		controller = new VisualizarTurmaController(this);

		TableView<Turma> tabela = construirTabela();

		ListView<Aluno> listaAlunos = new ListView<>();
		listaAlunos.setOrientation(Orientation.VERTICAL);
		listaAlunos.setCellFactory(lv -> new AlunoListCell());

		tabela.getSelectionModel().selectedItemProperty().addListener((observable, oldTurma, newTurma) -> {
			var lista = FXCollections.observableArrayList(newTurma.getListaAlunos());
			lista.sort((m1, m2) -> m1.getRa().compareTo(m2.getRa()));
			listaAlunos.setItems(lista);
		});

		VBox centro = new VBox(10, tabela, new Label("Alunos matriculados"), listaAlunos);
		centro.setAlignment(Pos.CENTER);
		VBox.setMargin(tabela, new Insets(50));
		VBox.setMargin(listaAlunos, new Insets(50));

		Button botaoVoltar = new Button("Voltar");
		botaoVoltar.setMinHeight(20);
		botaoVoltar.setOnAction(controller::navigateHome);
		HBox base = new HBox(10);
		base.getChildren().addAll(botaoVoltar);
		base.setMinHeight(15);
		botaoVoltar.setPrefWidth(100);;
		HBox.setMargin(botaoVoltar, new Insets(10, 0, 50, 0));

		principal = new BorderPane(centro);
		principal.setBottom(base);
		base.setAlignment(Pos.TOP_CENTER);
		// principal.getStylesheets().setAll("resources/css/visualizar-aluno.css");
	}

	private TableView<Turma> construirTabela() {
		TableColumn<Turma, String> colunaCodigo = new TableColumn<>("Codigo");
		colunaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));

		TableColumn<Turma, String> colunaProfessor = new TableColumn<>("Professor");
		colunaProfessor.setCellValueFactory(cdf -> {
			return cdf.getValue().getProfessor().nomeProperty();
		});

		TableColumn<Turma, String> colunaHorario = new TableColumn<>("Horario");
		colunaHorario.setCellValueFactory(new PropertyValueFactory<>("horario"));


		TableView<Turma> tabela = new TableView<>(turmas);
		tabela.getColumns().addAll(colunaCodigo, colunaProfessor, colunaHorario);
		tabela.setMaxSize(0.95 * stage.getWidth(), 0.95 * stage.getHeight());
		return tabela;
	}

	@Override
	public BorderPane getNode() {
		return principal;
	}

	@Override
	public VisualizarTurmaController getController() {
		return controller;
	}

}
