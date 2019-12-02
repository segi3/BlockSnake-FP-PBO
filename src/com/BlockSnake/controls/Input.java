package com.BlockSnake.controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.BlockSnake.Main;
import com.BlockSnake.entities.Direction;
import com.BlockSnake.game.LocalPlayer;
import com.BlockSnake.game.SinglePlayer;

public class Input implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(Main.singleThread.isAlive()) {
			if(e.getKeyCode() == KeyEvent.VK_W) {
				if(Main.singleGame.getSnake().getDirection() != Direction.down)
					Main.singleGame.getSnake().setDirection(Direction.up);
			}else if(e.getKeyCode() == KeyEvent.VK_D) {
				if(Main.singleGame.getSnake().getDirection() != Direction.left)
					Main.singleGame.getSnake().setDirection(Direction.right);
			}else if(e.getKeyCode() == KeyEvent.VK_S) {
				if(Main.singleGame.getSnake().getDirection() != Direction.up)
					Main.singleGame.getSnake().setDirection(Direction.down);
			}else if(e.getKeyCode() == KeyEvent.VK_A) {
				if(Main.singleGame.getSnake().getDirection() != Direction.right)
					Main.singleGame.getSnake().setDirection(Direction.left);
			}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				SinglePlayer.paused = !SinglePlayer.paused;
			}
		}
		
		if(Main.localThread.isAlive()) {
			if(e.getKeyCode() == KeyEvent.VK_W) {
				if(Main.localGame.getSnake(0).getDirection() != Direction.down)
					Main.localGame.getSnake(0).setDirection(Direction.up);
			}else if(e.getKeyCode() == KeyEvent.VK_D) {
				if(Main.localGame.getSnake(0).getDirection() != Direction.left)
					Main.localGame.getSnake(0).setDirection(Direction.right);
			}else if(e.getKeyCode() == KeyEvent.VK_S) {
				if(Main.localGame.getSnake(0).getDirection() != Direction.up)
					Main.localGame.getSnake(0).setDirection(Direction.down);
			}else if(e.getKeyCode() == KeyEvent.VK_A) {
				if(Main.localGame.getSnake(0).getDirection() != Direction.right)
					Main.localGame.getSnake(0).setDirection(Direction.left);
			}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				LocalPlayer.paused = !LocalPlayer.paused;
				if(!LocalPlayer.running) {
					LocalPlayer.running = true;
				}
			}
			
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				if(Main.localGame.getSnake(1).getDirection() != Direction.down)
					Main.localGame.getSnake(1).setDirection(Direction.up);
			}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if(Main.localGame.getSnake(1).getDirection() != Direction.left)
					Main.localGame.getSnake(1).setDirection(Direction.right);
			}else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				if(Main.localGame.getSnake(1).getDirection() != Direction.up)
					Main.localGame.getSnake(1).setDirection(Direction.down);
			}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				if(Main.localGame.getSnake(1).getDirection() != Direction.right)
					Main.localGame.getSnake(1).setDirection(Direction.left);
			}
		}
		
		if(Main.onlineThread.isAlive()) {
			if(e.getKeyCode() == KeyEvent.VK_W) {
				if(Main.onlineGame.getSnake(0).getDirection() != Direction.down)
					Main.onlineGame.getSnake(0).setDirection(Direction.up);
			}else if(e.getKeyCode() == KeyEvent.VK_D) {
				if(Main.onlineGame.getSnake(0).getDirection() != Direction.left)
					Main.onlineGame.getSnake(0).setDirection(Direction.right);
			}else if(e.getKeyCode() == KeyEvent.VK_S) {
				if(Main.onlineGame.getSnake(0).getDirection() != Direction.up)
					Main.onlineGame.getSnake(0).setDirection(Direction.down);
			}else if(e.getKeyCode() == KeyEvent.VK_A) {
				if(Main.onlineGame.getSnake(0).getDirection() != Direction.right)
					Main.onlineGame.getSnake(0).setDirection(Direction.left);
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}

}
