package app.views;

import app.model.Materia;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;

public class MateriaListCell extends ListCell<Materia> {
		@Override
		protected void updateItem(Materia item, boolean empty) {
			super.updateItem(item, empty);
			if (item == null || empty) {
				setDisabled(true);
				setGraphic(null);
			}
			if (item != null) {
				setDisabled(false);
				setText(item.getCodigo());
				setContentDisplay(ContentDisplay.TOP);
			}
		}

	}
