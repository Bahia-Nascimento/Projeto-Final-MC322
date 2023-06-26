package app.views;

import app.App;
import app.Utils;
import app.controllers.AtualizarAlunoController;
import app.model.Aluno;
import app.model.Curso;
import app.model.Materia;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.SetChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
		var grades = FXCollections.observableArrayList(aluno.gradeProperty());
		ListView<Materia> listaGrade = new ListView<>(grades);
		listaGrade.setOrientation(Orientation.VERTICAL);
		listaGrade.setCellFactory(lv -> new MateriaListCell());

		var completas = FXCollections.observableArrayList(aluno.getCompletas());
		ListView<Materia> listaCompletas = new ListView<>(completas);
		aluno.completasProperty().addListener(new SetChangeListener<Materia>() {
			@Override
			public void onChanged(Change<? extends Materia> change) {
				var added = change.getElementAdded();
				var removed = change.getElementRemoved();
				if (added != null) {
					if (!completas.contains(added))
						completas.add(added);
				} else if (removed != null) {
					if (completas.contains(removed))
						completas.remove(removed);
				}
				completas.sort((g1, g2) -> g1.getCodigo().compareTo(g2.getCodigo()));
				grades.sort((g1, g2) -> g1.getCodigo().compareTo(g2.getCodigo()));
			}
		});
		aluno.gradeProperty().addListener(new SetChangeListener<Materia>() {
			@Override
			public void onChanged(Change<? extends Materia> change) {
				var added = change.getElementAdded();
				var removed = change.getElementRemoved();
				if (added != null) {
					if (!grades.contains(added))
						grades.add(added);
				} else if (removed != null) {
					if (grades.contains(removed))
						grades.remove(removed);
				}
				completas.sort((g1, g2) -> g1.getCodigo().compareTo(g2.getCodigo()));
				grades.sort((g1, g2) -> g1.getCodigo().compareTo(g2.getCodigo()));
			}
		});
		listaCompletas.setOrientation(Orientation.VERTICAL);
		listaCompletas.setCellFactory(lv -> new MateriaListCell());

		Button botaoPraDireita = new Button("🠖");
		botaoPraDireita.setOnAction(e -> {
			var selecionado = listaGrade.getSelectionModel().getSelectedItem();
			System.out.println(selecionado);
			System.out.println(selecionado != null);
			if (selecionado != null) {
				System.out.println("sfsfiosfhd");
				aluno.eliminarMateria(selecionado.getCodigo());
			}
		});
		Button botaoPraEsquerda = new Button("\u2190");
		botaoPraEsquerda.setOnAction(e -> {
			var selecionado = listaCompletas.getSelectionModel().getSelectedItem();
			System.out.println(selecionado);
			System.out.println(selecionado != null);
			if (selecionado != null) {
				System.out.println("sfsfiosfhd");
				aluno.completasProperty().remove(selecionado);
				aluno.gradeProperty().add(selecionado);
			}
		});
		VBox botoes = new VBox(5, botaoPraDireita, botaoPraEsquerda);

		HBox listas = new HBox(20, listaGrade, botoes, listaCompletas);

		Button botaoVoltar = new Button("Voltar");
		botaoVoltar.setMinHeight(20);
		botaoVoltar.setOnAction(e -> {
			System.out.println("seu");
			System.out.println(App.scene);
			System.out.println(principal.getScene());
			App.scene = new Scene(new MenuPrincipal(stage).getNode(), 1000, 700);
			stage.setScene(App.scene);
			stage.show();
			e.consume();
		});
		Button botaoVoltar2 = Utils.criarBotao("Voltar");
		botaoVoltar2.setOnAction(controller::navigateHome);
		HBox base = new HBox(10);
		base.getChildren().addAll(botaoVoltar, botaoVoltar2);
		base.setMinHeight(15);
		botaoVoltar.setPrefWidth(100);
		HBox.setMargin(botaoVoltar, new Insets(10, 0, 50, 0));

		principal = new BorderPane(new VBox(10, centro, listas));
		principal.setBottom(base);
		base.setAlignment(Pos.TOP_CENTER);
	}

	@Override
	public BorderPane getNode() {
		return principal;
	}

	@Override
	public AtualizarAlunoController getController() {
		return controller;
	}
}
