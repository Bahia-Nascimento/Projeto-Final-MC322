package app.controllers;

import app.App;
import app.model.Aluno;
import app.model.AlunosModel;
import app.model.MateriaModel;
import app.model.Professor;
import app.model.ProfessorModel;
import app.model.Turma;
import app.model.TurmaModel;
import app.views.AtualizarAluno;
import app.views.AtualizarProfessor;
import app.views.AtualizarTurma;
import app.views.MenuPrincipal;
import app.views.VisualizarAluno;
import app.views.VisualizarMateria;
import app.views.VisualizarProfessor;
import app.views.VisualizarTurma;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MenuPrincipalController extends Controller<MenuPrincipal> {
	private AlunosModel model_a;
	private ProfessorModel model_p;
	private TurmaModel model_t;
	private MateriaModel model_m;

	public MenuPrincipalController(MenuPrincipal view) {
		super(view);
		model_a = AlunosModel.getInstance();
		model_p = ProfessorModel.getInstance();
		model_t = TurmaModel.getInstance();
		model_m = MateriaModel.getInstance();
	}

	public void atualizarAluno(ActionEvent _e, Stage stage) {
		Stage janelaRA = new Stage();

		Label l = new Label("Insira o RA: ");
		TextField tf = new TextField();
		tf.textProperty().addListener((o, textoAntigo, textoNovo) -> {
			if (!textoNovo.chars().allMatch(Character::isDigit)) {
				tf.setText(textoAntigo);
			}
		});
		l.setLabelFor(tf);

		HBox centro = new HBox(10);
		centro.getChildren().addAll(l, tf);

		HBox botoes = new HBox(10);
		botoes.setAlignment(Pos.BASELINE_CENTER);

		Button botaoConfirmar = new Button("Confirmar");
		botaoConfirmar.setOnAction(e -> {
			Aluno alunoSelecionado = model_a.alunosProperty().get(tf.getText());
			if (alunoSelecionado != null) {
				var aa = new AtualizarAluno(stage, alunoSelecionado);
				Parent a = aa.getNode();
				Scene cena = new Scene(a, 500, 500);
				cena.getStylesheets().setAll("resources/css/main.css");
				boolean maximize = stage.isMaximized();
				stage.setScene(cena);
				if (maximize) {
					stage.setMaximized(false);
					stage.setMaximized(true);

				}
				janelaRA.close();
			}
		});
		Button botaoVoltar = new Button("Cancelar");
		botaoVoltar.setOnAction(e -> janelaRA.close());

		botoes.getChildren().addAll(botaoVoltar, botaoConfirmar);

		BorderPane painel = new BorderPane(centro);
		painel.setBottom(botoes);
		BorderPane.setMargin(botoes, new Insets(0, 0, 20, 0));

		Scene cena = new Scene(painel, 350, 100);
		cena.getStylesheets().setAll("resources/css/main.css");
		janelaRA.setScene(cena);
		janelaRA.show();
	}

	public void atualizarProfessor(ActionEvent _e, Stage stage) {
		Stage janelaCadastro = new Stage();

		Label l = new Label("Insira o Cadastro do Professor: ");
		TextField tf = new TextField();
		tf.textProperty().addListener((o, textoAntigo, textoNovo) -> {
			if (!textoNovo.chars().allMatch(Character::isDigit) || textoNovo.isEmpty()) {
				tf.setText(textoAntigo);
			}
		});
		l.setLabelFor(tf);

		HBox centro = new HBox(10);
		centro.getChildren().addAll(l, tf);

		HBox botoes = new HBox(10);
		botoes.setAlignment(Pos.BASELINE_CENTER);
		
		Button botaoConfirmar = new Button("Confirmar");
		botaoConfirmar.setOnAction(e -> {
			Professor professorSelecionado = model_p.professorProperty().get(tf.getText());
			if (professorSelecionado != null) {
				var aa = new AtualizarProfessor(stage, professorSelecionado);
				Parent a = aa.getNode();
				Scene cena = new Scene(a, 500, 500);
				cena.getStylesheets().setAll("resources/css/main.css");
				janelaCadastro.close();
				boolean maximize = stage.isMaximized();
				stage.setScene(cena);
				stage.setMaximized(maximize);
			}
		});
		Button botaoVoltar = new Button("Cancelar");
		botaoVoltar.setOnAction(e -> janelaCadastro.close());

		botoes.getChildren().addAll(botaoVoltar, botaoConfirmar);

		BorderPane painel = new BorderPane(centro);
		painel.setBottom(botoes);
		Scene cena = new Scene(painel, 350, 100);
		cena.getStylesheets().setAll("resources/css/main.css");
		janelaCadastro.setScene(cena);
		janelaCadastro.show();
	}

	public void atualizarTurma(ActionEvent _e, Stage stage) {
		Stage janelaCodigo = new Stage();

		Label l = new Label("Insira o Codigo da Matéria: ");
		TextField tf = new TextField();
		l.setLabelFor(tf);

		HBox centro = new HBox(10);
		centro.getChildren().addAll(l, tf);

		HBox botoes = new HBox(10);
		Button botaoConfirmar = new Button("Confirmar");
		botaoConfirmar.setOnAction(e -> {
			Turma turmaSelecionada = model_t.turmaProperty().get(tf.getText());
			if (turmaSelecionada != null) {
				var aa = new AtualizarTurma(stage, turmaSelecionada);
				Parent a = aa.getNode();
				Scene cena = new Scene(a, 500, 500);
				cena.getStylesheets().setAll("resources/css/main.css");
				janelaCodigo.close();
				boolean maximize = stage.isMaximized();
				stage.setScene(cena);
				stage.setMaximized(maximize);
			}
		});
		Button botaoVoltar = new Button("Cancelar");
		botaoVoltar.setOnAction(e -> janelaCodigo.close());

		botoes.getChildren().addAll(botaoVoltar, botaoConfirmar);

		BorderPane painel = new BorderPane(centro);
		painel.setBottom(botoes);
		Scene cena = new Scene(painel, 350, 100);
		cena.getStylesheets().setAll("resources/css/main.css");
		janelaCodigo.setScene(cena);
		janelaCodigo.show();
	}

	public void visualizarAluno(ActionEvent _e) {
		var va = new VisualizarAluno(view.getStage(),
				FXCollections.observableArrayList(model_a.alunosProperty().values()));
		Parent root = va.getNode();
		Scene cena = new Scene(root, App.scene.getWidth(), App.scene.getHeight());
		cena.getStylesheets().setAll("resources/css/main.css");
		view.getStage().setScene(cena);
	}

	public void visualizarProfessor(ActionEvent _e) {
		var vp = new VisualizarProfessor(view.getStage(),
				FXCollections.observableArrayList(model_p.professorProperty().values()));
		Parent root = vp.getNode();
		Scene cena = new Scene(root, App.scene.getWidth(), App.scene.getHeight());
		cena.getStylesheets().setAll("resources/css/main.css");
		view.getStage().setScene(cena);
	}

	public void visualizarMateria(ActionEvent _e) {
		var vm = new VisualizarMateria(view.getStage(),
				FXCollections.observableArrayList(model_m.materiaProperty().values()));
		Parent root = vm.getNode();
		Scene cena = new Scene(root, App.scene.getWidth(), App.scene.getHeight());
        cena.getStylesheets().setAll("resources/css/main.css");
		view.getStage().setScene(cena);
	}

	public void visualizarTurma(ActionEvent _e) {
		var vt = new VisualizarTurma(view.getStage(),
				FXCollections.observableArrayList(model_t.turmaProperty().values()));
		Parent root = vt.getNode();
		Scene cena = new Scene(root, App.scene.getWidth(), App.scene.getHeight());
        cena.getStylesheets().setAll("resources/css/main.css");
		view.getStage().setScene(cena);
	}
}
