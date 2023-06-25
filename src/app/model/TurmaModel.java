package app.model;

import javafx.beans.property.MapProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.collections.FXCollections;

public class TurmaModel {
	private static TurmaModel instance = null;

	public static TurmaModel getInstance() {
		if (instance == null) {
			instance = new TurmaModel();
		}
		return instance;
	}

	private SimpleMapProperty<String, Turma> turma = new SimpleMapProperty<>();

	private TurmaModel() {
		turma.set(FXCollections.observableHashMap());
		turma.getValue().put("MC102", new Turma(
				null,
                null,
				null));
	}

	public MapProperty<String, Turma> turmaProperty() {
		return turma;
	}
}
