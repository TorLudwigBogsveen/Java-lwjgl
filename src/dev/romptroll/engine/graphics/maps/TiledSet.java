package dev.romptroll.engine.graphics.maps;

import java.util.ArrayList;
import java.util.List;

public class TiledSet {
	private List<Tile> tiles = new ArrayList<Tile>();
	
	public Tile getTile(int index) {
		return tiles.get(index);
	}
	
	public void addTile(Tile tile) {
		tiles.add(tile);
	}
}
