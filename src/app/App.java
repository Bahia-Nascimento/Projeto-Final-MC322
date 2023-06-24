package app;

import app.views.MenuPrincipal;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MenuPrincipal mp = new MenuPrincipal(primaryStage);
        Parent root = mp.getNode();
        Scene scene = new Scene(root, 400, 400);
        scene.getStylesheets().setAll("resources/css/main.css");
        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        primaryStage.setTitle("iComp");
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    @Override
    public void stop() {

    }
}
