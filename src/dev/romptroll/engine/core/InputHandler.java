package dev.romptroll.engine.core;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;

public abstract class InputHandler implements Disposable {
	
	private KeyCallback keyCallback;
	private CursorCallback cursorCallback;
	private MouseButtonCallback mouseButtonCallback;
	
	public InputHandler() {
		keyCallback = new KeyCallback();
		cursorCallback = new CursorCallback();
		mouseButtonCallback = new MouseButtonCallback();
	}
	private class KeyCallback extends GLFWKeyCallback { 
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
	}
		
	public KeyCallback getKeyCallBack() {
		return keyCallback;
	}
	
	private class CursorCallback extends GLFWCursorPosCallback {
		@Override
		public void invoke(long window, double xpos, double ypos) {
			mouseMoved(xpos, ypos);
		}
	}
	
	public CursorCallback getCursorCallBack() {
		return cursorCallback;
	}
	
	private class MouseButtonCallback extends GLFWMouseButtonCallback {
		@Override
		public void invoke(long window, int button, int action, int mods) {
			switch(action) {
			case GLFW.GLFW_PRESS:
				mousePressed(button);
				break;
			case GLFW.GLFW_RELEASE:
				mouseReleased(button);
				break;
			default:
				System.err.println("Mouse button action not defined!");
			}
		}
	}
	
	public MouseButtonCallback getMouseButtonCallback() {
		return mouseButtonCallback;
	}
	
	public void dispose() {
		keyCallback.close();
		cursorCallback.close();
		mouseButtonCallback.close();
	}
	
	protected abstract void keyPressed(int key);

	protected abstract void keyReleased(int key);
	
	protected abstract void keyRepeated(int key);
	
	protected abstract void mouseMoved(double xpos, double ypos);
	
	protected abstract void mousePressed(int button);
	
	protected abstract void mouseReleased(int button);

}

