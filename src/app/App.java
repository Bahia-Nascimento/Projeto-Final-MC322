package app;

import app.views.MenuPrincipal;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MenuPrincipal mp = new MenuPrincipal();
        Parent root = mp.getNode();
        Scene scene = new Scene(root, 400, 400);
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
