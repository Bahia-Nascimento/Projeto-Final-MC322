package app.views;

import app.controllers.SolicitarDiplomaController;
import app.model.Aluno;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SolicitarDiploma extends View<BorderPane> {

    private BorderPane principal;
    private SolicitarDiplomaController controller;

    public SolicitarDiploma(Stage stage, Aluno aluno) {
        super(stage);
        stage.getIcons().add(new Image("resources/img/iComp_logo.png"));
        controller = new SolicitarDiplomaController(this);

        if (aluno.solicitarDiploma() == false) {
            Stage janelaSD = new Stage();
            janelaSD.getIcons().add(new Image("resources/img/iComp_logo.png"));
            
            Label l = new Label("\n\n\n\n\n        A solicitação de diploma do aluno " + aluno.getNome() + " não foi autorizada.\n" 
                                + "\n                                             Faltam materias a serem realizadas.");
            l.setWrapText(true);
            l.setMaxWidth(Double.MAX_VALUE);
            l.setAlignment(Pos.CENTER);
            HBox centro = new HBox(10);
            centro.getChildren().addAll(l);

            HBox botoes = new HBox(10);
            botoes.setAlignment(Pos.BASELINE_CENTER);
            Button botaoVoltar = new Button("Voltar");
            botaoVoltar.setOnAction(e -> janelaSD.close());

            botoes.getChildren().addAll(botaoVoltar);

            BorderPane painel = new BorderPane(centro);
            painel.setBottom(botoes);
            BorderPane.setMargin(botoes, new Insets(0, 0, 20, 0));

            Scene cena = new Scene(painel, 500, 300);
            cena.getStylesheets().setAll("resources/css/main.css");
            janelaSD.setScene(cena);
            janelaSD.show();
        }

        if (aluno.solicitarDiploma() == true) {
            Stage janelaSD = new Stage();
            janelaSD.getIcons().add(new Image("resources/img/iComp_logo.png"));
            Label l = new Label("\n\n\n\n\n\n\n            A solicitação de diploma do aluno " + aluno.getNome() + " foi autorizada.");
            l.setMaxWidth(Double.MAX_VALUE);
            l.setAlignment(Pos.CENTER);
            HBox centro = new HBox(10);
            centro.getChildren().addAll(l);

            HBox botoes = new HBox(10);
            botoes.setAlignment(Pos.BASELINE_CENTER);
            Button botaoVoltar = new Button("Voltar");
            botaoVoltar.setOnAction(e -> janelaSD.close());

            botoes.getChildren().addAll(botaoVoltar);

            BorderPane painel = new BorderPane(centro);
            painel.setBottom(botoes);
            BorderPane.setMargin(botoes, new Insets(0, 0, 20, 0));

            Scene cena = new Scene(painel, 500, 300);
            cena.getStylesheets().setAll("resources/css/main.css");
            janelaSD.setScene(cena);
            janelaSD.show();
        }
    }

    @Override
    public BorderPane getNode() {
        return principal;
    }

    @Override
    public SolicitarDiplomaController getController() {
        return controller;
    }

}