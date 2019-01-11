package dev.romptroll.test.writetext;

import org.lwjgl.glfw.GLFW;

import dev.romptroll.engine.core.InputHandler;

public class WriteInput extends InputHandler {
	
	public String text = "";

	@Override
	protected void keyPressed(int key, int scancode) {
		text+=GLFW.glfwGetKeyName(key, scancode);
		
	}

	@Override
	protected void keyReleased(int key, int scancode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void keyRepeated(int key, int scancode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void mouseMoved(double xpos, double ypos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void mousePressed(int button) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void mouseReleased(int button) {
		// TODO Auto-generated method stub
		
	}

}
