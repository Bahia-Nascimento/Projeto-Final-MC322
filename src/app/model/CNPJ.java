package app.model;
/**
 * Representa um CNPJ válido.
 */
public record CNPJ(String valor) implements ID<String> {
    /**
     * @param valor valor
     * @throws IDInvalidoException quando valor é inválido.
     */
    public CNPJ {
        if (!Validacao.validaCNPJ(valor)) {
            throw new IDInvalidoException();
        }
    }
}
