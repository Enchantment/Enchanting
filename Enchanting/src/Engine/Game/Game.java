package Engine.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import Engine.Game.Levels.Level;
import Engine.Game.Utilities.FPSTimer;
import Engine.Game.Utilities.Timer;
import Engine.Game.Utilities.Maths.Vector.Vec2f;
import Engine.Graphics.Window;

public class Game {
	boolean debugMode;
	boolean running;
	boolean chatActivated;
	Window window;
	Level curLevel;
	GameResources resources;
	InputHandler inputHandler;
	Timer mainTimer;
	public Game(){
		this.debugMode = false;
		this.running = false;
		this.chatActivated = false;
		this.resources = new GameResources();
		this.window = new Window("Enchanting", 1200,900,false);
		this.inputHandler = new InputHandler(this);
		this.curLevel = new Level("Resources/Levels/bigassmap.txt", "Test_WORLD");
		this.mainTimer = new FPSTimer();
	}
	public void start(){
		if(running) return;
		resources.load();
		window.launchWindow();
		running = true;
		gameLoop();
	}
	public void gameLoop(){
		while(running){
			handleInput();
			handleLogic();
			render();
		}
	}
	public void handleLogic(){
		
	}
	public void render(){
		BufferStrategy bs = window.getBufferStrategy();
		if(bs == null){
			window.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, window.getWidth(), window.getHeight());
		curLevel.drawLevel(g, window, new Vec2f(0,0));
		g.dispose();
		bs.show();
	}
	public void handleInput(){
		
	}
	public boolean getDebug() {
		return debugMode;
	}
}
