package Engine.Game.Levels;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Engine.Game.Utilities.Maths.GameException;

public class Level {
	int width, height;
	int tileWidth, tileHeight;
	
	public Level(String levelMap){
		
	}
	public void drawLevel(){
		
	}
	public void loadLevel(String levelMap){
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(levelMap));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if(scanner == null) throw new GameException("Failed to load levelMap: " + levelMap);
		
	}
}
