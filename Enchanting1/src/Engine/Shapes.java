package Engine;

public class Shapes {
	public static class Vec2f{
		public float x, y;
		public Vec2f(float x, float y){
			this.x = x;
			this.y = y;
		}
	}
	public static class Vec2i{
		public int x, y;
		public Vec2i(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static class Rect2f{
		public float x, y, w, h;
		public Rect2f(float x, float y, float w, float h){
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
		}
	}
	public static class Rect2i{
		public int x, y, w, h;
		public Rect2i(int x, int y, int w, int h){
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
		}
	}
	public static class Sphere2f{
		public float x, y, radius;
		public Sphere2f(float x, float y, float radius){
			this.x = x;
			this.y = y;
			this.radius = radius;
		}
	}
}
