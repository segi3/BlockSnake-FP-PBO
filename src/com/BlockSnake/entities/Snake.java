package com.BlockSnake.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import com.BlockSnake.Point;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import com.BlockSnake.Point;

public class Snake extends Entity {
	
	//snake properties
	private Direction direction;
	public final static int SIZE = 20;
	
	//arraylist for block postions
	public ArrayList<Point> location;
	
	private int originX;
	private int originY;
	private Direction defaultDirection;
	

	private static boolean dead = false;
	
	public Snake() {
		
		location = new ArrayList<Point>();
		direction = Direction.right;
		location.add(new Point(0, 0));
		originX = 0;
		originY = 0;
		defaultDirection = Direction.right;
	}
	
	public Snake(int x, int y, Direction d) {
		
		location = new ArrayList<Point>();
		direction = d;
		location.add(new Point(x, y));
		defaultDirection = d;
		originX = x;
		originY = y;
	}
	
	public void setLocation(ArrayList<Point> loc) {
		
		this.location = loc;
	}
	
	public boolean checkCollisionWith(Entity e) {
		
		//eat food
		if(e instanceof Food) {
			if(location.get(0).getX() == e.getX() && location.get(0).getY() == e.getY()) {
				
				increaseLength();
				return true;
			}
		}
		
		//local player snake
		if(e instanceof Snake) {
			
			Snake other = (Snake) e;
			
			for(int i=0; i<other.location.size(); i++) {
				
				if(location.get(0).equals(other.location.get(i))) {
					
					if (i==0) {
						other.reset();
						other.setDead(true);
						
					}

					Snake.setDead(true);
					reset();
				}
			}
		}
		
		if(e instanceof Poison) {
			
			if(location.get(0).getX() == e.getX() && location.get(0).getY() == e.getY()) {
				
			if(location.size() == 1) {
				
				Snake.setDead(true);
				reset();
				
				return false;
			}
			
			decreaseLength();
			
			return true;
				
			}
			
		}
		
		return false;
	}
	
	public void reset() {
		
		int size = location.size();
		
		for(int i=size-1; i>0; i--) {
			
			location.remove(i);
		}
		
		location.get(0).setPoint(originX, originY);
		setDirection(defaultDirection);
	}
	
	public void increaseLength() {
		
		location.add(new Point(location.get(location.size()-1)));
	}
	
	public void decreaseLength() {
		
		location.remove(location.size()-1);
	}
	
	public void setDirection(Direction d) {
		
		this.direction = d;
	}
	
	public Direction getDirection() {
		
		return direction;
	}
	
	public static boolean isDead() {
		return dead;
	}

	public static void setDead(boolean dead) {
		Snake.dead = dead;
	}

	@Override
	public void tick() {
		
		for(int i=(location.size()-1); i>0; i--) {
			
			location.get(i).setPoint(location.get(i-1));
		}
		
		switch(direction) {
		case up:
			location.get(0).setY(location.get(0).getY() - SIZE);
			break;
		case down:
			location.get(0).setY(location.get(0).getY() + SIZE);
			break;
		case right:
			location.get(0).setX(location.get(0).getX() + SIZE);
			break;
		case left:
			location.get(0).setX(location.get(0).getX() - SIZE);
			break;
		}
		
		//check for head self collision
		for(int i = 1; i<location.size(); i++) {
			if(location.get(0).equals(location.get(i))) {
				Snake.setDead(true);
				reset();
				
			}
		}
		
//		check border collision
//		if(location.get(0).getX() >= 500|| location.get(0).getX() < 0 || location.get(0).getY() >= 500 || location.get(0).getY() < 0) {
//			reset();
//		}
		
		if(location.get(0).getX() >= 500) {
			
			location.get(0).setPoint(0, location.get(0).getY());
			setDirection(Direction.right);
		}
		
		if(location.get(0).getX() <0) {
			
			location.get(0).setPoint(500-20 , location.get(0).getY());
			setDirection(Direction.left);
		}
		if(location.get(0).getY() >=500) {
			
			location.get(0).setPoint(location.get(0).getX(), 0);
			setDirection(Direction.down);
		}
		if(location.get(0).getY() <0) {
			location.get(0).setPoint(location.get(0).getX(), 500);
			setDirection(Direction.up);
		}
	}

	@Override
	public void render(Graphics g, Color c, int offX, int offY) {
		
		g.setColor(c);
		
		for(int i = 0; i < location.size(); i++) {
			
			g.fillRect(location.get(i).getX() + offX, location.get(i).getY() + offY, SIZE, SIZE);
		}
		
		g.setColor(Color.WHITE);
		g.drawString(String.valueOf(location.size()), location.get(0).getX() + offX, location.get(0).getY() + offY);
	}
}
