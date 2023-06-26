package app.model;

import javafx.beans.property.MapProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.collections.FXCollections;

public class AlunosModel {
	private static AlunosModel instance = null;

	public static AlunosModel getInstance() {
		if (instance == null) {
			instance = new AlunosModel();
		}
		return instance;
	}

	private SimpleMapProperty<String, Aluno> alunos = new SimpleMapProperty<>(FXCollections.observableHashMap());

	private AlunosModel() {

		alunos.bindContentBidirectional(Faculdade.getIC().getAlunos());
	}

	public MapProperty<String, Aluno> alunosProperty() {
		return alunos;
	}
}
