package app.views;

import java.net.URL;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MenuPrincipal implements View<BorderPane> {
	private BorderPane bp;

	public MenuPrincipal() {
		VBox vb;
		{
			Image athyrson;
			try {

				athyrson = new Image("file://resources/img/athyrson.jpg");
				System.out.println();
			} catch (Exception e) {
				System.out.println("adadad");
				throw e;
			}
			ImageView icone = new ImageView();
			icone.setImage(athyrson);
			icone.setPreserveRatio(true);
			icone.setFitWidth(400);
			icone.setCache(true);
			Text nome = new Text("iComp");
			nome.setFont(new Font(40));
			vb = new VBox(10, icone, nome);
			vb.setAlignment(Pos.CENTER);
		}
		GridPane gp;
		{
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

			gp = new GridPane();
			gp.setAlignment(Pos.CENTER);

			gp.addRow(0, botaoCadAluno, botaoCadProfessor, botaoCadMat, botaoCadTurma);
			gp.addRow(1, botaoVerAlunos, botaoVerProfessor, botaoVerMateria, botaoVerTurma);
		}
		bp = new BorderPane(gp);
		bp.setTop(vb);
	}

	@Override
	public BorderPane getNode() {
		return bp;
	}
}
