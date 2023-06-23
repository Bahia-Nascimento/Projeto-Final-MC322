package app.views;

import javafx.scene.control.MenuBar;

public class MenuSuperior implements View<MenuBar> {
	private MenuBar mb;

	MenuSuperior() {
		mb = new MenuBar();
	}

	@Override
	public MenuBar getNode() {
		return mb;
	}
}
