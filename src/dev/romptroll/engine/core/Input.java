package dev.romptroll.engine.core;

public class Input extends InputHandler {
	
	public boolean keys[] = new boolean[1024];

	@Override
	public void keyPressed(int key) {
		keys[key] = true;
	}

	@Override
	public void keyReleased(int key) {
		keys[key] = false;
	}

	@Override
	public void keyRepeated(int key) {
		
	}

}
