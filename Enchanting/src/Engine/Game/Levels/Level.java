package Engine.Game.Levels;

import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Engine.Game.Utilities.Maths.GameException;
import Engine.Game.Utilities.Maths.Rectangle.Rect2i;
import Engine.Game.Utilities.Maths.Vector.Vec2f;
import Engine.Graphics.Window;

public class Level {
	int width, height;
	int tileWidth, tileHeight;
	int [][] terrainMap;
	int [][] terrainObjectMap;
	Tileset tTileset;
	Tileset tOTileset;
	public Level(String levelMap){
		loadLevel(levelMap);
		tTileset = new Tileset("Resources/Tilesets/terrain.jpg", "Resources/Tilesets/terraininfo.txt", tileWidth, tileHeight);
		tOTileset = new Tileset("Resources/Tilesets/terrain.jpg", "Resources/Tilesets/terraininfo.txt", tileWidth, tileHeight);
	}
	public void drawLevel(Graphics g, Window mainWindow, Vec2f cameraLocation){
		for(int yLoc = (int) -cameraLocation.y, y = (int) ((yLoc+cameraLocation.y)/tileHeight); yLoc < mainWindow.getHeight(); yLoc+=tileHeight, y++)
			for(int xLoc = (int) -cameraLocation.x, x = (int) ((xLoc+cameraLocation.x)/tileWidth); xLoc < mainWindow.getWidth(); xLoc+=tileWidth, x++){
				if(terrainMap[y][x] != -1){
					Rect2i box = tTileset.tiles[terrainMap[y][x]].getBox();
					g.drawImage(tTileset.getImage(), xLoc, yLoc, xLoc+tileWidth, yLoc+tileHeight, box.x, box.y, box.x+box.w, box.y+box.h, null);
				}
				if(terrainObjectMap[y][x] != -1){
					Rect2i box = tOTileset.tiles[terrainObjectMap[y][x]].getBox();
					g.drawImage(tOTileset.getImage(), xLoc, yLoc, xLoc+tileWidth, yLoc+tileHeight, box.x, box.y, box.x+box.w, box.y+box.h, null);
				}
			}
	}
	
	public void loadLevel(String levelMap){
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(levelMap));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if(scanner == null) throw new GameException("Failed to load levelMap: " + levelMap);
		width = scanner.nextInt();
		height = scanner.nextInt();
		tileWidth = scanner.nextInt();
		tileHeight = scanner.nextInt();
		terrainMap = new int[height][width];
		terrainObjectMap = new int[height][width];
		scanner.useDelimiter(",");
		for(int y = 0; y < height; y++)
		{
			scanner.nextLine();
			for(int x = 0; x < width; x++){
				terrainMap[y][x] = scanner.nextInt()-1;
			}
		}
		for(int y = 0; y < height; y++)
		{
			scanner.nextLine();
			for(int x = 0; x < width; x++){
				terrainObjectMap[y][x] = scanner.nextInt()-1;
			}
		}	
	}
}