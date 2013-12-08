package Engine.Graphics;

import java.awt.BorderLayout;
import java.awt.Canvas;

import javax.swing.JFrame;

public class Window extends Canvas{
	JFrame frame;
	public Window(String caption, int width, int height, boolean resizable){
		frame = new JFrame(caption);
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		frame.setResizable(resizable);
		frame.add(this, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void launchWindow(){
		frame.setVisible(true);
	}
}