package dev.romptroll.test.gameoflife;

import org.lwjgl.glfw.GLFW;

import dev.romptroll.engine.core.Application;
import dev.romptroll.engine.core.Engine;
import dev.romptroll.engine.core.Input;
import dev.romptroll.engine.graphics.Renderer;
import dev.romptroll.engine.graphics.Window;

public class Main implements Application {
	public static void main(String[] args) {
		Engine.init(new Main());
	}
	
	Window win;
	Renderer ren;
	Grid grid;
	Input input;
	
	@Override
	public void init() {
		win = new Window(1920, 1080, "Font Test", true);
		Window.setContext(win);
		win.setInputHandler(input = new Input());
		ren = new Renderer(win);
		grid = new Grid(win.getWidth()/1, win.getHeight()/1, 1, 1);
	}

	@Override
	public void update(float delta) {
		GLFW.glfwPollEvents();
		grid.update(delta);
		if(input.keys[GLFW.GLFW_KEY_ESCAPE]) {
			System.exit(0);
		}
	}

	@Override
	public void render() {
		ren.clearColor(0, 255, 255, 255);
		ren.clear();
		ren.translate(-win.getWidth()/2, -win.getHeight()/2);
		grid.render(ren);
		win.swapBuffers();
	}
}
