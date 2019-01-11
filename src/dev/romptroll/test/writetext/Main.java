package dev.romptroll.test.writetext;

import org.lwjgl.glfw.GLFW;

import dev.romptroll.engine.core.Application;
import dev.romptroll.engine.core.Engine;
import dev.romptroll.engine.core.Input;
import dev.romptroll.engine.graphics.FontLoader;
import dev.romptroll.engine.graphics.Renderer;
import dev.romptroll.engine.graphics.Texture;
import dev.romptroll.engine.graphics.Window;

public class Main implements Application {
	public static void main(String[] args) {
		Engine.init(new Main());
	}
	
	Window win;
	Renderer ren;
	Texture atlas;
	WriteInput input;
	
	@Override
	public void init() {
		win = new Window(1000, 500, "Font Test", false);
		Window.setContext(win);
		ren = new Renderer(win);
		ren.setFont(FontLoader.loadFont("fonttest/font"));
		ren.getFont().width = 16;
		ren.getFont().height = 16;
		win.setInputHandler(input = new WriteInput());
	}

	@Override
	public void update(float delta) {
		GLFW.glfwPollEvents();
	}

	@Override
	public void render() {
		ren.clearColor(0, 255, 255, 255);
		ren.clear();
		ren.drawString(0, 0, input.text);
		win.swapBuffers();
	}
}
