package dev.romptroll.engine.scene;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import dev.romptroll.engine.graphics.Renderer;

public class Scene {
	private List<GameObject> objects = new ArrayList<GameObject>();
	private Queue<GameObject> queue = new LinkedList<GameObject>();
	
	public Renderer renderer;
	
	public Scene(Renderer renderer) {
		this.renderer = renderer;
	}
	
	public void addObject(GameObject object) {
		queue.add(object);
	}

	public void update(float delta) {
		
		while(!queue.isEmpty()) {
			objects.add(queue.poll());
		}
		for(GameObject o: objects) {
			o.update(delta);
		}
	}

	public void render() {
		for(GameObject o: objects) {
			o.render(renderer);
		}
	}
}
