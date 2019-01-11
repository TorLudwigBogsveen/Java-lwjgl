package dev.romptroll.engine.graphics;

import java.util.HashMap;
import java.util.Map;

public class Font {
	
	private Map<Character, Texture> data = new HashMap<Character, Texture>();
	public int width = 32;
	public int height = 32;
	
	public Font(Map<Character, Texture> data) {
		this.data = data;
	}
	
	public Texture getCharacter(char character) {
		return data.get(character);
	}
	
	public Texture[] getString(String string) {
		Texture[] textures = new Texture[string.length()];
		for(int i = 0; i < string.length(); i++) {
			textures[i]  = data.get(string.charAt(i));
		}
		return textures;
	}
}
