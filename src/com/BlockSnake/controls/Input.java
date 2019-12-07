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
				if(SinglePlayer.gameover == false)
				SinglePlayer.paused = !SinglePlayer.paused;
			}else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
				if (SinglePlayer.gameover == true) {
					SinglePlayer.dead = 0;
					Snake.setDead(false);
					SinglePlayer.gameover = false;
				}
			}
				
		}
		
		if(Main.localThread.isAlive()) {
			if(e.getKeyCode() == KeyEvent.VK_W) {
				if(Main.localGame.P1.getDirection() != Direction.down)
					Main.localGame.P1.setDirection(Direction.up);
			}else if(e.getKeyCode() == KeyEvent.VK_D) {
				if(Main.localGame.P1.getDirection() != Direction.left)
					Main.localGame.P1.setDirection(Direction.right);
			}else if(e.getKeyCode() == KeyEvent.VK_S) {
				if(Main.localGame.P1.getDirection() != Direction.up)
					Main.localGame.P1.setDirection(Direction.down);
			}else if(e.getKeyCode() == KeyEvent.VK_A) {
				if(Main.localGame.P1.getDirection() != Direction.right)
					Main.localGame.P1.setDirection(Direction.left);
			}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				if(LocalPlayer.gameover == false) {
					LocalPlayer.paused = !LocalPlayer.paused;
					if(!LocalPlayer.running) {
						LocalPlayer.running = true;
					}
				}
			}else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
				if (LocalPlayer.gameover == true) {
					LocalPlayer.P1.setDead(false);
					LocalPlayer.P2.setDead(false);
					LocalPlayer.dead1 = false;
					LocalPlayer.dead2 = false;
					LocalPlayer.gameover = false;
				}
			}
			
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				if(Main.localGame.P2.getDirection() != Direction.down)
					Main.localGame.P2.setDirection(Direction.up);
			}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if(Main.localGame.P2.getDirection() != Direction.left)
					Main.localGame.P2.setDirection(Direction.right);
			}else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				if(Main.localGame.P2.getDirection() != Direction.up)
					Main.localGame.P2.setDirection(Direction.down);
			}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				if(Main.localGame.P2.getDirection() != Direction.right)
					Main.localGame.P2.setDirection(Direction.left);
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}

}
