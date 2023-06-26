package app.model;

import javafx.beans.property.MapProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.collections.FXCollections;

public class MateriaModel {
	private static MateriaModel instance = null;

	public static MateriaModel getInstance() {
		if (instance == null) {
			instance = new MateriaModel();
		}
		return instance;
	}

	private SimpleMapProperty<String, Materia> materia = new SimpleMapProperty<>();

	private MateriaModel() {
		materia.set(FXCollections.observableHashMap());
		materia.bindContentBidirectional(Faculdade.getIC().materiasProperty());
	}

	public MapProperty<String, Materia> materiaProperty() {
		return materia;
	}
}
