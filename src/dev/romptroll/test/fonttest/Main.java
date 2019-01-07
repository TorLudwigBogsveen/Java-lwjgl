package dev.romptroll.test.fonttest;

import org.lwjgl.glfw.GLFW;

import dev.romptroll.engine.core.Application;
import dev.romptroll.engine.core.Engine;
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
	
	@Override
	public void init() {
		win = new Window(1000, 500, "Font Test", false);
		Window.setContext(win);
		ren = new Renderer(win);
		atlas = new Texture("fonttest/font.png");
		//atlas = new Texture("bullethell/player.png");
	}

	@Override
	public void update(float delta) {
		GLFW.glfwPollEvents();
	}

	@Override
	public void render() {
		ren.clearColor(255, 0, 0, 255);
		ren.clear();
		ren.setColor(0, 255, 255);
		ren.drawImage(atlas.crop(0, 0, 32, 32), -100, -200, 16*30, 16*30);
		win.swapBuffers();
	}
}
