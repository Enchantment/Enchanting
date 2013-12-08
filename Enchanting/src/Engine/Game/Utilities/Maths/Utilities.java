package Engine.Game.Utilities.Maths;

import java.awt.Color;

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
}
