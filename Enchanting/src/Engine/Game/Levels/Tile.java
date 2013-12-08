package Engine.Game.Levels;

import java.awt.Color;

import Engine.Game.Utilities.Maths.GameException;
import Engine.Game.Utilities.Maths.Utilities;
import Engine.Game.Utilities.Maths.Rectangle.Rect2i;
/*
 * Tile class. Contains location in tileset, solid?, emitter? and 
 * tileColor, which is the average of all the pixels in the tile
 */
public class Tile {
	private int ID;
	//Offset(x,y) + Dimension(w,h)
	private Rect2i box;
	private boolean solid, emitter;
	private Color tileColor;
	public Tile(Tileset tileset,int ID, boolean solid, boolean emitter){
		if(tileset.tiles[ID] != null) throw new GameException("Tile already exists ID:"+ID);
		this.ID = ID;
		this.solid = solid;
		this.emitter = emitter;
		this.box = new Rect2i((ID%tileset.numTilesX*tileset.tileWidth), ID/tileset.numTilesX*tileset.tileHeight, tileset.tileWidth, tileset.tileHeight);
		//Get average color of the tile. Used for minimap and image map loading
		int pixels[] = null;
		int a = tileset.getImage().getWidth();
		pixels = tileset.getImage().getRGB(box.x, box.y, box.w, box.h, null, 0, box.w);
		this.tileColor = Utilities.averageColor(pixels);
		//If color already being used, slightly change it
		while(checkColorExists(tileset.tiles, this.tileColor)){
			int rand = Utilities.rand(1,3);
			switch(rand){
			case 1:
				if(tileColor.getRed() <= 246) tileColor = 	new Color(tileColor.getRed()+Utilities.rand(1,10), tileColor.getBlue(), tileColor.getGreen());
				else tileColor = 							new Color(tileColor.getRed()-Utilities.rand(1,10), tileColor.getBlue(), tileColor.getGreen());
				break;
			case 2:
				if(tileColor.getBlue() <= 246) tileColor = 	new Color(tileColor.getRed(), tileColor.getBlue()+Utilities.rand(1,10), tileColor.getGreen());
				else tileColor = 							new Color(tileColor.getRed(), tileColor.getBlue()-Utilities.rand(1,10), tileColor.getGreen());
				break;
			case 3:
				if(tileColor.getGreen() <= 246) tileColor = new Color(tileColor.getRed(), tileColor.getBlue(), tileColor.getGreen()+Utilities.rand(1,10));
				else tileColor = 							new Color(tileColor.getRed(), tileColor.getBlue(), tileColor.getGreen()-Utilities.rand(1,10));
				break;
			}
		}
		tileset.tiles[ID] = this;
	}
	private boolean checkColorExists(Tile[] tiles, Color rgb){
		for(Tile tile : tiles){
			if(tile != null)
				if(tile.tileColor.equals(this.tileColor)) 
					return true;
		}
		return false;
	}
	//Gets()
	public int getID(){
		return ID;
	}
	public Rect2i getBox(){
		return box;
	}
	public boolean isSolid(){
		return solid;
	}
	public boolean isEmitter(){
		return emitter;
	}
	public Color getTileColor(){
		return tileColor;
	}
}
