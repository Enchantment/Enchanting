package Levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Engine.Enchanting;
import Engine.Shapes.Vec2f;
import Engine.Window;

public class Level {
	private int lvlMap[][];
	//Number tiles
	BufferedImage tileSet;
	int lvlWidth, lvlHeight;
	int numTilesX, numTilesY;
	public Level(){
		lvlWidth = 100;
		lvlHeight = 100;
		try {
			tileSet = ImageIO.read(new File("tileset.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(tileSet == null) throw new RuntimeException("Failed to load tileset");
		lvlMap = new int[lvlWidth][lvlHeight];
		for(int y = 0; y < lvlHeight; y++)
			for(int x = 0; x < lvlWidth; x++){
				lvlMap[x][y] = 0 + (int)(Math.random() * ((47 - 0) + 1));
			}
	}
	public void drawLevel(Graphics g){
		for(float y = -Enchanting.mainPlayer.cameraLocation.y%TileSet.HEIGHT; y < Enchanting.mainWindow.getHeight(); y+=TileSet.HEIGHT)
			for(float x = -Enchanting.mainPlayer.cameraLocation.x%TileSet.WIDTH; x < Enchanting.mainWindow.getWidth(); x+=TileSet.WIDTH){g.drawImage(tileSet, (int)x, (int)y, (int)x+TileSet.WIDTH, (int)y+TileSet.HEIGHT, 
						lvlMap[(int) ((x+Enchanting.mainPlayer.cameraLocation.x)/TileSet.WIDTH)][(int) ((y+Enchanting.mainPlayer.cameraLocation.y)/TileSet.HEIGHT)]%TileSet.NUM_TILES_X*TileSet.WIDTH, 
						lvlMap[(int) ((x+Enchanting.mainPlayer.cameraLocation.x)/TileSet.WIDTH)][(int) ((y+Enchanting.mainPlayer.cameraLocation.y)/TileSet.HEIGHT)]/TileSet.NUM_TILES_X*TileSet.HEIGHT, 
						lvlMap[(int) ((x+Enchanting.mainPlayer.cameraLocation.x)/TileSet.WIDTH)][(int) ((y+Enchanting.mainPlayer.cameraLocation.y)/TileSet.HEIGHT)]%TileSet.NUM_TILES_X*TileSet.WIDTH+TileSet.WIDTH, 
						lvlMap[(int) ((x+Enchanting.mainPlayer.cameraLocation.x)/TileSet.WIDTH)][(int) ((y+Enchanting.mainPlayer.cameraLocation.y)/TileSet.HEIGHT)]/TileSet.NUM_TILES_X*TileSet.HEIGHT+TileSet.HEIGHT,
						null);
			}
	}
}
