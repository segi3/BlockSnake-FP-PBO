package com.BlockSnake.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.BlockSnake.Main;
import com.BlockSnake.controls.ButtonListener;
import com.BlockSnake.controls.Input;
import com.BlockSnake.game.LocalPlayer;
import com.BlockSnake.game.SinglePlayer;

public class SnakePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//game size
	public int W = 500;
	public int H = 500;
	
	Screen screenState;
	
	//panel components
	Image snakeTitleIMG;
	Image playButtonIMG;
	Image menuButtonIMG;
	Image singleButtonIMG;
	Image localButtonIMG;
	Image backButtonIMG;
	Image exitButtonIMG;
	
	
	public JButton playButton;
	public JButton singleButton;
	public JButton localButton;
	public JButton backButton;
	public JButton menuButton;
	public JButton returnButton;
	public JButton exitButton;
	
	//controls
	Input input;
	
	ButtonListener buttonListener;
	
	public SnakePanel() {
		
		screenState = Screen.Menu;
		init();
		addComponents();
	}
	
	private void addComponents() {
		
		this.add(playButton);
		this.add(menuButton);
		this.add(singleButton);
		this.add(localButton);
		this.add(backButton);
		this.add(returnButton);
		this.add(exitButton);

		playButton.addActionListener(buttonListener);
		menuButton.addActionListener(buttonListener);
		singleButton.addActionListener(buttonListener);
		localButton.addActionListener(buttonListener);
		backButton.addActionListener(buttonListener);
		returnButton.addActionListener(buttonListener);
		exitButton.addActionListener(buttonListener);
		
		addKeyListener(input);
	}
	
	//initialize
	private void init() {
		
		buttonListener = new ButtonListener(this);
		input = new Input();

		try {
			snakeTitleIMG = ImageIO.read(new File("res/snake_title.png"));
			playButtonIMG = ImageIO.read(new File("res/play_button.png"));
			menuButtonIMG = ImageIO.read(new File("res/menu_button.png"));
			singleButtonIMG = ImageIO.read(new File("res/single_button.png"));
			localButtonIMG = ImageIO.read(new File("res/local_button.png"));
			backButtonIMG = ImageIO.read(new File("res/back_button.png"));
			exitButtonIMG = ImageIO.read(new File("res/exit_button.png"));
			
			playButton = new JButton(new ImageIcon(playButtonIMG));
			menuButton = new JButton(new ImageIcon(menuButtonIMG));
			singleButton = new JButton(new ImageIcon(singleButtonIMG));
			localButton = new JButton(new ImageIcon(localButtonIMG));
			backButton = new JButton(new ImageIcon(backButtonIMG));
			returnButton = new JButton(new ImageIcon(backButtonIMG));
			exitButton = new JButton(new ImageIcon(exitButtonIMG));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	//change screen mode
	public void setScreenMode(Screen s ) {
		
		screenState = s;
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		int offsetX = this.getWidth()/2 - W/2;
		int offsetY = this.getHeight()/2 - H/2;

		switch(screenState) {
		
		case Menu:
			
			g.drawImage(snakeTitleIMG, this.getWidth()/2 - snakeTitleIMG.getWidth(this)/2, 50, this);
			
			playButton.setPreferredSize(new Dimension(400, 60));
			playButton.setLocation(this.getWidth()/2 - playButton.getWidth()/2, this.getHeight()/2 - playButton.getHeight()/2);
			
			exitButton.setPreferredSize(new Dimension(400, 60));
			exitButton.setLocation(this.getWidth()/2 - exitButton.getWidth()/2, this.getHeight()/2 - exitButton.getHeight()/2 + 80);
			
			playButton.setVisible(true);
			menuButton.setVisible(false);
			singleButton.setVisible(false);
			localButton.setVisible(false);
			backButton.setVisible(false);
			returnButton.setVisible(false);
			exitButton.setVisible(true);
			
			break;
			
		case PlayMenu:
			
			playButton.setVisible(false);
			menuButton.setVisible(false);
			returnButton.setVisible(false);
			exitButton.setVisible(false);
			
			g.drawImage(snakeTitleIMG, this.getWidth()/2 - snakeTitleIMG.getWidth(this)/2, 50, this);
			
			singleButton.setPreferredSize(new Dimension(400, 60));
			singleButton.setLocation(this.getWidth()/2 - singleButton.getWidth()/2, this.getHeight()/2 - singleButton.getHeight()/2);
			singleButton.setVisible(true);
			
			localButton.setPreferredSize(new Dimension(400, 60));
			localButton.setLocation(this.getWidth()/2 - localButton.getWidth()/2, this.getHeight()/2 - localButton.getHeight()/2 + 20 + localButton.getHeight());
			localButton.setVisible(true);
			
			backButton.setPreferredSize(new Dimension(400, 60));
			backButton.setLocation(this.getWidth()/2 - backButton.getWidth()/2, this.getHeight()/2 - backButton.getHeight()/2 + 180 + backButton.getHeight());
			backButton.setVisible(true);
			
			break;
			
		case Game:
			
			requestFocus();
			menuButton.setLocation(offsetX + W - menuButton.getWidth(), offsetY + H);
			menuButton.setPreferredSize(new Dimension(100, 40));
			
			playButton.setVisible(false);
			singleButton.setVisible(false);
			menuButton.setVisible(true);
			localButton.setVisible(false);
			backButton.setVisible(false);
			returnButton.setVisible(false);
			exitButton.setVisible(false);
			
			g.setColor(Color.GRAY);
			g.fillRect(offsetX, offsetY, W, H);
			
			//Render entities
			Main.singleGame.getFood().render(g, Color.GREEN, offsetX, offsetY);
			Main.singleGame.getSnake().render(g, Color.RED, offsetX, offsetY);
			
			if(SinglePlayer.paused) {
				
				g.drawString("Paused", this.getWidth()/2, this.getHeight()/2);
			}
			
			break;
			
		case LocalGame:
			
			requestFocus();
			menuButton.setLocation(offsetX + W - menuButton.getWidth(), offsetY + H);
			menuButton.setPreferredSize(new Dimension(100, 40));
			
			playButton.setVisible(false);
			singleButton.setVisible(false);
			menuButton.setVisible(true);
			localButton.setVisible(false);
			backButton.setVisible(false);
			returnButton.setVisible(false);
			exitButton.setVisible(false);
			
			g.setColor(Color.GRAY);
			g.fillRect(offsetX, offsetY, W, H);
			
			//Render entities
			Main.localGame.getFood().render(g, Color.GREEN, offsetX, offsetY);
			Main.localGame.getSnake(0).render(g, Color.RED, offsetX, offsetY);
			Main.localGame.getSnake(1).render(g, Color.BLUE, offsetX, offsetY);
			
			if(LocalPlayer.paused) {
				
				g.drawString("Paused", this.getWidth()/2, this.getHeight()/2);
			}
			
//			if(LocalPlayer.dead==1 ) {
//				g.drawString("P1 Game Over", this.getWidth()/3, this.getHeight()/3);
//				LocalPlayer.dead = 0;
//				Snake.dead = false;
//			}
//			
//			if(LocalPlayer.dead==2 ) {
//				g.drawString("P2 Game Over", this.getWidth()/3, this.getHeight()/3);
//				LocalPlayer.dead = 0;
//				Snake.dead = false;
//			}
			
			break;
			
		}
	}
}
