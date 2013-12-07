package Engine;

public class Timer{
    double startTime, lastTime;
    public Timer(){
        startTime = 0;
        lastTime = 0;
    }
    public void startTimer(){
        startTime =  System.nanoTime();
        lastTime = startTime;
    }
    public void checkTime(){
        lastTime = System.nanoTime();
    }
    public double getTime(){
        return (System.nanoTime()-lastTime);
    }
    public double getTimeS(){
        return (System.nanoTime()-lastTime)/1000000000.0;
    }
    public double getRunTime(){
        return (System.nanoTime()-startTime);
    }
    
}
