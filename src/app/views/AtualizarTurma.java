package app.views;

import app.controllers.AtualizarTurmaController;
import app.model.Aluno;
import app.model.Faculdade;
import app.model.Turma;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AtualizarTurma extends View<BorderPane> {
	BorderPane principal;
	AtualizarTurmaController controller;
	private Turma turma;

	public AtualizarTurma(Stage stage, Turma turma) {
		super(stage);
		controller = new AtualizarTurmaController(this);
		stage.getIcons().add(new Image("resources/img/iComp_logo.png"));

		var alunoARemover = new SimpleObjectProperty<Aluno>(null);
		this.turma = turma;
		GridPane centro = new GridPane();

		TextField tfProfessor = new TextField(turma.getProfessor().getCadastro());
		TextField tHorario = new TextField(turma.getHorario());
		centro.addColumn(0,
				new Label("Código:"),
				new Label("Horário"),
				new Label("Professor:"));
		centro.addColumn(1,
				new Text(turma.getMateria().getCodigo()),
				tHorario,
				tfProfessor);

		ObservableList<Aluno> alunos = FXCollections.observableArrayList(turma.listaAlunosProperty());
		ListView<Aluno> listaAlunos = new ListView<>(alunos);
		listaAlunos.setCellFactory(a -> new AlunoListCell());
		turma.listaAlunosProperty().addListener(new ListChangeListener<Aluno>() {
			@Override
			public void onChanged(Change<? extends Aluno> c) {
				if (c.next()) {
					if (c.getAddedSize() > 0) {
						var adicionado = c.getAddedSubList();
						alunos.addAll(adicionado);
					}
					if (c.getRemovedSize() > 0) {
						alunos.removeAll(c.getRemoved());
					}
				}
				if (c.next()) {
				}
			}

		});

		Button botaoRemover = new Button("Remover aluno selecionado.");
		botaoRemover.setOnAction(e -> {
			alunoARemover.setValue(listaAlunos.getSelectionModel().getSelectedItem());
		});

		Label labelAluno = new Label("Insira o ra do aluno a adicionar");
		TextField tfAluno = new TextField();
		tfAluno.textProperty().addListener((observable, textoAntigo, textoNovo) -> {
			if (!textoNovo.chars().allMatch(Character::isDigit)) {
				tfAluno.setText(textoAntigo);
			}
		});
		Button botaoAdicionarAluno = new Button("Adicionar Aluno");
		botaoAdicionarAluno.setOnAction(e -> {
			var alunosIC = Faculdade.getIC().getAlunos();
			String ra = tfAluno.getText();
			Aluno aluno = alunosIC.get(ra);
			if (aluno == null) {
				Stage janelaErro = new Stage();
				Label textoErro = new Label("Não existe aluno com ra " + ra);
				Button botaoOK = new Button("OK");
				botaoOK.setOnAction(_e -> {
					janelaErro.close();
				});
				VBox root = new VBox(5, textoErro, botaoOK);
				Scene cena = new Scene(root, 200, 100);
				janelaErro.setScene(cena);
				janelaErro.show();
			} else {
				aluno.addTurma(turma);
			}
		});

		HBox botoes = new HBox(10, botaoAdicionarAluno, botaoRemover);
		botoes.setAlignment(Pos.CENTER);

		Button botaoConfirmar = new Button("Confirmar mudanças.");
		botaoConfirmar.setMinHeight(20);
		botaoConfirmar.setOnAction(
				e -> controller.professorTf(tfProfessor.getText(), tHorario.getText(), alunoARemover.getValue()));

		Button botaoVoltar = new Button("Voltar");
		botaoVoltar.setMinHeight(20);
		botaoVoltar.setOnAction(controller::navigateHome);
		HBox base = new HBox(10);
		base.getChildren().addAll(botaoVoltar, botaoConfirmar);
		base.setMinHeight(15);
		botaoVoltar.setPrefWidth(100);
		HBox.setMargin(botaoVoltar, new Insets(10, 0, 50, 0));
		HBox.setMargin(botaoConfirmar, new Insets(10, 0, 50, 0));

		VBox vbox = new VBox(5, centro, new Label("Alunos cadastrados"), listaAlunos, labelAluno, tfAluno, botoes);

		principal = new BorderPane(vbox);
		principal.setBottom(base);
		base.setAlignment(Pos.TOP_CENTER);
	}

	@Override
	public BorderPane getNode() {
		return principal;
	}

	@Override
	public AtualizarTurmaController getController() {
		return controller;
	}

	public Turma getTurma() {
		return turma;
	}
}