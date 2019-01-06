package dev.romptroll.engine.graphics;

import static org.lwjgl.opengl.GL11.*;

public class Renderer {
	
	public void drawRect(int x, int y, int width, int height) {
		float windowWidth = 500;
		float windowHeight = 250;
		float x1 = x/windowWidth;
		float y1 = y/windowHeight;
		float x2 = x1+width/windowWidth;
		float y2 = y1+height/windowHeight;
		glRectf(x1, y1, x2, y2);
	}
	
	public void drawImage(Texture texture, int x, int y, int width, int height) {
		float windowWidth = 500;
		float windowHeight = 250;
		float x1 = x/windowWidth;
		float y1 = y/windowHeight;
		float x2 = x1+width/windowWidth;
		float y2 = y1+height/windowHeight;
		glBindTexture(GL_TEXTURE_2D, texture.getID());
		glEnable(GL_TEXTURE_2D);
		glBegin(GL_QUADS);
		glTexCoord2f(1, 1); glVertex2f(x1,y1);
		glTexCoord2f(0, 1); glVertex2f(x1,y2);
		glTexCoord2f(0, 0); glVertex2f(x2,y2);
		glTexCoord2f(1, 0); glVertex2f(x2,y1);
		glEnd();
		glDisable(GL_TEXTURE_2D);
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
		float windowWidth = 500;
		float windowHeight = 250;
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
}
