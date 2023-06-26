package app.model;

public enum Curso {
	CIENCIA("42 - Ciência da Computação", "Ciência da Computação", 42), 
	ENGENHARIA("34 - Engenharia da Computação", "Engenharia da Computação", 34);

	private final String nomeCompleto;
	private final String nomeCurto;
	private final int codigo;

	Curso(String nomeCompleto, String nomeCurto, int codigo) {
		this.nomeCompleto = nomeCompleto;
		this.nomeCurto = nomeCurto;
		this.codigo = codigo;
	}

	public String nomeCompleto() {
		return nomeCompleto;
	}

	public String nomeCurto() {
		return nomeCurto;
	}

	public int codigo() {
		return codigo;
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
