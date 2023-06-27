package app.views;

import java.time.LocalDate;

import app.Utils;
import app.controllers.VisualizarProfessorController;
import app.model.Professor;
import app.model.Turma;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
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

public class VisualizarProfessor extends View<BorderPane> {
	

	private BorderPane principal;
	private VisualizarProfessorController controller;

	private static SimpleStringProperty getDateStringProperty(LocalDate data) {
		return new SimpleStringProperty(data.format(Utils.formatadorPadrao));
	}

	private static ChangeListener<? super LocalDate> getDateListener(SimpleStringProperty s) {
		return (observable, oldData, newData) -> {
			s.setValue(newData.format(Utils.formatadorPadrao));
		};
	}

	private ObservableList<Professor> professores;

	public VisualizarProfessor(Stage stage, ObservableList<Professor> professores) {
		super(stage);
		this.professores = professores;
		controller = new VisualizarProfessorController(this);
		stage.getIcons().add(new Image("resources/img/iComp_logo.png"));

		TableView<Professor> tabela = construirTabela();

		ListView<Turma> listaTurmas = new ListView<>();
		listaTurmas.setOrientation(Orientation.VERTICAL);
		listaTurmas.setCellFactory(lv -> new TurmaListCell());

		tabela.getSelectionModel().selectedItemProperty().addListener((observable, oldProfessor, newProfessor) -> {
			var lista = FXCollections.observableArrayList(newProfessor.getTurmas());
			lista.sort((m1, m2) -> m1.getCodigo().compareTo(m2.getCodigo()));
			listaTurmas.setItems(lista);
		});

		VBox centro = new VBox(10, tabela, new Label("Turmas lecionadas"), listaTurmas);
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

	private TableView<Professor> construirTabela() {
		TableColumn<Professor, String> colunaCadastro = new TableColumn<>("Cadastro");
		colunaCadastro.setCellValueFactory(new PropertyValueFactory<>("Cadastro"));

		TableColumn<Professor, String> colunaCpf = new TableColumn<>("CPF");
		colunaCpf.setCellValueFactory(cdf -> {
			return cdf.getValue().getCpf().valor();
		});

		TableColumn<Professor, String> colunaNome = new TableColumn<>("Nome");
		colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

		TableColumn<Professor, String> colunaDataNascimento = new TableColumn<>("Data de Nascimento");
		colunaDataNascimento.setCellValueFactory(cdf -> {
			SimpleStringProperty s = getDateStringProperty(cdf.getValue().getDataNascimento());
			cdf.getValue().dataNascimentoProperty().addListener(getDateListener(s));
			return s;
		});

		TableColumn<Professor, String> colunaDataCadastro = new TableColumn<>("Data de Cadastro");
		colunaDataCadastro.setCellValueFactory(cdf -> {
			SimpleStringProperty s = getDateStringProperty(cdf.getValue().getDataCadastro());
			cdf.getValue().dataNascimentoProperty().addListener(getDateListener(s));
			return s;
		});


		TableView<Professor> tabela = new TableView<>(professores);
		tabela.getColumns().addAll(colunaCadastro, colunaCpf, colunaNome, colunaDataNascimento, colunaDataCadastro);
		tabela.setMaxSize(0.95 * stage.getWidth(), 0.95 * stage.getHeight());
		return tabela;
	}

	@Override
	public BorderPane getNode() {
		return principal;
	}

	@Override
	public VisualizarProfessorController getController() {
		return controller;
	}

}
