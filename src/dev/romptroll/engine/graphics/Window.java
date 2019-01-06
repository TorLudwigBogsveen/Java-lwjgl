package dev.romptroll.engine.graphics;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.nio.IntBuffer;

import org.lwjgl.glfw.GLFWWindowCloseCallback;
import org.lwjgl.opengl.GL;

import dev.romptroll.engine.core.Disposable;
import dev.romptroll.engine.core.InputHandler;



public class Window implements Disposable {
	
	/*Represents the title and size of the current window.
	 *Variables should be not be accessed directly instead use the setters and getters associated with the variables.*/
	private String title;
	
	/*Reference to an GLFW window should not be visible by implementations of the Window class*/
	private long window_ptr;
	
	public Window(int width, int height, String title, boolean fullscreen) {
		this.title = title;
		initWindow(width, height, title, fullscreen);
	}
	
	private void initWindow(int width, int height, String title, boolean fullscreen) {
		//TODO only call this method once!
		if(!glfwInit()) {
			System.err.println("GLFW wasnt initialized corectly!!!");
			return;
		}
		glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);
		if(fullscreen)
			window_ptr = glfwCreateWindow(width, height, title, glfwGetPrimaryMonitor(), 0);
		else 
			window_ptr = glfwCreateWindow(width, height, title, 0, 0);
		if(window_ptr == NULL) {
			System.err.println("Window wasnt initialized corectly!!!");
			return;
		}
		glfwSetWindowCloseCallback(window_ptr,  new GLFWWindowCloseCallback() {
			public void invoke(long arg0) {
				glfwDestroyWindow(window_ptr);
				System.exit(0);
			}
		});
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		glfwSetWindowTitle(window_ptr, title);
		this.title = title;
	}
	
	public int getWidth() {
		IntBuffer width = IntBuffer.allocate(1);
		IntBuffer height = IntBuffer.allocate(1);;
		glfwGetWindowSize(window_ptr, width, height);
		return width.get(0);

	}
	
	public int getHeight() {
		IntBuffer width = IntBuffer.allocate(1);
		IntBuffer height = IntBuffer.allocate(1);
		glfwGetWindowSize(window_ptr, width, height);
		return height.get(0);
	}
	
	public void rezise(int width, int height) {
		glfwSetWindowSize(window_ptr, width, height);
	}
	
	public void setInputHandler(InputHandler input) {
		glfwSetKeyCallback(window_ptr, input.getKeyCallBack());
		glfwSetCursorPosCallback(window_ptr, input.getCursorCallBack());
		glfwSetMouseButtonCallback(window_ptr, input.getMouseButtonCallback());
	}

	public void swapBuffers() {
		glfwSwapBuffers(window_ptr);
	}

	@Override
	public void dispose() {
		glfwDestroyWindow(window_ptr);
	}
	
	public static void setContext(Window window) {
		glfwMakeContextCurrent(window.window_ptr);
		GL.createCapabilities();
	}
	
}
