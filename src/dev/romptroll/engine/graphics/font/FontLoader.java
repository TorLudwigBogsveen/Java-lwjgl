package dev.romptroll.engine.graphics.font;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import dev.romptroll.engine.graphics.Texture;

public class FontLoader {
	public static Font loadFont(String path) {
		Font font = null;
		try {
			Map<Character, Texture> data = new HashMap<Character, Texture>();
			Scanner scan = new Scanner(new File(FontLoader.class.getResource("../../../../"+path+".txt").toURI().getPath()));
			Texture atlas = new Texture(path+".png");
			int w = scan.nextInt();
			int h = scan.nextInt();
			while(scan.hasNext()) {
				char key = scan.next().charAt(0);
				int x = scan.nextInt();
				int y = scan.nextInt();
				data.put(key, atlas.crop(x*w, y*h, w, h));
			}
			font = new Font(data);
			scan.close();
		} catch (FileNotFoundException | URISyntaxException e) {
			e.printStackTrace();
		}
		return font;
	}
}
