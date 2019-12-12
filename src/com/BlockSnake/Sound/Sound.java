package com.BlockSnake.Sound;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class Sound {
	
	String path;
	
	public Sound (String path){
		
		this.path = path;
		
		
		
	}
	
	public void soundPlay(){
		
		URL url = Sound.class.getResource(this.path);
		AudioClip clip = Applet.newAudioClip(url);
		clip.play();
		//Thread.sleep(1000);
		//clip.loop();
		//Thread.sleep(2000);
		clip.stop();
		
	}
	
	
}
