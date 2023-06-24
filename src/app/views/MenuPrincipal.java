package app.views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import app.controllers.MenuPrincipalController;
import app.model.CPF;
import app.model.Materia;
import app.model.Professor;
import app.model.Turma;

public class MenuPrincipal extends View<BorderPane> {
	private BorderPane bp;
	private MenuPrincipalController controller;

	public MenuPrincipal(Stage stage) {
		super(stage);
		controller = new MenuPrincipalController(this);



		VBox topo = construirTopo();
		GridPane centro = construirCentro();
		HBox base = construirBase();

		bp = new BorderPane(centro);
		bp.setTop(topo);
		bp.setBottom(base);
		bp.getStylesheets().add("resources/css/menu-principal.css");

		
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

	private GridPane construirCentro() {
		Button botaoCadAluno = criarBotao("Atualizar Aluno");
		botaoCadAluno.setOnAction(controller::navigateHome);
		
		Button botaoCadProfessor = criarBotao("Atualizar Professor");
		botaoCadProfessor.setOnAction(e -> {

			DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			Professor teste_prof = new Professor("658262", new CPF("71031371885"), "Luiz Danilo Souza",
												LocalDate.parse("09/06/1958", formatador), LocalDate.parse("09/06/1958", formatador));
			AtualizarProfessor atualizarProfessor = new AtualizarProfessor(stage, teste_prof);
			Scene scene_prof = new Scene(atualizarProfessor.getNode(), 400, 400);
			stage.setScene(scene_prof);

		});
		Button botaoCadMat = criarBotao("Atualizar Matéria");
		botaoCadMat.setOnAction(e -> {

			Materia teste_mat = new Materia("MC102", 6, null);
			AtualizarMateria atualizarMateria = new AtualizarMateria(stage, teste_mat);
			Scene scene_mat = new Scene(atualizarMateria.getNode(), 400, 400);
			stage.setScene(scene_mat);

		});
		Button botaoCadTurma = criarBotao("Atualizar Turma");
		botaoCadTurma.setOnAction(e -> {
			
			DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			Professor teste_prof = new Professor("658262", new CPF("71031371885"), "Luiz Danilo Souza",
												LocalDate.parse("09/06/1958", formatador), LocalDate.parse("09/06/1958", formatador));
			Materia teste_mat = new Materia("MC102", 6, null);
			Turma teste_turma = new Turma(teste_mat,"A" ,teste_prof);
			AtualizarTurma atualizarTurma = new AtualizarTurma(stage, teste_turma);
			Scene scene_tur = new Scene(atualizarTurma.getNode(), 400, 400);
			stage.setScene(scene_tur);
			
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
