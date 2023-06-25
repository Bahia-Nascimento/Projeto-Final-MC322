package app.model;

import java.time.LocalDate;

import javafx.beans.property.MapProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.collections.FXCollections;

public class ProfessorModel {
	private static ProfessorModel instance = null;

	public static ProfessorModel getInstance() {
		if (instance == null) {
			instance = new ProfessorModel();
		}
		return instance;
	}

	private SimpleMapProperty<String, Professor> professor = new SimpleMapProperty<>();

	private ProfessorModel() {
		professor.set(FXCollections.observableHashMap());
		professor.getValue().put("658262", new Professor(
				"658262",
                new CPF("71031371885"),
				"Luiz Danilo Souza",
				LocalDate.of(2000, 4, 12),
				LocalDate.of(2000, 4, 5)));
	}

	public MapProperty<String, Professor> professorProperty() {
		return professor;
	}
}
