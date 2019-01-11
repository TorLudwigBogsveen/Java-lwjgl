package dev.romptroll.engine.graphics;

import static org.lwjgl.opengl.GL11.*;

import dev.romptroll.engine.graphics.font.Font;

public class Renderer {
	
	private Window window;
	private Font font;
	
	public Renderer(Window window) {
		this.window = window;
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		
		float windowWidth = window.getWidth()/2;
		float windowHeight = window.getHeight()/2;
		float x1 = -(window.getWidth()/2)/windowWidth;
		float y1 = -(window.getHeight()/2)/windowHeight;
		glTranslatef(x1, y1, 0);
	}
	
	public void drawRect(int x, int y, int width, int height) {
		float windowWidth = window.getWidth()/2;
		float windowHeight = window.getHeight()/2;
		float x1 = x/windowWidth;
		float y1 = y/windowHeight;
		float x2 = x1+width/windowWidth;
		float y2 = y1+height/windowHeight;
		glRectf(x1, y1, x2, y2);
	}
	
	public void drawImage(Texture texture, int x, int y, int width, int height) {
		float windowWidth = window.getWidth()/2;
		float windowHeight = window.getHeight()/2;
		float x1 = x/windowWidth;
		float y1 = y/windowHeight;
		float x2 = x1+width/windowWidth;
		float y2 = y1+height/windowHeight;
		glBindTexture(GL_TEXTURE_2D, texture.getID());
		glEnable(GL_TEXTURE_2D);
		glBegin(GL_QUADS);
		glTexCoord2f(1, 0); glVertex2f(x1,y1);
		glTexCoord2f(0, 0); glVertex2f(x1,y2);
		glTexCoord2f(0, 1); glVertex2f(x2,y2);
		glTexCoord2f(1, 1); glVertex2f(x2,y1);
		glEnd();
		glDisable(GL_TEXTURE_2D);
	}
	
	public void drawString(int x, int y, String string) {
		if(font == null) {
			System.out.println("TRIED TO DRAW TO STRING WITHOUT A FONT SELECTED!!!");
			return;
		}
		Texture[] textures = font.getString(string);
		for(int i = 0; i < string.length(); i++) {
			drawImage(textures[i], x+font.width*i, y, font.width, font.height);
		}
	}
	
	public void setColor(int r, int g, int b) {
		glColor3f((float)r/256, (float)g/256, (float)b/256);
	}
	
	public void setColor(int r, int g, int b, int a) {
		glColor4f((float)r/256, (float)g/256, (float)b/256, (float)a/256);
	}
	
	public void clear() {
		glClear(GL_COLOR_BUFFER_BIT);
	}
	
	public void clearColor(int r, int g, int b, int a) {
		glClearColor((float)r/256, (float)g/256, (float)b/256, (float)a/256);
	}
	
	public void translate(float x, float y) {
		float windowWidth = window.getWidth()/2;
		float windowHeight = window.getHeight()/2;
		float x1 = x/windowWidth;
		float y1 = y/windowHeight;
		glPopMatrix();
		glPushMatrix();
		glTranslatef(x1, y1, 0);
	}
	
	public void rotate(float angle) {
		glPopMatrix();
		glPushMatrix();
		glRotatef(angle, 0, 0, 1);
	}
	
	public void pushMatric() {
		glPushMatrix();
	}
	
	public void popMatric() {
		glPopMatrix();
	}
	
	public void setFont(Font font) {
		this.font = font;
	}
	
	public Font getFont() {
		return font;
	}
}
