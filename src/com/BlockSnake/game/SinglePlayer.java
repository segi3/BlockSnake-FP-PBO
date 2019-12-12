package com.BlockSnake.game;


import com.BlockSnake.entities.Food;
import com.BlockSnake.entities.Snake;
import com.BlockSnake.entities.Poison;
import java.applet.Applet;
import java.applet.AudioClip;

public class SinglePlayer extends GameMode implements Runnable {
	
	//game properties
	public static boolean running = false;
	public static boolean paused = false;
	public static boolean gameover = false;
	public static int dead = 0;
	static int gameSpeed = 100000000;
	
	//entities
	Snake snake;
	Food food;
	Poison poison;
	
	//SFX
	AudioClip ateFood = Applet.newAudioClip(SinglePlayer.class.getResource("ateFood.wav"));
	AudioClip atePoison = Applet.newAudioClip(SinglePlayer.class.getResource("atePoison.wav"));
	AudioClip gameOver = Applet.newAudioClip(SinglePlayer.class.getResource("Game-Over.wav"));
	
	public SinglePlayer() {
		
		snake = new Snake();
		food = new Food();
		poison = new Poison();
		
	}
	
	public void reset() {
		
		snake.reset();
		food.reset();
		poison.reset();
		running = false;
		paused = false;
		gameover = false;
	}
	
	@Override
	public void run() {
		
		running = true;
		
		Long last = System.nanoTime();
		
		while(running) {
			
			if(!gameover) {
				
				if(!paused) {
					
					if(System.nanoTime() - last > gameSpeed) {
						
						last = System.nanoTime();
						
						try {
							tick();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}
				if(Snake.isDead()==true) {
					
					gameOver.play();
					SinglePlayer.dead=1;
					gameover=true;
				}
			}
		}
	}
	
	public void tick() throws InterruptedException {
		
		snake.tick();
		food.tick();
		poison.tick();
		
		
		if(snake.checkCollisionWith(food)) {
			
//			eatFood.soundPlay();
			ateFood.play();
//			Thread.sleep(1000);
//			clip.loop();
//			clip.stop();
			
			food = new Food();
			
		}
		
		if(snake.checkCollisionWith(poison)) {
			
			atePoison.play();
			Thread.sleep(500);
			poison = new Poison();
		}
	}
	
	public Snake getSnake() {
		
		return snake;
	}
	
	public Food getFood() {
		
		return food;
	}
	
	public Poison getPoison() {
		
		return poison;
	}
}
