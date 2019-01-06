package dev.romptroll.engine.graphics;

public class Camera {
	public float x, y;
	public Renderer renderer;
	
	public Camera(Renderer renderer) {
		this.renderer = renderer;
	}
	
	public void lookAt(float x, float y) {
		renderer.translate(this.x=x, this.y=y);
	}
}
