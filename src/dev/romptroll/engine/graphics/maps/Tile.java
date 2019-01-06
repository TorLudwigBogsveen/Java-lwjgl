package dev.romptroll.engine.graphics.maps;

import dev.romptroll.engine.graphics.Texture;

public class Tile {
	public Texture texture;
	public int r;
	public int g;
	public int b;
	
	public Tile(Texture texture) {
		this.texture = texture;
	}
}
