package dev.romptroll.test;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dev.romptroll.engine.core.Application;
import dev.romptroll.engine.core.Engine;
import dev.romptroll.engine.core.Input;
import dev.romptroll.engine.graphics.Camera;
import dev.romptroll.engine.graphics.Renderer;
import dev.romptroll.engine.graphics.Texture;
import dev.romptroll.engine.graphics.Window;
import dev.romptroll.engine.graphics.maps.Tile;
import dev.romptroll.engine.graphics.maps.TiledMap;
import dev.romptroll.engine.graphics.maps.TiledMapLayer;
import dev.romptroll.engine.graphics.maps.TiledMapLoader;
import dev.romptroll.engine.graphics.maps.TiledMapRenderer;
import dev.romptroll.engine.graphics.maps.TiledSet;

public class Main implements Application {
	
	Window window;
	Camera camera;
	Renderer renderer;
	Input input;
	
	TiledSet set;
	TiledMapLayer map;
	TiledMapRenderer ren;
	Texture texture;
			
	public static void main(String[] args) {
		Engine.init(new Main());
	}
	
	public void init() {
		window = new Window(1000, 500, "Test", false);
		window.setInputHandler(input = new Input());
		Window.setContext(window);
		renderer = new Renderer(window);
		camera = new Camera(renderer);
				
		set = new TiledSet();
		set.addTile(new Tile(new Texture("tilemap/tile0.png")));
		set.addTile(new Tile(new Texture("tilemap/tile1.png")));
		set.addTile(new Tile(new Texture("tilemap/tile2.png")));
		set.addTile(new Tile(new Texture("tilemap/tile3.png")));
		map = TiledMapLoader.loadSimpleMap("tilemap/map.txt", set);
		map.setTileSize(8, 8);
		ren = new TiledMapRenderer(renderer);
	}
	

	@Override
	public void update(float delta) {
		glfwPollEvents();
		camera.lookAt(camera.x-0.6f, -250);
	}

	@Override
	public void render() {
		renderer.clear();
		ren.drawTiledMapLayer(map);	
		window.swapBuffers();
	}
}
