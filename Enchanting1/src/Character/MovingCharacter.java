package Character;

import Engine.Shapes.Vec2f;

public class MovingCharacter extends Character{
	Vec2f speed;
	MovingCharacter(String spritesheet, Vec2f location, Vec2f size, Vec2f speed,
			int animation, int direction) {
		super(spritesheet, location, size, animation, direction);
		this.speed = speed;
	}
	public void moveChar(double time){
		location.x += speed.x*time;
		location.y += speed.y*time;
	}
	public void setSpeed(Vec2f speed){
		this.speed = speed;
	}
	public void stopChar(){
		this.speed = new Vec2f(0,0);
		animation = 0;
	}
}
