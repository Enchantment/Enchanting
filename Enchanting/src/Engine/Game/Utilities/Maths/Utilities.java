package Engine.Game.Utilities.Maths;

public class Utilities {
	public static int rand(){
		return (int) Math.random();
	}
	public static int rand(int min, int max){
		return min + (int)(Math.random() * ((max - min) + 1));
	}
}
