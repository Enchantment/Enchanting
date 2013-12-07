package Engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import Graphics.Window;
import Levels.Level;
import Maths.Vector.Vec2f;

public class Enchanting {
	public static Window  mainWindow;
	Timer mainTimer;
	boolean running;
	Vec2f cameraLocation;
	Level curLevel;
	public Enchanting(){
		mainWindow = new Window("Enchanting", 1200, 900, false);
		cameraLocation = new Vec2f(0,0);
		curLevel = new Level("Resources/terrainMap2.txt");
	}
	public void start(){
		mainWindow.launchWindow();
		running = true;
		mainTimer = new FPSTimer(60);
		//Must appear right before gameLoop starts. After all is loaded
		mainTimer.startTimer();
		gameLoop();
	}
	public void stop(){
		running = false;
	}
	public void gameLoop(){
		
		while(running){
			handleInput();
			render();
			applyLogic();
			mainTimer.checkTime();
		}
	}
	public void render(){
		BufferStrategy bs = mainWindow.getBufferStrategy();
		if(bs == null){
			mainWindow.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, mainWindow.getWidth(), mainWindow.getHeight());
		curLevel.drawLevel(g, cameraLocation);
		g.dispose();
		bs.show();
	}
	public void applyLogic(){
	}
	public void handleInput(){
		
	}
	public static void main(String[] args) {
		Enchanting game = new Enchanting();
		game.start();
	}

}
