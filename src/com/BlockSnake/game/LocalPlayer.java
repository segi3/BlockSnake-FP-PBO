package com.BlockSnake.game;

import java.util.ArrayList;

import com.BlockSnake.entities.Direction;
import com.BlockSnake.entities.Food;
import com.BlockSnake.entities.Snake;

public class LocalPlayer extends GameMode implements Runnable {

	//entities
	ArrayList<Snake> snakes;
	Food food;
	
	//game properties
	public static boolean running = false;
	public static boolean paused = false;
//	public static int dead = 0;
	static int gameSpeed = 100000000;
	
	public LocalPlayer() {
		
		snakes = new ArrayList<Snake>();
		snakes.add(new Snake());
		snakes.add(new Snake(480, 480, Direction.left));
		food = new Food();
	}
	
	public void reset() {
		
		snakes.get(0).reset();
		snakes.get(1).reset();
		food.reset();
		running = false;
		paused = false;
	}
	
	@Override
	public void run() {
		
		long last = System.nanoTime();
		running = true;
		
		while(running) {
			if(!paused) {
				if(System.nanoTime() - last > gameSpeed) {
					last = System.nanoTime();
					tick();
				}
//				if(snakes.get(0).dead==true) {
//					this.dead=1;
//				if(snakes.get(1).dead == true) {
//					this.dead = 2;
//				}
//				}
			}
		}
	}
	
	private void tick() {
		
		snakes.get(0).tick();
		snakes.get(1).tick();
		food.tick();
		
		if(snakes.get(0).checkCollisionWith(food)) {
			food = new Food();
		}
		if(snakes.get(1).checkCollisionWith(food)) {
			food = new Food();
		}
		if(snakes.get(0).checkCollisionWith(snakes.get(1))) {
			food = new Food();
		}
		if(snakes.get(1).checkCollisionWith(snakes.get(0))) {
			food = new Food();
		}
	}
	
	public Snake getSnake(int x) {
		
		return snakes.get(x);
	}
	
	public Food getFood() {
		
		return food;
	}
}
