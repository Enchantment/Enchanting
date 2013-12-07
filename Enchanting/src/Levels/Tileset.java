package Levels;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Tileset {
	BufferedImage spriteSheet;
	int tileWidth, tileHeight;
	int numTilesX, numTilesY;
	public Tileset(String filename, int tileWidth, int tileHeight){
		try {
			spriteSheet = ImageIO.read(new File(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(spriteSheet == null) throw new RuntimeException("Failed to load tilesheet: " + filename);
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		numTilesX = spriteSheet.getWidth()/tileWidth;
		numTilesY = spriteSheet.getHeight()/tileHeight;
	}
}
