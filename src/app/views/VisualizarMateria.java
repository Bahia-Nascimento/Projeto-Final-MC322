package app.views;

import java.time.LocalDate;

import app.Utils;
import app.controllers.VisualizarAlunoController;
import app.controllers.VisualizarMateriaController;
import app.model.Aluno;
import app.model.Materia;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VisualizarMateria extends View<BorderPane> {
	
	private BorderPane principal;
	private VisualizarMateriaController controller;

	private static SimpleStringProperty getDateStringProperty(LocalDate data) {
		return new SimpleStringProperty(data.format(Utils.formatadorPadrao));
	}

	private static ChangeListener<? super LocalDate> getDateListener(SimpleStringProperty s) {
		return (observable, oldData, newData) -> {
			s.setValue(newData.format(Utils.formatadorPadrao));
		};
	}

	private ObservableList<Materia> materias;

	public VisualizarMateria(Stage stage, ObservableList<Materia> materias) {
		super(stage);
		this.materias = materias;
		controller = new VisualizarMateriaController(this);

		TableView<Materia> tabela = construirTabela();

		VBox centro = new VBox(10, tabela);
		centro.setAlignment(Pos.CENTER);
		VBox.setMargin(tabela, new Insets(50));

		Button botaoVoltar = new Button("Voltar");
		botaoVoltar.setMinHeight(14);
		botaoVoltar.setOnAction(controller::navigateHome);
		HBox base = new HBox(10);
		base.getChildren().addAll(botaoVoltar);
		base.setMinHeight(15);

		principal = new BorderPane(centro);
		principal.setBottom(base);
		base.setAlignment(Pos.TOP_CENTER);
		// principal.getStylesheets().setAll("resources/css/visualizar-aluno.css");
	}

	private TableView<Materia> construirTabela() {
		TableColumn<Aluno, String> colunaCodigo = new TableColumn<>("Código");
		colunaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));

		TableColumn<Aluno, String> colunaCreditos = new TableColumn<>("Créditos");
		colunaCreditos.setCellValueFactory(new PropertyValueFactory<>("creditos"));

		TableColumn<Aluno, String> colunaRequisitos = new TableColumn<>("Créditos");
		colunaRequisitos.setCellValueFactory(new PropertyValueFactory<>("creditos"));
		};

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