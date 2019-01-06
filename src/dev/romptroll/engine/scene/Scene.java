package dev.romptroll.engine.scene;

import java.util.ArrayList;
import java.util.List;

public class Scene {
	private List<GameObject> objects = new ArrayList<GameObject>();
	
	public void addObject(GameObject object) {
		objects.add(object);
	}

	public void update(float delta) {
		for(GameObject o: objects) {
			o.update(delta);
		}
	}

	public void render() {
		for(GameObject o: objects) {
			o.render();
		}
	}
}
