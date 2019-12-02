package com.BlockSnake.controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.BlockSnake.Main;
import com.BlockSnake.gui.Screen;
import com.BlockSnake.gui.SnakePanel;
import com.BlockSnake.game.LocalPlayer;
import com.BlockSnake.game.SinglePlayer;

public class ButtonListener implements ActionListener {
	
	SnakePanel panel;
	
	public ButtonListener(SnakePanel panel) {
		
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(panel.playButton == e.getSource()) {
			panel.setScreenMode(Screen.PlayMenu);
		}else if(panel.menuButton == e.getSource()) {
			SinglePlayer.running = false;
			LocalPlayer.running = false;
			panel.setScreenMode(Screen.Menu);
		}else if(panel.singleButton == e.getSource()) {
			panel.setScreenMode(Screen.Game);
			Main.startSinglePlayer();
		}else if(panel.localButton == e.getSource()) {
			panel.setScreenMode(Screen.LocalGame);
			Main.startLocalPlayer();
		}else if(panel.onlineButton == e.getSource()) {
			panel.setScreenMode(Screen.OnlineMenu);
		}else if(panel.connectButton == e.getSource()){
			panel.setScreenMode(Screen.OnlineGame);
			Main.startOnlineGame(panel.ipTextField.getText());
		}else if(panel.backButton == e.getSource()) {
			panel.setScreenMode(Screen.Menu);
		}else if(panel.returnButton == e.getSource()) {
			panel.setScreenMode(Screen.PlayMenu);
		}else if(panel.exitButton == e.getSource()) {
			System.exit(0);
		}
		
	}
	

}
