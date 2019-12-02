package com.BlockSnake.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Food extends Entity {
	
	public final static int SIZE = 20;
	
	public Food(int x, int y) {
		this.X = x;
		this.Y = y;
	}
	
	public Food() {
		
		this.X = new Random().nextInt(40) * SIZE;
		this.Y = new Random().nextInt(40) * SIZE;
	}
	
	public void reset() {
		
		this.X = new Random().nextInt(40) * SIZE;
		this.Y = new Random().nextInt(40) * SIZE;
	}

	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g, Color c, int offsetX, int offsetY) {
		g.setColor(c);
		g.fillRect(offsetX+X, offsetY+Y, SIZE, SIZE);
	}
}
