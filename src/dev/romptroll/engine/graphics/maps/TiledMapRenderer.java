package dev.romptroll.engine.graphics.maps;

import dev.romptroll.engine.graphics.Renderer;

public class TiledMapRenderer {
	
	protected Renderer renderer;
	
	public TiledMapRenderer(Renderer renderer) {
		this.renderer = renderer;
	}
	
	public void drawTiledMap(TiledMap map) {
		for(int i = 0; i < map.size(); i++) {
			drawTiledMapLayer(map.getLayer(i));
		}
	}
	
	public void drawTiledMapLayer(TiledMapLayer layer) {
		for(int i = 0; i < layer.getWidth(); i++) {
			for(int j = 0; j < layer.getHeight(); j++) {
				Tile tile = layer.getTile(i, j);
				renderer.setColor(tile.color[0], tile.color[1], tile.color[2]);
				renderer.drawImage(tile.texture, i*layer.getTileWidth(), j*layer.getTileHeight(), layer.getTileWidth(), layer.getTileHeight());
			}
		}
	}
}
