package app.model;

import javafx.beans.property.ReadOnlyProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Representa um CPF válido.
 */
public class CPF implements ID<String> {
    /**
     * @param valor valor
     * @throws IDInvalidoException quando valor é inválido.
     */
    private final SimpleStringProperty valor;
    public CPF(String string) {
        valor = new SimpleStringProperty(string);
    }

    @Override
    public SimpleStringProperty valor() {
        return valor;
    }

    public SimpleStringProperty valorProperty() {
        return valor;
    }
}
