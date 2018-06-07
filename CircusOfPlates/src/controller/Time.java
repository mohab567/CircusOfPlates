package controller;

import model.LevelStrategy;
import model.Log4j;
import view.GUI;

public class Time {
    long lastLoopTime = System.nanoTime();
    int TARGET_FPS;
    long OPTIMAL_TIME;
    long lastFpsTime;
    long fps;
    boolean gameRunning = true;
    GUI gui;
    LevelStrategy lv;
    private static Time instance;
    // RunGame R = new
    private Time() {
    	
     //   Log4j.logger.info("GAME STARTED!");
        lv = new LevelStrategy();
        gui = GUI.getInstance();
        gui.run();
        lv.setStartTime(System.nanoTime());

    }
    
    public static Time getInstance() {
        if (instance == null) {
            instance = new Time();
        }
        return instance;

    }
    // to do , finish and show the state of winner .....
    public void pause() { 
        gui.getInstance().pauseResume = false;
    }

    public void cont() {
        gui.getInstance().pauseResume = true;
    }

    public void reset() {
    	gui.getInstance().pauseResume = true;
    	lv.setStartTime(System.nanoTime());
    	gui.reset();
    }

    public void start() {
        while (gameRunning) {
            TARGET_FPS = lv.getFPS();
            OPTIMAL_TIME = 1000000000 / TARGET_FPS ;
            // work out how long its been since the last update, this
            // will be used to calculate how far the entities should
            // move this loop
            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;
            double delta = updateLength / ((double) OPTIMAL_TIME);

            // update the frame counter
            lastFpsTime += updateLength;
            fps++;

            // update our FPS counter if a second has passed since
            // we last recorded
            if (lastFpsTime >= 1000000000) {
                lastFpsTime = 0;
                fps = 0;
            }

            // update the game logic
            // run();
            if(gui.getInstance().pauseResume)
               gui.up();
            // we want each frame to take 10 milliseconds, to do this
            // we've recorded when we started the frame. We add 10 milliseconds
            // to this and then factor in the current time to give
            // us our final value to wait for
            // remember this is in ms, whereas our lastLoopTime etc. vars are in
            // ns.
            try {
                Thread.sleep((lastLoopTime - System.nanoTime() + OPTIMAL_TIME)
                        / 1000000);
            } catch (Exception e) {
            }
        }
      //  Log4j.logger.info("GAME ENDED!");
    }

     public static void main(String[] args) {
        Time.getInstance().start();
       // time.start();
        
    }
}
