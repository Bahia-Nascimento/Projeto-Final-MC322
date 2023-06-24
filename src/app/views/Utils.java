package app.views;

import javafx.scene.control.Button;

public class Utils {
	public static Button criarBotao(String text, String... classesCSS) {
		Button b = new Button(text);
		String[] args = new String[classesCSS.length + 1];
		args[0] = "botao";
		System.arraycopy(classesCSS, 0, args, 1, classesCSS.length);
		b.getStyleClass().setAll(args);
		return b;
	}
}
