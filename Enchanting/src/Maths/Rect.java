package Maths;

import java.awt.geom.Rectangle2D;

/*
 * Simple rectangle
 */
public class Rect {
	public class Rect2f{
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
		public float x, y, w, h;
	}
	public class Rect2i{
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
		public int x, y, w, h;
	}
	
}
