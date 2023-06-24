package app.views;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static app.views.Utils.*;

import app.controllers.MenuPrincipalController;

public class MenuPrincipal extends View<BorderPane> {
	private BorderPane bp;
	private MenuPrincipalController controller;

	public MenuPrincipal(Stage stage) {
		super(stage);
		VBox topo = construirTopo();
		GridPane centro = construirCentro();
		HBox base = construirBase();

		bp = new BorderPane(centro);
		bp.setTop(topo);
		bp.setBottom(base);
		bp.getStylesheets().add("resources/css/menu-principal.css");

		controller = new MenuPrincipalController(this);
	}

	private static VBox construirTopo() {

		Image athyrson;
		athyrson = new Image("resources/img/athyrson.jpg");
		ImageView icone = new ImageView();
		icone.setImage(athyrson);
		icone.setPreserveRatio(true);
		icone.setFitWidth(400);
		icone.setCache(true);
		Text nome = new Text("iComp");
		nome.setFont(new Font(40));

		VBox vb = new VBox(10, icone, new Text("placeholder para o logo."), nome);
		vb.setAlignment(Pos.CENTER);
		return vb;
	}

	private static GridPane construirCentro() {
		Button botaoCadAluno = criarBotao("Cadastrar Aluno");
		botaoCadAluno.setOnAction(e -> {
		});
		Button botaoCadProfessor = criarBotao("Cadastrar Professor");
		botaoCadProfessor.setOnAction(e -> {
		});
		Button botaoCadMat = criarBotao("Cadastrar Matéria");
		botaoCadMat.setOnAction(e -> {
		});
		Button botaoCadTurma = criarBotao("Cadastrar Turma");
		botaoCadTurma.setOnAction(e -> {
		});

		Button botaoVerAlunos = criarBotao("Visualizar Alunos");
		botaoVerAlunos.setOnAction(e -> {
		});
		Button botaoVerProfessor = criarBotao("Visualizar Professores");
		botaoVerProfessor.setOnAction(e -> {
		});
		Button botaoVerMateria = criarBotao("Visualizar Matérias");
		botaoVerMateria.setOnAction(e -> {
		});
		Button botaoVerTurma = criarBotao("Visualizar Turma");
		botaoVerTurma.setOnAction(e -> {
		});

		GridPane centro = new GridPane();
		centro.setAlignment(Pos.CENTER);
		centro.setId("centro");
		centro.addRow(0, botaoCadAluno, botaoCadProfessor, botaoCadMat, botaoCadTurma);
		centro.addRow(1, botaoVerAlunos, botaoVerProfessor, botaoVerMateria, botaoVerTurma);
		return centro;
	}

	private static HBox construirBase() {
		HBox base = new HBox(10,
				new Label("Créditos:   "),
				new Text("Breno Nishimoto ([RA aqui])    " +
						"Gabriel de Carvalho Silva Nascimento ([RA aqui])    " +
						"Gustavo Souza ([RA aqui])    " +
						"Mateus da Costa e Silva Rios Alves de Andrade (230806)"));
		base.setAlignment(Pos.BOTTOM_CENTER);
		return base;
	}

	@Override
	public BorderPane getNode() {
		return bp;
	}

	@Override
	public MenuPrincipalController getController() {
		return controller;
	}
}
