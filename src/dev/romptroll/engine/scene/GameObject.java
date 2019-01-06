package dev.romptroll.engine.scene;

import java.util.ArrayList;
import java.util.List;

import dev.romptroll.engine.scene.components.Transform;

public class GameObject {
	public List<GameComponent> components;
	public Transform transform;
	
	public GameObject() {
		components = new ArrayList<GameComponent>();
		transform = new Transform();
	}
	
	public void update(float delta) {
		for(GameComponent c: components) {
			c.update(delta);
		}
	}
	
	public void render() {
		for(GameComponent c: components) {
			c.render();
		}
	}
	
	public void addComponent(GameComponent component) {
		component.parent = this;
		components.add(component);
	}
	
	public GameComponent getComponent(int index) {
		return components.get(index);
	}
	
	public void removeComponent(int index) {
		components.remove(index);
	}
}
