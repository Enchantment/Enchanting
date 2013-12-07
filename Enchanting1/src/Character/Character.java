package Character;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Engine.Enchanting;
import Engine.Shapes.Vec2f;

public class Character {
	BufferedImage spriteSheet;
	Vec2f location;
	Vec2f size;
	int animation, numAnimationsX;
	int direction;
	Character(String spritesheet, Vec2f location, Vec2f size, int animation, int direction){
		try {
			this.spriteSheet = ImageIO.read(new File(spritesheet));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.location = location;
		this.size = size;
		this.animation = animation;
		this.numAnimationsX = (int) (spriteSheet.getWidth()/size.x);
		this.direction = direction;
	}	
	public void drawChar(Graphics g){
		g.drawImage(spriteSheet, (int)(location.x-Enchanting.mainPlayer.cameraLocation.x), (int)(location.y-Enchanting.mainPlayer.cameraLocation.y), (int)(location.x-Enchanting.mainPlayer.cameraLocation.x+size.x), (int)(location.y-Enchanting.mainPlayer.cameraLocation.y+size.y), 
				(int)(animation%numAnimationsX*size.x), (int)(animation/numAnimationsX*size.y), (int)(animation%numAnimationsX*size.x+size.x), (int)(animation/numAnimationsX*size.y+size.y), null);
	}
}
