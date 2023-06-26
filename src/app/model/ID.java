package app.model;

import javafx.beans.property.ReadOnlyProperty;

public interface ID<T> {
    ReadOnlyProperty<T> valor();
    default T getValor() {
        return valor().getValue();
    }
}
