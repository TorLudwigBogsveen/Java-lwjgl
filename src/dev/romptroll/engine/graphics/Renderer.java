package dev.romptroll.engine.graphics;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glRectf;

import dev.romptroll.engine.core.Window;

public class Renderer {
	private Window window;
	
	public Renderer(Window window) {
		this.window = window;
	}
	
	public void drawRect(int x, int y, int width, int height) {
		float windowWidth = 500;
		float windowHeight = 250;
		float x1 = x/windowWidth;
		float y1 = y/windowHeight;
		float x2 = x1+width/windowWidth;
		float y2 = y1+height/windowHeight;
		glRectf(x1, y1, x2, y2);
	}
	
	public void clear() {
		glClear(GL_COLOR_BUFFER_BIT);
	}
}
