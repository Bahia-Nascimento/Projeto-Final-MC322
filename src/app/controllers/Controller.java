package app.controllers;

import app.App;
import app.views.View;
import javafx.event.ActionEvent;

public abstract class Controller<V extends View<?>> {

    protected V view;

    public Controller(V view) {
        this.view = view;
    }

    public void navigateHome(ActionEvent e) {
        view.getStage().setScene(App.scene);
    }

    public V getView() {
        return view;
    }
}
