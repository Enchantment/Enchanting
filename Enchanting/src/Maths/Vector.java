package Maths;

public class Vector {
	public static class Vec2f{
		public Vec2f(){
			this.x = 0;
			this.y = 0;
		}
		public Vec2f(float x, float y){
			this.x = x;
			this.y = y;
		}
		public Vec2f(int x, int y){
			this.x = x;
			this.y = y;
		}
		public float x, y;
	}
	public static class Vec2i{
		public Vec2i(){
			this.x = 0;
			this.y = 0;
		}
		public Vec2i(float x, float y){
			this.x = (int)x;
			this.y = (int)y;
		}
		public Vec2i(int x, int y){
			this.x = x;
			this.y = y;
		}
		public int x, y;
	}
}
