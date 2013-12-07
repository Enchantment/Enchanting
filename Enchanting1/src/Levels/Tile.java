package Levels;

import java.awt.Color;
/*
 * Simple tile class. ID, solid?, emitter?, and its color.
 * Color is used to load map from an image
 * Adds tile to tile list when created but checks first that color and id are not being used
 */
public class Tile {
	public int ID;
	public boolean solid, emitter;
	Tile(int ID, boolean solid, boolean emitter){
		this.ID = ID;
		this.solid = solid;
		this.emitter = emitter;
		if(TileSet.tiles[ID] == null) TileSet.tiles[ID] = this;
		else throw new RuntimeException("Tile already exists: " + ID);
	}
}
