package dev.romptroll.engine.graphics.maps;

import java.util.ArrayList;
import java.util.List;

public class TiledMap {
	private List<TiledMapLayer> layers = new ArrayList<TiledMapLayer>();
	
	public void addLayer(TiledMapLayer layer) {
		layers.add(layer);
	}
	
	public void removeLayer(int index) {
		layers.remove(index);
	}
}
