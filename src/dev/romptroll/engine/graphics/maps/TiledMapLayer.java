package dev.romptroll.engine.graphics.maps;

public class TiledMapLayer {
	private Tile tiles[];
	private int width;
	private int height;
	
	private int tile_width;
	private int tile_height;
	
	public TiledMapLayer(int width, int height) {
		tiles = new Tile[width*height];
		this.width = width;
		this.height = height;
	}
	
	public Tile getTile(int x, int y) {
		return tiles[x+y*width];
	}
	
	public void setTile(int x, int y, Tile tile) {
		tiles[x+y*width] = tile;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getTileWidth() {
		return tile_width;
	}
	
	public int getTileHeight() {
		return tile_height;
	}
	
	public void setTileSize(int tile_width, int tile_height) {
		this.tile_width = tile_width;
		this.tile_height = tile_height;
	}
}
