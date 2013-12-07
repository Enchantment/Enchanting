package Engine;

import Engine.FPSTimer;
import Graphics.Window;

public class Enchanting {
	Window mainWindow;
	Timer mainTimer;
	boolean running;
	public Enchanting(){
		mainWindow = new Window("Enchanting", 1200, 900, false);
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
