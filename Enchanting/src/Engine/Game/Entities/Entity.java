package Engine.Game.Entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import Engine.Game.Enchanting;
import Engine.Game.Utilities.Maths.Rectangle.Rect2f;
import Engine.Game.Utilities.Maths.Rectangle.Rect2i;
import Engine.Game.Utilities.Maths.Vector.Vec2f;
import Engine.Graphics.Window;

public class Entity {
	Rect2f box;
	BufferedImage spritesheet;
	String name;
	int numAnimations;
	int curAnimation;
	Rect2i[] animationOffsets;
	//Add object to database
	public Entity(String spritesheetFilename, String name, int width, int height){
		try {
			this.spritesheet = ImageIO.read(new File(spritesheetFilename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.name = name;
		numAnimations = (spritesheet.getWidth()/width)*(spritesheet.getHeight()/height);
		animationOffsets = new Rect2i[numAnimations];
		int i = 0;
		for(int y = 0; y < spritesheet.getHeight(); y+=height)
			for(int x = 0; x < spritesheet.getWidth(); x+=width){
				animationOffsets[i] = new Rect2i(x, y, width, height);
				i++;
			}
	}
	public Entity(BufferedImage spritesheet, String name, int width, int height){
		this.spritesheet = spritesheet;
		this.name = name;
		numAnimations = (spritesheet.getWidth()/width)*(spritesheet.getHeight()/height);
		animationOffsets = new Rect2i[numAnimations];
		int i = 0;
		for(int y = 0; y < spritesheet.getHeight(); y+=height)
			for(int x = 0; x < spritesheet.getWidth(); x+=width){
				animationOffsets[i] = new Rect2i(x, y, width, height);
				i++;
			}
	}
	//Used to add an object already in the database
	public Entity(Entity entity, Rect2f box){
			this.spritesheet = entity.spritesheet;
			this.name = name;
			this.numAnimations = entity.numAnimations;
			this.animationOffsets = entity.animationOffsets;
			this.curAnimation = 0;
			this.box = box;
	}
	public void draw(Graphics g, Vec2f cameraLocation, Window window){
		if(box.x-cameraLocation.x > 0 && box.x-cameraLocation.x < window.getWidth() && box.y-cameraLocation.y > 0 && box.y-cameraLocation.y < window.getHeight()){
			g.drawImage(spritesheet, (int)(box.x-cameraLocation.x), (int)(box.y-cameraLocation.y), (int)(box.x+box.w-cameraLocation.x), (int)(box.y+box.h-cameraLocation.y),
						animationOffsets[curAnimation].x, animationOffsets[curAnimation].y, animationOffsets[curAnimation].x+animationOffsets[curAnimation].w, animationOffsets[curAnimation].y+animationOffsets[curAnimation].h, null);
			if(Enchanting.game.getDebug())g.drawRect((int)box.x, (int)box.y, (int)box.w, (int)box.h);
		}
	}
}
