package dev.romptroll.engine.graphics;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FontLoader {
	public static Font loadFont() {
		String path = "";
		Font font = null;
		try {
			Map<String, Texture> data = new HashMap<String, Texture>();
			Scanner scan = new Scanner(new File(FontLoader.class.getResource("../../../../"+path).toURI().toString()));
			Texture atlas = new Texture(path);
			while(scan.hasNext()) {
				String key = scan.next();
				int x = scan.nextInt();
				int y = scan.nextInt();
				int w = scan.nextInt();
				int h = scan.nextInt();
			}
			font = new Font(data);
		} catch (FileNotFoundException | URISyntaxException e) {
			e.printStackTrace();
		}
		return font;
	}
}
