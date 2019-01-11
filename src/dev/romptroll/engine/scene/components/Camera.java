package dev.romptroll.engine.scene.components;

import dev.romptroll.engine.graphics.Renderer;
import dev.romptroll.engine.scene.GameComponent;

public class Camera extends GameComponent {
	public float x, y;
	public Renderer renderer;
	
	public Camera(Renderer renderer) {
		this.renderer = renderer;
	}
	
	public void lookAt(float x, float y) {
		renderer.translate(this.x=x, this.y=y);
	}
}
