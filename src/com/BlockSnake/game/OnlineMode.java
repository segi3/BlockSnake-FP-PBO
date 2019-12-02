package com.BlockSnake.game;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import com.BlockSnake.Point;
import com.BlockSnake.entities.Direction;
import com.BlockSnake.entities.Food;
import com.BlockSnake.entities.Snake;

public class OnlineMode extends GameMode implements Runnable{
	
	ArrayList<Snake> snakes;
	Food food;
	
	// Client Configurations
	String host;
	Socket socket;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	public OnlineMode(String ip) {
		snakes = new ArrayList<Snake>();
		snakes.add(new Snake());
		snakes.add(new Snake(780, 780, Direction.left));
		food = new Food();
		host = ip;
		try {
			socket = new Socket(ip, 6110);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public OnlineMode() {
		snakes = new ArrayList<Snake>();
		snakes.add(new Snake());
		snakes.add(new Snake());
		food = new Food();
	}
	
	public void setIP(String ip) {
		host = ip;
		try {
			socket = new Socket(ip, 6110);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		
		boolean status = false;
		ArrayList<Point> loc1 = new ArrayList<Point>();
		ArrayList<Point> loc2 = new ArrayList<Point>();
		
		Object obj1 = new Object();
		Object obj2 = new Object();

		int foodX = 0;
		int foodY = 0;
		
		while(true) {
			
			try {
				status = ois.readBoolean();
				obj1 = ois.readObject();
				obj2 = ois.readObject();
				foodX = ois.readInt();
				foodY = ois.readInt();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			if(status) {
				// READ DATA
				try {
					status = ois.readBoolean();
					obj1 = ois.readObject();
					obj2 = ois.readObject();
					foodX = ois.readInt();
					foodY = ois.readInt();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
				loc1 = (ArrayList<Point>) obj1;
				loc2 = (ArrayList<Point>) obj2;
				
				snakes.get(0).setLocation(loc1);
				snakes.get(1).setLocation(loc2);
				
				food.setX(foodX);
				food.setY(foodY);
				
				// SEND DATA
				try {
					oos.writeObject(snakes.get(0).getDirection());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	public Food getFood() {
		return food;
	}
	
	public Snake getSnake(int x) {
		return snakes.get(x);
	}
}
