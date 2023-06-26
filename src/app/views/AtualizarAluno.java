package app.views;

import app.Utils;
import app.controllers.AtualizarAlunoController;
import app.controllers.Controller;
import app.model.Aluno;
import app.model.Curso;
import app.model.Materia;
import javafx.collections.FXCollections;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AtualizarAluno extends View<BorderPane> {
	BorderPane principal;
	AtualizarAlunoController controller;

	public AtualizarAluno(Stage stage, Aluno aluno) {
		super(stage);
		controller = new AtualizarAlunoController(this);

		GridPane centro = new GridPane();
		centro.setAlignment(Pos.CENTER);
		centro.setHgap(10);
		centro.setVgap(5);

		ChoiceBox<Curso> cursoSelecionado = new ChoiceBox<>();
		cursoSelecionado.getItems().addAll(Curso.CIENCIA, Curso.ENGENHARIA);
		cursoSelecionado.setValue(aluno.getCurso());

		centro.addColumn(0,
				new Label("RA:"),
				new Label("Nome:"),
				new Label("CPF:"),
				new Label("Data de Nascimento:"),
				new Label("Data de Cadastro:"),
				new Label("Curso:"));
		centro.addColumn(1,
				new Text(aluno.getRa()),
				new Text(aluno.getNome()),
				new Text(aluno.getCpf().getValor()),
				new Text(aluno.getDataNascimento().format(Utils.formatadorPadrao)),
				new Text(aluno.getDataCadastro().format(Utils.formatadorPadrao)),
				cursoSelecionado);
		cursoSelecionado.getSelectionModel().selectedItemProperty().addListener((o, old, newCurso) -> {
			aluno.setCurso(newCurso);
		});
		centro.setAlignment(Pos.CENTER);
		centro.setHgap(10);
		centro.setVgap(5);

		ListView<Materia> listaGrade = new ListView<>(FXCollections.observableArrayList(aluno.getGrade()));
		listaGrade.setOrientation(Orientation.VERTICAL);
		listaGrade.setCellFactory(lv -> new MateriaListCell());

		ListView<Materia> listaCompletas = new ListView<>(FXCollections.observableArrayList(aluno.getCompletas()));
		listaCompletas.setOrientation(Orientation.VERTICAL);
		listaCompletas.setCellFactory(lv -> new MateriaListCell());

		Button botaoPraDireita = new Button("🠖");
		botaoPraDireita.setOnAction(e -> {
			var selecionado = listaGrade.getSelectionModel().getSelectedItem();
			if (selecionado != null) {
				aluno.getGrade().remove(selecionado);
				aluno.getCompletas().add(selecionado);
			}
		});
		Button botaoPraEsquerda = new Button(" \u1F814");
		botaoPraEsquerda.setOnAction(e -> {
			var selecionado = listaCompletas.getSelectionModel().getSelectedItem();
			if (selecionado != null) {
				aluno.getGrade().remove(selecionado);
				aluno.getCompletas().add(selecionado);
			}
		});
		VBox botoes = new VBox(5, botaoPraDireita, botaoPraEsquerda);

		HBox listas = new HBox(20, listaGrade, botoes, listaCompletas);

		Button botaoVoltar = Utils.criarBotao("Voltar");
		botaoVoltar.setOnAction(controller::navigateHome);
		HBox base = new HBox(10, botaoVoltar);
		base.setAlignment(Pos.BASELINE_CENTER);

		principal = new BorderPane(new VBox(10, centro));
		principal.setBottom(base);
	}

	@Override
	public BorderPane getNode() {
		return principal;
	}

	@Override
	public Controller<? extends View<BorderPane>> getController() {
		return controller;
	}
}
