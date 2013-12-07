package Engine;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import Character.Player;
import Engine.Shapes.Vec2f;
import Levels.Level;
public class Enchanting {
	public static Window mainWindow;
	public static Player mainPlayer;
	boolean running;
	Timer gameTimer;
	KeyListener listener;
	Level mainLevel;
	Timer timer;
	public Enchanting(){
		mainWindow = new Window(1200, 840, 1, "Enchanting");
		running = false;
		gameTimer = new Timer();
		mainLevel = new Level();
		timer = new FPSTimer(60);
	}
	public void start(){
		if(running) return;
		running = true;
		mainWindow.LaunchWindow();
		mainWindow.frame.addKeyListener(new InputHandler());
		mainPlayer = new Player("player.png",new Vec2f(800, 800),new Vec2f(32, 32), new Vec2f(0,0), 0, 0);
		gameLoop();
	}
	public void gameLoop(){
		timer.startTimer();
		while(running){
			readInput();
			render();
			applyLogic();
			timer.checkTime();
		}
	}
	private void readInput() {
	}
	private void render(){
		BufferStrategy bs = mainWindow.getBufferStrategy();
		if(bs == null){
			mainWindow.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, mainWindow.getWidth(), mainWindow.getHeight());
		mainLevel.drawLevel(g);
		mainPlayer.drawChar(g);
		g.dispose();
		bs.show();
	}
	private void applyLogic(){
		double time = timer.getTimeS();
		mainPlayer.moveChar(time);
	}
	public static void main(String[] args) {
		Enchanting game = new Enchanting();
		game.start();
	}
	public class InputHandler implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			  switch (e.getKeyCode()) {

		        case KeyEvent.VK_LEFT:
		        	mainPlayer.setSpeed(new Vec2f(-150,0));
		            break;

		        case KeyEvent.VK_RIGHT:
		        	mainPlayer.setSpeed(new Vec2f(150,0));
		            break;
		        case KeyEvent.VK_UP:
		        	mainPlayer.setSpeed(new Vec2f(0,-150));
		            break;

		        case KeyEvent.VK_DOWN:
		        	mainPlayer.setSpeed(new Vec2f(0,+150));
		            break;

		        case KeyEvent.VK_SPACE:
		            break;
		    }
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			
		}
		
	}
}