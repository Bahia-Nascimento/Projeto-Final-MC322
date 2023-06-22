package app.model;

/**
 * Representa um CPF válido.
 */
public record CPF(String valor) implements ID<String> {
    /**
     * @param valor valor
     * @throws IDInvalidoException quando valor é inválido.
     */
    public CPF {
        if (!Validacao.validaCPF(valor)) {
            throw new IDInvalidoException();
        }
    }
}
