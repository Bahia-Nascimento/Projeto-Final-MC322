package app;

import app.model.CNPJ;
import app.model.Faculdade;
import app.views.MenuPrincipal;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private MenuPrincipal menuPrincipal;

    private Faculdade ic;

    @Override
    public void init() {
        menuPrincipal = new MenuPrincipal();
        ic = new Faculdade("Instituto de Computação.", new CNPJ("STYLESHEET_CASPIAN"));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new GridPane(), 400, 400);

    }

    @Override
    public void stop() {

    }
}
