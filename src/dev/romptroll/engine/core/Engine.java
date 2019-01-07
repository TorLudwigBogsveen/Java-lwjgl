package dev.romptroll.engine.core;

public class Engine implements Runnable {	
	public static void init(Application app) {
		new Thread(new Engine(app), "GameLoop").start();
	}	
	
	private Application app;
	
	private Engine(Application app) {
		this.app = app;
	}

	@Override
	public void run() {
		app.init();
		
		long lastTime = 0;
		long time = 0;
		long timer = 0;
		float deltaTime = 0;
		int frames = 0;
		while(true) {
			deltaTime = (time-lastTime);
			lastTime = time;
			timer += deltaTime;
			frames++;
			time = System.currentTimeMillis();
			app.update(deltaTime);
			app.render();
			
			if(timer >= 1000) {
				frames = 0;
				timer = 0;
			}
		}
	}
}
