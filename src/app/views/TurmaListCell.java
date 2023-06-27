package app.views;

import app.model.Turma;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;

public class TurmaListCell extends ListCell<Turma> {

    @Override
    protected void updateItem(Turma item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null) {
            setText(item.getCodigo());
            setContentDisplay(ContentDisplay.TOP);
        } else {
            setText(null);
        }
    }

}
