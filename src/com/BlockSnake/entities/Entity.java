package com.BlockSnake.entities;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Entity {
	
	protected int X;
	protected int Y;
	
	public final static int SIZE = 20;
	
	public void setX(int x) {
		
		this.X = x;
	}
	
	public void setY(int y) {
		
		this.Y = y;
	}
	
	public int getX() {
		
		return X;
	}
	
	public int getY() {
		
		return Y;
	}
	
	public void tick() {
		
	}
	
	protected void render(Graphics g, Color c, int offX, int offY) {
		
		g.setColor(c);
		g.fillRect(offX+X, offY+Y, SIZE, SIZE);
	}
}
