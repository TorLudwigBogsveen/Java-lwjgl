package dev.romptroll.engine.graphics.maps;

import dev.romptroll.engine.graphics.Texture;

public class Tile {
	public Texture texture;
	public int r = 255;
	public int g = 255;
	public int b = 255;
	
	public Tile(Texture texture) {
		this.texture = texture;
	}
}
