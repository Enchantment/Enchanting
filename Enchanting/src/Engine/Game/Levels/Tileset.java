package Engine.Game.Levels;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

import Engine.Game.Utilities.Maths.GameException;

public class Tileset {
	public int numTilesX;
	public int numTilesY;
	public int tileWidth, tileHeight;
	public int totalTiles;
	
	private BufferedImage spritesheet;
	public Tile [] tiles;

	public Tileset(BufferedImage spritesheet, String tileInfo, int tileWidth, int tileHeight){
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		this.spritesheet = spritesheet;
		if(spritesheet == null) throw new GameException("Spritesheet not loaded yet..");
		this.numTilesX = spritesheet.getWidth()/tileWidth;
		this.numTilesY = spritesheet.getHeight()/tileHeight;
		totalTiles = numTilesX*numTilesY;
		tiles = new Tile[numTilesX*numTilesY];
		loadTiles(tileInfo);
		
	}
	public BufferedImage getImage(){
		return spritesheet;
	}
	public void loadTiles(String tileInfo){
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(tileInfo));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if(scanner==null) throw new GameException("Failed to load tileset info");
		while(scanner.hasNext()){
			new Tile(this, scanner.nextInt(), (scanner.nextInt()==1), (scanner.nextInt()==1), (scanner.nextInt()==1));
		}
	}
}
