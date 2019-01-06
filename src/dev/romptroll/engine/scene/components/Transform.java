package dev.romptroll.engine.scene.components;

import dev.romptroll.engine.scene.GameComponent;

public class Transform extends GameComponent {
	
	public float x, y;

	public void translate(float x, float y) {
		this.x += x;
		this.y += y;
	}

}
