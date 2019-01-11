package dev.romptroll.test.gameoflife;

import java.util.Random;

import dev.romptroll.engine.graphics.Renderer;
import dev.romptroll.engine.scene.GameComponent;

public class Grid extends GameComponent {
	private final int DEAD = 0;
	private final int ALIVE = 1;
	private int width, height;
	private int cellWidth;
	private int cellHeight;
	private int[][] grid;

	
	public Grid(int width, int height, int cellWidth, int cellHeight) {
		this.width = width;
		this.height = height;
		this.cellWidth = cellWidth;
		this.cellHeight = cellHeight;
		this.grid = new int[width][height];
		
		Random ran = new Random();
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				grid[i][j] = ran.nextInt(2);
			}
		}
	}
	
	@Override
	public void update(float delta) {
		super.update(delta);
		int[][] next = new int[width][height]; 
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				int n = 0;
				for(int x = -1; x < 2; x++) {
					for(int y = -1; y < 2; y++) {
						int xx = i+x;
						int yy = j+y;
						if(xx < 0) xx = width-1;
						if(xx >= width) xx = 0;
						if(yy < 0) yy = height-1;
						if(yy >= height) yy = 0;
						if(grid[xx][yy] == ALIVE) n++;
					}
				}
				n -= grid[i][j];
				if(n < 2 || n > 3) {
					next[i][j] = DEAD;
				}
				else if(n == 3) 
					next[i][j] = ALIVE;
				else if(grid[i][j] == ALIVE)
					next[i][j] = ALIVE;
			}
		}
		grid = next;
	}
	
	@Override
	public void render(Renderer ren) {
		super.render(ren);
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				if(grid[i][j] == DEAD) {
					ren.setColor(0, 0, 0);
				}
				else  {
					ren.setColor(255, 255, 255);
				}
				ren.drawRect(i*cellWidth, j*cellHeight, cellWidth, cellHeight);
			}
		}
	}
	
}
