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

public class MenuPrincipal implements View<BorderPane> {
	private BorderPane bp;

	public MenuPrincipal() {
		VBox topo = construirTopo();
		GridPane centro = construirCentro();
		HBox base = construirBase();

		bp = new BorderPane(centro);
		bp.setTop(topo);
		bp.setBottom(base);
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
		Button botaoCadAluno = new Button("Cadastrar Aluno");
		botaoCadAluno.setOnAction(e -> {
		});
		Button botaoCadProfessor = new Button("Cadastrar Professor");
		botaoCadProfessor.setOnAction(e -> {
		});
		Button botaoCadMat = new Button("Cadastrar Matéria");
		botaoCadMat.setOnAction(e -> {
		});
		Button botaoCadTurma = new Button("Cadastrar Turma");
		botaoCadTurma.setOnAction(e -> {
		});

		Button botaoVerAlunos = new Button("Visualizar Alunos");
		botaoVerAlunos.setOnAction(e -> {
		});
		Button botaoVerProfessor = new Button("Visualizar Professores");
		botaoVerProfessor.setOnAction(e -> {
		});
		Button botaoVerMateria = new Button("Visualizar Matérias");
		botaoVerMateria.setOnAction(e -> {
		});
		Button botaoVerTurma = new Button("Visualizar Turma");
		botaoVerTurma.setOnAction(e -> {
		});

		GridPane centro = new GridPane();
		centro.setAlignment(Pos.CENTER);

		centro.addRow(0, botaoCadAluno, botaoCadProfessor, botaoCadMat, botaoCadTurma);
		centro.addRow(1, botaoVerAlunos, botaoVerProfessor, botaoVerMateria, botaoVerTurma);
		return centro;
	}

	private static HBox construirBase() {
		HBox base = new HBox(10,
				new Label("Créditos: "),
				new Text("Breno Nishimoto ([RA aqui])  " +
						"Gabriel de Carvalho Silva Nascimento ([RA aqui])  " +
						"Gustavo Souza ([RA aqui])  " +
						"Mateus da Costa e Silva Rios Alves de Andrade (230806)"));
		base.setAlignment(Pos.BOTTOM_CENTER);
		return base;
	}

	@Override
	public BorderPane getNode() {
		return bp;
	}
}
