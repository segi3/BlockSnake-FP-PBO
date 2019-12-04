package com.BlockSnake.game;


import com.BlockSnake.entities.Food;
import com.BlockSnake.entities.Snake;

public class SinglePlayer extends GameMode implements Runnable {
	
	//game properties
	public static boolean running = false;
	public static boolean paused = false;
	static int gameSpeed = 100000000;
	
	//entities
	Snake snake;
	Food food;
	
	public SinglePlayer() {
		
		snake = new Snake();
		food = new Food();
	}
	
	public void reset() {
		
		snake.reset();
		food.reset();
		running = false;
		paused = false;
	}
	
	@Override
	public void run() {
		
		running = true;
		
		Long last = System.nanoTime();
		while(running) {
			if(!paused) {
				if(System.nanoTime() - last > gameSpeed) {
					last = System.nanoTime();
					tick();
				}
			}
		}
	}
	
	public void tick() {
		
		snake.tick();
		food.tick();
		
		if(snake.checkCollisionWith(food)) {
			
			food = new Food();
		}
	}
	
	public Snake getSnake() {
		
		return snake;
	}
	
	public Food getFood() {
		
		return food;
	}
}

