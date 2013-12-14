package Engine.Game.Utilities.Maths;

import java.awt.Color;

import Engine.Game.Utilities.Maths.Rectangle.Rect2f;
import Engine.Game.Utilities.Maths.Vector.Vec2f;

public class Utilities {
	public static int rand(){
		return (int) Math.random();
	}
	public static int rand(int min, int max){
		return min + (int)(Math.random() * ((max - min) + 1));
	}
	//Uses AARRGGBB
	public static Color averageColor(int pixels[]){
		long red = 0, blue = 0, green = 0;
		int numPixels = 0;
		for(int pixel : pixels){
			Color temp = new Color(pixel);
			numPixels++;
			red+=temp.getRed();
			green+=temp.getGreen();
			blue+=temp.getBlue();
			
		}
		return new Color((int)(red/numPixels), (int)(green/numPixels),(int)(blue/numPixels));
	}
	public boolean pointCollided(Rect2f a, Vec2f b){
		if(b.x>a.x && b.x<(a.x+a.w) && b.y>a.y && b.y<(a.y+a.y)) 
			return true;
		return false;
	}
	public boolean rectCollided(Rect2f a, Rect2f b){
		Vec2f p_1 = new Vec2f(a.x, a.y);
		Vec2f p_2 = new Vec2f(a.x+a.w, a.y);
		Vec2f p_3 = new Vec2f(a.x, a.y+a.h);
		Vec2f p_4 = new Vec2f(a.x+a.w, a.y+a.h);
		if(pointCollided(a, p_1) || pointCollided(a, p_2) || pointCollided(a, p_3) ||  pointCollided(a, p_4))
			return true;
		return false;
	}
	public static boolean isTransparent(int[] pixels){
		for(int pixel : pixels){
			Color temp = new Color(pixel);
			int a = temp.getAlpha();
			if(temp.getAlpha() < 255) 
				return true;	
		}
		return false;
	}
}
