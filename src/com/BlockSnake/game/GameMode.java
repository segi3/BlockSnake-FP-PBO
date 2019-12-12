package com.BlockSnake.game;

import com.BlockSnake.controls.Input;
import com.BlockSnake.entities.Poison;
import com.BlockSnake.entities.Food;
import com.BlockSnake.entities.Snake;

public class GameMode {
	
	Snake snake;
	Food food;
	Poison poison;
	boolean paused = false;
	Input input;
	
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
