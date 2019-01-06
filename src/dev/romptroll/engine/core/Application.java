package dev.romptroll.engine.core;

public interface Application {
	
	
	/*
	 *
	 * Application interface meant to be implemented in the main class of the running program and will include
	 * all necessary methods for initializing updating and rendering the game.
	 * 
	 * */
	
	public void init();
	
	/*This method will be called once every tick and will contain all game logic.*/
	public void update(float delta);
	
	/*This method will be called once every draw cycle and will handle all game rendering.*/
	public void render();
	
}
