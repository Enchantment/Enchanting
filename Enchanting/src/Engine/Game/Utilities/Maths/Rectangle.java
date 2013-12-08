package Engine.Game.Utilities.Maths;

/*
 * 2d Rectangle. xLocation, yLocation, width, height.
 * Contains both int and float rectangles, as well as all functions related
 */
public class Rectangle {
	//Rectangle made of floats
	public static class Rect2f{
		public Rect2f(){
			this.x = 0;
			this.y = 0;
			this.w = 0;
			this.h = 0;
		}
		public Rect2f(float x, float y, float w, float h){
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
		}
		public Rect2f(int x, int y, int w, int h){
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
		}
		public void setRect(Rect2f rect){
			this.x = rect.x;
			this.y = rect.y;
			this.w = rect.w;
			this.h = rect.h;
		}
		public void setRect(Rect2i rect){
			this.x = rect.x;
			this.y = rect.y;
			this.w = rect.w;
			this.h = rect.h;
		}
		public float x, y, w, h;
	}
	//Rectangle made of ints. If converting from a Rect2f careful with value lost
	public static class Rect2i{
		public Rect2i(){
			this.x = 0;
			this.y = 0;
			this.w = 0;
			this.h = 0;
		}
		public Rect2i(float x, float y, float w, float h){
			this.x = (int)x;
			this.y = (int)y;
			this.w = (int)w;
			this.h = (int)h;
		}
		public Rect2i(int x, int y, int w, int h){
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
		}
		public void setRect(Rect2f rect){
			this.x = (int)rect.x;
			this.y = (int)rect.y;
			this.w = (int)rect.w;
			this.h = (int)rect.h;
		}
		public void setRect(Rect2i rect){
			this.x = rect.x;
			this.y = rect.y;
			this.w = rect.w;
			this.h = rect.h;
		}
		public int x, y, w, h;
	}
	
}
