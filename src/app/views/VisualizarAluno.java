package app.views;

import java.time.LocalDate;

import app.Utils;
import app.controllers.Controller;
import app.model.Aluno;
import app.model.CPF;
import app.model.Curso;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class VisualizarAluno extends View<BorderPane> {
	private BorderPane principal;

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

		TableView<Aluno> tabela = construirTabela();
		principal = new BorderPane(tabela);
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
		return tabela;
	}

	@Override
	public BorderPane getNode() {
		return principal;
	}

	@Override
	public Controller<? extends View<BorderPane>> getController() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getController'");
	}

}
