package app.model;

public enum Curso {
	CIENCIA("42 - Ciência da Computação"), ENGENHARIA("34 - Engenharia da Computação");

	private final String nomeCompleto;

	Curso(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String nomeCompleto() {
		return nomeCompleto;
	}

	public static Curso fromString(String str) {
		String lstr = str.toLowerCase();
		if (lstr.contains("ciência") || lstr.contains("42")) {
			return CIENCIA;
		} else if (lstr.contains("engenharia") || lstr.contains("34")) {
			return ENGENHARIA;
		}
		throw new IllegalArgumentException("Não foi possível interpretar '" + str + "'.");
	}

	@Override
	public String toString() {
		return nomeCompleto;
	}
}
