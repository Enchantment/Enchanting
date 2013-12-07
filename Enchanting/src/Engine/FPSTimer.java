package Engine;

public class FPSTimer extends Timer{
    int maxFPS, FPS;
    double delta;
    public FPSTimer(int maxFPS){
        super();
        this.maxFPS = maxFPS;
        FPS = 0;
        delta = 0;
    }
	public void checkTime(){
        delta+=getTime();
        FPS++;
        if(delta>=1000000000.0){
            delta = 0;
            System.out.println(FPS + " FPS");
            FPS = 0;
        }
        super.checkTime();       
    }
}