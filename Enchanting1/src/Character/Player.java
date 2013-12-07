package Character;

import Engine.Enchanting;
import Engine.Shapes.Vec2f;

public class Player extends MovingCharacter{
	public Player(String spritesheet, Vec2f location, Vec2f size, Vec2f speed,
			int animation, int direction) {
		super(spritesheet, location, size, speed, animation, direction);
		int i = Enchanting.mainWindow.getWidth();
		this.cameraLocation = new Vec2f(location.x-Enchanting.mainWindow.getWidth()/2, location.y-Enchanting.mainWindow.getHeight()/2);
		if(this.cameraLocation.x<0) this.cameraLocation.x = 0;
		if(this.cameraLocation.y<0) this.cameraLocation.y = 0;
	}

	public Vec2f cameraLocation;
	
	public void moveChar(double time){
		super.moveChar(time);
		this.cameraLocation = new Vec2f(location.x-Enchanting.mainWindow.getWidth()/2, location.y-Enchanting.mainWindow.getHeight()/2);
		if(cameraLocation.x<0) cameraLocation.x = 0;
		if(cameraLocation.y<0) cameraLocation.y = 0;
	}
	
}
