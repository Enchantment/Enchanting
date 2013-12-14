package Engine.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Engine.Graphics.Window;

public class InputHandler implements KeyListener, MouseListener{

	public InputHandler(Game game){
		game.window.addKeyListener(this);
		game.window.addMouseListener(this);
	}
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse clicked at: " + e.getPoint().x +"," + e.getPoint().y);
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		
	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {
		
	}


}
