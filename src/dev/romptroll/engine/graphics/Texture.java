package dev.romptroll.engine.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Random;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;
import static org.lwjgl.opengl.GL11.*;


public class Texture {
	private int id;
	private int width;
	private int height;
	
	private ByteBuffer pixels;
	
	public Texture(String path) {
		try {
			BufferedImage image = ImageIO.read(Texture.class.getResource("../../../../"+path));
			width = image.getWidth();
			height = image.getHeight();
			
			int raw[] = new int[width*height*4];
			raw = image.getRGB(0, 0, width, height, null, 0, width);
			
			pixels = BufferUtils.createByteBuffer(width*height*4);
			for(int i = 0; i < width; i++) {
				for(int j = 0; j < height; j++) {
					int pixel = raw[i+j*width];
					pixels.put((byte)((pixel >> 16) & 0xFF)); //RED
					pixels.put((byte)((pixel >> 8) & 0xFF));  //GREEN
					pixels.put((byte)((pixel >> 0) & 0xFF));  //BLUE
					pixels.put((byte)((pixel >> 24) & 0xFF)); //ALPHA
				}
			}
			pixels.flip();
			
			id = glGenTextures();
			
			glBindTexture(GL_TEXTURE_2D, id);
			
			glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
			glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
			
			glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, pixels);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Texture(int width, int height, ByteBuffer data) {
		id = glGenTextures();
		
		glBindTexture(GL_TEXTURE_2D, id);
		
		glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
		glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		
		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, data);
	}
	
	public Texture crop(int x, int y, int width, int height) {
		ByteBuffer data = BufferUtils.createByteBuffer(width*height*4);
		pixels.rewind();
		for(int j = 0; j < height; j++) {
			for(int i = 0; i < width; i++) {
				int index = ((i+x)+(j+y)*this.width)*4;
				data.put(pixels.get(index+0));
				data.put(pixels.get(index+1));
				data.put(pixels.get(index+2));
				data.put(pixels.get(index+3));
			}
		}
		data.flip();
		return new Texture(width, height, data);
	}

	public int getID() {
		return id;
	}
}
