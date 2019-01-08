package dev.romptroll.engine.graphics.maps;

public class TiledMapLayer {
	
	private Tile tiles[];
	private int colors[][];
	
	private int width;
	private int height;
	
	private int tile_width;
	private int tile_height;
	
	public TiledMapLayer(int width, int height) {
		tiles = new Tile[width*height];
		colors = new int[width*height][3];
		this.width = width;
		this.height = height;
	}
	
	public Tile getTile(int x, int y) {
		return tiles[x+y*width];
	}
	
	public void setTile(int x, int y, Tile tile) {
		tiles[x+y*width] = tile;
		colors[x+y*width] = tile.color.clone(); 
	}
	
	public int[] getColor(int x, int y) {
		return colors[x+y*width];
	}
	
	public void setColor(int x, int y, int r, int g, int b) {
		colors[x+y*width][0] = r;
		colors[x+y*width][1] = g;
		colors[x+y*width][2] = b;
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
