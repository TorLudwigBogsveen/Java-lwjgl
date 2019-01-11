package dev.romptroll.engine.core;

public class Input extends InputHandler {
	
	public boolean keys[] = new boolean[1024];
	public boolean buttons[] = new boolean[8];
	
	public int mouseX;
	public int mouseY;

	@Override
	protected void keyPressed(int key, int scancode) {
		keys[key] = true;
	}

	@Override
	protected void keyReleased(int key, int scancode) {
		keys[key] = false;
	}

	@Override
	protected void keyRepeated(int key, int scancode) {
		
	}

	@Override
	protected void mouseMoved(double xPos, double yPos) {
		mouseX = (int) xPos;
		mouseY = (int) yPos;
	}

	@Override
	protected void mousePressed(int button) {
		buttons[button] = true;
	}

	@Override
	protected void mouseReleased(int button) {
		buttons[button] = false;
	}

}
