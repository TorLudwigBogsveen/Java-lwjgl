package dev.romptroll.test.editor;

import org.lwjgl.glfw.GLFW;

import dev.romptroll.engine.core.Application;
import dev.romptroll.engine.core.Engine;
import dev.romptroll.engine.graphics.Window;
import dev.romptroll.engine.graphics.maps.TiledMap;

public class Main implements Application {
	public static void main(String[] args) {
		Engine.init(new Main());
	}
	
	Window win;
	TiledMap map;

	@Override
	public void init() {
		win = new Window(1000, 500, "Editor", false);
		Window.setContext(win);
	}

	@Override
	public void update(float delta) {
		GLFW.glfwPollEvents();
	}

	@Override
	public void render() {
		win.swapBuffers();
	}
}
