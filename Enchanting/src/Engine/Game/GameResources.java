package Engine.Game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Engine.Game.Utilities.Maths.GameException;

public class GameResources {
	private String tilesetsPath = "Resources/Tilesets/";
	private String levelsPath = "Resources/Levels/";
	private String objectsPath = "Resources/Objects/";
	public static BufferedImage terrainTileset;
	public static BufferedImage terrainObjectsTileset;
	public static BufferedImage testObject;
	public GameResources(){
		try {
			terrainTileset = ImageIO.read(new File(tilesetsPath + "terrain.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(terrainTileset == null) throw new GameException("Failed to load terrainTileset");
		try {
			terrainObjectsTileset = ImageIO.read(new File(tilesetsPath + "terrain.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(terrainObjectsTileset == null) throw new GameException("Failed to load terrainTileset");
		try {
			testObject = ImageIO.read(new File(objectsPath + "dirt.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(terrainObjectsTileset == null) throw new GameException("Failed to load object spritesheet");
	}
}
