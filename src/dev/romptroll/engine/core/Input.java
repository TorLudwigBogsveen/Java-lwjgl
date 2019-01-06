package dev.romptroll.engine.core;

public class Input extends InputHandler {
	
	public boolean keys[] = new boolean[1024];
	
	public int mouseX;
	public int mouseY;

	@Override
	protected void keyPressed(int key) {
		keys[key] = true;
	}

	@Override
	protected void keyReleased(int key) {
		keys[key] = false;
	}

	@Override
	protected void keyRepeated(int key) {
		
	}

	@Override
	protected void mouseMoved(double xPos, double yPos) {
		mouseX = (int) xPos;
		mouseY = (int) yPos;
	}

}
