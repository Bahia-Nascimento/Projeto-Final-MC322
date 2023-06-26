package app.views;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static app.Utils.*;

import app.controllers.MenuPrincipalController;

public class MenuPrincipal extends View<BorderPane> {
	private BorderPane bp;
	private MenuPrincipalController controller;

	public MenuPrincipal(Stage stage) {
		super(stage);
		controller = new MenuPrincipalController(this);

		HBox topo = construirTopo();
		GridPane centro = construirCentro();
		HBox base = construirBase();

		bp = new BorderPane(centro);
		bp.setTop(topo);
		bp.setBottom(base);
		bp.getStylesheets().add("resources/css/menu-principal.css");
	}

	private static HBox construirTopo() {

		Image logo_unicamp;
		logo_unicamp = new Image("resources/img/logo-unicamp-name-line-blk-red-0160.png");
		ImageView icone = new ImageView();
		icone.setImage(logo_unicamp);
		icone.setPreserveRatio(true);
		icone.setFitWidth(200);
		icone.setCache(true);
		Image logo_icomp;
		logo_icomp = new Image("resources/img/iComp_logo.png");
		ImageView icone_2 = new ImageView();
		icone_2.setImage(logo_icomp);
		icone_2.setPreserveRatio(true);
		icone_2.setFitWidth(300);
		icone_2.setCache(true);

		HBox hb = new HBox(10, icone, new Text("                                                    "), icone_2);
		hb.setAlignment(Pos.CENTER);
		hb.setTranslateX(0);
		hb.setTranslateY(100);
		return hb;
	}

	private GridPane construirCentro() {
		Button botaoCadAluno = criarBotao("Atualizar Aluno");
		botaoCadAluno.setOnAction(e -> controller.atualizarAluno(e, stage));
		
		Button botaoCadProfessor = criarBotao("Atualizar Professor");
		botaoCadProfessor.setOnAction(e -> controller.atualizarProfessor(e, stage));
		
		Button botaoCadTurma = criarBotao("Atualizar Turma");
		botaoCadTurma.setOnAction(e -> controller.atualizarTurma(e, stage));

		Button botaoVerAlunos = criarBotao("Visualizar Alunos");
		botaoVerAlunos.setOnAction(controller::visualizarAluno);
		Button botaoVerProfessor = criarBotao("Visualizar Professores");
		botaoVerProfessor.setOnAction(controller::visualizarProfessor);
		Button botaoVerMateria = criarBotao("Visualizar Matérias");
		botaoVerMateria.setOnAction(controller::visualizarMateria);
		Button botaoVerTurma = criarBotao("Visualizar Turma");
		botaoVerTurma.setOnAction(controller::visualizarTurma);
		Button botaoDiploma = criarBotao("Solicitar Diploma");
		botaoDiploma.setOnAction(controller::solicitarDiploma);

		Button botaoSair = criarBotao("Sair");
		botaoSair.setOnAction(e -> {
			stage.close();
		});

		GridPane centro = new GridPane();
		centro.setAlignment(Pos.CENTER);
		centro.setId("centro");
		centro.addRow(0, botaoCadAluno, botaoCadProfessor, botaoCadTurma, botaoDiploma);
		centro.addRow(1, botaoVerAlunos, botaoVerProfessor, botaoVerMateria, botaoVerTurma);
		centro.addRow(4, botaoSair);
		centro.setVgap(30);
      	centro.setHgap(30);
		return centro;
	}
	
	private static HBox construirBase() {
		HBox base = new HBox(10,
				new Label("Créditos:   "),
				new Text("Breno Shigeki Guimarães Nishimoto (220599)    " +
						"Gabriel de Carvalho Silva Nascimento (222103)    " +
						"Gustavo Souza (171425)    " +
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
