package app.views;

import javafx.scene.Node;

public interface View<T extends Node> {
	T getNode();
}
