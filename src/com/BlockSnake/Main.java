package com.BlockSnake;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.BlockSnake.gui.SnakePanel;
import com.BlockSnake.game.LocalPlayer;
import com.BlockSnake.game.OnlineMode;
import com.BlockSnake.game.SinglePlayer;

public class Main {
	
	//Window Propertties
	static JFrame frame;
	static SnakePanel panel;
	static ImageIcon imgIcon;
	static int WIDTH = 1200;
	static int HEIGHT = 900;
	
	//Game modes
	public static SinglePlayer singleGame;
	public static LocalPlayer localGame;
	public static OnlineMode onlineGame;
	
	//Threads
	public static Thread singleThread;
	public static Thread localThread;
	public static Thread onlineThread;
	
	public static void main(String[] args) {
		
		init();
		configureWindow();
		run();
	}
	
	private static void run() {
		
		while(true) {
			render();
		}
	}
	
	//initialize
	private static void init() {
		
		frame = new JFrame("Block Snake");
		panel = new SnakePanel();
		imgIcon = new ImageIcon("res/icon.png");
		singleGame = new SinglePlayer();
		localGame = new LocalPlayer();
		onlineGame = new OnlineMode();
		
		singleThread = new Thread(singleGame);
		localThread = new Thread(localGame);
		onlineThread = new Thread(onlineGame);
	}
	
	private static void configureWindow() {
		
		//panel properties
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		//frame properties
		frame.setIconImage(imgIcon.getImage());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.pack();
	}
	
	public static void startSinglePlayer() {
		
		singleGame.reset();
		singleThread = new Thread(singleGame);
		singleThread.start();
	}
	
	public static void startLocalPlayer() {
		
		localGame.reset();
		localThread = new Thread(localGame);
		localThread.start();
	}
	
	public static void startOnlineGame(String host) {
		
		onlineGame.setIP(host);
		onlineThread = new Thread(onlineGame);
		onlineThread.start();
	}
	
	public static void render() {
		
		panel.repaint();
	}

}
