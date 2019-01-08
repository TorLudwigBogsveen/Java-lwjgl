package dev.romptroll.engine.graphics.maps;

import dev.romptroll.engine.graphics.Texture;

public class Tile {
	public Texture texture;
	public int[] color = {255, 255, 255};
	
	public Tile(Texture texture) {
		this.texture = texture;
	}
}
