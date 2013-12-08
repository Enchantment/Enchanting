package Engine.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import Engine.Game.Levels.Level;
import Engine.Game.Utilities.FPSTimer;
import Engine.Game.Utilities.Timer;
import Engine.Game.Utilities.Maths.Vector.Vec2f;
import Engine.Graphics.Window;

public class Enchanting {
	public static Window  mainWindow;
	boolean running;
	public static Vec2f cameraLocation;
	Level curLevel;
	Timer mainTimer;
	public Enchanting(){
		mainWindow = new Window("Enchanting", 1200, 900, false);
		cameraLocation = new Vec2f(232,200);
		curLevel = new Level("Resources/Levels/terrainMap3.txt");
		mainTimer = new FPSTimer(60);
	}
	public void start(){
		mainWindow.launchWindow();
		running = true;
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
		curLevel.drawLevel(g, mainWindow, cameraLocation);
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