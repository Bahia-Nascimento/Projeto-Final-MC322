package app.model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Representa um CNPJ válido.
 */
public record CNPJ(SimpleStringProperty valor) implements ID<String> {
    /**
     * @param valor valor
     * @throws IDInvalidoException quando valor é inválido.
     */
    public CNPJ {
        if (!Validacao.validaCNPJ(valor.getValue())) {
            throw new IDInvalidoException();
        }
    }

    public CNPJ(String string) {
        this(new SimpleStringProperty(string));
    }

}
