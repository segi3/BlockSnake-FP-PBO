package com.BlockSnake.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Poison extends Entity {
	
public final static int SIZE = 20;
	
	public Poison(int x, int y) {
		this.X = x;
		this.Y = y;
	}
	
	public Poison() {
		
		this.X = new Random().nextInt(25) * SIZE;
		this.Y = new Random().nextInt(25) * SIZE;
	}
	
	public void reset() {
		
		this.X = new Random().nextInt(25) * SIZE;
		this.Y = new Random().nextInt(25) * SIZE;
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
