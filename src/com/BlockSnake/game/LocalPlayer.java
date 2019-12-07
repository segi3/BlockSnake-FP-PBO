package com.BlockSnake.game;

import java.util.ArrayList;

import com.BlockSnake.entities.Direction;
import com.BlockSnake.entities.Food;
import com.BlockSnake.entities.Snake;

public class LocalPlayer extends GameMode implements Runnable {

	//entities
//	public static ArrayList<Snake> snakes;
	public static Snake P1;
	public static Snake P2;
	Food food;
	
	//game properties
	public static boolean running = false;
	public static boolean paused = false;
	public static boolean gameover = false;
	public static boolean dead1 = false;
	public static boolean dead2 = false;
	static int gameSpeed = 100000000;
	
	public LocalPlayer() {
		
//		snakes = new ArrayList<Snake>();
//		snakes.add(new Snake());
//		snakes.add(new Snake(480, 480, Direction.left));
		P1 = new Snake();
		P2 = new Snake(480, 480, Direction.left);
		food = new Food();
	}
	
	public void reset() {
		
//		snakes.get(0).reset();
//		snakes.get(1).reset();
		P1.reset();
		P2.reset();
		food.reset();
		running = false;
		paused = false;
		gameover = false;
	}
	
	@Override
	public void run() {
		
		long last = System.nanoTime();
		running = true;
		
		while(running) {
			if(!gameover) {
//				System.out.println(P1.isDead()==P2.isDead());
				if(P1.isDead()==true) {
//					System.out.println(LocalPlayer.dead);
					LocalPlayer.dead1=true;
					gameover=true;
				}
				if(P2.isDead() == true) {

//					System.out.println(LocalPlayer.dead);
					LocalPlayer.dead2 = true;
					gameover=true;
				}
//				if(P2.isDead() == true && P1.isDead()==true) {
//
////					System.out.println(LocalPlayer.dead);
//					LocalPlayer.dead2 = true;
//					LocalPlayer.dead1=true;
//					gameover=true;
//				}
				if(!paused) {
					if(System.nanoTime() - last > gameSpeed) {
						last = System.nanoTime();
						tick();
					}
				}
			}
		}
	}
	
	private void tick() {
		
//		snakes.get(0).tick();
//		snakes.get(1).tick();
		P1.tick();
		P2.tick();
		food.tick();
		
		if(P1.checkCollisionWith(food)) {
			food = new Food();
		}
		if(P2.checkCollisionWith(food)) {
			food = new Food();
		}
		if(P1.checkCollisionWith(P2)) {
			food = new Food();
		}
		if(P2.checkCollisionWith(P1)) {
			food = new Food();
		}
	}
	
//	public Snake getSnake(int x) {
//		
//		return snakes.get(x);
//	}
	
	public Food getFood() {
		
		return food;
	}
}
