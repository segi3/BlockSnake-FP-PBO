package com.BlockSnake.controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.BlockSnake.Main;
import com.BlockSnake.gui.Screen;
import com.BlockSnake.gui.SnakePanel;
import com.BlockSnake.game.LocalPlayer;
import com.BlockSnake.game.SinglePlayer;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class ButtonListener implements ActionListener {
	
	SnakePanel panel;
	
	public ButtonListener(SnakePanel panel) {
		
		this.panel = panel;
	}

	AudioClip clip1 = Applet.newAudioClip(SinglePlayer.class.getResource("menu.wav"));
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(panel.playButton == e.getSource()) {
			clip1.play();
			panel.setScreenMode(Screen.PlayMenu);
			
		}else if(panel.menuButton == e.getSource()) {
			clip1.play();
			SinglePlayer.running = false;
			LocalPlayer.running = false;
			panel.setScreenMode(Screen.Menu);
			
		}else if(panel.singleButton == e.getSource()) {
			clip1.play();
			panel.setScreenMode(Screen.Game);
			Main.startSinglePlayer();
			
		}else if(panel.localButton == e.getSource()) {
			clip1.play();
			panel.setScreenMode(Screen.LocalGame);
			Main.startLocalPlayer();
			
		}else if(panel.backButton == e.getSource()) {
			clip1.play();
			panel.setScreenMode(Screen.Menu);
			
		}else if(panel.returnButton == e.getSource()) {
			clip1.play();
			panel.setScreenMode(Screen.PlayMenu);
			
		}else if(panel.exitButton == e.getSource()) {
			clip1.play();
			System.exit(0);
		}
		
	}
	

}
