package com.BlockSnake.game;

import com.BlockSnake.controls.Input;
import com.BlockSnake.entities.Food;
import com.BlockSnake.entities.Snake;

public class GameMode {
	
	Snake snake;
	Food food;
	boolean paused = false;
	Input input;
	
	public Snake getSnake() {
		
		return snake;
	}
	
	public Food getFood() {
		
		return food;
	}
}
