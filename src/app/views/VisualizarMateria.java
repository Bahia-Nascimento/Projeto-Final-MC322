package app.views;

import app.controllers.VisualizarMateriaController;
import app.model.Materia;
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
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VisualizarMateria extends View<BorderPane> {

	private BorderPane principal;
	private VisualizarMateriaController controller;

	private ObservableList<Materia> materias;

	public VisualizarMateria(Stage stage, ObservableList<Materia> materias) {
		super(stage);
		this.materias = materias;
		controller = new VisualizarMateriaController(this);
		stage.getIcons().add(new Image("resources/img/iComp_logo.png"));

		TableView<Materia> tabela = construirTabela();

		ListView<Turma> listaTurmas = new ListView<>();
		listaTurmas.setOrientation(Orientation.VERTICAL);
		listaTurmas.setCellFactory(lv -> new TurmaListCell());

		tabela.getSelectionModel().selectedItemProperty().addListener((observable, oldMateria, newMateria) -> {
			var lista = FXCollections.observableArrayList(newMateria.getTurmas());
			lista.sort((m1, m2) -> m1.getCodigo().compareTo(m2.getCodigo()));
			listaTurmas.setItems(lista);
		});

		VBox centro = new VBox(10, tabela, new Label("Turmas: "), listaTurmas);
		centro.setAlignment(Pos.CENTER);
		VBox.setMargin(tabela, new Insets(50));
		VBox.setMargin(listaTurmas, new Insets(50));

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

	private TableView<Materia> construirTabela() {
		TableColumn<Materia, String> colunaCodigo = new TableColumn<>("Código");
		colunaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));

		TableColumn<Materia, String> colunaCreditos = new TableColumn<>("Créditos");
		colunaCreditos.setCellValueFactory(new PropertyValueFactory<>("creditos"));

		TableColumn<Materia, String> colunaRequisitos = new TableColumn<>("Requisitos");
		colunaRequisitos.setCellValueFactory(cdf->{
			return cdf.getValue().reqToString();
		});



		TableView<Materia> tabela = new TableView<>(materias);
		tabela.getColumns().addAll(colunaCodigo, colunaCreditos, colunaRequisitos);
		tabela.setMaxSize(0.95 * stage.getWidth(), 0.95 * stage.getHeight());
		return tabela;
	}

	@Override
	public BorderPane getNode() {
		return principal;
	}

	@Override
	public VisualizarMateriaController getController() {
		return controller;
	}

}
