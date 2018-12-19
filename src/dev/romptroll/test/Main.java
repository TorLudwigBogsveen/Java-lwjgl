package dev.romptroll.test;

import org.lwjgl.glfw.GLFW;

import dev.romptroll.engine.core.Application;
import dev.romptroll.engine.core.Window;

public class Main implements Application, Runnable {
	
	private Thread thread;
	private Window window;
	
	public static void main(String[] args) {
		new Main().start();
	}
	
	private void start() {
		thread = new Thread(this, "Game");
		thread.start();
	}
	
	private void init() {
		window = new Window(600, 400, "Test");
		window.rezise(200, 500);
	}
	
	@Override
	public void run() {
		init();

		while(true) {
			update(0f);
			render();
		}
	}

	@Override
	public void update(float delta) {
		GLFW.glfwPollEvents();
	}

	@Override
	public void render() {
		GLFW.glfwSwapBuffers(window.window);
	}

}
