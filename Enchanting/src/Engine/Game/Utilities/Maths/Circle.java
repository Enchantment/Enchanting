package Engine.Game.Utilities.Maths;

import Engine.Game.Utilities.Maths.Vector.Vec2f;
import Engine.Game.Utilities.Maths.Vector.Vec2i;

public class Circle {
	public static class Circle2f{
		public Circle2f(Vec2f location, float radius){
			this.location = location;
			this.radius = radius;
		}
		public Circle2f(float x, float y, float radius){
			this.location = new Vec2f(x, y);
			this.radius = radius;
		}
		public Circle2f(int x, int y, int radius){
			this.location = new Vec2f(x, y);
			this.radius = radius;
		}
		Vec2f location;
		float radius;
	}
	public static class Circle2i{
		public Circle2i(Vec2i location, float radius){
			this.location = location;
			this.radius = radius;
		}
		public Circle2i(float x, float y, float radius){
			this.location = new Vec2i(x, y);
			this.radius = radius;
		}
		public Circle2i(int x, int y, int radius){
			this.location = new Vec2i(x, y);
			this.radius = radius;
		}
		Vec2i location;
		float radius;
	}
}
