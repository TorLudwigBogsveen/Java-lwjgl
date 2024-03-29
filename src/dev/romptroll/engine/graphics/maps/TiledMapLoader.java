package dev.romptroll.engine.graphics.maps;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class TiledMapLoader {
	
	public static TiledMapLayer loadSimpleMap(String filePath, TiledSet set) {
		Scanner scan;
		TiledMapLayer layer = null;
		try {
			scan = new Scanner(new File(TiledMapLoader.class.getResource("../../../../../"+filePath).toURI().getPath()));
			layer = new TiledMapLayer(scan.nextInt(), scan.nextInt());
			for(int j = layer.getHeight()-1; j >= 0; j--) {
				for(int i = 0; i < layer.getWidth(); i++) {
					Tile tile = set.getTile(scan.nextInt());
					layer.setTile(i, j, tile);
				}
			}
		} catch (FileNotFoundException | URISyntaxException e) {
			e.printStackTrace();
		}
		return layer;
	}
}
