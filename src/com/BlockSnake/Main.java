package com.BlockSnake;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.BlockSnake.gui.SnakePanel;
import com.BlockSnake.game.LocalPlayer;
import com.BlockSnake.game.SinglePlayer;

import java.applet.Applet;
import java.applet.AudioClip;

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
	
	//Threads
	public static Thread singleThread;
	public static Thread localThread;
	
	static AudioClip clip1 = Applet.newAudioClip(SinglePlayer.class.getResource("background-music.wav"));
	
	
	public static void main(String[] args) {
		
		clip1.play();
		clip1.loop();
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
		
		singleThread = new Thread(singleGame);
		localThread = new Thread(localGame);
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
	
	public static void render() {
		
		panel.repaint();
	}

}
