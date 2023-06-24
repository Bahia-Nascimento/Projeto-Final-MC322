package app.model;

import java.time.LocalDate;
import java.util.Collections;

import javafx.beans.property.MapProperty;
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

	private SimpleMapProperty<String, Aluno> alunos = new SimpleMapProperty<>();

	private AlunosModel() {
		alunos.set(FXCollections.observableHashMap());
		alunos.getValue().put("230806", new Aluno(
				new CPF("16557446746"),
				"José dos Campos",
				LocalDate.of(2000, 4, 12),
				LocalDate.of(2000, 4, 5),
				Curso.CIENCIA, "230806",
				Collections.emptyList(),
				Collections.emptyList()));
	}

	public MapProperty<String, Aluno> alunosProperty() {
		return alunos;
	}
}
