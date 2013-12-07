package Engine;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Window extends Canvas{
	public JFrame frame;
	int Width, Height, Scale;
	String Caption;
	public Window(int Width, int Height, int Scale, String Caption){
		this.Width = Width;
		this.Height = Height;
		this.Scale = Scale;
		this.Caption = Caption;
	}
	public void LaunchWindow(){
		frame = new JFrame(Caption);
		frame.setSize(Width*Scale, Height*Scale);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.add(this, BorderLayout.CENTER);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	
}
