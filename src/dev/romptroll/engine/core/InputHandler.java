package dev.romptroll.engine.core;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;

public abstract class InputHandler extends GLFWKeyCallback {

	@Override
	public void invoke(long window, int key, int scancode, int action, int mods) {
		switch(action) {
		case GLFW.GLFW_PRESS:
			keyPressed(key);
			break;
		case GLFW.GLFW_RELEASE:
			keyReleased(key);
			break;
		case GLFW.GLFW_REPEAT:
			keyRepeated(key);
			break;
		default:
			System.err.println("Key action not defined!");
		}
	}
	
	public abstract void keyPressed(int key);

	public abstract void keyReleased(int key);
	
	public abstract void keyRepeated(int key);
}

