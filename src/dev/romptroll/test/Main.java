package dev.romptroll.test;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dev.romptroll.engine.core.Application;
import dev.romptroll.engine.core.Input;
import dev.romptroll.engine.core.Window;
import dev.romptroll.engine.graphics.Renderer;

public class Main implements Application, Runnable {
	
	private Thread thread;
	private Window window;
	private Renderer renderer;
	private Input input;
	
	public static Random rand = new Random();
	
	private List<Particle> particles = new ArrayList<Particle>();
	
	public static void main(String[] args) {
		new Main().start();
	}
	
	private void start() {
		thread = new Thread(this, "Game");
		thread.start();
	}
	
	private void init() {
		window = new Window(1000, 500, "Test");
		window.setInputHandler(input = new Input());
		Window.setContext(window);
		renderer = new Renderer(window);
	}
	
	@Override
	public void run() {
		init();
		glClearColor(0.6f, 0.2f, 0.2f, 1f);
		
		for(int i = 0; i < 1000000; i++) {
			particles.add(new Particle(rand.nextInt(1000)-500, rand.nextInt(500)-250, 1, 1));
		}
		
		long lastTime = 0;
		long time = 0;
		long timer = 0;
		float deltaTime = 0;
		int frames = 0;
		while(true) {
			deltaTime = time-lastTime;
			lastTime = time;
			timer += deltaTime;
			frames++;
			time = System.currentTimeMillis();
			update(deltaTime);
			render();
			
			if(timer >= 1000) {
				window.setTitle(Integer.toString(frames));
				frames = 0;
				timer = 0;
			}
		}
	}

	@Override
	public void update(float delta) {
		glfwPollEvents();
		for(Particle p: particles) {
			p.update(delta);
		}
	}

	@Override
	public void render() {
		window.swapBuffers();
		renderer.clear();
		for(Particle p: particles) {
			p.render(renderer);
		}
	}

	class Particle {
		public float x;
		public float y;
		public int width;
		public int height;
		
		public Particle(int x, int y, int width, int height) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}
		
		public void update(float delta) {
			x += (rand.nextFloat()-0.5f)*10;
			y += (rand.nextFloat()-0.5f)*10;
		}
		
		public void render(Renderer renderer) {
			renderer.drawRect((int)x, (int)y, width, height);
		}
	}
}
