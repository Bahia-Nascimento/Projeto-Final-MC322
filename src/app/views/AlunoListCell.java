package app.views;

import app.model.Aluno;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;

public class AlunoListCell extends ListCell<Aluno> {
	@Override
	protected void updateItem(Aluno item, boolean empty) {
		super.updateItem(item, empty);
		if (item != null) {
			setText(item.getNome());
			setContentDisplay(ContentDisplay.TOP);
		} else {
			setText(null);
		}
	}

}
