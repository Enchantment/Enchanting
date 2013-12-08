package Engine.Game.Utilities;

public class FPSTimer extends Timer{
	
	private int maxFPS, lastFPS, frames;
	private double delta;
	public FPSTimer(int maxFPS){
        super();
        this.maxFPS = maxFPS;
        lastFPS = 0;
        delta = 0;
	}
	public void checkTime(){
        delta+=getTime();
        frames++;
        if(delta>=1000000000.0){
            delta = 0;
            lastFPS = frames;
            System.out.println(lastFPS + " FPS");
            frames = 0;
        }
        super.checkTime();       
    }
	public int getFPS(){
		return lastFPS;
	}
}
