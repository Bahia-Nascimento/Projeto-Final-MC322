package app.views;

import java.time.LocalDate;

import app.controllers.Controller;
import app.model.Aluno;
import app.model.CPF;
import app.model.Curso;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class VisualizarAluno extends View<BorderPane> {
	private BorderPane principal;

	VisualizarAluno(Stage stage, ObservableList<Aluno> alunos) {
		super(stage);
		TableColumn<Aluno, String> colunaRa = new TableColumn<>("RA");
		colunaRa.setCellValueFactory(new PropertyValueFactory<>("ra"));
		TableColumn<Aluno, String> colunaCpf = new TableColumn<>("CPF");
		colunaRa.setCellValueFactory(cdf -> {
			return null;//cdf.getValue().getCpf().valor();
		});
		TableColumn<Aluno, String> colunaNome = new TableColumn<>("Nome");
		TableColumn<Aluno, String> colunaDataNascimento = new TableColumn<>("Data de Nascimento");
		TableColumn<Aluno, String> colunaDataCadastro = new TableColumn<>("Data de Cadastro");
		TableColumn<Aluno, String> colunaCurso = new TableColumn<>("Curso");

		TableView<Aluno> tabela = new TableView<>(alunos);
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
