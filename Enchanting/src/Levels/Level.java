package Levels;

import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Engine.Enchanting;
import Maths.Vector.Vec2f;
/*
 * Level contains 3 layers:
 * 1-Terrain Layer
 * 2-TerrainObject Layer
 * 3-Object Layer(quadtree really)
 */
public class Level {
	public TerrainTileset tTileset;
	public TerrainTileset tOTileset;
	public int [][] terrain;
	public int [][] terrainObjects;
	public int lvlWidth, lvlHeight, tileWidth, tileHeight;
	
	public Level(String mapFilename){
		tTileset = new TerrainTileset("Resources/terrain.jpg");
		tOTileset = new TerrainTileset("Resources/terrainobjects.png");
		loadLevel(mapFilename);
	}
	private void loadLevel(String mapFilename){
		Scanner scanner = null;
		try {
			scanner =  new Scanner(new File(mapFilename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if(scanner == null) throw new RuntimeException("Unable to find map file");


		lvlWidth = scanner.nextInt();
		lvlHeight = scanner.nextInt();
		tileWidth = scanner.nextInt();
		tileHeight = scanner.nextInt();
		scanner.useDelimiter(",");
		terrain = new int[lvlWidth][lvlHeight];
		terrainObjects = new int[lvlWidth][lvlHeight];
		for(int y = 0; y < lvlWidth; y++)
		{
			scanner.nextLine();
			for(int x = 0; x < lvlHeight; x++){
				terrain[x][y] = scanner.nextInt();
			}
		}
		for(int y = 0; y < lvlWidth; y++)
		{
			scanner.nextLine();
			for(int x = 0; x < lvlHeight; x++){
				terrainObjects[x][y] = scanner.nextInt();
			}
		}
		scanner.close();
	}
	public void drawLevel(Graphics g, Vec2f cameraLocation){
		for(float y = -cameraLocation.y%tileHeight; y < Enchanting.mainWindow.getHeight(); y+=tileHeight)
			for(float x = -cameraLocation.x%tileWidth; x < Enchanting.mainWindow.getWidth(); x+=tileWidth){
				g.drawImage(tTileset.tileset, (int)x, (int)y, (int)x+tileWidth, (int)y+tileHeight, 
						terrain[(int) ((x+cameraLocation.x)/tileWidth)][(int) ((y+cameraLocation.y)/tileHeight)]%TerrainTileset.NUM_TILES_X*tileWidth, 
						terrain[(int) ((x+cameraLocation.x)/tileWidth)][(int) ((y+cameraLocation.y)/tileHeight)]/TerrainTileset.NUM_TILES_X*tileHeight, 
						terrain[(int) ((x+cameraLocation.x)/tileWidth)][(int) ((y+cameraLocation.y)/tileHeight)]%TerrainTileset.NUM_TILES_X*tileWidth+tileWidth, 
						terrain[(int) ((x+cameraLocation.x)/tileWidth)][(int) ((y+cameraLocation.y)/tileHeight)]/TerrainTileset.NUM_TILES_X*tileHeight+tileHeight,
						null);
			}
		for(float y = -cameraLocation.y%tileHeight; y < Enchanting.mainWindow.getHeight(); y+=tileHeight)
			for(float x = -cameraLocation.x%tileWidth; x < Enchanting.mainWindow.getWidth(); x+=tileWidth){
				g.drawImage(tOTileset.tileset, (int)x, (int)y, (int)x+tileWidth, (int)y+tileHeight, 
						terrainObjects[(int) ((x+cameraLocation.x)/tileWidth)][(int) ((y+cameraLocation.y)/tileHeight)]%TerrainTileset.NUM_TILES_X*tileWidth, 
						terrainObjects[(int) ((x+cameraLocation.x)/tileWidth)][(int) ((y+cameraLocation.y)/tileHeight)]/TerrainTileset.NUM_TILES_X*tileHeight, 
						terrainObjects[(int) ((x+cameraLocation.x)/tileWidth)][(int) ((y+cameraLocation.y)/tileHeight)]%TerrainTileset.NUM_TILES_X*tileWidth+tileWidth, 
						terrainObjects[(int) ((x+cameraLocation.x)/tileWidth)][(int) ((y+cameraLocation.y)/tileHeight)]/TerrainTileset.NUM_TILES_X*tileHeight+tileHeight,
						null);
			}
	}
}
