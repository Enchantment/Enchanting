package Graphics;


import java.awt.BorderLayout;
import java.awt.Canvas;

import javax.swing.JFrame;

public class Window extends Canvas{
	JFrame frame;
	public Window(String caption, int width, int height, boolean resizable){
		frame = new JFrame(caption);
		frame.setSize(width, height);
		frame.setResizable(resizable);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.add(this, BorderLayout.CENTER);
	}
	public void launchWindow(){
		if(frame.isVisible()) return;
		frame.setVisible(true);
	}
}
