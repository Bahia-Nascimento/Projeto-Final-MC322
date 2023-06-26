package app.views;

import java.time.LocalDate;

import app.Utils;
import app.controllers.VisualizarProfessorController;
import app.model.Professor;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

		TableView<Professor> tabela = construirTabela();

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

	private TableView<Professor> construirTabela() {
		TableColumn<Professor, String> colunaRa = new TableColumn<>("Cadastro");
		colunaRa.setCellValueFactory(new PropertyValueFactory<>("cadastro"));

		TableColumn<Professor, String> colunaCpf = new TableColumn<>("CPF");
		colunaCpf.setCellValueFactory(cpf -> {
			return cpf.getValue().getCpf().valor();
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
		tabela.getColumns().addAll(colunaRa, colunaCpf, colunaNome, colunaDataNascimento, colunaDataCadastro);
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