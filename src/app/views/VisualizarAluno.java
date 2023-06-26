package app.views;

import java.time.LocalDate;

import app.Utils;
import app.controllers.VisualizarAlunoController;
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

public class VisualizarAluno extends View<BorderPane> {
	
	private BorderPane principal;
	private VisualizarAlunoController controller;

	private static SimpleStringProperty getDateStringProperty(LocalDate data) {
		return new SimpleStringProperty(data.format(Utils.formatadorPadrao));
	}

	private static ChangeListener<? super LocalDate> getDateListener(SimpleStringProperty s) {
		return (observable, oldData, newData) -> {
			s.setValue(newData.format(Utils.formatadorPadrao));
		};
	}

	private ObservableList<Aluno> alunos;

	public VisualizarAluno(Stage stage, ObservableList<Aluno> alunos) {
		super(stage);
		this.alunos = alunos;
		controller = new VisualizarAlunoController(this);

		TableView<Aluno> tabela = construirTabela();

		ListView<Materia> listaGrade = new ListView<>();
		listaGrade.setOrientation(Orientation.VERTICAL);
		listaGrade.setCellFactory(lv -> new MateriaListCell());

		tabela.getSelectionModel().selectedItemProperty().addListener((observable, oldAluno, newAluno) -> {
			var lista = FXCollections.observableArrayList(newAluno.getGrade());
			lista.sort((m1, m2) -> m1.getCodigo().compareTo(m2.getCodigo()));
			listaGrade.getItems().setAll(lista);
		});

		ListView<Materia> listaCompletas = new ListView<>();
		listaCompletas.setOrientation(Orientation.VERTICAL);
		listaCompletas.setCellFactory(lv -> new MateriaListCell());

		tabela.getSelectionModel().selectedItemProperty().addListener((observable, oldAluno, newAluno) -> {
			var lista = FXCollections.observableArrayList(newAluno.getCompletas());
			lista.sort((m1, m2) -> m1.getCodigo().compareTo(m2.getCodigo()));
			listaCompletas.setItems(lista);
		});

		VBox centro = new VBox(10, tabela, new Label("Matérias concluídas"), listaCompletas);
		centro.setAlignment(Pos.CENTER);
		VBox.setMargin(tabela, new Insets(50));
		VBox.setMargin(listaCompletas, new Insets(50));

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

	private TableView<Aluno> construirTabela() {
		TableColumn<Aluno, String> colunaRa = new TableColumn<>("RA");
		colunaRa.setCellValueFactory(new PropertyValueFactory<>("ra"));

		TableColumn<Aluno, String> colunaCpf = new TableColumn<>("CPF");
		colunaCpf.setCellValueFactory(cdf -> {
			return cdf.getValue().getCpf().valor();
		});

		TableColumn<Aluno, String> colunaNome = new TableColumn<>("Nome");
		colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

		TableColumn<Aluno, String> colunaDataNascimento = new TableColumn<>("Data de Nascimento");
		colunaDataNascimento.setCellValueFactory(cdf -> {
			SimpleStringProperty s = getDateStringProperty(cdf.getValue().getDataNascimento());
			cdf.getValue().dataNascimentoProperty().addListener(getDateListener(s));
			return s;
		});

		TableColumn<Aluno, String> colunaDataCadastro = new TableColumn<>("Data de Cadastro");
		colunaDataCadastro.setCellValueFactory(cdf -> {
			SimpleStringProperty s = getDateStringProperty(cdf.getValue().getDataCadastro());
			cdf.getValue().dataNascimentoProperty().addListener(getDateListener(s));
			return s;
		});

		TableColumn<Aluno, String> colunaCurso = new TableColumn<>("Curso");
		colunaCurso.setCellValueFactory(cdf -> {
			SimpleStringProperty s = new SimpleStringProperty(cdf.getValue().getCurso().nomeCurto());
			cdf.getValue().cursoProperty().addListener((observable, oldCurso, newCurso) -> {
				s.setValue(newCurso.nomeCurto());
			});
			return s;
		});

		TableView<Aluno> tabela = new TableView<>(alunos);
		tabela.getColumns().addAll(colunaRa, colunaCpf, colunaNome, colunaDataNascimento, colunaDataCadastro,
				colunaCurso);
		tabela.setMaxSize(0.95 * stage.getWidth(), 0.95 * stage.getHeight());
		return tabela;
	}

	@Override
	public BorderPane getNode() {
		return principal;
	}

	@Override
	public VisualizarAlunoController getController() {
		return controller;
	}

}