package dev.romptroll.engine.core;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import org.lwjgl.glfw.GLFWWindowCloseCallback;



public class Window {
	
	/*Represents the title and size of the current window.
	 *Variables should be not be accessed directly instead use the setters and getters associated with the variables.*/
	private String title;
	private int width, height;
	
	/*Reference to an GLFW window should not be visible by implementations of the Window class*/
	public long window;
	
	public Window(int width, int height, String title) {
		
		//TODO only call this method once!
		if(!glfwInit()) {
			System.err.println("GLFW wasnt initialized corectly!!!");
			return;
		}
		glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);

		window = glfwCreateWindow(width, height, title, 0, 0);
		if(window == NULL) {
			System.err.println("Window wasnt initialized corectly!!!");
			return;
		}
		glfwSetWindowCloseCallback(window,  new GLFWWindowCloseCallback() {
			public void invoke(long arg0) {
				System.out.println("exit");
			}
		});
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		//TODO change the title of the GLFW window.
		this.title = title;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void rezise(int width, int height) {
		glfwSetWindowSize(window, width, height);
		this.width = width;
		this.height = height;
	}
	
	
}
